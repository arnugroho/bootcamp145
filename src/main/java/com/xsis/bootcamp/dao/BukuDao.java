package com.xsis.bootcamp.dao;

import java.util.Collection;

import com.xsis.bootcamp.model.Buku;

public interface BukuDao {
	
	public void insert(Buku buku) throws Exception;

	public void update(Buku buku) throws Exception;

	public void delete(Buku buku) throws Exception;
	
	public Collection<Buku> listAll() throws Exception;
	
	public Buku get(Long idBuku) throws Exception;

}
