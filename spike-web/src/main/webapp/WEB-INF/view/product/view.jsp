<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form >
	商品产地:${product.productPlace}</br>
	商品名称:${product.productName}</br>
	商品品牌:${product.brandName}</br>
	商品重量:${product.productWeight}</br>
	规格和包装:${product.specification}</br>
	商品详情图片地址:${product.productPicture}</br>
	<input type="button" onclick="back(this)" value="返回">
</form>
</body>
<script type="text/javascript">
	function back(obj) {
		history.back();
	}
</script>
</html>