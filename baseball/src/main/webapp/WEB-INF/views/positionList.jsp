<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<table class="table">
	<thead>
		<tr>
			<th>포지션</th>
			<th>롯데</th>
			<th>기아</th>
			<th>NC</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach var="player" items="${players}">
			<tr>
				<td>${player.position }</td>
				<td>${player.lotteName}</td>
				<td>${player.kiaName}</td>
				<td>${player.ncName}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</table>
</div>



</body>
</html>
</html>