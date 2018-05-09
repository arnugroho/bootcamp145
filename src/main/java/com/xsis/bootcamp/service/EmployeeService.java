package com.xsis.bootcamp.service;

import java.util.Collection;

import com.xsis.bootcamp.model.Employee;

public interface EmployeeService {
	public Employee get(Integer idEmployee) throws Exception;

	public abstract Collection<Employee> listAll() throws Exception;

}
