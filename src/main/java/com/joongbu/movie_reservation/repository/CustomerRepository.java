package com.joongbu.movie_reservation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joongbu.movie_reservation.dto.CustomerDto;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDto, Integer> {

	boolean existsBycId(String cId);

	Optional<CustomerDto> findBycId(String cId);

	Optional<CustomerDto> findBycIdAndPw(String cId, String pw);
}
