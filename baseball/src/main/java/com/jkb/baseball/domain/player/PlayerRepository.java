package com.jkb.baseball.domain.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jkb.baseball.domain.team.Team;

public interface PlayerRepository extends JpaRepository<Player, Long>{

	
	Player findByPlayerName(String playerName);
	
	@Modifying
	@Query(value = "INSERT INTO player(playerName, position, teamId) VALUES(:playerName, :position, :teamId)", nativeQuery = true)
	int mPlayerSave(String playerName, String position, Long teamId);
}
//