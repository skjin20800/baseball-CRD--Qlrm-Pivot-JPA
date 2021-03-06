<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class = " container">
<h1 class="display-2">팀 등록</h1>
<form>
  <div class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text">팀 이름</span>
    </div>
    <input type="text" class="form-control" id="teamName">
  </div>  
  <div class="form-check">
  <label class="form-check-label">
    <input type="radio" class="form-check-input" name="stadium" value="부산스타디움">부산스타디움
  </label>
</div>
<div class="form-check">
  <label class="form-check-label">
    <input type="radio" class="form-check-input" name="stadium" value="대구스타디움">대구스타디움
  </label>
</div>
<div class="form-check disabled">
  <label class="form-check-label">
    <input type="radio" class="form-check-input" name="stadium" value="서울스타디움">서울스타디움
  </label>
</div>
  
  <button type="button" class="btn btn-primary" id="btn-teamSave">등록</button>
</form>
</div>
<script>
      $("#btn-teamSave").on("click", (e)=>{
	e.preventDefault(); //form태그 action안타게 막아버리는것
	
    var obj_length = document.getElementsByName("stadium").length;
	    var stadium;
    for (var i=0; i<obj_length; i++) {
        if (document.getElementsByName("stadium")[i].checked == true) {
        	stadium = document.getElementsByName("stadium")[i].value;
        }
    }
  	let data = {
  			stadium: stadium,
  			teamName: $("#teamName").val(),
	};
      
      $.ajax({
		type: "POST",
		url: "/team",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType:"json"
	}).done((res)=>{
		if(res === 1){
			alert("등록되었습니다");
		}else{
			alert("이미 등록된 팀입니다.");
		}
	});
	      
});

</script>

</body>
</html>
</html>