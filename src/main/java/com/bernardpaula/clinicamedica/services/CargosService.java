package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Cargos;
import com.bernardpaula.clinicamedica.repository.CargosRepository;
import com.bernardpaula.clinicamedica.services.exceptions.DataIntegrityException;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class CargosService {

	@Autowired
	public CargosRepository repo;
	
	
	public Cargos find(Integer id) {
		Optional<Cargos> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo" + Cargos.class.getName()));
		}
	
	public Cargos insert(Cargos obj) {
		return repo.save(obj);
	}
	
	
	
	public Cargos update(Cargos obj) {
		Cargos newObj = find(obj.getCd_cargo());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(Cargos newObj, Cargos obj) {
		newObj.setDs_cargo(obj.getDs_cargo());
		newObj.setNm_cargo(obj.getNm_cargo());
	}
	
	public void delete (Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir Cargos");
		}
	}
	
	public List<Cargos> findAll(){
		return repo.findAll();
	}
	
	public Page<Cargos> findPage(Integer nome, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(nome, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
