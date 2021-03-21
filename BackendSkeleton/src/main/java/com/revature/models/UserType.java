package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Cacheable
@Entity
@Table(name="user_type")
public class UserType {
	
	
	@Id
	@Column(name="ut_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="type")
	private String type;
	
	@OneToMany(mappedBy="userTypeFk", fetch=FetchType.LAZY)
	private List<User> uTypeList = new ArrayList<User>();

	public UserType() {
		super();
	}

	public UserType(int id, String type, List<User> uTypeList) {
		super();
		this.id = id;
		this.type = type;
		this.uTypeList = uTypeList;
	}

	public UserType(String type, List<User> uTypeList) {
		super();
		this.type = type;
		this.uTypeList = uTypeList;
	}
	

	public UserType(String type) {
		super();
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<User> getuTypeList() {
		return uTypeList;
	}

	public void setuTypeList(List<User> uTypeList) {
		this.uTypeList = uTypeList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((uTypeList == null) ? 0 : uTypeList.hashCode());
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
		UserType other = (UserType) obj;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (uTypeList == null) {
			if (other.uTypeList != null)
				return false;
		} else if (!uTypeList.equals(other.uTypeList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserType [id=" + id + ", type=" + type + ", uTypeList=" + uTypeList + "]";
	}
	
	
}
