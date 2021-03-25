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

import com.jkb.baseball.domain.stadium.Stadium;
import com.jkb.baseball.service.StadiumService;
import com.jkb.baseball.web.dto.stadium.StadiumReqDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StadiumController {

	private final StadiumService stadiumService;
	
	@GetMapping("/stadium")
	public String StadiumList(Model model) {
		List<Stadium> stadiums = stadiumService.야구장목록();
		model.addAttribute("stadiums",stadiums);
		return "stadiumList";
	}
	
	@GetMapping("/stadiumForm")
	public String StadiumForm(Model model) {
		return "stadiumSave";
	}	
	
	@PostMapping("/stadium")
	@ResponseBody
	public int StadiumSave(@RequestBody StadiumReqDto stadiumReqDto) {
		
		int result = stadiumService.야구장등록(stadiumReqDto.toEntity());
		System.out.println(result);
		return result;
	}
	
	@DeleteMapping("/stadium/{id}")
	@ResponseBody
	public int deleteById(@PathVariable Long id){
		int result = stadiumService.삭제하기(id);
		return result;
	}
	
}
