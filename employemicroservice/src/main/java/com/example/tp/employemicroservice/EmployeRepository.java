package com.example.tp.employemicroservice;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface EmployeRepository extends JpaRepository<Employe, Long> {
    List<Employe> findByDepartmentId(Long departmentId);
}
