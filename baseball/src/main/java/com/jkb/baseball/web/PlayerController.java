		package com.jkb.baseball.web;

import java.util.List;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jkb.baseball.domain.player.Player;
import com.jkb.baseball.domain.query.PositionQuery;
import com.jkb.baseball.service.PlayerService;
import com.jkb.baseball.web.dto.player.PlayerReqDto;
import com.jkb.baseball.web.dto.player.PositionRespDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PlayerController {

	private final PlayerService playerService;
	private final PositionQuery PositionQuery;

	
	@GetMapping("/player")
	public String PlayerList(Model model) {
		List<Player> players = playerService.선수목록();
		model.addAttribute("players",players);
		return "playerList";
	}
	
	@GetMapping("/playerForm")
	public String PlayerForm(Model model) {
		return "playerSave";
	}	
			
	@PostMapping("/player")
	@ResponseBody
	public int PlayerSave(@RequestBody PlayerReqDto playerReqDto) {
		int result = playerService.선수등록(playerReqDto.getTeamName(), playerReqDto.toEntity());
		return result;
	}
	
	@DeleteMapping("/player/{id}")
	@ResponseBody
	public int deleteById(@PathVariable Long id){
		int result = playerService.삭제하기(id);
		return result;
	}
	
	@GetMapping("/player/position")
	public String positionFindAll(Model model){
		
		JpaResultMapper jpaResultMapper = new JpaResultMapper();
		List<Long> teamName = playerService.팀찾기();		
		
		List<PositionRespDto> positionRespDto =jpaResultMapper
				.list(PositionQuery.positionPivot(teamName.get(0),teamName.get(1),teamName.get(2)),
						PositionRespDto.class);	
		
		model.addAttribute("players", positionRespDto);
		return "positionList";
		
		
	}
	
}
