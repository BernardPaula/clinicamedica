package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Pacientes;
import com.bernardpaula.clinicamedica.repository.PacientesRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class PacientesService {

	@Autowired
	public PacientesRepository repo;
	
	public Pacientes find(Integer id) {
		Optional<Pacientes> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + "Tipo: " + Pacientes.class.getName()));
	}
	
	public Pacientes insert (Pacientes obj) {
		return repo.save(obj);
	}
	
	
	public Pacientes update(Pacientes obj) {
		Pacientes newObj = repo.save(obj);		
		return find(newObj.getCdPaciente());
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Pacientes> findAll(){
		return repo.findAll();
	}
	
	public Page<Pacientes> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Pacientes> filtrar(String pesquisa){
		return repo.filtrar(pesquisa);
	}
}
