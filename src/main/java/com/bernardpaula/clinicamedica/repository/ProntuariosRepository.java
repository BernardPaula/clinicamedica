package com.bernardpaula.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Prontuarios;

@Repository
public interface ProntuariosRepository extends JpaRepository<Prontuarios, Integer> {

	@Query(value = "SELECT * FROM prontuarios WHERE ds_posologia LIKE %:pesquisa%", nativeQuery=true)
	List<Prontuarios> filtrar(@Param("pesquisa")String pesquisa);
	
}
