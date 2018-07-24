<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>inPlayer</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/h1.css">
<link rel="stylesheet" type="text/css" href="css/origin/color.css">
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container ">
	参加するプレイヤーと割り当てられる役職は以下の通りです<br>
	<div class="mini-yohaku-area"></div>
	参加者
	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th scope="col">playername</th>
				<th scope="col">icon</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="player" items="${inPlayerList}" >
				<tr>
					<td>${player.name}</td>
					<td><img class="img-icon" src="img/${player.icon}" alt="No img"></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="yohaku10-area"></div>
	役職
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
		<div class="mini-yohaku-area"></div>
		<form method="post" action="inPlayer">
			<p align="center">
				<input type="submit" class="btn btn-danger" value="GAME START">
					<!--  <a class="btn btn-danger" href="PlayerKakunin" role="button">お、やんのか？？？</a> -->
				</p>
		</form>

	</div>
</body>
</html>