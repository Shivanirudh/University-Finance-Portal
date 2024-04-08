package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class EmployeeSalary {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Getter
    @Column(nullable = false)
    private double amount;
    @Getter
    @Column(nullable = false)
    private Date payment_date;
    @Getter
    private String description;
    @Getter
    private int status;

    public EmployeeSalary() {

    }
    public EmployeeSalary(Employee employee, double amount, Date payment_date, String description, int status) {
        this.employee = employee;
        this.amount = amount;
        this.payment_date = payment_date;
        this.description = description;
        this.status = status;
    }


    public void setEmployee_id(Employee employee) {
        this.employee = employee;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmployeeSalary{" +
                "id=" + id +
                ", employee_id=" + employee.getEmployee_id() +
                ", amount=" + amount +
                ", payment_date=" + payment_date +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
