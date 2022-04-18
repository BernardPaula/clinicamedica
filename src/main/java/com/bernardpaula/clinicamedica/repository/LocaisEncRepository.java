package com.bernardpaula.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.LocaisEnc;

@Repository
public interface LocaisEncRepository extends JpaRepository<LocaisEnc, Integer> {

}
