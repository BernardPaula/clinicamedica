package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
		LogAcesso newObj = repo.save(obj);	
		return find(newObj.getCdAcesso());
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
	
	public Page<LogAcesso> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<LogAcesso> filtrar(String pesquisa){
		return repo.filtrar(pesquisa);
	}
	
}
