package com.bernardpaula.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Laudos;

@Repository
public interface LaudosRepository extends JpaRepository<Laudos, Integer> {

	@Query(value = "SELECT * FROM laudos WHERE ds_laudo LIKE %:pesquisa%", nativeQuery=true)
	List<Laudos> filtrar(@Param("pesquisa")String pesquisa);
	
}
