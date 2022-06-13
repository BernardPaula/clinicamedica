package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Convenios;
import com.bernardpaula.clinicamedica.repository.ConveniosRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class ConveniosService {

	@Autowired 
	public ConveniosRepository repo;
	
	
	
	public Convenios find (Integer id) {
		Optional<Convenios> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! id: " + id + "Tipo: " + Convenios.class.getName()));
	}
	
	
	public Convenios insert (Convenios obj) {
		obj.setCdConvenio(null);
		return repo.save(obj);
	}
	
	public Convenios update(Convenios obj) {
		Convenios newObj = repo.save(obj);
		return find(newObj.getCdConvenio());
	}
	
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public List<Convenios> findAll(){
		return repo.findAll();
	}
	
	public Page<Convenios> findPage(Integer nome, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(nome, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Convenios> filtrar(String pesquisa){
		return repo.filtrar(pesquisa);
	}
}
