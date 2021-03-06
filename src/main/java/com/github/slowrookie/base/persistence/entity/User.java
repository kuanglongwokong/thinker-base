package com.github.slowrookie.base.persistence.entity;

import com.github.slowrookie.persistence.AuditablePersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 用户实体类
 * 
 * @author 刘佳兴
 */
@Entity
@Table(name = "base_user")
public class User extends AuditablePersistable {

	private static final long serialVersionUID = 1L;

	@Column(name="organization_")
	protected Long organization;
	
	@Column(name = "login_name_", unique = true ,length = 20)
	protected String loginName;
	
	@Column(name = "real_name_", length = 20)
	protected String realName;
	
	@NotNull
	@Column(name = "password_", length = 255)
	protected String password;
	
	@Column(name = "gender_")
	protected Integer gender;
	
	@Column(name = "email_", length = 50)
	protected String email;
	
	@Column(name = "mobile_", length = 20)
	protected String mobile;
	
	@Column(name = "telephone_", length = 20)
	protected String telephone;
	
	public User() {
		super();
	}

	public User(Long id){
		this.id = id;
	}

	public User(Long organization, String loginName,
			String realName, String password, Integer gender,
			String email, String mobile, String telephone) {
		super();
		this.organization = organization;
		this.loginName = loginName;
		this.realName = realName;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
		this.telephone = telephone;
		this.activity = 1;
	}

	public String getLoginName() {
		return loginName;
	}

	public Long getOrganization() {
		return organization;
	}

	public void setOrganization(Long organization) {
		this.organization = organization;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "User{" +
				"organization=" + organization +
				", loginName='" + loginName + '\'' +
				", realName='" + realName + '\'' +
				", password='" + password + '\'' +
				", gender=" + gender +
				", email='" + email + '\'' +
				", mobile='" + mobile + '\'' +
				", telephone='" + telephone + '\'' +
				'}';
	}
}
