package com.example.HazelcastConcepts.service;

import com.example.HazelcastConcepts.entity.Employee;

public interface EmployeeService {
    Employee getById(Long id);

    Employee getByCode(String code);

    Employee createEmployee(Employee employee);

    Employee updateById(Employee employee);
}
