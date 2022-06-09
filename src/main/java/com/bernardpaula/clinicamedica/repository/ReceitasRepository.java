package com.bernardpaula.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Receitas;

@Repository
public interface ReceitasRepository extends JpaRepository<Receitas, Integer>{

	@Query(value = "SELECT * FROM receitas WHERE ds_posologia LIKE %:pesquisa%", nativeQuery=true)
	List<Receitas> filtrar(@Param("pesquisa")String pesquisa);
}
