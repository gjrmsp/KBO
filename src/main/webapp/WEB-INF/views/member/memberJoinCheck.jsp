<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container">
		<h1>Member Join Check</h1>

		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input" id="all" value="">전체동의
			</label>
		</div>

		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input check" value="">동의
			</label>
		</div>

		<div class="jumbotron">
			<h1>Bootstrap Tutorial</h1>
			<p>Bootstrap is the most popular HTML, CSS...</p>
		</div>

		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input check" value="">동의
			</label>
		</div>

		<div class="jumbotron">
			<h1>Bootstrap Tutorial</h1>
			<p>Bootstrap is the most popular HTML, CSS...</p>
		</div>

		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input check" value="">동의
			</label>
		</div>

		<div class="jumbotron">
			<h1>Bootstrap Tutorial</h1>
			<p>Bootstrap is the most popular HTML, CSS...</p>
		</div>

		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input check" value="">동의
			</label>
		</div>

		<div class="jumbotron">
			<h1>Bootstrap Tutorial</h1>
			<p>Bootstrap is the most popular HTML, CSS...</p>
		</div>

		<button class="btn btn-danger" id="btn">JOIN</button>
		<script type="text/javascript"
			src="../resources/jquery/memberJoinCheck.js"></script>
	</div>
</body>
</html>