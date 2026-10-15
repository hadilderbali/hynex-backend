package com.example.hynexproject.Service;

import com.example.hynexproject.DTO.AIQualificationResult;
import com.example.hynexproject.DTO.SearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@Service
public class AIService {

  @Value("${groq.api.key}")
  private String apiKey;

  @Value("${groq.api.url}")
  private String apiUrl;

  @Value("${groq.model}")
  private String model;

  private final ObjectMapper objectMapper;

  public AIService(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  public AIQualificationResult qualifyBusiness(SearchResult business) {

    RestClient client = RestClient.builder()
      .baseUrl(apiUrl)
      .build();

    String prompt = buildQualificationPrompt(business);

    Map<String, Object> requestBody = Map.of(
      "model", model,
      "messages", new Object[]{
        Map.of(
          "role", "system",
          "content", """
                                        You are the HYNEX prospect qualification assistant.

                                        Your job is to determine whether a business is a good
                                        potential client for HYNEX, a digital studio that creates
                                        professional websites and digital solutions for small
                                        and local businesses.

                                        Qualification criteria:

                                        1. The business should appear to be an active business.
                                        2. It should be a small, local, independent business or practice.
                                        3. It should belong to a useful HYNEX category such as:
                                           beauty, salon, dentist, medical practice, gym, fitness,
                                           wellness, spa, wedding/event business, or another
                                           local service.
                                        4. It should have evidence of an active social presence
                                           when social links are provided.
                                        5. A professional website should be missing, weak,
                                           outdated, or clearly inadequate.
                                        6. Public contact information is valuable.
                                        7. Large corporations, major chains, and businesses
                                           already having a strong modern website should normally
                                           not qualify.
                                        8. Never invent information that is not present in the
                                           business data.
                                        9. Detect the most appropriate language for contacting
                                           the business from the available information.
                                           Use only: fr, en, ar, other.

                                        Return ONLY the requested JSON structure.
                                        """
        ),
        Map.of(
          "role", "user",
          "content", prompt
        )
      },
      "response_format", Map.of(
        "type", "json_schema",
        "json_schema", Map.of(
          "name", "prospect_qualification",
          "strict", true,
          "schema", Map.of(
            "type", "object",
            "properties", Map.of(
              "qualified", Map.of(
                "type", "boolean"
              ),
              "language", Map.of(
                "type", "string",
                "enum", new String[]{
                  "fr",
                  "en",
                  "ar",
                  "other"
                }
              ),
              "reason", Map.of(
                "type", "string"
              )
            ),
            "required", new String[]{
              "qualified",
              "language",
              "reason"
            },
            "additionalProperties", false
          )
        )
      )
    );

    String response = client.post()
      .header("Authorization", "Bearer " + apiKey)
      .header("Content-Type", "application/json")
      .body(requestBody)
      .retrieve()
      .body(String.class);

    try {
      Map<String, Object> responseMap =
        objectMapper.readValue(response, Map.class);

      Map<String, Object> choice =
        (Map<String, Object>) ((java.util.List<?>) responseMap.get("choices")).get(0);

      Map<String, Object> message =
        (Map<String, Object>) choice.get("message");

      String content = (String) message.get("content");

      return objectMapper.readValue(
        content,
        AIQualificationResult.class
      );

    } catch (Exception e) {
      throw new RuntimeException(
        "Failed to parse AI qualification response: " + response,
        e
      );
    }
  }

  private String buildQualificationPrompt(SearchResult business) {

    return """
                Analyze this business for HYNEX.

                Business name: %s
                Category: %s
                Country: %s
                City: %s
                Address: %s
                Phone: %s
                Email: %s
                Website: %s
                Instagram: %s
                Facebook: %s

                Determine whether this business should be considered a
                potential HYNEX prospect.

                Do not invent missing information.
                """
      .formatted(
        value(business.getBusinessName()),
        value(business.getCategory()),
        value(business.getCountry()),
        value(business.getCity()),
        value(business.getAddress()),
        value(business.getPhone()),
        value(business.getEmail()),
        value(business.getWebsite()),
        value(business.getInstagramUrl()),
        value(business.getFacebookUrl())
      );
  }

  private String value(String value) {
    return value == null || value.isBlank()
      ? "Not provided"
      : value;
  }
}
