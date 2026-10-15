package com.example.hynexproject.Controller;

import com.example.hynexproject.DTO.AIQualificationResult;
import com.example.hynexproject.DTO.SearchResult;
import com.example.hynexproject.Service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AITestController {

  private final AIService aiService;

  @GetMapping("/qualification-test")
  public AIQualificationResult testQualification() {

    SearchResult business = SearchResult.builder()
      .businessName("Salon Bella")
      .category("Beauty Salon")
      .country("France")
      .city("Paris")
      .address("12 Rue de Paris")
      .phone("+33123456789")
      .email("contact@salonbella.fr")
      .website("")
      .instagramUrl("https://instagram.com/salonbella")
      .facebookUrl("https://facebook.com/salonbella")
      .build();

    return aiService.qualifyBusiness(business);
  }
}
