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
	<div class="container tyuo-area" >
		<div class="mini-yohaku-area"></div>
		<h3>${player.name}さんでよろしいですか？？？</h3>
		<div class = "mini-yohaku-area"></div>
		<div >
			<img class="icon" src="img/${player.icon}" alt="No img">
		</div>
		<div class = "mini-yohaku-area"></div>
		<P>
		<c:if test="${voteFrg!=null}">
			<a class="btn btn-primary"href="Vote"role="butten">yes!!</a>
		</c:if>
		<c:if test="${voteFrg==null}">
			<a class="btn btn-primary"href="Koudou"role="butten">yes!!</a>
		</c:if>
	</div>
</body>
</html>
