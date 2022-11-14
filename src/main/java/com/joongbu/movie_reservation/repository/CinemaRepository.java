package com.joongbu.movie_reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.joongbu.movie_reservation.dto.CinemaDto;

@Repository
public interface CinemaRepository extends JpaRepository<CinemaDto, Integer>{

	@Query("SELECT u FROM CinemaDto u WHERE u.area =:aNo")
	List<CinemaDto> findByarea(int aNo);
}
