package com.bernardpaula.clinicamedica.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bernardpaula.clinicamedica.domain.ExamesComp;
import com.bernardpaula.clinicamedica.services.ExamesCompService;

@RestController
@RequestMapping(value = "/exames")
public class ExamesCompResource {

	@Autowired
	public ExamesCompService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ExamesComp> find(@PathVariable Integer id){
		ExamesComp obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
}
