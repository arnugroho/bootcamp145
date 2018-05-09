package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.xsis.bootcamp.dao.EmployeeDao;
import com.xsis.bootcamp.model.Employee;
import com.xsis.bootcamp.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public Employee get(Integer idEmployee) throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.get(idEmployee);
	}

	@Override
	public Collection<Employee> listAll() throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.listAll();
	}

}
