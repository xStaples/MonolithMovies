package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Reviews {
  
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reviewsSequence")
  @SequenceGenerator(name="reviewsSequence", sequenceName="REVIEWS_SEQ", allocationSize=1)
  private int id; 

  private int reviewScore; 

  private String reviewText;

  @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  private Movies movieFk;

  @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  private User userFk;

  public Reviews() {
  }

  public Reviews(int id, int reviewScore, String reviewText, Movies movieFk, User userFk) {
    this.id = id;
    this.reviewScore = reviewScore;
    this.reviewText = reviewText;
    this.movieFk = movieFk;
    this.userFk = userFk;
  }

  public Reviews(int reviewScore, String reviewText, Movies movieFk, User userFk) {
    this.reviewScore = reviewScore;
    this.reviewText = reviewText;
    this.movieFk = movieFk;
    this.userFk = userFk;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getReviewScore() {
    return reviewScore;
  }

  public void setReviewScore(int reviewScore) {
    this.reviewScore = reviewScore;
  }

  public String getReviewText() {
    return reviewText;
  }

  public void setReviewText(String reviewText) {
    this.reviewText = reviewText;
  }

  public Movies getMovieFk() {
    return movieFk;
  }

  public void setMovieFk(Movies movieFk) {
    this.movieFk = movieFk;
  }

  public User getUserFk() {
    return userFk;
  }

  public void setUserFk(User userFk) {
    this.userFk = userFk;
  }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((movieFk == null) ? 0 : movieFk.hashCode());
	result = prime * result + reviewScore;
	result = prime * result + ((reviewText == null) ? 0 : reviewText.hashCode());
	result = prime * result + ((userFk == null) ? 0 : userFk.hashCode());
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
	Reviews other = (Reviews) obj;
	if (id != other.id)
		return false;
	if (movieFk == null) {
		if (other.movieFk != null)
			return false;
	} else if (!movieFk.equals(other.movieFk))
		return false;
	if (reviewScore != other.reviewScore)
		return false;
	if (reviewText == null) {
		if (other.reviewText != null)
			return false;
	} else if (!reviewText.equals(other.reviewText))
		return false;
	if (userFk == null) {
		if (other.userFk != null)
			return false;
	} else if (!userFk.equals(other.userFk))
		return false;
	return true;
}

@Override
public String toString() {
	return "Reviews [id=" + id + ", reviewScore=" + reviewScore + ", reviewText=" + reviewText + ", movieFk=" + movieFk
			+ ", userFk=" + userFk + "]";
}

  
  
}
