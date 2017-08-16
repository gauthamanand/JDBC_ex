package com.model.bl;
import com.model.dao.EmployeeDaoImpl;
import java.util.ArrayList;

import com.model.bean.Employee;

public class EmployeeBL {
	public ArrayList <Employee> listAllEmployees() {
		ArrayList <Employee> Emp = null;
		EmployeeDaoImpl persistence = new EmployeeDaoImpl();
		Emp = persistence.displayAll();
		return Emp;
	}
	
	public boolean insertEmployee(Employee emp) {
		EmployeeDaoImpl persistence = new EmployeeDaoImpl();
		return (persistence.insert(emp));
	}
	
	public boolean deleteEmployee(int ID) {
		EmployeeDaoImpl persistence = new EmployeeDaoImpl();
		return (persistence.delete(ID));
	}
	
	public Employee searchEmployee(int ID) {
		EmployeeDaoImpl persistence = new EmployeeDaoImpl();
		return (persistence.searchById(ID));
	}
}
