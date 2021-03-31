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

	@ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cast_id")
	private Cast cast;
	
	@ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "details_id")
	private Details details;

	
	
	public Movie() {
		super();
	}
	
	

	public Movie(int id, String movieName, Date movieRelease, List<Reviews> reviews, User user, Cast cast,
			Details details) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieRelease = movieRelease;
		this.reviews = reviews;
		this.user = user;
		this.cast = cast;
		this.details = details;
	}

	


	public Movie(String movieName, Date movieRelease, List<Reviews> reviews, User user, Cast cast, Details details) {
		super();
		this.movieName = movieName;
		this.movieRelease = movieRelease;
		this.reviews = reviews;
		this.user = user;
		this.cast = cast;
		this.details = details;
	}

	public Movie(String movieName){
		this.movieName = movieName;
	}



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



	public Cast getCast() {
		return cast;
	}



	public void setCast(Cast cast) {
		this.cast = cast;
	}



	public Details getDetails() {
		return details;
	}



	public void setDetails(Details details) {
		this.details = details;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cast == null) ? 0 : cast.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + id;
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + ((movieRelease == null) ? 0 : movieRelease.hashCode());
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Movie other = (Movie) obj;
		if (cast == null) {
			if (other.cast != null)
				return false;
		} else if (!cast.equals(other.cast))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (id != other.id)
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
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", movieRelease=" + movieRelease + ", reviews="
				+ reviews + ", user=" + user + ", cast=" + cast + ", details=" + details + "]";
	}

}
