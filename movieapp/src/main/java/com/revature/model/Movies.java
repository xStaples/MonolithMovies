package com.revature.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class Movies implements Serializable{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="moviesSequence")
  @SequenceGenerator(name="moviesSequence", sequenceName="MOVIES_SEQ", allocationSize=1)
  private int id;

  private String movieName;
  
  private Date movieRelease;

  @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  private MovieCast movieCastFk;

  @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  private Details movieDetailsFk;

  @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  private User viewer;

  @OneToMany(mappedBy="movieFk", fetch=FetchType.LAZY)
  private List<Reviews> movieReviewList = new ArrayList<>();

  

  public Movies() {
  }

  public Movies(int id, String movieName, Date movieRelease, MovieCast movieCastFk, Details movieDetailsFk) {
    this.id = id;
    this.movieName = movieName;
    this.movieRelease = movieRelease;
    this.movieCastFk = movieCastFk;
    this.movieDetailsFk = movieDetailsFk;
  }

  public Movies(String movieName, Date movieRelease, MovieCast movieCastFk, Details movieDetailsFk) {
    this.movieName = movieName;
    this.movieRelease = movieRelease;
    this.movieCastFk = movieCastFk;
    this.movieDetailsFk = movieDetailsFk;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMovieName() {
    return movieName;
  }

  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }

  public Date getMovieRelease() {
    return movieRelease;
  }

  public void setMovieRelease(Date movieRelease) {
    this.movieRelease = movieRelease;
  }

  public MovieCast getMovieCastFk() {
    return movieCastFk;
  }

  public void setMovieCastFk(MovieCast movieCastFk) {
    this.movieCastFk = movieCastFk;
  }

  public Details getMovieDetailsFk() {
    return movieDetailsFk;
  }

  public void setMovieDetailsFk(Details movieDetailsFk) {
    this.movieDetailsFk = movieDetailsFk;
  }

  public List<Reviews> getMovieReviewList() {
    return movieReviewList;
  }

  public void setMovieReviewList(List<Reviews> movieReviewList) {
    this.movieReviewList = movieReviewList;
  }

  public User getViewer() {
    return viewer;
  }

  public void setViewer(User viewer) {
    this.viewer = viewer;
  }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((movieCastFk == null) ? 0 : movieCastFk.hashCode());
	result = prime * result + ((movieDetailsFk == null) ? 0 : movieDetailsFk.hashCode());
	result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
	result = prime * result + ((movieRelease == null) ? 0 : movieRelease.hashCode());
	result = prime * result + ((movieReviewList == null) ? 0 : movieReviewList.hashCode());
	result = prime * result + ((viewer == null) ? 0 : viewer.hashCode());
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
	Movies other = (Movies) obj;
	if (id != other.id)
		return false;
	if (movieCastFk == null) {
		if (other.movieCastFk != null)
			return false;
	} else if (!movieCastFk.equals(other.movieCastFk))
		return false;
	if (movieDetailsFk == null) {
		if (other.movieDetailsFk != null)
			return false;
	} else if (!movieDetailsFk.equals(other.movieDetailsFk))
		return false;
	if (movieName == null) {
		if (other.movieName != null)
			return false;
	} else if (!movieName.equals(other.movieName))
		return false;
	if (movieRelease == null) {
		if (other.movieRelease != null)
			return false;
	} else if (!movieRelease.equals(other.movieRelease))
		return false;
	if (movieReviewList == null) {
		if (other.movieReviewList != null)
			return false;
	} else if (!movieReviewList.equals(other.movieReviewList))
		return false;
	if (viewer == null) {
		if (other.viewer != null)
			return false;
	} else if (!viewer.equals(other.viewer))
		return false;
	return true;
}

@Override
public String toString() {
	return "Movies [id=" + id + ", movieName=" + movieName + ", movieRelease=" + movieRelease + ", movieCastFk="
			+ movieCastFk + ", movieDetailsFk=" + movieDetailsFk + ", viewer=" + viewer + ", movieReviewList="
			+ movieReviewList + "]";
}



  
  
  
}
