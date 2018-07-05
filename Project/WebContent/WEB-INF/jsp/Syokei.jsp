<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Syokei</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/h1.css">
<link rel="stylesheet" type="text/css" href="css/origin/color.css">
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container">
		<p>今夜処刑されたプレイヤーは</p>
		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col"></th>
					<th scope="col">playername</th>
					<th scope="col">playericon</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
			<!--人数分ループ -->
				<c:forEach var="player" items="${tousenPlayerList}" >
					<tr>
						<th></th>
						<th scope="row">${player.name}</th>
						<td><img class="img-icon" src="img/${player.icon}" alt="No img"></td>
					</tr>
				</c:forEach>
			<!-- ループ終了 -->
			</tbody>
		</table>
		<p>ご冥福をお祈りいたします</p>
		<a class="btn btn-primary"href="Syouhai"role="butten">syouhai</a>
	</div>
</body>
</html>