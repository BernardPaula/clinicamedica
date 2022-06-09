package com.bernardpaula.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Pacientes;

@Repository
public interface PacientesRepository extends JpaRepository<Pacientes, Integer> {

	@Query(value = "SELECT * FROM pacientes WHERE nm_paciente LIKE %:pesquisa%", nativeQuery=true)
	List<Pacientes> filtrar(@Param("pesquisa")String pesquisa);
	
}
