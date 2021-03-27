package com.revature.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.movie.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
