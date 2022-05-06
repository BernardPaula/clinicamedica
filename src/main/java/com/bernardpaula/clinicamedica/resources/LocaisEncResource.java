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

import com.bernardpaula.clinicamedica.domain.LocaisEnc;
import com.bernardpaula.clinicamedica.services.LocaisEncService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/locaisenc")
public class LocaisEncResource {

	@Autowired
	public LocaisEncService service;
	
	@ApiOperation(value = "Busca LocaisEnc por id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<LocaisEnc> find(@PathVariable Integer id){
		LocaisEnc obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere LocaisEnc")
	@RequestMapping(value = "/inserir", method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody LocaisEnc obj){
		obj.setCod_local_enc(null);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCod_local_enc()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza LocaisEnc")
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody LocaisEnc obj, @PathVariable Integer id){
		obj.setCod_local_enc(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Remove LocaisEnc")
	@RequestMapping(value = "/{id}", method =RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Lista todos os LocaisEnc")
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	public ResponseEntity<List<LocaisEnc>> findAll(){
		List<LocaisEnc> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
