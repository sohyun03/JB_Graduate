package com.joongbu.movie_reservation.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/*
+---------+-------------+------+-----+---------+----------------+
| Field   | Type        | Null | Key | Default | Extra          |
+---------+-------------+------+-----+---------+----------------+
| ci_no   | int         | NO   | PRI | NULL    | auto_increment |
| ci_name | varchar(45) | NO   |     | NULL    |                |
| a_no    | int         | NO   | MUL | NULL    |                |
+---------+-------------+------+-----+---------+----------------+
 */
@Data
@Entity
@Table(name = "cinema")
public class CinemaDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_no")
	private int ciNo;
	
	@Column(name = "ci_name")
	private String ciName;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "a_no", updatable = false)
//	private AreaDto area;
	
	private int area;
	
}
