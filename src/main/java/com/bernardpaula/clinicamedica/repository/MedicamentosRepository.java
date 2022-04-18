package com.bernardpaula.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Medicamentos;

@Repository
public interface MedicamentosRepository extends JpaRepository<Medicamentos, Integer>{

}
