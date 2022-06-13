package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Consultas;
import com.bernardpaula.clinicamedica.repository.ConsultasRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class ConsultasService {
	
	@Autowired
	public ConsultasRepository repo;
	
	public Consultas find(Integer id) {
		Optional<Consultas> obj = repo.findById(id);
				
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! id:" + id + "Tipo: " + Consultas.class.getName()));	
	}
	
	public Consultas insert(Consultas obj) {
		return repo.save(obj);
	}

	public Consultas update(Consultas obj) {
		Consultas newObj = repo.save(obj);
		return find(newObj.getCdConsulta());
		}
	
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Consultas> findAll(){
		return repo.findAll();
	}
	
	public Page<Consultas> findPage(Integer nome, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(nome, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Consultas> filtrar(String pesquisa){
		return repo.filtrar(pesquisa);
	}
	
}
