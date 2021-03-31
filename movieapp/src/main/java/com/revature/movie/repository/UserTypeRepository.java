package com.revature.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.movie.models.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

}
