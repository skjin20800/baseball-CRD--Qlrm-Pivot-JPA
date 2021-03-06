package com.jkb.baseball.domain.stadium;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import com.jkb.baseball.domain.team.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Stadium {

	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy("id desc")
	private Long id; //시퀀스, auto_increment
	
	@Column(nullable = false, length = 100, unique = true)
	private String stadiumName;
			
	//양방향 매핑
	@OneToOne(mappedBy = "stadium",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Team team;
		
	
}
