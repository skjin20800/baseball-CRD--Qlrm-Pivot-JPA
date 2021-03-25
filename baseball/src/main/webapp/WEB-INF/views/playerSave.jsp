<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class = " container">
<h1 class="display-2">선수 등록</h1>
<form>
  <div class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text">선수이름</span>
    </div>
    <input type="text" class="form-control" id="playerName">
  </div>
    <div class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text">포지션&nbsp;&nbsp;&nbsp;&nbsp;</span>
    </div>
    <input type="text" class="form-control" id="position">
  </div>
<div class="form-check">
  <label class="form-check-label">
    <input type="radio" class="form-check-input" name="team" value="롯데">롯데
  </label>
</div>
<div class="form-check">
  <label class="form-check-label">
    <input type="radio" class="form-check-input" name="team" value="NC">NC
  </label>
</div>
<div class="form-check disabled">
  <label class="form-check-label">
    <input type="radio" class="form-check-input" name="team" value="기아">기아
  </label>
</div>


  <button type="button" class="btn btn-primary" id="btn-playerSave">등록</button>
</form>
</div>

<script>

      $("#btn-playerSave").on("click", (e)=>{
	e.preventDefault(); //form태그 action안타게 막아버리는것
	
	        var obj_length = document.getElementsByName("team").length;
	  	    var team;
	        for (var i=0; i<obj_length; i++) {
	            if (document.getElementsByName("team")[i].checked == true) {
	                team = document.getElementsByName("team")[i].value;
	            }
	        }
	   
  	let data = {
  			teamName: team,
  			position: $("#position").val(),
  			playerName: $("#playerName").val(),
	};
      
      $.ajax({
		type: "POST",
		url: "/player",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
	}).done((res)=>{
		console.log(res);
		if(res === 1){
			alert("등록되었습니다");
		}else{
			alert("이미 선수를 등록 하였습니다.");
		}
	});      
});

</script>

</body>
</html>
</html>