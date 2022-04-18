package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Convenios;
import com.bernardpaula.clinicamedica.repository.ConveniosRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class ConveniosService {

	@Autowired 
	public ConveniosRepository repo;
	
	
	
	public Convenios find (Integer id) {
		Optional<Convenios> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! id: " + id + "Tipo: " + Convenios.class.getName()));
	}
	
	
	public Convenios insert (Convenios obj) {
		obj.setCd_convenio(null);
		return repo.save(obj);
	}
	
	public Convenios update(Convenios obj) {
		Convenios newObj = find(obj.getCd_convenio());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(Convenios newObj, Convenios obj) {
		newObj.setDs_regioes(obj.getDs_regioes());
		newObj.setDt_inicio(obj.getDt_inicio());
		newObj.setNm_convenio(obj.getNm_convenio());
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public List<Convenios> findAll(){
		return repo.findAll();
	}
	
	
}
