package com.example.hynexproject.Service;


import com.example.hynexproject.DTO.AIQualificationResult;
import com.example.hynexproject.DTO.SearchResult;
import com.example.hynexproject.Entity.Prospects;
import com.example.hynexproject.Entity.Prospects;
import com.example.hynexproject.Repository.ProspectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

  private final SearchProvider searchProvider;
  private final AIService aiService;
  private final ProspectRepository prospectRepository;

  public List<Prospects> findProspects() {

    List<SearchResult> businesses =
      searchProvider.searchBusinesses();

    List<Prospects> qualifiedProspects =
      new ArrayList<>();

    for (SearchResult business : businesses) {

      AIQualificationResult result =
        aiService.qualifyBusiness(business);

      if (result.isQualified()) {

        Prospects prospect = Prospects.builder()
          .businessName(business.getBusinessName())
          .category(business.getCategory())
          .country(business.getCountry())
          .city(business.getCity())
          .address(business.getAddress())
          .phone(business.getPhone())
          .email(business.getEmail())
          .website(business.getWebsite())
          .instagramUrl(business.getInstagramUrl())
          .facebookUrl(business.getFacebookUrl())
          .build();

        Prospects saved =
          prospectRepository.save(prospect);

        qualifiedProspects.add(saved);
      }
    }

    return qualifiedProspects;
  }
}
