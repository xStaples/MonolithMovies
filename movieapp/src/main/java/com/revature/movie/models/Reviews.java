package com.revature.movie.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Reviews implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reviewsSequence")
	@SequenceGenerator(name = "reviewsSequence", sequenceName = "REVIEWS_SEQ", allocationSize = 1)
	private int id;

	private int reviewScore;

	private String reviewText;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "movie_id")
	private Movie movie;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Reviews() {
	}

	public Reviews(int id, int reviewScore, String reviewText, User user) {
		this.id = id;
		this.reviewScore = reviewScore;
		this.reviewText = reviewText;
		this.user = user;
	}

	public Reviews(int reviewScore, String reviewText, User user) {
		this.reviewScore = reviewScore;
		this.reviewText = reviewText;
		this.user = user;
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

	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * @param movie the movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + reviewScore;
		result = prime * result + ((reviewText == null) ? 0 : reviewText.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Reviews)) {
			return false;
		}
		Reviews other = (Reviews) obj;
		if (id != other.id) {
			return false;
		}
		if (movie == null) {
			if (other.movie != null) {
				return false;
			}
		} else if (!movie.equals(other.movie)) {
			return false;
		}
		if (reviewScore != other.reviewScore) {
			return false;
		}
		if (reviewText == null) {
			if (other.reviewText != null) {
				return false;
			}
		} else if (!reviewText.equals(other.reviewText)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Reviews [id=" + id + ", reviewScore=" + reviewScore + ", reviewText=" + reviewText + ", movie=" + movie
				+ ", user=" + user + "]";
	}


}