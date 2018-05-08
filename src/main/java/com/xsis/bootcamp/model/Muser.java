package com.xsis.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.xsis.bootcamp.model.common.CommonModel;

@Entity
@Table(name = Muser.TABLE_NAME)
public class Muser extends CommonModel {
	private static final long serialVersionUID = -410528525061506841L;
	public static final String TABLE_NAME = "m_user";
	@Id
	@Column(name = "id", length = 11)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = Muser.TABLE_NAME)
	@TableGenerator(name = Muser.TABLE_NAME, table = "T_SEQUENCE", pkColumnName = "SEQ_NAME", pkColumnValue = Muser.TABLE_NAME, valueColumnName = "SEQ_VAL", allocationSize = 1, initialValue = 1)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 50)
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 50)
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "m_employee_id",length = 11)
	private Integer mEmployeeId;

	public Integer getmEmployeeId() {
		return mEmployeeId;
	}

	public void setmEmployeeId(Integer mEmployeeId) {
		this.mEmployeeId = mEmployeeId;
	}

	@Column(name = "m_role_id", length=11)
	private Integer mRoleId;

	public Integer getmRoleId() {
		return mRoleId;
	}

	public void setmRoleId(Integer mRoleId) {
		this.mRoleId = mRoleId;
	}
	
/*	@ManyToOne
	@JoinColumn(name="tb_m_role", insertable=false, updatable=false)
	private Role roleDesc;

	public Role getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(Role roleDesc) {
		this.roleDesc = roleDesc;
	}

	@ManyToOne
	@JoinColumn(name = "m_employee", insertable=false, updatable=false)
	private Employee employeeDesc;

	public Employee getEmployeeDesc() {
		return employeeDesc;
	}

	public void setEmployeeDesc(Employee employeeDesc) {
		this.employeeDesc = employeeDesc;
	}*/

}
