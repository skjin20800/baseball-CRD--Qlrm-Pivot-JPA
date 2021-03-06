package com.jkb.baseball.domain.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<Team, Long>{

	
	Team findByTeamName(String teamName);
	
	@Modifying
	@Query(value = "INSERT INTO team(stadiumId, teamName) VALUES(:stadiumId, :teamName)", nativeQuery = true)
	int mTeamSave(Long stadiumId ,String teamName);
}
