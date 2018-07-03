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

		<p>${player.yName}は</p>
		<p>${player.yDetail}</p>
		<c:if test="${player.yName =='人狼'}">
		<%-- <c:if test=""></c:if> --%>
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
		<a class="btn btn-primary"href="PlayerKakunin"role="button">OK!!</a>

	</div>
</body>
</html>