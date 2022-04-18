package com.bernardpaula.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Medicos;

@Repository
public interface MedicosRepository extends JpaRepository<Medicos, Integer> {

}
