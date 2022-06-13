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

import com.bernardpaula.clinicamedica.domain.LogAcesso;
import com.bernardpaula.clinicamedica.services.LogAcessoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/logacessos")
public class LogAcessoResource {

	@Autowired
	private LogAcessoService service;
	
	@ApiOperation(value = "Busca LogAcesso por id")
	@RequestMapping(value = "/pesquisar/{id}", method = RequestMethod.GET)
	public ResponseEntity<LogAcesso> find(@PathVariable Integer id){
		LogAcesso obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere LogAcesso")
	@RequestMapping(value = "/inserir", method = RequestMethod.POST )
	public ResponseEntity<Void> insert(@RequestBody LogAcesso obj){
		obj.setCdAcesso(null);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCdAcesso()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza LogAcesso")
	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<LogAcesso> update(@RequestBody LogAcesso obj, @PathVariable Integer id){
		obj.setCdAcesso(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Remove LogAcesso")
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
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
	
	@ApiOperation(value = "Retorna uma página de LogAcessos")
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<LogAcesso>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nmUsuario")String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		Page<LogAcesso> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Retorna uma lista de LogAcessos filtrados pela pesquisa")
	@RequestMapping(value="/filtrar/{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<List<LogAcesso>> filtrar(@PathVariable String pesquisa){
		List<LogAcesso> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
}
