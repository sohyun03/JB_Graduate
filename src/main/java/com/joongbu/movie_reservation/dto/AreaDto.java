package com.joongbu.movie_reservation.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/*
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| a_no   | int         | NO   | PRI | NULL    | auto_increment |
| a_name | varchar(45) | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+ 
*/
@Data
@Entity
@Table(name = "area")
public class AreaDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "a_no")
	private int aNo;
	@Column(name = "a_name")
	private String aName;
}
