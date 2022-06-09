package com.bernardpaula.clinicamedica.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bernardpaula.clinicamedica.domain.Convenios;
import com.bernardpaula.clinicamedica.services.ConveniosService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/convenios")
public class ConveniosResource {

	@Autowired
	public ConveniosService service;
	
	@ApiOperation(value = "Busca por id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Convenios> find(@PathVariable Integer id){
		Convenios obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere Conv�nios")
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Convenios obj){
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCd_convenio()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza Conv�nios")
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Convenios obj, @PathVariable Integer id){
		obj.setCd_convenio(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Remove Conv�nios")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Retorna todos os Conv�nios")
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Convenios>> findAll(){
		List<Convenios> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value= "Retorna uma p�gina de Conv�nios")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Convenios>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nm_convenio")String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		Page<Convenios> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Retorna uma lista de Conv�nios filtrada pela pesquisa")
	@RequestMapping(value="/filtrar/{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<List<Convenios>> filtrar(@PathVariable String pesquisa){
		List<Convenios> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
}
