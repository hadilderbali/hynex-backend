package com.example.hynexproject.Controller;

import com.example.hynexproject.Entity.Prospects;
import com.example.hynexproject.Service.ProsepectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/prospects")
@CrossOrigin(origins = "http://localhost:4200")
public class ProspectController {

  private final ProsepectService prospectService;

  @GetMapping
  public List<Prospects> getAllProspects() {
    return prospectService.getAllProspects();
  }

  @GetMapping("/{id}")
  public Prospects getProspectById(@PathVariable Long id) {
    return prospectService.getProspectById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Prospects createProspect(@RequestBody Prospects prospect) {
    return prospectService.createProspect(prospect);
  }

  @PutMapping("/{id}")
  public Prospects updateProspect(
    @PathVariable Long id,
    @RequestBody Prospects prospect
  ) {
    return prospectService.updateProspect(id, prospect);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteProspect(@PathVariable Long id) {
    prospectService.deleteProspect(id);
  }
}
