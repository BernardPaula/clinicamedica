package com.bernardpaula.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.LocaisEnc;

@Repository
public interface LocaisEncRepository extends JpaRepository<LocaisEnc, Integer> {

	@Query(value= "SELECT * FROM locais_enc WHERE nm_clinica LIKE %:pesquisa%", nativeQuery=true)
	List<LocaisEnc> filtrar(@Param("pesquisa")String pesquisa);
}
