package com.bernardpaula.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Consultas;

@Repository
public interface ConsultasRepository extends JpaRepository<Consultas,Integer> {

}
