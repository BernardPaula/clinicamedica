package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
	
	public ExamesComp insert(ExamesComp obj) {
		return repo.save(obj);
	}
	
	
	public ExamesComp update(ExamesComp obj) {
		ExamesComp newObj = repo.save(obj);
		return find(newObj.getCdExameComp());
	}
	
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	
	public List<ExamesComp> findAll(){
		return repo.findAll();
	}
	
	public Page<ExamesComp> findPage(Integer nome, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(nome, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<ExamesComp> filtrar(String pesquisa){
		return repo.filtrar(pesquisa);
	}
}
