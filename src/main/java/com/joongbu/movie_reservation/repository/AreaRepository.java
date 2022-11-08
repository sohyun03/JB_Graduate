package com.joongbu.movie_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joongbu.movie_reservation.dto.AreaDto;

@Repository
public interface AreaRepository extends JpaRepository<AreaDto, Integer>{

	long countByaNo(int aNo);
	
}
