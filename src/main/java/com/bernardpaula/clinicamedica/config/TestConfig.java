package com.bernardpaula.clinicamedica.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bernardpaula.clinicamedica.services.DBService;



@Configuration
@Profile("teste")
public class TestConfig {

	@Autowired
	private DBService dbservice;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbservice.instantiateDatabase();
		
		return true;
	}
	
}
