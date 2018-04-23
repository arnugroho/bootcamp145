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
@Table(name = Personel.TABLE_NAME)
public class Personel extends CommonModel {
	private static final long serialVersionUID = -410528525061506841L;
	public static final String TABLE_NAME = "tb_m_user";
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = Personel.TABLE_NAME)
	@TableGenerator(name = Personel.TABLE_NAME, table = "T_SEQUENCE", pkColumnName = "SEQ_NAME", pkColumnValue = Personel.TABLE_NAME, valueColumnName = "SEQ_VAL", allocationSize = 1, initialValue = 1)
	private Long id; //
	@Column(name = "username", nullable = false, unique=true)
	private String username; //
	@Column(name = "password", nullable = false)
	private String password; //
	@Column(name = "roleid", nullable = false)
	private Integer roleId; //
	@Column(name = "isactive", nullable = false)
	private Integer isActive; //
	@Column(name = "usercode", nullable = false)
	private String userCode; //
	@Column(name = "email", nullable = false, unique=true)
	private String email; //

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
