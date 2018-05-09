package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.EmployeeDao;
import com.xsis.bootcamp.model.Employee;
import com.xsis.bootcamp.util.GeneralVariable;
import com.xsis.bootcamp.util.SessionHibernate;

@Repository
public class EmployeeDaoImpl extends SessionHibernate implements EmployeeDao {

	@Override
	public Employee get(Integer idEmployee) throws Exception {
		Employee employee = getSession().get(Employee.class, idEmployee);
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Employee> listAll() throws Exception {
		String query = new StringBuilder().append("from Employee where isDelete = " + GeneralVariable.ISDELETE_FALSE).toString();
		return getSession().createQuery(query).list();
	}
	
}
