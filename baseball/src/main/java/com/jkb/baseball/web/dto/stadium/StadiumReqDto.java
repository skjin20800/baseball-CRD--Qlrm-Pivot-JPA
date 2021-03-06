package com.jkb.baseball.web.dto.stadium;

import com.jkb.baseball.domain.stadium.Stadium;

import lombok.Data;

@Data
public class StadiumReqDto {
	
	private String stadiumName;
	
	public Stadium toEntity() {
		return Stadium.builder()
				.stadiumName(stadiumName)
				.build();		
	}
}

