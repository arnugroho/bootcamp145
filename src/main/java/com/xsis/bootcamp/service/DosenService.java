package com.xsis.bootcamp.service;

import java.util.Collection;

import com.xsis.bootcamp.model.Dosen;

public interface DosenService {
	public Collection<Dosen> listDosen () throws Exception;
	public Dosen getDosen (int nikDosen) throws Exception;
	public void insertDosen (Dosen dosen) throws Exception;
	public void updateDosen (Dosen dosen) throws Exception;
	public void deleteDosen (Dosen dosen) throws Exception;
}
