package com.bernardpaula.clinicamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.LogAcesso;

@Repository
public interface LogAcessoRepository extends JpaRepository<LogAcesso, Integer>{

}
