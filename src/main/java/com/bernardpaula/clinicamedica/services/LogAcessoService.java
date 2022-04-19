package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.LogAcesso;
import com.bernardpaula.clinicamedica.repository.LogAcessoRepository;
import com.bernardpaula.clinicamedica.services.exceptions.DataIntegrityException;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class LogAcessoService {


	@Autowired
	public LogAcessoRepository repo;
	
	
	public LogAcesso find(Integer id) {
		Optional<LogAcesso> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo" + LogAcesso.class.getName()));
		}
	
	public LogAcesso insert(LogAcesso obj) {
		return repo.save(obj);
	}
	
	public LogAcesso update(LogAcesso obj) {
		LogAcesso newObj = find(obj.getCd_acesso());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(LogAcesso newObj, LogAcesso obj) {
		newObj.setCd_acesso(obj.getCd_acesso());
		newObj.setNm_usuario(obj.getNm_usuario());
	}
	
	public void delete (Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir LogAcesso");
		}
	}
	
	public List<LogAcesso> findAll(){
		return repo.findAll();
	}
	
	
}
