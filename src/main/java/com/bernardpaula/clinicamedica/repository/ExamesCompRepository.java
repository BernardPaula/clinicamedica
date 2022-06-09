package com.bernardpaula.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.ExamesComp;

@Repository
public interface ExamesCompRepository extends JpaRepository<ExamesComp, Integer> {

	@Query(value="SELECT * FROM exames_comp WHERE nm_exame LIKE %:pesquisa%", nativeQuery=true)
	List<ExamesComp> filtrar(@Param("pesquisa")String pesquisa);
	
}
