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

import com.bernardpaula.clinicamedica.domain.Receitas;
import com.bernardpaula.clinicamedica.services.ReceitasService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitasResource {

	@Autowired
	public ReceitasService service;
	
	@ApiOperation(value = "Retorna Receitas por id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Receitas> find (@PathVariable Integer id){
		Receitas obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere Receitas")
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Receitas obj){
		obj.setCd_receitas(null);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCd_receitas()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza Receitas")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Receitas obj, @PathVariable Integer id){
		obj.setCd_receitas(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Remove Receitas")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Lista todas as Receitas")
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Receitas>> findAll(){
		List<Receitas> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
