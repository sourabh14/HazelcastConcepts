package com.example.HazelcastConcepts.service.impl;

import com.example.HazelcastConcepts.entity.Employee;
import com.example.HazelcastConcepts.repository.EmployeeRepository;
import com.example.HazelcastConcepts.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    @Cacheable(value = "employee", key="#id")
    public Employee getById(Long id) {
        /*
            @Cacheable is used to demarcate methods that are cacheable - that is, methods for whom the result is
            stored into the cache so on subsequent invocations (with the same arguments), the value in the cache is
            returned without having to actually execute the method.

            @Cacheable annotation allows the user to specify how the key is generated through its key attribute.
            The developer can use SpEL to pick the arguments of interest
         */
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee getByCode(String code) {
        /*
            This method is not cached, so everytime hibernate query will be called
         */
        return employeeRepository.findByCode(code);
    }

    @Override
    @CachePut(value = "employee", key="#employee.id")
    public Employee updateById(Employee employee) {
        /*
            For cases where the cache needs to be updated without interfering with the method execution, one can use
            the @CachePut annotation. That is, the method will always be executed and its result placed into the cache
         */
        return employeeRepository.save(employee);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}
