<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<table class="table">
	<thead>
		<tr>
			<th>NO</th>
			<th>선수 이름</th>
			<th>포지션</th>
			<th>팀</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="sum" value="0" />
		<c:forEach var="player" items="${players}">
			<c:set var="sum" value="${sum +1}" />
			<tr  id="player-${player.id}">
				<td><c:out value="${sum}" /></td>
				<td>${player.playerName}</td>
				<td>${player.position}</td>
				<td>${player.team.teamName}</td>
				<td><button type="button" class="btn btn-danger" onclick="deletePlayer(${player.id})">삭제</button></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</table>
</div>

<script>
function deletePlayer(id){
	
	 if (confirm("정말 삭제하시겠습니까??") == true){    //확인
	        }else{   //취소
	            return;
	          }
		
	    $.ajax({
			type: "DELETE",
			url: "/player/"+id,
			dataType:"json"
		}).done((res)=>{
			console.log(res);
			if(res === 1){
			$("#player-"+id).remove();
			}else{
				alert("삭제에 실패하였습니다.");
			}
		});
	}
	</script>

</body>
</html>
</html>