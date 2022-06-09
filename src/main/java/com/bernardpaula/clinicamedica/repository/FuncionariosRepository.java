package com.bernardpaula.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Funcionarios;

@Repository
public interface FuncionariosRepository extends JpaRepository<Funcionarios, Integer>{

	@Query(value = "SELECT * FROM funcionarios WHERE nm_funcionario LIKE %:pesquisa%", nativeQuery=true)
	List<Funcionarios> filtrar(@Param("pesquisa")String pesquisa);
	
}
