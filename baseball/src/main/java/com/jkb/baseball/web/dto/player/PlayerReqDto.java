package com.jkb.baseball.web.dto.player;

import com.jkb.baseball.domain.player.Player;
import com.jkb.baseball.domain.team.Team;

import lombok.Data;

@Data
public class PlayerReqDto {
		
	private String teamName;
	private String playerName;
	private String position;
	
	public Player toEntity() {
		return Player.builder()
				.playerName(playerName)
				.position(position)
				.build();		
	}
}
