<%@page import="Models.Food"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Order</h1>
<%
	Food food = (Food) request.getAttribute("food");
%>
<form action="OrderServlet" method="POST">
	Tên món ăn: <%=food.getTen() %> <br/>
	Giá: <input type="text" id="gia" name="gia" value='<%=food.getGia() %>' />
<br/>
	Số lượng: <input type="text" id="soluong" name="soluong"
	onchange="tinhthanhtien()" /> <br/>
	Thành tiền: <input type="text" id="thanhtien" name="thanhtien" /><br/>
<input type="hidden" name="idmonan" value='<%=food.getId()%>'/>
<input type="submit" value="Submit" />
</form>
<script>
function tinhthanhtien() {
var soluong = document.getElementById("soluong").value;
var gia = document.getElementById("gia").value;
document.getElementById("thanhtien").value = soluong*gia;
}
</script>
</body>
</html>