package com.xsis.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.xsis.bootcamp.model.common.CommonModel;

@Entity
@Table(name = Buku.TABLE_NAME)
public class Buku extends CommonModel{
	private static final long serialVersionUID = 5100344803426903598L;
	public static final String TABLE_NAME = "tb_m_buku";
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = Buku.TABLE_NAME)
	@TableGenerator(name = Buku.TABLE_NAME, table = "T_SEQUENCE", pkColumnName = "SEQ_NAME", pkColumnValue = Buku.TABLE_NAME, valueColumnName = "SEQ_VAL", allocationSize = 1, initialValue = 1)
	private Long id; //
	
	@Column(name = "nama_buku")
	private String namaBuku; //
	
	@Column(name = "pengarang")
	private String pengarang;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamaBuku() {
		return namaBuku;
	}

	public void setNamaBuku(String namaBuku) {
		this.namaBuku = namaBuku;
	}

	public String getPengarang() {
		return pengarang;
	}

	public void setPengarang(String pengarang) {
		this.pengarang = pengarang;
	}
	
	

}
