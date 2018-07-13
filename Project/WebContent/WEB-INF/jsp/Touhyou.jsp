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
			<p>つるし上げたい人に投票してください</p>
			<form method="post" action="Vote" >
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
							<c:forEach var="player" items="${inPlayerList}" >
							<c:if test="${player.id != sessionScope.player.id}">
								<tr>
									<th><input type="radio" name=playerName value="${player.name}"></th>
									<th scope="row">${player.name}</th>
									<td><img class="img-icon" src="img/${player.icon}" alt="No img"></td>
								</tr>
							</c:if>
							</c:forEach>
						<!-- ループ終了 -->
						</tbody>
				</table>
				<c:if test="${errMsg != null}">
					<div class="alert alert-danger" role="alert">${errMsg}</div>
				</c:if>
				<input type="submit" class="btn btn-primary" value="vote">
			</form>
		</div>
</body>
</html>