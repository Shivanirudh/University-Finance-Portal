package com.example.demo.Repositories;

import com.example.demo.Entities.Department;
import com.example.demo.Entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Query("select e from Employee e where e.department.department_id = (select d.department_id from Department d where d.name='Accounts')")
    List<Employee> findEmployeesByDepartment();
    Employee findEmployeeByEmail(String email);
}
