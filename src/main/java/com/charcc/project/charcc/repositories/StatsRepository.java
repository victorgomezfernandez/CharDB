package com.charcc.project.charcc.repositories;

import com.charcc.project.charcc.models.Stats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatsRepository extends JpaRepository<Stats, Long> {
}
