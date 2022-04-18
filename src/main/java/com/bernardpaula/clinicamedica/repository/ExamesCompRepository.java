package com.bernardpaula.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.ExamesComp;

@Repository
public interface ExamesCompRepository extends JpaRepository<ExamesComp, Integer> {

}
