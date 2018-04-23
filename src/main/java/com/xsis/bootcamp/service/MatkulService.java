package com.xsis.bootcamp.service;

import java.util.Collection;

import com.xsis.bootcamp.model.Matkul;

public interface MatkulService {
	public Collection<Matkul> listMatkul() throws Exception;
	public Matkul getMatkul (int idMatkul) throws Exception;
	public void insertMatkul (Matkul matkul) throws Exception;
	public void updateMatkul (Matkul matkul) throws Exception;
	public void deleteMatkul (Matkul matkul) throws Exception;
}
