package com.example.hynexproject.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchResult {

  private String businessName;
  private String category;
  private String country;
  private String city;
  private String address;
  private String phone;
  private String email;
  private String website;
  private String instagramUrl;
  private String facebookUrl;
}
