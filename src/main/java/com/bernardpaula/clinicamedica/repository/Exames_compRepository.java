package com.bernardpaula.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Exames_comp;

@Repository
public interface Exames_compRepository extends JpaRepository<Exames_comp, Integer> {

}
