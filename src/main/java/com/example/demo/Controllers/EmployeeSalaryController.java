package com.example.demo.Controllers;

import com.example.demo.Entities.Department;
import com.example.demo.Entities.EmployeeSalary;
import com.example.demo.Exceptions.DepartmentNotFoundException;
import com.example.demo.Exceptions.EmployeeSalaryNotFoundException;
import com.example.demo.Services.EmployeeSalaryService;
import com.example.demo.Services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeSalaryController {
    public EmployeeSalaryService employeeSalaryService;

    public EmployeeSalaryController(EmployeeSalaryService employeeSalaryService) {
        this.employeeSalaryService = employeeSalaryService;
    }

    @PostMapping("/employeesalaries")
    public EmployeeSalary create(@RequestBody EmployeeSalary employeeSalary) {
//        System.out.println(employeeSalary);
//        System.out.println(employee_id);
        return employeeSalaryService.create(employeeSalary);
    }
    @GetMapping("/employeesalaries/{id}")
    EmployeeSalary one(@PathVariable Long id) {

        return employeeSalaryService.findById(id)
                .orElseThrow(() -> new EmployeeSalaryNotFoundException(id));
    }

    @GetMapping("/employeesalaries/all")
    List<EmployeeSalary> all() {
        return employeeSalaryService.findAll();
    }

    @PutMapping("/employeesalaries/{id}")
    EmployeeSalary updateEmployeeSalary(@RequestBody EmployeeSalary newEmployeeSalary, @PathVariable Long id) {

        return employeeSalaryService.findById(id)
                .map(employeeSalary -> {
                    employeeSalary.setAmount(newEmployeeSalary.getAmount());
                    employeeSalary.setDescription(newEmployeeSalary.getDescription());
                    employeeSalary.setId(newEmployeeSalary.getId());
                    employeeSalary.setPayment_date(newEmployeeSalary.getPayment_date());
                    employeeSalary.setStatus(newEmployeeSalary.getStatus());

                    return employeeSalaryService.update(employeeSalary);
                })
                .orElseGet(() -> {
                    newEmployeeSalary.setId(id);
                    return employeeSalaryService.update(newEmployeeSalary);
                });
    }

    @PutMapping("/employeesalaries/flip/{id}")
    EmployeeSalary flipEmployeeSalary(@PathVariable Long id) {

        return employeeSalaryService.findById(id)
                .map(employeeSalary -> {
                    if(employeeSalary.getStatus() == 0)
                        employeeSalary.setStatus(1);
                    return employeeSalaryService.update(employeeSalary);
                })
                .orElseThrow();
    }

    @DeleteMapping("/employeesalaries/{id}")
    void deleteEmployeeSalary(@PathVariable Long id) {
        employeeSalaryService.delete(id);
    }
}
