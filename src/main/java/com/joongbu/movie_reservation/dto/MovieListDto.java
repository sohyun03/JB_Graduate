package com.joongbu.movie_reservation.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/*
+---------+--------------+------+-----+---------+----------------+
| Field   | Type         | Null | Key | Default | Extra          |
+---------+--------------+------+-----+---------+----------------+
| ml_no   | int          | NO   | PRI | NULL    | auto_increment |
| ml_name | varchar(45)  | NO   |     | NULL    |                |
| ml_rate | double       | YES  |     | NULL    |                |
| ml_date | date         | NO   |     | NULL    |                |
| imgurl  | varchar(200) | YES  |     | NULL    |                |
+---------+--------------+------+-----+---------+----------------+
 */

@Data
@Entity
@Table(name = "movie_list")
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
	
}
