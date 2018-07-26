<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>uranaikekka</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/h1.css">
<link rel="stylesheet" type="text/css" href="css/origin/color.css">
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />
		<div class="container ">
		<div class="yohaku10-area"></div>
			<c:if test="${boti == null}">
				<p>${divinedPlayer.name}さんの役職はこんなカンジです</p>
				<div class="yohaku10-area"></div>
				<p>${divinedPlayer.yName}</p>
			</c:if>

			<c:if test="${boti != null}">
			<p>墓地にある役職はこんなカンジです</p>
			<div class="yohaku10-area"></div>
				<table class="table table-striped table-dark">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">yakusyokuname</th>
								<th scope="col">icon</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
						<!--人数分ループ -->
							<c:forEach var="boti" items="${botiList}" >
								<tr>
									<th></th>
									<th>${boti.name}</th>
									<td><img class="img-icon" src="img/${boti.icon}"></td>
									<th scope="row"></th>
								</tr>
							</c:forEach>
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