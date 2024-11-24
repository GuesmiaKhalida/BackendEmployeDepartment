package com.example.tp.employemicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employes")
public class employeRestControler {
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private DepartmentServiceClient departmentServiceClient;
    @GetMapping
    public List<Employe> getAllEmploye() {
        return employeRepository.findAll();
    }

    @PostMapping
    public Employe save(@RequestBody Employe emp){
        return employeRepository.save(emp);
    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable(name="id") Long id){
        employeRepository.deleteById(id);
    }

    @PutMapping(value="/{id}")
    public Employe updateEmp(@PathVariable(name="id") Long id, @RequestBody Employe emp){
        emp.setId(id);
        return employeRepository.save(emp);
    }



    @GetMapping("/department/{id}")
    public List<Employe> getEmployeesByDepartment(@PathVariable Long id) {

        return employeRepository.findByDepartmentId(id);
    }

    @GetMapping("/{id}")
    public EmployeWithDepartment getEmployeeWithDepartment(@PathVariable Long id) {
        Employe employe = employeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));;
        Department department = departmentServiceClient.getDepartmentById(employe.getDepartmentId());

        return new EmployeWithDepartment(employe, department);
    }
}
