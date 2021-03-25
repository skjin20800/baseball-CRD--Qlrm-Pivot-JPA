package com.jkb.baseball.web.dto.team;

import com.jkb.baseball.domain.team.Team;

import lombok.Data;

@Data
public class TeamReqDto {
	
	private String teamName;
	private String stadium;

	
	public Team toEntity() {
		return Team.builder()
				.teamName(teamName)
				.build();		
	}
}
