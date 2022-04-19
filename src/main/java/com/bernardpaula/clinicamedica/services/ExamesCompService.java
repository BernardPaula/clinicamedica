package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
		ExamesComp newObj = find(obj.getCd_exame_comp());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	
	public void updateData(ExamesComp newObj, ExamesComp obj) {
		newObj.setCd_receita(obj.getCd_receita());
		newObj.setDs_observacao(obj.getDs_observacao());
		newObj.setNm_exame(obj.getNm_exame());
	}
	
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	
	public List<ExamesComp> findAll(){
		return repo.findAll();
	}
	
}
