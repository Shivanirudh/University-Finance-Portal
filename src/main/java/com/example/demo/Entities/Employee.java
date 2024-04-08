package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Entity
public class Employee {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;
    @Getter
    @Column(nullable = false)
    private String first_name;
    @Getter
    private String last_name;
    @Getter
    @Column(nullable = false, unique = true)
    private String email;
    @Getter
    private String title;
    @Getter
    private String photograph_path;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
//    private List<EmployeeSalary> employeeSalary;
//    public List<EmployeeSalary> getEmployeeSalary() {
//        return employeeSalary;
//    }
//
//    public void setEmployeeSalary(List<EmployeeSalary> employeeSalary) {
//        this.employeeSalary = employeeSalary;
//    }


    @Getter
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @Getter
    private String password;

    public Employee(String first_name, String last_name, String email, String title, String photograph_path, String password, Department department) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.title = title;
        this.photograph_path = photograph_path;
        this.password = password;
        this.department = department;
    }

    public Employee() {

    }

    public void setEmployee_id(Long employeeId) {
        this.employee_id = employeeId;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", photograph_path='" + photograph_path + '\'' +
//                ", department=" + department.toString() +
                '}';
    }
}
