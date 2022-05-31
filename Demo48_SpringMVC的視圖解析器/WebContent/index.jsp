<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp首頁</h1>
	<h1>因為jsp可以直接訪問，所以就不需要再設置首頁的請求映射</h1>
	<a href="${pageContext.request.contextPath}/success">success</a>
</body>
</html>