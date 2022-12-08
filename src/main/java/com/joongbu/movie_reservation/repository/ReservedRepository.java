package com.joongbu.movie_reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.joongbu.movie_reservation.dto.ReservedDto;

@Repository
public interface ReservedRepository extends JpaRepository<ReservedDto, Integer>{

	@Query(value = "SELECT u FROM ReservedDto u WHERE u.cNo=:cNo")
	List<ReservedDto> findAll(int cNo);
}
