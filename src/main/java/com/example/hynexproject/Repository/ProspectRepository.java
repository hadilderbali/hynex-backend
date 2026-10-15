package com.example.hynexproject.Repository;

import com.example.hynexproject.Entity.Prospects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProspectRepository extends JpaRepository<Prospects, Long> {
}
