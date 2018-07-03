<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
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

		<P>${player.name}さんでよろしいですか？？？</P>
		<p><img class="img-icon" src="img/${player.icon}" alt="No img"></p>
		<c:if test="${voteFrg!=null}">
			<a class="btn btn-primary"href="vote"role="butten">vote!!</a>
		</c:if>
		<c:if test="${voteFrg==null}">
		<a class="btn btn-primary"href="Koudou"role="butten">yes!!</a>
		</c:if>
	</div>
</body>
</html>