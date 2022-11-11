package com.joongbu.movie_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joongbu.movie_reservation.dto.CinemaDto;

@Repository
public interface CinemaRepository extends JpaRepository<CinemaDto, Integer>{

	CinemaDto findByarea(int area);
}
