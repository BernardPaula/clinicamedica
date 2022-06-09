package com.bernardpaula.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.LogAcesso;

@Repository
public interface LogAcessoRepository extends JpaRepository<LogAcesso, Integer>{

	@Query(value = "SELECT * FROM log_acesso WHERE nm_usuario LIKE %:pesquisa%", nativeQuery=true)
	List<LogAcesso> filtrar(@Param("pesquisa")String pesquisa);
	
}
