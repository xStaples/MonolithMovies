/**
 * 
 */
package com.revature.movie.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * @author hectorv
 *
 */
@Entity
public class Movie implements Serializable{
	  private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moviesSequence")
	@SequenceGenerator(name = "moviesSequence", sequenceName = "MOVIES_SEQ", allocationSize = 1)
	private int id;

	private String movieName;

	private Date movieRelease;
	
	@OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
	private List<Reviews> reviews;
	
	@ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	/**
	 * @return the movieRelease
	 */
	public Date getMovieRelease() {
		return movieRelease;
	}

	/**
	 * @param movieRelease the movieRelease to set
	 */
	public void setMovieRelease(Date movieRelease) {
		this.movieRelease = movieRelease;
	}

	/**
	 * @return the reviews
	 */
	public List<Reviews> getReviews() {
		return reviews;
	}

	/**
	 * @param reviews the reviews to set
	 */
	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
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

}
