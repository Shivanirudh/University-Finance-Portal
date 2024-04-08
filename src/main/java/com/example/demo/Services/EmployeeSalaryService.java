package com.example.demo.Services;

import com.example.demo.Entities.Employee;
import com.example.demo.Entities.EmployeeSalary;
import com.example.demo.Exceptions.EmployeeNotFoundException;
import com.example.demo.Repositories.EmployeeRepository;
import com.example.demo.Repositories.EmployeeSalaryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeSalaryService {
    private final EmployeeSalaryRepository employeeSalaryRepository;

    public EmployeeSalaryService(EmployeeSalaryRepository employeeSalaryRepository) {
        this.employeeSalaryRepository = employeeSalaryRepository;
    }

    public EmployeeSalary create(EmployeeSalary employeeSalary){
//        EmployeeRepository employeeRepository = null;
//        Employee employee = new EmployeeService(employeeRepository).findById(employee_id).orElseThrow(() -> new EmployeeNotFoundException(employee_id));
//        System.out.println(employee);
//        employeeSalary.setEmployee_id(employee);
        return employeeSalaryRepository.save(employeeSalary);
    }

    public List<EmployeeSalary> findAll(){
        List<EmployeeSalary> employeeSalaries = new ArrayList<>();
        employeeSalaryRepository.findAll().forEach(employeeSalaries::add);

        return employeeSalaries;
    }

    public Optional<EmployeeSalary> findById(Long id) {
        return employeeSalaryRepository.findById(id);
    }

    public EmployeeSalary update(EmployeeSalary employeeSalary) {
        return employeeSalaryRepository.save(employeeSalary);
    }

    public void delete(Long id) {
        employeeSalaryRepository.deleteById(id);
    }
}
