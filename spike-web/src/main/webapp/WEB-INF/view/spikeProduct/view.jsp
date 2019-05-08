<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
	商品id:${productInfo.productId}"</br>
	商家id:${productInfo.merchantId}"</br>
	商品标题:${productInfo.productTitle}</br>
	商品图片地址:${productInfo.productPicture}</br>
	秒杀价格:${productInfo.spikePrice}</br>
	商品原价:${productInfo.originalPrice}</br>
	秒杀开始时间:${productInfo.startTime}</br>
	秒杀结束时间:${productInfo.endTime}</br>
	秒杀商品数量:${productInfo.productCount}</br>
	库存:${productInfo.stockCount}</br>
	描述:${productInfo.description}</br>
</form>
</body>
</html>