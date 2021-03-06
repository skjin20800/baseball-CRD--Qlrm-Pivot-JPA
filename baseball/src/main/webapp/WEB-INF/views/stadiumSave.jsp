<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class = " container">
<h1 class="display-2">야구장 등록</h1>
<form>
  <div class="form-check">
  <label class="form-check-label">
    <input type="radio" class="form-check-input" name="team" value="부산스타디움">부산스타디움
  </label>
</div>
<div class="form-check">
  <label class="form-check-label">
    <input type="radio" class="form-check-input" name="team" value="대구스타디움">대구스타디움
  </label>
</div>
<div class="form-check disabled">
  <label class="form-check-label">
    <input type="radio" class="form-check-input" name="team" value="서울스타디움">서울스타디움
  </label>
</div>
  <button type="button" class="btn btn-primary" id="btn-stadiumSave">등록</button>
</form>
</div>

<script>
      $("#btn-stadiumSave").on("click", (e)=>{
	e.preventDefault(); //form태그 action안타게 막아버리는것
	
    var obj_length = document.getElementsByName("team").length;
	    var team;
    for (var i=0; i<obj_length; i++) {
        if (document.getElementsByName("team")[i].checked == true) {
            team = document.getElementsByName("team")[i].value;
        }
    }    
  	let data = {
  			stadiumName: team,
	};
      
      $.ajax({
		type: "POST",
		url: "/stadium",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType:"json"
	}).done((res)=>{
		console.log(res);
		if(res === 1){
			alert("등록되었습니다");
		}else{
			alert("이미 구장을 등록 하였습니다.");
		}
	});
	
	
});

</script>

</body>
</html>
</html>