package com.github.slowrookie.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.slowrookie.persistence.IdentityPersistable;

/**
 * 角色和菜单关联表
 * 
 * @author 刘佳兴
 */
@Entity
@Table(name = "base_role_menu")
public class RoleMenu extends IdentityPersistable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="id_"), nullable = false)
	protected Role role;
	
	//不需要返回关联对象的children属性
	@JsonIgnoreProperties(value = "children")
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="id_"), nullable = false)
	protected Menu menu;

	public Menu getMenu() {
		return menu;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
}
