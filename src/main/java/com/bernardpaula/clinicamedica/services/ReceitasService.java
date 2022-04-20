package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
		Receitas newObj = find(obj.getCd_receitas());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(Receitas newObj, Receitas obj) {
		newObj.setCd_clinica(obj.getCd_clinica());
		newObj.setCd_exame(obj.getCd_exame());
		newObj.setCd_medicamento(obj.getCd_medicamento());
		newObj.setCd_medico(obj.getCd_medico());
		newObj.setCd_paciente(obj.getCd_paciente());
		newObj.setDs_observacoes(obj.getDs_observacoes());
		newObj.setDs_posologia(obj.getDs_posologia());
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	
	public List<Receitas> findAll(){
		return repo.findAll();
	}
	
}
