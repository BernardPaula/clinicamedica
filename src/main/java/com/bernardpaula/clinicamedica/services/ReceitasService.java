package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Receitas;
import com.bernardpaula.clinicamedica.repository.ReceitasRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class ReceitasService {

	@Autowired
	public ReceitasRepository repo;
	
	public Receitas find(Integer id) {
		Optional<Receitas> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
		"Objeto não encontrado! id: " + id + "Tipo: " + Receitas.class.getName()));
	}
	
	public Receitas insert(Receitas obj) {
		return repo.save(obj);
	}
	
	public Receitas update(Receitas obj) {
		Receitas newObj = repo.save(obj);
		return find(newObj.getCdReceitas());
	}

	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	
	public List<Receitas> findAll(){
		return repo.findAll();
	}
	
	public Page<Receitas> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Receitas> filtrar(String pesquisa){
		return repo.filtrar(pesquisa);
	}
}
