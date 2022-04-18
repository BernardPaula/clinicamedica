package com.bernardpaula.clinicamedica.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.ExamesComp;
import com.bernardpaula.clinicamedica.repository.ExamesCompRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class ExamesCompService {

	@Autowired
	public ExamesCompRepository repo;
	
	
	public ExamesComp find(Integer id) {
		Optional<ExamesComp> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + "Tipo: " + ExamesComp.class.getName()));
	}
	
}
