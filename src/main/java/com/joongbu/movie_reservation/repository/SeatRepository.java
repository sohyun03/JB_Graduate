package com.joongbu.movie_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joongbu.movie_reservation.dto.SeatDto;

public interface SeatRepository extends JpaRepository<SeatDto, Integer>{

}
