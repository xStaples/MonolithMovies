package com.revature.model;

import java.io.Serializable;
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
public class MovieCast implements Serializable{
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="movieCastSequence")
  @SequenceGenerator(name="movieCastSequence", sequenceName="MOVIECAST_SEQ", allocationSize=1)
  private int id;

  private String actor;

  private String role;

  @OneToMany(mappedBy="movieCastFk", fetch=FetchType.LAZY)
  private List<Movies> movieCastList = new ArrayList<>();

  public MovieCast() {
  }

  public MovieCast(int id, String actor, String role) {
    this.id = id;
    this.actor = actor;
    this.role = role;
  }

  public MovieCast(String actor, String role) {
    this.actor = actor;
    this.role = role;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getActor() {
    return actor;
  }

  public void setActor(String actor) {
    this.actor = actor;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public List<Movies> getMovieCashList() {
    return movieCastList;
  }

  public void setMovieCashList(List<Movies> movieCashList) {
    this.movieCastList = movieCashList;
  }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((actor == null) ? 0 : actor.hashCode());
	result = prime * result + id;
	result = prime * result + ((movieCastList == null) ? 0 : movieCastList.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
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
	MovieCast other = (MovieCast) obj;
	if (actor == null) {
		if (other.actor != null)
			return false;
	} else if (!actor.equals(other.actor))
		return false;
	if (id != other.id)
		return false;
	if (movieCastList == null) {
		if (other.movieCastList != null)
			return false;
	} else if (!movieCastList.equals(other.movieCastList))
		return false;
	if (role == null) {
		if (other.role != null)
			return false;
	} else if (!role.equals(other.role))
		return false;
	return true;
}

@Override
public String toString() {
	return "MovieCast [id=" + id + ", actor=" + actor + ", role=" + role + ", movieCashList=" + movieCastList + "]";
}



  
  
}
