<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Uranaisi</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/h1.css">
<link rel="stylesheet" type="text/css" href="css/origin/color.css">
</head>
<body>
<jsp:include page="/baselayout/header.jsp" />
	<div class="container">
		<p>${plyer.name}さんの役職は</p>
		<p>${player.yName}です</p>
		<p>誰を占いますか？</p>
		<table class="table table-striped table-dark">
				<thead>
					<tr>
						<th scope="col"></th>
						<th scope="col">アイコン載せたい</th>
						<th scope="col">playername</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
				<!--人数分ループ -->
					<tr>
						<th><input type="radio" name="sanka"></th>
						<th scope="row">(^^♪)</th>
						<td>ちっぴーせんせい</td>
					</tr>
				<!-- ループ終了 -->
					<tr>
						<th><input type="radio" name="sanka"></th>
						<th>墓地</th>
						<td>boti</td>
					</tr>

				</tbody>
		</table>
		<a class="btn btn-primary"href="#"role="button">占う</a>
	</div>
</body>
</html>