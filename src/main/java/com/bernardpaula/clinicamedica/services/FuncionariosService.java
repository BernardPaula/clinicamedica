package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Funcionarios;
import com.bernardpaula.clinicamedica.repository.FuncionariosRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionariosService {

	@Autowired
	public FuncionariosRepository repo;
	
	
	public Funcionarios find(Integer id) {
		Optional<Funcionarios> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + "Tipo: " + Funcionarios.class.getName()));
	}
	
	public Funcionarios insert(Funcionarios obj) {
		return repo.save(obj);
	}
	
	public Funcionarios update(Funcionarios obj) {
		Funcionarios newObj = repo.save(obj);
		return find(newObj.getCdCargo());
	}
	
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	
	public List<Funcionarios> findAll(){
		return repo.findAll();
	}
	
	public Page<Funcionarios> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
	PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
	return repo.findAll(pageRequest);
	}
	
	public List<Funcionarios> filtrar(String pesquisa){
		return repo.filtrar(pesquisa);
	}
	
}
