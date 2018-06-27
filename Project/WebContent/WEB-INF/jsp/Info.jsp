<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users info</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/color.css">
<link rel="stylesheet" type="text/css" href="css/origin/h1.css">
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container">

		<div class="alert alert-primary" role="alert">

			<%-- <p align="right">
				 ${sessionScope.userInfo.loginId} san<a
					href="LogoutServlet"
					class="alert-link"><span style="margin-right: 12em;"></span>ログアウト</a>
				 --%>

			<h1 align="center">player information</h1>

			<div>
				<h4 style="float: left;">player ID</h4>
				<h4 style="text-align: center">${player.id}</h4>
			</div>
			<div style="clear: both;"></div>

			<div>
				<h4 style="float: left;">player name</h4>
				<h4 style="text-align: center">${player.name}</h4>
			</div>
			<div style="clear: both;"></div>

			<div>
				<h4 style="float: left;">ゲーム参加回数</h4>
				<h4 style="text-align: center;" id="g">${player.gamecount}</h4>
			</div>
			<div style="clear: both;"></div>

			<div>
				<h4 style="float: left;">優勝回数</h4>
				<h4 style="text-align: center;" id="w">${player.wincount}</h4>
			</div>
			<div style="clear: both;"></div>

			<div>

				<h4 style="float: left;">勝率</h4>
				<h4 style="text-align: center;">
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
			<div style="clear: both;"></div>
			<a
				href="Index">"戻る"
			</a>
		</div>

	</div>

</body>
</html>