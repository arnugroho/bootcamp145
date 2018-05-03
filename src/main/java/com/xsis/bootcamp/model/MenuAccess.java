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
@Table(name = MenuAccess.TABLE_NAME)
public class MenuAccess extends CommonModel {
	private static final long serialVersionUID = -410528525061506841L;
	public static final String TABLE_NAME = "m_menu_access";
	@Id
	@Column(name = "id", length = 11)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = MenuAccess.TABLE_NAME)
	@TableGenerator(name = MenuAccess.TABLE_NAME, table = "T_SEQUENCE", pkColumnName = "SEQ_NAME", pkColumnValue = MenuAccess.TABLE_NAME, valueColumnName = "SEQ_VAL", allocationSize = 1, initialValue = 1)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	@Column(name = "m_menu_id", nullable = false, length = 11)
	private Integer mMenuId;

	public Integer getmMenuId() {
		return mMenuId;
	}

	public void setmMenuId(Integer mMenuId) {
		this.mMenuId = mMenuId;
	}

	@Column(name = "m_role_id", nullable = false, length = 11)
	private Integer mRoleId;

	public Integer getmRoleId() {
		return mRoleId;
	}

	public void setmRoleId(Integer mRoleId) {
		this.mRoleId = mRoleId;
	}

	@ManyToOne
	@JoinColumn(name = "m_role")
	private Role roleDesc;

	public Role getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(Role roleDesc) {
		this.roleDesc = roleDesc;
	}

	@ManyToOne
	@JoinColumn(name = "m_menu")
	private Menu menuDesc;

	public Menu getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(Menu menuDesc) {
		this.menuDesc = menuDesc;
	}

}
