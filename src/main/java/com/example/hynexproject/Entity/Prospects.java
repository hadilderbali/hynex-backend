package com.example.hynexproject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prospects implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String businessName;

  private String category;

  private String country;

  private String city;

  private String address;

  private String phone;

  private String whatsapp;

  private String email;

  private String website;

  private String instagramUrl;

  private String facebookUrl;
}
