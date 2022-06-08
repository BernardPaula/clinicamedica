package com.bernardpaula.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Clinicas;

@Repository
public interface ClinicasRepository extends JpaRepository<Clinicas, Integer> {

	@Query(value = "SELECT * FROM clinica WHERE nm_clinica LIKE %:pesquisa%", nativeQuery=true)
	List<Clinicas> filtrarPesquisa(@Param("pesquisa")String pesquisa);
}
