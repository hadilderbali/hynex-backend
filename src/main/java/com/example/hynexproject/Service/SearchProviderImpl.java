package com.example.hynexproject.Service;

import com.example.hynexproject.DTO.SearchResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Component
public class SearchProviderImpl implements SearchProvider {

  @Override
  public List<SearchResult> searchBusinesses() {
    return Collections.emptyList();
  }
}
