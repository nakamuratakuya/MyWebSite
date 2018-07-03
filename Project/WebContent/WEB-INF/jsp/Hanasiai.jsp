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
		<p>村人全員の行動が完了しました </p>
		<p>次にだれをつるし上げるか、話し合ってください</p>
		<form method="post" action="PlayerKakunin">
			<input type="submit" class="btn btn-primary" value="vote" name="voteFrg">
		</form>
	</div>
</body>
</html>