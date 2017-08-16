package com.model.dao;

import java.util.ArrayList;

import com.model.bean.Employee;
public interface EmployeeDAO {
	ArrayList<Employee> displayAll();
	Employee searchById(int Id);
	boolean insert(Employee Emp);
	boolean delete(int Id);
}
