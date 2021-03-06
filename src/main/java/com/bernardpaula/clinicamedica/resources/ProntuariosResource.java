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

import com.bernardpaula.clinicamedica.domain.Prontuarios;
import com.bernardpaula.clinicamedica.services.ProntuariosService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/prontuarios")
public class ProntuariosResource {

	@Autowired
	private ProntuariosService service;
	
	@ApiOperation(value = "Retorna Prontuarios por id")
	@RequestMapping(value = "/pesquisar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Prontuarios> find (@PathVariable Integer id){
		Prontuarios obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere Prontuarios")
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Prontuarios obj){
		obj.setCdProntuario(null);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCdProntuario()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza Prontuarios")
	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Prontuarios> update(@RequestBody Prontuarios obj, @PathVariable Integer id){
		obj.setCdProntuario(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Remove Prontuarios")
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Lista todos os Prontuarios")
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Prontuarios>> findAll(){
		List<Prontuarios> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Retorna uma p??gina de Prontuarios")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Prontuarios>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "dsPosologia")String orderBy,
			@RequestParam(value = "direction", defaultValue = "0")String direction){
		Page<Prontuarios> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Retorna uma lista de Prontuarios filtrados pela pesquisa")
	@RequestMapping(value="/filtrar/{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<List<Prontuarios>> filtrar(@PathVariable String pesquisa){
		List<Prontuarios> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
}
