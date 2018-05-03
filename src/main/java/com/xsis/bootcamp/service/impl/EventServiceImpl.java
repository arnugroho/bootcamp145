package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.BukuDao;
import com.xsis.bootcamp.dao.EventDao;
import com.xsis.bootcamp.model.Event;
import com.xsis.bootcamp.service.EventService;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;
	
	public void insert(Event event) throws Exception {
		// TODO Auto-generated method stub
		eventDao.insert(event);
	}

	public void update(Event event) throws Exception {
		// TODO Auto-generated method stub
		eventDao.update(event);
	}

	public void delete(Event event) throws Exception {
		// TODO Auto-generated method stub
		eventDao.delete(event);
	}

	public Collection<Event> listAll() throws Exception {
		// TODO Auto-generated method stub
		return eventDao.listAll();
	}

	@Override
	public Event get(int idEvent) throws Exception {
	
		return eventDao.get(idEvent);
	}


}
