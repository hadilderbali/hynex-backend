package com.example.hynexproject.Controller;

import com.example.hynexproject.Entity.Prospects;
import com.example.hynexproject.Service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SearchController {

  private final SearchService searchService;

  @GetMapping
  public List<Prospects> search() {
    return searchService.findProspects();
  }
}
