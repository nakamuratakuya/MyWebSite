<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> info</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/color.css">
<link rel="stylesheet" type="text/css" href="css/origin/h1.css">
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container">

		<div class="alert alert-primary" role="alert">


			<h1 align="center">player information</h1>


			 <div class="row justify-content-around">
			    <div class="col-4" align="center">
			    	<h4>PLAYER NAME</h4>
			  		<h4>${player.name}</h4>
				 </div>
				 <div class="col-4" align="center">
			    	<h4>PLAYER ID</h4>
			  		<h4>${player.id}</h4>
				 </div>
			 </div>

			<div class="mini-yohaku-area" ></div>

			 <div class="row justify-content-around">
			    <div class="col-4" align="center">
			    	<h4>GAME COUNT</h4>
			  		<h4 id="g">${player.gamecount}</h4>
				 </div>
				 <div class="col-4" align="center">
			    	<h4>WIN COUNT</h4>
			  		<h4 id="w">${player.wincount}</h4>
				 </div>
				 <div class="col-4" align="center">
			    	<h4>WIN PERCENT</h4>
			  		<h4>
			  		<script type="text/javascript">
						elemW = document.getElementById("w");
						elemG = document.getElementById("g");

						var contentW = elemW.innerHTML;
						var contentG = elemG.innerHTML;

						var w = Number(contentW);
						var g = Number(contentG);

						var result = w / g * 10000;
						result = Math.floor(result);
						var a = result / 100;

						if(w == 0){
							document.write(0);
						}
						else{
							document.write(a);
						}
					</script>
						%
			  		</h4>
				 </div>
			 </div>

			<div class="mini-yohaku-area" ></div>

			<a
				href="Index">"戻る"
			</a>
		</div>

	</div>

</body>
</html>