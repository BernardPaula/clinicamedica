package com.bernardpaula.clinicamedica.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Clinicas;
import com.bernardpaula.clinicamedica.repository.ClinicasRepository;

@Service
public class ClinicasService {

	@Autowired
	private ClinicasRepository repo;
	
	
	public Clinicas find(Integer id) {
		Optional<Clinicas> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException (
			"Objeto não encontrado! Id: " + id + "Tipo: " + Clinicas.class.getName()));
	}
	
	public Clinicas insert(Clinicas obj) {
		obj.setCd_clinica(null);
		return repo.save(obj);
	}
	
}
