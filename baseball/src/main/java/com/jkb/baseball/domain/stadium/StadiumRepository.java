package com.jkb.baseball.domain.stadium;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<Stadium, Long>{
	Stadium findByStadiumName(String stadiumName);
}
