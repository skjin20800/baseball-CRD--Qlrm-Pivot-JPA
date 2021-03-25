package com.jkb.baseball.domain.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Player {

	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //시퀀스, auto_increment
	
	@Column(nullable = false, length = 100, unique = true)
	private String playerName;
	
	@Column(nullable = false, length = 100)// 123456 => 해쉬(비밀번호 암호화)
	private String position;
	
	@ManyToOne
	@JoinColumn(name = "teamId")
	private Team team;
	
}
