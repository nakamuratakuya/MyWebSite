<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/h1.css">
<link rel="stylesheet" type="text/css" href="css/origin/color.css">
</head>
<body>
<jsp:include page="/baselayout/header.jsp" />
	<div class="container">
		<p>村人全員の行動が完了しました </p>
		<p>次にだれをつるし上げるか、時間内で話し合ってください</p>

		<div id = "timer" style=text-align:center >
	        <div id = 'box'>
		        <h1 id="display">03:00</h1>
	            <div id= 'button'>
		           <!--  <button id = 'start'class="btn btn-primary">スタート</button> -->
		         	<!--  <button id = 'stop'>ストップ</button> -->
		            <button id = 'reset'class="btn btn-primary">リセット</button>
	            </div>
	        </div>
    	</div>

		<!-- <div class="mini-yohaku-area"></div> -->

		<p>用意されている役職は以下の通りです
		<p>このうち二つは墓地に送られています
		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col">役職名</th>
					<th scope="col">icon</th>
					<th scope="col">陣営</th>
					<th scope="col">説明</th>
					<th scope="col">人数</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="yakusyoku" items="${yakusyokuList}" >
					<tr>
						<td>${yakusyoku.name}</td>
						<td><img class="img-icon" src="img/${yakusyoku.icon}" alt="No img"></td>
						<td>${yakusyoku.side}</td>
						<td>${yakusyoku.detail}</td>
						<td>
							<c:if test="${yakusyoku.id==1}">
								${siminCount}人
							</c:if>
							<c:if test="${yakusyoku.id==2}">
								${jinrouCount}人
							</c:if>
							<c:if test="${yakusyoku.id==3}">
								${uranaisiCount}人
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<form method="post" action="PlayerKakunin">
			<input type="submit" id="vote" class="btn btn-primary" value="vote" name="voteFrg">
		</form>

	</div>
	<script type="text/javascript">

	    var interval_id;
	    var start_click = false;
	    var time = 180;
	    var min = 0;
	    var sec = 0;


	    function count_start(){
	        if(start_click === false){
	            interval_id = setInterval(count_down , 1000);
	            start_click = true;
	        }
	    }

	    function count_down(){
	        var display = document.getElementById('display');
	        console.log(time);
	        if (time === 1 ){
	            display.innerHTML = 'TIME UP!';
	            document.getElementById("vote").click();
	        }else{
	            time--;
	            min = Math.floor(time / 60);
	            sen = Math.floor(time % 60);
	            display.innerHTML = '0' + min +':' + sen ;
	         if (sen<10) {
	             display.innerHTML = '0' + min + ':' + '0' + sen;
	         }
	         }

	    }


	/*     function count_stop(){
	        clearInterval(interval_id);
	        start_click = false;

	    } */
	    function count_reset(){
	        time = 180;
	        min = 0;
	        sen = 0;
	        var reset = document.getElementById('display');
	        reset.innerHTML = '03:00';

	   }

	    window.onload = function(){
	    	count_start();
	/*         var start = document.getElementById('start');
	    start.addEventListener('click' , count_start , false); */
	  /*   var stop = document.getElementById('stop');
	    stop.addEventListener('click', count_stop , false ); */
	     var reset = document.getElementById('reset');
	    reset.addEventListener('click', count_reset , false );
	    }
	</script>
</body>
</html>