<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Uranaisi</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/h1.css">
<link rel="stylesheet" type="text/css" href="css/origin/color.css">
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />
		<div class="container">
			<p>${player.name}さんの役職は</p>
			<p>${player.yName}です</p>
			<p>${player.yComment}www</p>
			<p>誰を占いますか？</p>
			<form method="post" action="Koudou">
				<table class="table table-striped table-dark">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">playername</th>
								<th scope="col">icon</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
						<!--人数分ループ -->
							<c:forEach var="player" items="${inPlayerList}" >
								<c:if test="${player.id != sessionScope.player.id}">
									<tr>
										<th><input type="radio" value="${player.id}" name=playerId></th>
										<td>${player.name}</td>
										<th scope="row"><img class="img-icon" src="img/${player.icon}" alt="No img"></th>
									</tr>
								</c:if>
							</c:forEach>
						<!-- ループ終了 -->
							<tr>
								<th><input type="radio" value="boti" name="playerId"></th>
								<td>墓地</td>
								<th><img class="img-icon" src="img/halloween_grave.png"></th>
							</tr>
						</tbody>
				</table>
				<c:if test="${errMsg != null}">
					<div class="alert alert-danger" role="alert">${errMsg}</div>
				</c:if>
				<input type="submit" class="btn btn-primary" value="占う">
			</form>
		</div>
</body>
</html>