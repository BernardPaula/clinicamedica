package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.LocaisEnc;
import com.bernardpaula.clinicamedica.repository.LocaisEncRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class LocaisEncService {

	@Autowired
	public LocaisEncRepository repo;
	
	
	public LocaisEnc find(Integer id) {
		Optional<LocaisEnc> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
		"Objeto não encontrado! id: " + id + "Tipo: " + LocaisEnc.class.getName()));
	}
	
	public LocaisEnc insert(LocaisEnc obj) {
		return repo.save(obj);
	}
	
	public LocaisEnc update(LocaisEnc obj) {
		LocaisEnc newObj = repo.save(obj);
		return find(newObj.getCodLocalEnc());
	}
	
	public void delete (Integer id) {
		repo.deleteById(id);
	}
	
	public List<LocaisEnc> findAll(){
		return repo.findAll();
	}
	
	public Page<LocaisEnc> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<LocaisEnc> filtrar(String pesquisa){
		return repo.filtrar(pesquisa);
	}
	
	
	
}
