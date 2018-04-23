package com.xsis.bootcamp.service;

import java.util.Collection;

import com.xsis.bootcamp.model.Ruangan;

public interface RuanganService {
	public Collection<Ruangan> listRuangan() throws Exception;
	public void insertRuangan(Ruangan ruangan) throws Exception;
	public void updateRuangan(Ruangan ruangan) throws Exception;
	public void deleteRuangan(Ruangan ruangan) throws Exception;

}
