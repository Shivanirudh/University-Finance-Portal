package com.example.demo.Services;

import com.example.demo.Entities.Department;
import com.example.demo.Entities.Employee;
import com.example.demo.Exceptions.DepartmentNotFoundException;
import com.example.demo.Repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
//    private final DepartmentRepository departmentRepository;

//    public EmployeeService() {
//    }

    public EmployeeService(EmployeeRepository employeeRepository) {
        //        this.departmentRepository=departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee employee){

//        Department department = new DepartmentService().findById(department_id).orElseThrow(() -> new DepartmentNotFoundException(department_id));
//        Employee employee1 = new Employee(employee.getFirst_name(),employee.getLast_name(), employee.getEmail(), employee.getTitle(), employee.getPhotograph_path(), employee.getPassword(), employee.getDepartment());
//        employee1.setDepartment(department);

//        department.


        return employeeRepository.save(employee);
    }

    public List<Employee> findAll(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);

        return employees;
    }

    public Employee findByEmail(String email){return employeeRepository.findEmployeeByEmail(email);}

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
