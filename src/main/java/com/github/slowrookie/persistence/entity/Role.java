package com.github.slowrookie.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.github.slowrookie.persistence.AuditablePersistable;

/**
 * 角色管理
 * 
 * @author 刘佳兴
 */
@Entity
@Table(name = "base_role")
public class Role extends AuditablePersistable {
	
	private static final long serialVersionUID = 1L;
	
	protected String name;

	public Role() {
		super();
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
