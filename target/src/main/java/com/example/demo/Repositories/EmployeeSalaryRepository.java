package com.example.demo.Repositories;

import com.example.demo.Entities.Employee;
import com.example.demo.Entities.EmployeeSalary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeSalaryRepository extends CrudRepository<EmployeeSalary, Long> {
    List<EmployeeSalary> findEmployeeSalariesByEmployee(Employee employee);
}
