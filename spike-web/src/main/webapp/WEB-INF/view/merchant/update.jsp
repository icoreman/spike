<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
	<input name="id" value="${merchant.id }" type="hidden"/>
	商家的姓名:<input name="merchantName" value="${merchant.merchantName}"></br>
	商家的店铺名称:<input name="merchantShopname" value="${merchant.merchantShopname}"></br>
	商家账号:<input name="merchantAccount" value="${merchant.merchantAccount}"></br>
	商家密码:<input name="merchantPassword" value="${merchant.merchantPassword}"></br>
	商家经营范围:<input name="merchantScope" value="${merchant.merchantScope}"></br>
	<input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
	function submit(obj){
		obj.parent.sumbit();
	}
</script>
</html>