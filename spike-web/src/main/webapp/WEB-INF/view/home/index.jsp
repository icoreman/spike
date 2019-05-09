<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
</head>
<body>
欢迎：<span id="userAccount"></span>
<a href="/spike-web/frontUser/toregister">注册</a></br>
<a href="/spike-web/frontUser/tologin">登录</a>
<a href="/spike-web/frontUser/logout">退出登录</a>

<table border="2">
	<c:forEach items="${list}" var="item">
		<tr>
		<td>${item.productTitle}</td>
		<td>${item.productPicture}</td>
		<td>${item.spikePrice}</td>
		<td>${item.originalPrice}</td>
		<td>${item.startTime}</td>
		<td>${item.endTime}</td>
		<td><a href="viewProductDetail?id=${item.id}">查看</a></td>
		</tr>
	</c:forEach>
</table>
<script src="/spike-web/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$.ajax({
		type:"get",
		url:"/spike-web/home/getUser",
		success:function(msg){
			$("#userAccount").html(msg);
		}
	});
	
</script>
</body>
</html>