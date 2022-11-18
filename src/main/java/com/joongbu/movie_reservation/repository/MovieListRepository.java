package com.joongbu.movie_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.joongbu.movie_reservation.dto.MovieListDto;

public interface MovieListRepository extends JpaRepository<MovieListDto, Integer> {
	
	@Query(value = "SELECT imgurl FROM MovieListDto u Where u.mlName=:name")
	String findByimgurl(String name);

}
