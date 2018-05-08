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
@Table(name = Menu.TABLE_NAME)
public class Menu extends CommonModel{
	private static final long serialVersionUID = 1806250763168915486L;

	public static final String TABLE_NAME = "m_menu";
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = TABLE_NAME)
	@TableGenerator(name = TABLE_NAME, table = "T_SEQUENCE", pkColumnName = "SEQ_NAME", pkColumnValue = TABLE_NAME, valueColumnName = "SEQ_VAL", allocationSize = 1, initialValue = 1)
	private Long id;
	
	@Column(name = "code", length = 50, unique=true)
	private String code;
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	@Column(name = "controller", length = 150, nullable = false)
	private String controller;
	@Column(name = "parent_id", length = 11, nullable = false)
	private int parentId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}
