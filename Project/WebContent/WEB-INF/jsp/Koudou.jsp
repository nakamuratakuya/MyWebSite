<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Koudou</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/h1.css">
<link rel="stylesheet" type="text/css" href="css/origin/color.css">

</head>
<body>
<jsp:include page="/baselayout/header.jsp" />
	<div class="container">
		<div class="mini-yohaku-area"></div>
		<p>${player.name}さんの役職は${player.yName}です</p>
		<p><img class="img-icon" src="img/${player.yIcon}"></p>
		<p>${player.yComment}</p>
		<div class="yohaku10-area"></div>
		<a class="btn btn-primary"href="PlayerKekka"role="button">ok!!</a>

	</div>
</body>
</html>