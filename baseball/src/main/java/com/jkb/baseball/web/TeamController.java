package com.jkb.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jkb.baseball.domain.team.Team;
import com.jkb.baseball.service.TeamService;
import com.jkb.baseball.web.dto.team.TeamReqDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TeamController {

	private final TeamService teamService;
	
	@GetMapping("/team")
	public String StadiumList(Model model) {
	List<Team> teams = teamService.팀목록();
		model.addAttribute("teams",teams);
		return "teamList";
	}
	
	@GetMapping("/teamForm")
	public String StadiumForm(Model model) {
		return "teamSave";
	}	
	
	@PostMapping("/team")
	@ResponseBody
	public int StadiumSave(@RequestBody TeamReqDto teamReqDto) {
		System.out.println("디티오"+teamReqDto);
		int result = teamService.팀등록(teamReqDto.getStadium(),teamReqDto.toEntity());
		return result;
	}
	
	@DeleteMapping("/team/{id}")
	@ResponseBody
	public int deleteById(@PathVariable Long id){
		int result = teamService.삭제하기(id);
		return result;
	}
	
}
