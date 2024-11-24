package com.example.tp.employemicroservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "departmentmicroservice", url = "http://localhost:8082")
public interface DepartmentServiceClient {

    @GetMapping("/departments/{id}")
    Department getDepartmentById(@PathVariable Long id);
}