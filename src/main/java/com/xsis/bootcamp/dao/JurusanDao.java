package com.xsis.bootcamp.dao;

import java.util.Collection;

import com.xsis.bootcamp.model.Jurusan;

public interface JurusanDao {

	public Collection<Jurusan> listJurusan() throws Exception;

	public void insertJurusan(Jurusan jurusan) throws Exception;

	public void updateJurusan(Jurusan jurusan) throws Exception;

	public void deleteJurusan(Jurusan jurusan) throws Exception;

}
