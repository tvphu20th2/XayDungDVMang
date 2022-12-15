<%@ taglib uri="/struts-tags" prefix="s"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<h1>Food list</h1>
	<s:if test='getMessage()"!=""'>
		<p>
			<s:property value="message" />
		</p>
	</s:if>
	<table>
		<tr>
			<th>Tên món ăn</th>
			<th>Hình ảnh</th>
			<th>Giá</th>
			<th></th>
		</tr>
		<s:iterator var="food" value="foodlist">
		<tr>
			<td><s:property value="ten"/></td>
			<td><img width='80' src=' ./img/<s:property value="hinh"/>'/></td>
			<td><s:property value="gia"/></td>
			<td><a href='orderAction?idmonan=<s:property value="id"/>'>Đặt món</a></td>
		</tr>
		</s:iterator>		
	</table>
</body>
</html>