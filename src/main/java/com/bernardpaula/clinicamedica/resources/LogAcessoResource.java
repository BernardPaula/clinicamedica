package com.bernardpaula.clinicamedica.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bernardpaula.clinicamedica.domain.LogAcesso;
import com.bernardpaula.clinicamedica.services.LogAcessoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/logacessos")
public class LogAcessoResource {

	@Autowired
	public LogAcessoService service;
	
	@ApiOperation(value = "Busca LogAcesso por id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<LogAcesso> find(@PathVariable Integer id){
		LogAcesso obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere LogAcesso")
	@RequestMapping(value = "/inserir", method = RequestMethod.POST )
	public ResponseEntity<Void> insert(@RequestBody LogAcesso obj){
		obj.setCd_acesso(null);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCd_acesso()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza LogAcesso")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody LogAcesso obj, @PathVariable Integer id){
		obj.setCd_acesso(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Remove LogAcesso")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Listar todos os LogAcessos")
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<LogAcesso>> findAll(){
		List<LogAcesso> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
}
