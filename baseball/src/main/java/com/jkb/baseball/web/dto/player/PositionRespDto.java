package com.jkb.baseball.web.dto.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionRespDto {	
	private String position;
	private String lotteName;
	private String kiaName;
	private String ncName;
	
}
