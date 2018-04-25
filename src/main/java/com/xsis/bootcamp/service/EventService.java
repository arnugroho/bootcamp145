package com.xsis.bootcamp.service;

import java.util.Collection;

import com.xsis.bootcamp.model.Event;

public interface EventService {

	public Event getEvent(int id) throws Exception;
	
	public abstract void insert(Event event) throws Exception;

	public abstract void update(Event event) throws Exception;

	public abstract void delete(Event event) throws Exception;
	
	public abstract Collection<Event> listAll() throws Exception;
	 
}
