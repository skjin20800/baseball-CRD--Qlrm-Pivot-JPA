package com.jkb.baseball.domain.team;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jkb.baseball.domain.player.Player;
import com.jkb.baseball.domain.stadium.Stadium;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Team {
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //시퀀스, auto_increment
	
	@Column(nullable = false, length = 100, unique = true)
	private String teamName;
	
	@OneToOne
	@JoinColumn(name = "stadiumId")
	private Stadium stadium;

	//양방향 매핑
	@OneToMany(mappedBy = "team",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"team"})
	@OrderBy("id desc")
	private List<Player> players;
	
}
