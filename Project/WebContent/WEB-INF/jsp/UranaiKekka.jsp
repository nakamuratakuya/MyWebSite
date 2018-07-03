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
			<c:if test="${boti == null}">
				<p>${divinedPlayer.name}さんの役職はこんなカンジです</p>
				<p>${divinedPlayer.yName}</p>
			</c:if>

			<c:if test="${boti != null}">
			<p>墓地にある役職はこんなカンジです</p>
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
									<td>表示できなくは無いが面倒だからしない</td>
									<th scope="row"></th>
								</tr>
							</c:forEach>
					</tbody>
					</table>
			</c:if>
			<a class="btn btn-primary"href="PlayerKakunin"role="button">ok!!</a>
		</div>
</body>
</html>