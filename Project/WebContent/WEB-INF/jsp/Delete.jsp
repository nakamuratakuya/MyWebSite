<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>player Delete</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/color.css">
<link rel="stylesheet" type="text/css" href="css/origin/h1.css">
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container">

		<div class="background-denger">
			<h1 align="center">player Delete</h1>
			<div class="yohaku10-area"></div>
			<h3 align="center">player name: ${player.name}　</h3>
			<div class="yohaku10-area"></div>
			<h3 align="center">ほんとに削除してよろしいでしょうか。</h3>

			<div class="dekaiyohaku">
				<div class="tyuo-area">
					<div style="display:inline-flex">
						<form action="Delete" method="post">
							<input class="btn btn-primary" type="hidden" name="id" value="${player.id}">
							<input class="btn btn-primary" type="submit" value="yes!">
						</form>
						<span style="margin-right: 7em;"></span>
						<a class="btn btn-success" href="Index" role="button">back</a>
					</div>
				</div>
				<p align="left">
				<!-- 	<a href="Index">"戻る" </a> -->

			</div>
		</div>
	</div>
</body>
</html>