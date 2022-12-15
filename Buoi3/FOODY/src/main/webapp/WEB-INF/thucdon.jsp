<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Food list</h1>
<%
	List<Food> list = (List<Food>) request.getAttribute("list");
%>
<%
	String message = (String) request.getAttribute("message");
	if(message!=null)
	out.print("<p>"+message+"</p>");
%>
<table >
<tr>
<th>Tên món ăn</th>
<th>Hình ảnh</th>
<th>Giá</th>
<th></th>
</tr>
<%
	for (final Food food : list) {
	out.print("<tr><td>"+food.getTen()+"</td><td><img width='80'src='./img/"+food.getHinh()+"'/></td><td>"
	+food.getGia()+"</td><td><a href='OrderServlet?idmonan="+food.getId()+"'>Đặt món</a></td></tr>");
	}
%>
</table>

</body>
</html>