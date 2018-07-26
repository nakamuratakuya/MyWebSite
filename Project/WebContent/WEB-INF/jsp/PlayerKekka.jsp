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
		<div class="yohaku10-area"></div>
		<p>${player.yName}は</p>
		<div class="yohaku10-area" ></div>
		<p>${player.yDetail}</p>
		<div class="yohaku10-area"></div>
		<c:if test="${player.yName =='人狼'}">
			以下の方が人狼です
			<table class="table table-striped table-dark">
				<thead>
					<tr>
						<th scope="col">playername</th>
						<th scope="col">icon</th>
					</tr>
				</thead>
				<tbody>
					<!--人数分ループ -->
					<c:forEach var="player" items="${jinrouList}">
						<tr>
							<td>${player.name}</td>
							<td><img class="img-icon" src="img/${player.icon}" alt="No img"></td>
						</tr>
					</c:forEach>
					<!-- ループ終了 -->
				</tbody>
			</table>
		</c:if>
		<div class="yohaku10-area"></div>
		<form method="post" action="PlayerKekka">
			<input type="submit" class="btn btn-primary" value=OK!!>
			<!-- <a class="btn btn-primary"href="PlayerKakunin" role="button">OK!!</a> -->
		</form>


</div>
</body>
</html>