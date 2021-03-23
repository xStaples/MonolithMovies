package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
  @SequenceGenerator(name="userSequence", sequenceName="USER_SEQ", allocationSize=1)
  private int id;

  private String username;

  private String password;

  private String firstName;

  private String lastName;

  @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  private UserType userType;

  @OneToMany(mappedBy="viewer", fetch=FetchType.LAZY)
  private List<Movies> watchList = new ArrayList<>();

  @OneToMany(mappedBy="userFk", fetch=FetchType.LAZY)
  private List<Reviews> userReviewList = new ArrayList<>();

  public User() {
  }

  public User(int id, String username, String password, String firstName, String lastName, UserType userType) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userType = userType;
  }

  public User(String username, String password, String firstName, String lastName, UserType userType) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userType = userType;
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserType getUserType() {
    return userType;
  }

  public void setUserType(UserType userType) {
    this.userType = userType;
  }

  public List<Reviews> getReviewList() {
    return userReviewList;
  }

  public void setReviewList(List<Reviews> reviewList) {
    this.userReviewList = reviewList;
  }

public List<Reviews> getUserReviewList() {
	return userReviewList;
}

public void setUserReviewList(List<Reviews> userReviewList) {
	this.userReviewList = userReviewList;
}

public List<Movies> getWatchList() {
  return watchList;
}

public void setWatchList(List<Movies> watchList) {
  this.watchList = watchList;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + id;
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((userReviewList == null) ? 0 : userReviewList.hashCode());
	result = prime * result + ((userType == null) ? 0 : userType.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	result = prime * result + ((watchList == null) ? 0 : watchList.hashCode());
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
	User other = (User) obj;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (id != other.id)
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (userReviewList == null) {
		if (other.userReviewList != null)
			return false;
	} else if (!userReviewList.equals(other.userReviewList))
		return false;
	if (userType == null) {
		if (other.userType != null)
			return false;
	} else if (!userType.equals(other.userType))
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	if (watchList == null) {
		if (other.watchList != null)
			return false;
	} else if (!watchList.equals(other.watchList))
		return false;
	return true;
}

@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", userType=" + userType + ", watchList=" + watchList + ", userReviewList="
			+ userReviewList + "]";
}


  


  
}
