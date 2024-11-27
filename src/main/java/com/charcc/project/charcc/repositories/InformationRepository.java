package com.charcc.project.charcc.repositories;

import com.charcc.project.charcc.models.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information, Long> {
}
