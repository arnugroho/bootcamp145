package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.EventDao;
import com.xsis.bootcamp.model.Event;
import com.xsis.bootcamp.util.SessionHibernate;

@Repository
public class EventDaoImpl extends SessionHibernate implements EventDao {

	public void insert(Event event) throws Exception {
		// TODO Auto-generated method stub
		getSession().save(event);
	}


	public void update(Event event) throws Exception {
		// TODO Auto-generated method stub
		getSession().merge(event);
	}

	public void delete(Event event) throws Exception {
		// TODO Auto-generated method stub
		getSession().delete(event);
	}

	public Collection<Event> listAll() throws Exception {
		// TODO Auto-generated method stub
		String query = new StringBuilder().append("from Event where is_delete=0").toString();
		return getSession().createQuery(query).list();
	}
	
}
