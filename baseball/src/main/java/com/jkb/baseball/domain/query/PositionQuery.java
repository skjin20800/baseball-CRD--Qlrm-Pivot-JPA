package com.jkb.baseball.domain.query;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PositionQuery {

	private final EntityManager em;
	public Query positionPivot(Long lotte, Long kia, Long nc) {
		
		StringBuffer sb = new StringBuffer(); // String전용 컬렉션(수집)이다, 동기화되어있음,
		sb.append("select position 포지션, ");
		sb.append("MAX(if(teamId = "+lotte+", playerName, '' )) 롯데, ");
		sb.append("MAX(if(teamId = "+kia+", playerName, '' )) 기아, ");
		sb.append("MAX(if(teamId = "+nc+", playerName, '')) NC ");
		sb.append("from player ");
		sb.append("GROUP by position ");
		sb.append("ORDER by position ");
		String sql = sb.toString();

		Query query = em.createNativeQuery(sql);	
		return query;
		
				
	}

	
}
