package com.bernardpaula.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Convenios;

@Repository
public interface ConveniosRepository extends JpaRepository<Convenios, Integer>{

	@Query(value="SELECT * FROM convenios WHERE nm_convenio LIKE %:pesquisa%", nativeQuery=true)
	public List<Convenios> filtrar(@Param("pesquisa")String pesquisa);
	
}
