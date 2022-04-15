package com.bernardpaula.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Cargos;

@Repository
public interface CargosRepository extends JpaRepository<Cargos, Integer> {

}
