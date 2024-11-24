package com.example.tp.departmentmicroservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DepartmentmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentmicroserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner star(DepartmentRepository  departmentRepository) {
		return args->{
			departmentRepository.save(new Department(null,"Informatique"));
			departmentRepository.save(new Department(null,"Mathematique"));
			departmentRepository.save(new Department(null,"Physique"));
			departmentRepository.findAll().forEach(dpt-> {System.out.println(dpt.toString());});
		};
	}
}
