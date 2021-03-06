package com.jkb.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jkb.baseball.domain.player.Player;
import com.jkb.baseball.domain.stadium.Stadium;
import com.jkb.baseball.domain.stadium.StadiumRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StadiumService {
	
	private final StadiumRepository stadiumRepository;
	
	@Transactional(readOnly = true)
	public List<Stadium> 야구장목록(){
		return stadiumRepository.findAll();
	}
	
	@Transactional
	public int 야구장등록(Stadium stadium){
		
		Stadium stadiumEntity = stadiumRepository.findByStadiumName(stadium.getStadiumName().toString());
		if(stadiumEntity != null) {
			return -1;
		}else {
			 stadiumRepository.save(stadium);
			return 1;
		}
	}
	
	@Transactional
	public int 삭제하기(Long id) {
		stadiumRepository.deleteById(id);
		return 1;
	}

}
