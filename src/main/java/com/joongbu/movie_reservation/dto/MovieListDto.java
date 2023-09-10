package com.joongbu.movie_reservation.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

/*
+---------+--------------+------+-----+---------+----------------+
| Field   | Type         | Null | Key | Default | Extra          |
+---------+--------------+------+-----+---------+----------------+
| ml_no   | int          | NO   | PRI | NULL    | auto_increment |
| ml_name | varchar(45)  | NO   |     | NULL    |                |
| ml_rate | double       | YES  |     | NULL    |                |
| ml_date | date         | NO   |     | NULL    |                |
| imgurl  | varchar(200) | YES  |     | NULL    |                |
| like    | int          | YES  |     | NULL    |                |
+---------+--------------+------+-----+---------+----------------+
 */

@Data  //lombok
@Entity
@Table(name = "movie_list")
@ToString(exclude = "movie")
public class MovieListDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ml_no")
	private int mlNo;
	
	@Column(name = "ml_name")
	private String mlName;
	@Column(name = "ml_rate")
	private double mlRate;
	@Column(name = "ml_date")
	private Date mlDate;
	private String imgurl;
	private int like;
	
	@OneToMany(mappedBy = "movieList", fetch = FetchType.LAZY) // 자신이 매핑되어 있는 필드명
	private List<MovieDto> movie = new ArrayList<>();
	
}
