package com.example.hynexproject.Service;

import com.example.hynexproject.Entity.Prospects;
import com.example.hynexproject.Repository.ProspectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class ProsepectService {


  private final ProspectRepository prospectRepository;

  public List<Prospects> getAllProspects() {
    return prospectRepository.findAll();
  }

  public Prospects getProspectById(Long id) {
    return prospectRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Prospect not found"));
  }

  public Prospects createProspect(Prospects prospect) {
    return prospectRepository.save(prospect);
  }

  public Prospects updateProspect(Long id, Prospects prospect) {
    Prospects existing = getProspectById(id);

    existing.setBusinessName(prospect.getBusinessName());
    existing.setCategory(prospect.getCategory());
    existing.setCountry(prospect.getCountry());
    existing.setCity(prospect.getCity());
    existing.setAddress(prospect.getAddress());
    existing.setPhone(prospect.getPhone());
    existing.setWhatsapp(prospect.getWhatsapp());
    existing.setEmail(prospect.getEmail());
    existing.setWebsite(prospect.getWebsite());
    existing.setInstagramUrl(prospect.getInstagramUrl());
    existing.setFacebookUrl(prospect.getFacebookUrl());

    return prospectRepository.save(existing);
  }

  public void deleteProspect(Long id) {
    prospectRepository.deleteById(id);
  }
}
