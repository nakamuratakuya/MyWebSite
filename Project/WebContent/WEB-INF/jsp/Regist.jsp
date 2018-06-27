<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>regist</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/h1.css">
<link rel="stylesheet" type="text/css" href="css/origin/color.css">
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container ">
	<div class="backgroud-area">
		<h3>プレイヤー新規登録</h3>
		<p align="right">
			<a href="Index">"戻る"</a>
		</p>
	</div>

		<c:if test="${errMsg != null}">
				<div class="alert alert-danger" role="alert">${errMsg}</div>
			</c:if>

		<div class="yohaku10-area"></div>
		<form method="post" action="Regist">

			<label for="playername">player  name</label>
			<input class="form-control" type="text"  required name="name" placeholder="your  name" >

			<div class="mini-yohaku-area"></div>

	 		 <div class="form-group">
	   	 		<label for="exampleFormControlFile1">your icon</label>
	    		<input type="file" name="icon" class="form-control-file" id="exampleFormControlFile1">
	 		 </div>
			<div class="yohaku70-area"> </div>
			<p align="center">
				<input type="submit" class="btn btn-primary" value="Regist">
			</p>

		</form>
	</div>

</body>
