<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="loginUser" method="POST">
		Username:<input type="text" name="tendangnhap" /><br />
		Password:<input type="password" name="matkhau" /><br />
		<input type="submit" value="login" />
	</form>
	<s:if test="hasActionMessages()">
	<div>
	<s:actionmessage/>
	</div>
	</s:if>
</body>
</html>