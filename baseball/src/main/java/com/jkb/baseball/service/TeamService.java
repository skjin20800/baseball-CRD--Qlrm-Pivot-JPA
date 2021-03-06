package com.jkb.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jkb.baseball.domain.player.Player;
import com.jkb.baseball.domain.player.PlayerRepository;
import com.jkb.baseball.domain.stadium.Stadium;
import com.jkb.baseball.domain.stadium.StadiumRepository;
import com.jkb.baseball.domain.team.Team;
import com.jkb.baseball.domain.team.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamService {
	
	private final TeamRepository teamRepository;
	private final StadiumRepository stadiumRepository;
	
	@Transactional(readOnly = true)
	public List<Team> 팀목록(){
		return teamRepository.findAll();		
	}
	
	@Transactional
	public int 팀등록(String stadiumName, Team team){
		Team teamEntity = teamRepository.findByTeamName(team.getTeamName());
		
		Stadium stadium = stadiumRepository.findByStadiumName(stadiumName);
		
		if(teamEntity != null) {return -1;}
		else {
			teamRepository.mTeamSave(stadium.getId(), team.getTeamName().toString());	 
			return 1;
		}
	}	
	@Transactional
	public int 삭제하기(Long id) {
		teamRepository.deleteById(id);
		return 1;
	}

}
