package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Prontuarios;
import com.bernardpaula.clinicamedica.repository.ProntuariosRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class ProntuariosService {
	
	@Autowired
	public ProntuariosRepository repo;
	
	public Prontuarios find(Integer id) {
		Optional<Prontuarios> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
		"Objeto não encontrado! id: " + id + "Tipo: " + Prontuarios.class.getName()));
	}
	
	public Prontuarios insert(Prontuarios obj) {
		return repo.save(obj);
	}
	
	public Prontuarios update(Prontuarios obj) {
		Prontuarios newObj = find(obj.getCd_prontuario());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(Prontuarios newObj, Prontuarios obj) {
		newObj.setCd_medicamento(obj.getCd_medicamento());
		newObj.setCd_exame(obj.getCd_exame());
		newObj.setCd_paciente(obj.getCd_paciente());
		newObj.setDs_observacao(obj.getDs_observacao());
		newObj.setDs_posologia(obj.getDs_posologia());
		newObj.setDs_resultado(obj.getDs_resultado());
		newObj.setDt_exame(obj.getDt_exame());
		newObj.setDt_finalmed(obj.getDt_finalmed());
		newObj.setDt_iniciomed(obj.getDt_iniciomed());
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	
	public List<Prontuarios> findAll(){
		return repo.findAll();
	}
}
