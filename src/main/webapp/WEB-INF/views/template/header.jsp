<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<!-- Brand -->
	<a class="navbar-brand" href="${pageContext.request.contextPath}/">Logo</a>

	<!-- Links -->
	<ul class="navbar-nav">
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/notice/noticeList">NOTICE</a>
		</li>
		<li class="nav-item">
			<a class="nav-link"	href="${pageContext.request.contextPath}/news/newsList">NEWS</a>
		</li>
	</ul>
</nav>
</html>