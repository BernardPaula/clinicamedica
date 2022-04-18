package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Cargos;
import com.bernardpaula.clinicamedica.repository.CargosRepository;
import com.bernardpaula.clinicamedica.services.exceptions.DataIntegrityException;
import com.bernardpaula.cursomc.domain.Pedido;

@Service
public class CargosService {

	@Autowired
	private CargosRepository repo;
	
	
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
		return newObj;
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
	
}
