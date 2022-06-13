package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Clinicas;
import com.bernardpaula.clinicamedica.repository.ClinicasRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class ClinicasService {

	@Autowired
	public ClinicasRepository repo;
	
	
	public Clinicas find(Integer id) {
		Optional<Clinicas> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Objeto não encontrado! Id: " + id + "Tipo: " + Clinicas.class.getName()));
	}
	
	public Clinicas insert(Clinicas obj) {
		obj.setCdClinica(null);
		return repo.save(obj);
	}
	
	public Clinicas update (Clinicas obj) {
		
	Clinicas objCurrent = repo.save(obj);
	return find(objCurrent.getCdClinica());
	}
	

	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
		}
	
	public List<Clinicas> findAll(){
		return repo.findAll();
	}
	
	public Page<Clinicas> findPage(Integer nome, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(nome, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Clinicas> filtrar(String pesquisa){
		return repo.filtrarPesquisa(pesquisa);
	}
}
