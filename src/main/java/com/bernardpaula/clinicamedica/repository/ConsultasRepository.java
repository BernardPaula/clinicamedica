package com.bernardpaula.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Consultas;

@Repository
public interface ConsultasRepository extends JpaRepository<Consultas,Integer> {

	@Query(value="SELECT * FROM consultas WHERE ds_tipo LIKE %:pesquisa%", nativeQuery=true)
	List<Consultas> filtrar(@Param(value="pesquisa")String consulta);
	
}
