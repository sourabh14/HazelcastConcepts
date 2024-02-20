package com.example.HazelcastConcepts.repository;

import com.example.HazelcastConcepts.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByCode(String code);
}
