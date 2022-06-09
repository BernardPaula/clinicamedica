package com.bernardpaula.clinicamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.clinicamedica.domain.Medicamentos;

@Repository
public interface MedicamentosRepository extends JpaRepository<Medicamentos, Integer>{

	@Query(value = "SELECT * FROM medicamentos WHERE nm_medicamento LIKE %:pesquisa%", nativeQuery=true)
	List<Medicamentos> filtrar(@Param("pesquisa")String pesquisa);
	
}
