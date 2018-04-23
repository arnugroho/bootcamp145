package com.xsis.bootcamp.dao;

import java.util.Collection;

import com.xsis.bootcamp.model.Mahasiswa;

public interface MahasiswaDao {
	public Collection<Mahasiswa> listMahasiswa() throws Exception;
	public Mahasiswa getMahasiswa(int nim) throws Exception;
	public void insertMahasiswa (Mahasiswa mahasiswa) throws Exception;
	public void updateMahasiswa (Mahasiswa mahasiswa) throws Exception;
	public void deleteMahasiswa (Mahasiswa mahasiswa) throws Exception;

}
