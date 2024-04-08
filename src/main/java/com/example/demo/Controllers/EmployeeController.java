package com.example.demo.Controllers;

import com.example.demo.Entities.EmpSaveDto;
import com.example.demo.Entities.Employee;
import com.example.demo.Exceptions.EmployeeNotFoundException;
import com.example.demo.Services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    public EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {

        return employeeService.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return employeeService.findById(id)
                .map(employee -> {
                    employee.setFirst_name(newEmployee.getFirst_name());
                    employee.setLast_name(newEmployee.getLast_name());
                    employee.setEmail(newEmployee.getEmail());
                    employee.setTitle(newEmployee.getTitle());
                    employee.setPhotograph_path(newEmployee.getPhotograph_path());
                    employee.setDepartment(newEmployee.getDepartment());
                    employee.setPassword(newEmployee.getPassword());
                    return employeeService.update(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setEmployee_id(id);
                    return employeeService.update(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
    }

    @PostMapping("/employees/login")
    public Long authLogin(@RequestParam("email") String email,@RequestParam("password") String password){
        Employee employee = employeeService.findByEmail(email);
        if(employee != null && Objects.equals(employee.getPassword(), password)) {
            System.out.println(employee.toString());
            return employee.getEmployee_id();
        }
        else{
            System.out.println("Invalid username or password");
            return 0L;
        }

    }

}
