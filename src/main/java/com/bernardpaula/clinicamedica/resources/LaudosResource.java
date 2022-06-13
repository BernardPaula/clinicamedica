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

import com.bernardpaula.clinicamedica.domain.Laudos;
import com.bernardpaula.clinicamedica.services.LaudosService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/laudos")
public class LaudosResource {

	@Autowired
	private LaudosService service;
	
	@ApiOperation(value = "Busca Laudos por id")
	@RequestMapping(value = "/pesquisar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Laudos> find(@PathVariable Integer id){
		Laudos obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere Laudos")
	@RequestMapping(value = "/inserir", method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Laudos obj){
		obj.setCdLaudo(null);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCdLaudo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza Laudos")
	@RequestMapping(value = "/atualizar/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Laudos> update(@RequestBody Laudos obj, @PathVariable Integer id){
		obj.setCdLaudo(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Remove Laudos")
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Lista todos os Laudos")
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Laudos>> findAll(){
		List<Laudos> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Retorna uma página de Laudos filtrados")
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Laudos>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "dsLaudo")String OrderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		Page<Laudos> list = service.findPage(page, linesPerPage, OrderBy, direction);
		return ResponseEntity.ok().body(list);
		}
	
	@ApiOperation(value = "Retorna uma lista de Laudos filtrados pela pesquisa")
	@RequestMapping(value="/filtrar/{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<List<Laudos>> filtrar(@PathVariable String pesquisa){
		List<Laudos> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
}
