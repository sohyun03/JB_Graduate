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
+-------+------+------+-----+---------+----------------+
| Field | Type | Null | Key | Default | Extra          |
+-------+------+------+-----+---------+----------------+
| m_no  | int  | NO   | PRI | NULL    | auto_increment |
| ci_no | int  | NO   | MUL | NULL    |                |
| ml_no | int  | NO   | MUL | NULL    |                |
+-------+------+------+-----+---------+----------------+
 */
@Data
@Entity
@Table(name = "movie")
public class MovieDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "m_no")
	private int mNo;

	@Column(name = "ci_no")
	private int ciNo;
	
	// 연관관계의 주인은 mappedBy 옵션을 사용하지 않는다.
	@ManyToOne(fetch = FetchType.LAZY) // 연관관계의 주인(외래키를 가지고 있는 쪽)
	@JoinColumn(name = "ml_no")
	private MovieListDto movieList;
}
