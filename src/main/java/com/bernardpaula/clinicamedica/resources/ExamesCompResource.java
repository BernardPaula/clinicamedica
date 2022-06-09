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

import com.bernardpaula.clinicamedica.domain.ExamesComp;
import com.bernardpaula.clinicamedica.services.ExamesCompService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/examescomps")
public class ExamesCompResource {

	@Autowired
	private ExamesCompService service;
	
	@ApiOperation(value = "Busca ExamesComp por id")
	@RequestMapping(value = "/pesquisar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ExamesComp> find(@PathVariable Integer id){
		ExamesComp obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere ExamesComp")
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ExamesComp obj){
		obj.setCd_exame_comp(null);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCd_exame_comp()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza ExamesComp")
	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ExamesComp> update (@RequestBody ExamesComp obj, @PathVariable Integer id){
		obj.setCd_exame_comp(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Remove ExamesComp")
	@RequestMapping(value = "/deletar/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Retorna todos os ExamesComp")
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	public ResponseEntity<List<ExamesComp>> findAll(){
		List<ExamesComp> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value="Retorna uma página de ExamesComp")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ExamesComp>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nm_exame")String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		Page<ExamesComp> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value= "Retorna uma lista de ExamesComp filtrados pela pesquisa")
	@RequestMapping(value="/filtrar/{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<List<ExamesComp>> filtrar(@PathVariable String pesquisa){
		List<ExamesComp> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
}
