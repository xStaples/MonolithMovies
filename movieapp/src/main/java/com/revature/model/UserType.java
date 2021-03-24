package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class UserType {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userTypeSequence")
  @SequenceGenerator(name="userTypeSequence", sequenceName="USERTYPE_SEQ", allocationSize=1)
  private int id;

  private String type;

  @OneToMany(mappedBy="userType", fetch=FetchType.LAZY)
  private List<User> userList = new ArrayList<>();

  public UserType() {
  }

  public UserType(int id, String type) {
    this.id = id;
    this.type = type;
  }

  public UserType(String type) {
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

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	result = prime * result + ((userList == null) ? 0 : userList.hashCode());
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
	if (userList == null) {
		if (other.userList != null)
			return false;
	} else if (!userList.equals(other.userList))
		return false;
	return true;
}

@Override
public String toString() {
	return "UserType [id=" + id + ", type=" + type + ", userList=" + userList + "]";
}


  
  
}
