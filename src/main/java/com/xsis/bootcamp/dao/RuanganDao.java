package com.xsis.bootcamp.dao;

import java.util.Collection;

import com.xsis.bootcamp.model.Ruangan;

public interface RuanganDao {
	public Collection<Ruangan> listRuangan() throws Exception;
	public void insertRuangan(Ruangan ruangan) throws Exception;
	public void updateRuangan(Ruangan ruangan) throws Exception;
	public void deleteRuangan(Ruangan ruangan) throws Exception;
}
