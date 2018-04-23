package com.xsis.bootcamp.dao;

import java.util.Collection;

import com.xsis.bootcamp.model.Dosen;

public interface DosenDao {
	
	public Collection<Dosen> listDosen() throws Exception;
	public void insertDosen(Dosen dosen) throws Exception;
	public void updateDosen(Dosen dosen) throws Exception;
	public void deleteDosen(Dosen dosen) throws Exception;
}