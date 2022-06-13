package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Prontuarios;
import com.bernardpaula.clinicamedica.repository.ProntuariosRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class ProntuariosService {
	
	@Autowired
	public ProntuariosRepository repo;
	
	public Prontuarios find(Integer id) {
		Optional<Prontuarios> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
		"Objeto não encontrado! id: " + id + "Tipo: " + Prontuarios.class.getName()));
	}
	
	public Prontuarios insert(Prontuarios obj) {
		return repo.save(obj);
	}
	
	public Prontuarios update(Prontuarios obj) {
		Prontuarios newObj = repo.save(obj);
		return find(newObj.getCdProntuario());
	}
	
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	
	public List<Prontuarios> findAll(){
		return repo.findAll();
	}
	
	public Page<Prontuarios> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Prontuarios> filtrar(String pesquisa){
		return repo.filtrar(pesquisa);
	}
}
