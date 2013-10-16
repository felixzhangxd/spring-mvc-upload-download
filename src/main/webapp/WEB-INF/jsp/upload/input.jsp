<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/upload/submit" method="post" enctype="multipart/form-data">
		<input type="file" name="image" /><br/>
		<input type="submit" /><br/>
	</form>
	<hr/>
	<form action="${pageContext.request.contextPath}/upload/submits" method="post" enctype="multipart/form-data">
		<input type="file" name="images" /><br/>
		<input type="file" name="images" /><br/>
		<input type="submit" /><br/>
	</form>
</body>
</html>