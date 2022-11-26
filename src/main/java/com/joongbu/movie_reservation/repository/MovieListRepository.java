package com.joongbu.movie_reservation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.joongbu.movie_reservation.dto.MovieListDto;

@Repository
public interface MovieListRepository extends JpaRepository<MovieListDto, Integer> {
	
	@Query(value = "SELECT imgurl FROM MovieListDto u WHERE u.mlName=:name")
	String findByimgurl(String name);
	
	@Query(value = "SELECT u FROM MovieListDto u WHERE u.mlName=:mName")
	Optional<MovieListDto> selectByUserIdAndPw(String mName);
	
	//@Query(value = "SELECT m FROM MovieListDto m ORDER BY mlRate DESC LIMIT 10")

	List<MovieListDto> findTop10ByOrderByLikeDesc();
	
	@Query(value = "SELECT m FROM MovieListDto m join fetch m.movie t WHERE t.ciNo=:ciNo")
	List<MovieListDto> findAll(int ciNo);
	
//	@Query(value = "SELECT distinct m FROM MovieListDto m join fetch m.movie")
//	List<MovieListDto> findAll();

}
