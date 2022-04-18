package com.bernardpaula.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Laudos;

@Repository
public interface LaudosRepository extends JpaRepository<Laudos, Integer> {

}
