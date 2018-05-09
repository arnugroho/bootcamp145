package com.xsis.bootcamp.dao;

import java.util.Collection;

import com.xsis.bootcamp.model.Employee;

public interface EmployeeDao {
	public Employee get(Integer idEmployee)throws Exception;
	
	public abstract Collection<Employee> listAll() throws Exception;

}
