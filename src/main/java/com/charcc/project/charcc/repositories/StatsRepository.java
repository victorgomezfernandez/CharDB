package com.charcc.project.charcc.repositories;

import com.charcc.project.charcc.models.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {
    Stats findByInformationId(Long informationId);
}