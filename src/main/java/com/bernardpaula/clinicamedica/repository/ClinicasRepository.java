package com.bernardpaula.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Clinicas;

@Repository
public interface ClinicasRepository extends JpaRepository<Clinicas, Integer> {

}
