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
@Table(name = Mrole.TABLE_NAME)
public class Mrole extends CommonModel {
	private static final long serialVersionUID = 1806250763168915486L;

	public static final String TABLE_NAME = "m_role";

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = TABLE_NAME)
	@TableGenerator(name = TABLE_NAME, table = "T_SEQUENCE", pkColumnName = "SEQ_NAME", pkColumnValue = TABLE_NAME, valueColumnName = "SEQ_VAL", allocationSize = 1, initialValue = 1)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "code", nullable = false, length = 50)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = false, length = 255)
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
