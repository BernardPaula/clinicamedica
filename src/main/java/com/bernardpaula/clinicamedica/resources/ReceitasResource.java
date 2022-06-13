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

import com.bernardpaula.clinicamedica.domain.Receitas;
import com.bernardpaula.clinicamedica.services.ReceitasService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitasResource {

	@Autowired
	private ReceitasService service;
	
	@ApiOperation(value = "Retorna Receitas por id")
	@RequestMapping(value = "/pesquisar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Receitas> find (@PathVariable Integer id){
		Receitas obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere Receitas")
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Receitas obj){
		obj.setCdReceitas(null);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCdReceitas()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza Receitas")
	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Receitas> update(@RequestBody Receitas obj, @PathVariable Integer id){
		obj.setCdReceitas(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Remove Receitas")
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
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
	
	@ApiOperation(value = "Retorna uma página de Receitas")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Receitas>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "dsPosologia")String orderBy,
			@RequestParam(value = "direction", defaultValue = "0")String direction){
		Page<Receitas> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Retorna uma lista de Receitas filtradas pela pesquisa")
	@RequestMapping(value = "/filtrar/{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<List<Receitas>> filtrar(@PathVariable String pesquisa){
		List<Receitas> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
	
}
