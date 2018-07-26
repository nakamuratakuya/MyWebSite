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
		<h1>${winSide}</h1>

		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col">市民側</th>
					<th scope="col">playername</th>
					<th scope="col">icon</th>
					<th scope="col">役職</th>
					<th scope="col">投票先</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="player" items="${inPlayerList}">
					<c:if test="${player.yId != 2}">
						<tr>
							<th></th>
							<th scope="row">${player.name }</th>
							<td><img class="img-icon" src="img/${player.icon}" alt="No img"></td>
							<td>${player.yName}</td>
							<td>${player.votePlayerName}</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>

		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col"	>人狼側</th>
					<th scope="col">playername</th>
					<th scope="col">icon</th>
					<th scope="col">役職</th>
					<th scope="col">投票先</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="player" items="${inPlayerList}">
					<c:if test="${player.yId == 2}">
						<tr>
							<th></th>
							<th scope="row">${player.name }</th>
							<td><img class="img-icon" src="img/${player.icon}" alt="No img"></td>
							<td>${player.yName}</td>
							<td>${player.votePlayerName}</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>

		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col"	>墓地</th>
					<th scope="col">役職</th>
					<th scope="col">icon</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="boti" items="${botiList}">
					<tr>
						<th></th>
						<td>${boti.name}</td>
						<td><img class="img-icon" src="img/${boti.icon}"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="yohaku10-area"></div>
		<div class="tyuo-area ">
			<a class="btn btn-primary"href="inPlayer"role="button">one more</a>
			<span style="margin-right: 7em;"></span>
			<a class="btn btn-primary"href="Index"role="button">end</a>

		</div>
	</div>
</body>
</html>