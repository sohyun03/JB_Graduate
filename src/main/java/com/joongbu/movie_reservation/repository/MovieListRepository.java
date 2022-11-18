package com.joongbu.movie_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joongbu.movie_reservation.dto.MovieListDto;

public interface MovieListRepository extends JpaRepository<MovieListDto, Integer> {
	

}
