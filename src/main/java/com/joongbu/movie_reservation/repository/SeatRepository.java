package com.joongbu.movie_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joongbu.movie_reservation.dto.SeatDto;

@Repository
public interface SeatRepository extends JpaRepository<SeatDto, Integer>{

}
