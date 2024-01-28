package com.spring.Dao;

import java.util.List;

import com.spring.model.Employee;

public interface EmployeeDao {
//to create
public int create(Employee employee);
//to update
public int update(Employee employee);
// to delete
public int delete(int id);
//to fetch employee records based on id from database
public Employee read(int id);
//to fetch all records from database
List<Employee> allEmployee();
}
