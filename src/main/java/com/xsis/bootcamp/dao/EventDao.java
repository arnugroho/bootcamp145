package com.xsis.bootcamp.dao;

import java.util.Collection;

import com.xsis.bootcamp.model.Event;

public interface EventDao {
	
	public abstract void insert(Event event) throws Exception;

	public abstract void update(Event event) throws Exception;

	public abstract void delete(Event event) throws Exception;

	public abstract Collection<Event> listAll() throws Exception;
	
	public Event get(int idEvent) throws Exception;
}
