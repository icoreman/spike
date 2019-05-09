<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><a href="toadd">添加商品</a></center>
<table border="2">
	<tr>
		<td>商品名称</td>
		<td>商品产地</td>
		<td>商品品牌</td>
		<td>商家重量</td>
		<td>规格包装</td>
		<td>图片地址</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list}" var="item">
		<tr>
		<td>${item.productName}</td>
		<td>${item.productPlace}</td>
		<td>${item.brandName}</td>
		<td>${item.productWeight}</td>
		<td>${item.specification}</td>
		<td>${item.productPicture}</td>
		<td><a href="toupdate?id=${item.id}">修改</a>||<a href="delete?id=${item.id}">删除</a>||<a href="query?id=${item.id}">查看</a><br>
		<a href="/spike-web/spikeProduct/toApply?productId=${item.id}">申请秒杀商品</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>