<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FOODY</title>
</head>
<body>

	<h1>Chọn Món </h1>
	<form action="LoginServlet" method="POST">
		Tên đăng nhập: <input type="text" name="tendangnhap"> <br />
		Mật khẩu: <input type="password" name="matkhau" />
	<input type="submit" value="Submit" />
	</form>
	<%
		String message = (String) request.getAttribute("message");
		if(message!=null)
		out.print("<p>"+message+"</p>");
	%>
</body>
</html>