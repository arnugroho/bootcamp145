package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.EventDao;
import com.xsis.bootcamp.model.Event;
import com.xsis.bootcamp.util.SessionHibernate;

@Repository
public class EventDaoImpl extends SessionHibernate implements EventDao {
	Log log = LogFactory.getLog(super.getClass());
	
	@Override
	public Event getEvent(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Event where id= :iD";
		Query query = session.createQuery(hql);
		query.setInteger("iD", id);
		if (query.list().size() > 0) {
			return (Event) query.list().get(0);
		} else {
			return null;
		}
		
		
	}

	@Override
	public void insert(Event event) throws Exception {
		// TODO Auto-generated method stub
		this.log.debug(new StringBuilder().append("Inserting ").append(event).toString());
		getSession().save(event);
	}

	@Override
	public void update(Event event) throws Exception {
		// TODO Auto-generated method stub
		this.log.debug(new StringBuilder().append("Inserting ").append(event).toString());
		getSession().merge(event);
	}

	@Override
	public void delete(Event event) throws Exception {
		// TODO Auto-generated method stub
		this.log.debug(new StringBuilder().append("Inserting ").append(event).toString());
		getSession().delete(event);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Event> listAll() throws Exception {
		String query = new StringBuilder().append("from Event").toString();
		return getSession().createQuery(query).list();
	}

}
