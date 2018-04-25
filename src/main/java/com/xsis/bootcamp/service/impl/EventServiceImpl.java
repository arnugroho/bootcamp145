package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.EventDao;
import com.xsis.bootcamp.model.Event;
import com.xsis.bootcamp.service.EventService;

@Service
@Transactional
public class EventServiceImpl implements EventService {
@Autowired
public EventDao eventDao;
	@Override
	public Event getEvent(int id) throws Exception {
		// TODO Auto-generated method stub
		return eventDao.getEvent(id);
	}

	@Override
	public void insert(Event event) throws Exception {
		// TODO Auto-generated method stub
		eventDao.insert(event);
	}

	@Override
	public void update(Event event) throws Exception {
		// TODO Auto-generated method stub
		eventDao.update(event);
	}

	@Override
	public void delete(Event event) throws Exception {
		// TODO Auto-generated method stub
		eventDao.delete(event);
	}

	@Override
	public Collection<Event> listAll() throws Exception {
		// TODO Auto-generated method stub
		return eventDao.listAll();
	}

}
