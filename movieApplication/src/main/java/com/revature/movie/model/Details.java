package com.revature.movie.model;

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
public class Details implements Serializable{
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="detailsSequence")
  @SequenceGenerator(name="detailsSequence", sequenceName="DETAILS_SEQ", allocationSize=1)
  private int id;

  private String genre;

  private String director;

  @OneToMany(mappedBy="movieDetailsFk", fetch=FetchType.LAZY)
  private List<Movies> movieDetailsList = new ArrayList<>();

  public Details() {
  }

  public Details(int id, String genre, String director) {
    this.id = id;
    this.genre = genre;
    this.director = director;
  }

  public Details(String genre, String director) {
    this.genre = genre;
    this.director = director;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }
  
  public List<Movies> getMovieDetailsList() {
	  return movieDetailsList;
}

  public void setMovieDetailsList(List<Movies> movieDetailsList) {
	  this.movieDetailsList = movieDetailsList;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((director == null) ? 0 : director.hashCode());
	result = prime * result + ((genre == null) ? 0 : genre.hashCode());
	result = prime * result + id;
	result = prime * result + ((movieDetailsList == null) ? 0 : movieDetailsList.hashCode());
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
	Details other = (Details) obj;
	if (director == null) {
		if (other.director != null)
			return false;
	} else if (!director.equals(other.director))
		return false;
	if (genre == null) {
		if (other.genre != null)
			return false;
	} else if (!genre.equals(other.genre))
		return false;
	if (id != other.id)
		return false;
	if (movieDetailsList == null) {
		if (other.movieDetailsList != null)
			return false;
	} else if (!movieDetailsList.equals(other.movieDetailsList))
		return false;
	return true;
}

@Override
public String toString() {
	return "Details [id=" + id + ", genre=" + genre + ", director=" + director + ", movieDetailsList="
			+ movieDetailsList + "]";
}




  

}
