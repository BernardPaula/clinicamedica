package com.bernardpaula.clinicamedica.services.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.bernardpaula.clinicamedica.domain.Clinicas;
import com.bernardpaula.clinicamedica.repository.ClinicasRepository;
import com.bernardpaula.clinicamedica.resources.exceptions.FieldMessage;



public class ClinicasInsertValidator implements ConstraintValidator<ClinicasInsert, Clinicas> {
	
	@Autowired
	private ClinicasRepository repo;
	
	@Override
	public void initialize(ClinicasInsert ann) {
	}

	@Override
	public boolean isValid(Clinicas cli, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		/*Clinicas cliB = repo.findByEmail(cli.getDs_email());
		if(cliB != null) {
			list.add(new FieldMessage("ds_email", "Email já existente"));
		}
		*/
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
