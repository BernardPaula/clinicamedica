package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Laudos;
import com.bernardpaula.clinicamedica.repository.LaudosRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class LaudosService {

	@Autowired
	public LaudosRepository repo;
	
	
	public Laudos find(Integer id) {
		Optional<Laudos> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
		"Objeto não encontrado! id: " + id + "Tipo: " + Laudos.class.getName()));
	}
	
	public Laudos insert(Laudos obj) {
		return repo.save(obj);
	}
	
	public Laudos update(Laudos obj) {
		Laudos newObj = repo.save(obj);
		return find(newObj.getCdLaudo());
	}
	
	
	public void delete (Integer id) {
		repo.deleteById(id);
	}
	
	public List<Laudos> findAll(){
		return repo.findAll();
	}
	
	public Page<Laudos> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Laudos> filtrar(String pesquisa){
		return repo.filtrar(pesquisa);
	}
}
