<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đặt món</title>
<style>

</style>

</head>
<body>
	<h1>Order</h1>
	<s:form action="submitOrderAction" method="POST" validate="true">	
			
	    <s:textfield label="Tên món ăn" readonly="true" value='%{foodorder.ten}' /> 
		<s:textfield id="gia" name="gia" label="Giá" value='%{foodorder.gia}' readonly="true" />
		
		<s:textfield id="soluong" name="soluong" label="Số lượng" onchange="tinhthanhtien()"/>
		<s:textfield id="thanhtien" name="thanhtien" label="Thành tiền" readonly="true" />
		
		<input type="hidden" name="idmonan" value='<s:property value="idmonan"/>'/>
			
		<s:submit/>
	</s:form>
	
	<script>
	function tinhthanhtien() {
		var soluong = document.getElementById("soluong").value;
		var gia = document.getElementById("gia").value;
		document.getElementById("thanhtien").value = soluong*gia;
	}
	</script>
	
</body>
</html>