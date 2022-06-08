package com.bernardpaula.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Cargos;

@Repository
public interface CargosRepository extends JpaRepository<Cargos, Integer> {

	@Query(value = "SELECT * FROM cargos WHERE nm_cargo like %:pesquisa%", nativeQuery=true)
	List<Cargos> filtrarPesquisa(@Param("pesquisa")String pesquisa);
}
