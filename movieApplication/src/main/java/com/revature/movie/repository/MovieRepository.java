package com.revature.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.movie.model.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
