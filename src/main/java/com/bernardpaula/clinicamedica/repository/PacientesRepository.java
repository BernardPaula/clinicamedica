package com.bernardpaula.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Pacientes;

@Repository
public interface PacientesRepository extends JpaRepository<Pacientes, Integer> {

}
