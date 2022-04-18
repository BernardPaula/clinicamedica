package com.bernardpaula.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Receitas;

@Repository
public interface ReceitasRepository extends JpaRepository<Receitas, Integer>{

}
