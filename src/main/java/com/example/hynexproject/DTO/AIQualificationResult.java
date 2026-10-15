package com.example.hynexproject.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AIQualificationResult {

  private boolean qualified;

  private String language;

  private String reason;
}
