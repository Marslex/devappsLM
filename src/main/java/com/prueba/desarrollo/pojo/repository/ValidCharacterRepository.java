package com.prueba.desarrollo.pojo.repository;

import com.prueba.desarrollo.pojo.model.ValidCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidCharacterRepository extends JpaRepository<ValidCharacter, Long> {
}
