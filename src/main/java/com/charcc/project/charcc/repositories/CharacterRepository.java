package com.charcc.project.charcc.repositories;

import com.charcc.project.charcc.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {

}
