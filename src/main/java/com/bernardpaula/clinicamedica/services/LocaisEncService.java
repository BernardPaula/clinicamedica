package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
		LocaisEnc newObj = find(obj.getCod_local_enc());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(LocaisEnc newObj, LocaisEnc obj) {
		newObj.setCd_exame_comp(obj.getCd_exame_comp());
		newObj.setDs_endereco(obj.getDs_endereco());
		newObj.setDs_observacoes(obj.getDs_observacoes());
		newObj.setNm_clinica(obj.getNm_clinica());
		newObj.setNr_telefone(obj.getNr_telefone());
	}
	
	public void delete (Integer id) {
		repo.deleteById(id);
	}
	
	public List<LocaisEnc> findAll(){
		return repo.findAll();
	}
	
	
	
}
