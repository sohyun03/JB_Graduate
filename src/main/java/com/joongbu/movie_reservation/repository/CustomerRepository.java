package com.joongbu.movie_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joongbu.movie_reservation.dto.CustomerDto;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDto, Integer>{
	
	boolean existsBycId(String cId);
}
