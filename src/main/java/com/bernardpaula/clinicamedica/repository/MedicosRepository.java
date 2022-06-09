package com.bernardpaula.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Medicos;

@Repository
public interface MedicosRepository extends JpaRepository<Medicos, Integer> {

	@Query(value = "SELECT * FROM medicos WHERE nm_medico LIKE %:pesquisa%", nativeQuery=true)
	List<Medicos> filtrar(@Param("pesquisa")String pesquisa);
	
}
