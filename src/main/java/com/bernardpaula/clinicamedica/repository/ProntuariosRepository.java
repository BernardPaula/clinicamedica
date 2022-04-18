package com.bernardpaula.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Prontuarios;

@Repository
public interface ProntuariosRepository extends JpaRepository<Prontuarios, Integer> {

}
