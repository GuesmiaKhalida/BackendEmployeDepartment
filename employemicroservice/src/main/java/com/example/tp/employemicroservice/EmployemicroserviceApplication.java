package com.example.tp.employemicroservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class EmployemicroserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployemicroserviceApplication.class, args);


	}
	@Bean
	CommandLineRunner star(EmployeRepository employeRepository) {
		return args->{
			employeRepository.save(new Employe(null,"Aichaoui","Aicha","aicha1.aicha1@adressemail.com",1L));
			employeRepository.save(new Employe(null,"Mohamed","Ahmed","mohamed.ahmed@adressemail.com",1L));
			employeRepository.save(new Employe(null,"Guesmia","Bilal","guesmia.bilal@adressemail.com",2L));
			employeRepository.findAll().forEach(emp-> {System.out.println(emp.toString());});
		};
	}


}
