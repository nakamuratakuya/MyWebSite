<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>jinrou</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/color.css">
<link rel="stylesheet" type="text/css" href="css/origin/h1.css">


</head>
<body>


	<nav class="navbar navbar-expand-lg navbar-light header">
		<div class="collapse navbar-collapse container" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">Jinrou</li>
			</ul>
			<span class="navbar-text">
				<a href="#">
					<font size ="3" color="#f0f8ff">
						りんくにしたよ
					</font>
				</a>
			</span>
		</div>
	</nav>


	<!-- <div class="header">
	<div class="container">
		    jinrou
			<span style="margin-right: 15em;"></span>
			<a href="#">
				<font size="5" >modoru
				</font>
			</a>
			</div>
	</div> -->

	<div class="container">

		<p>参加者を選んで下さい</p>
		<div class="yohaku10-area"></div>
		<a href="Regist">新規登録</a>
		<form method="post" action="Index">
			<!--参加人数を決めるのテーブル-->
			<table class="table table-striped table-dark">
				<thead>
					<tr>
						<th scope="col">参加</th>
						<th scope="col">playername</th>
						<th scope="col">icon</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<!--人数分ループ -->
					<c:forEach var="player" items="${playerList}" >
					<tr>
						<th><input type="checkbox" value="${player.id}" name="playerId"></th>
						<td>${player.name}</td>
						<td><img class="img-icon" src="img/${player.icon}" alt="No img"></td>
						<td><a class="btn btn-primary" href="Info?id=${player.id}" role="button">info</a>
							<a class="btn btn-success" href="#" role="button">update</a> <a
							class="btn btn-danger" href="Delete?id=${player.id}" role="button">delete</a></td>
					</tr>
					</c:forEach>
					<!-- ループ終了 -->
				</tbody>
			</table>
			<div class="mini-yohaku-area"></div>
			<c:if test="${errMsg != null}">
				<div class="alert alert-danger" role="alert">${errMsg}</div>
			</c:if>
			<p align="center">
				<input type="submit" class="btn btn-primary" value="sanka">
			</p>
		</form>
	</div>
</body>
</html>