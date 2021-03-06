package com.jkb.baseball.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jkb.baseball.domain.player.Player;
import com.jkb.baseball.domain.player.PlayerRepository;
import com.jkb.baseball.domain.team.Team;
import com.jkb.baseball.domain.team.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {
	
	private final PlayerRepository playerRepository;
	private final TeamRepository teamRepository;
	
	@Transactional(readOnly = true)
	public List<Player> 선수목록(){
		return playerRepository.findAll();
	}
	
	@Transactional
	public int 선수등록(String teamName,Player player){		
		Player playerEntity = playerRepository.findByPlayerName(player.getPlayerName());
		Team team = teamRepository.findByTeamName(teamName);
		
		if(playerEntity != null) {return -1;}
		else {
			playerRepository.mPlayerSave(player.getPlayerName(),player.getPosition(), team.getId());	 
			return 1;
		}
	}
	
	@Transactional
	public int 삭제하기(Long id) {		
		playerRepository.deleteById(id);
		return 1;
	}
	
	@Transactional(readOnly = true)
	public List<Long> 팀찾기(){
		Team lotte = teamRepository.findByTeamName("롯데");
		Team kia = teamRepository.findByTeamName("기아");
		Team nc = teamRepository.findByTeamName("nc");
		
		List<Long> teamName = new ArrayList<>();	
		teamName.add(lotte.getId());
		teamName.add(kia.getId());
		teamName.add(nc.getId());
		return teamName;
	}
	
	
}
