<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Koudou</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/baselayout/header.jsp" />
	<div class="container">

		<p>${player.Name}さんの役職は${player.yname}です</p>
		<p><img class="img-icon" src="img/${player.yIcon}"></p>
		<p>${player.yComment}</p>
		<a class="btn btn-primary"href="PlayerKekka"role="button">ok!!</a>

	</div>
</body>
</html>