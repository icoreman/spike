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
	商品产地:${productDetail.productPlace}</br>
	商品名称:${productDetail.productName}</br>
	商品品牌:${productDetail.brandName}</br>
	商品重量:${productDetail.productWeight}</br>
	规格和包装:${productDetail.specification}</br>
	商品详情图片地址:${productDetail.productDetailPicture}</br>
</form>
</body>
<script type="text/javascript">
	function submit(obj){
		obj.parent.sumbit();
	}
</script>
</html>