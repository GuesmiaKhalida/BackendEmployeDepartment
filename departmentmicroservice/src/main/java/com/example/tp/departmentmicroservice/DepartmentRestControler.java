package com.example.tp.departmentmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentRestControler {
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @PostMapping
    public Department save(@RequestBody Department dpt){
        return departmentRepository.save(dpt);
    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable(name="id") Long id){
        departmentRepository.deleteById(id);
    }

    @PutMapping(value="/{id}")
    public Department updateEmp(@PathVariable(name="id") Long id, @RequestBody Department dpt){
        dpt.setId(id);
        return departmentRepository.save(dpt);
    }

    @GetMapping(value="/{id}")
    public Department getDepartment(@PathVariable(name="id") Long id){
        return departmentRepository.findById(id).get();
    }




}
