<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
<input name="id" value="${productInfo.id }" type="hidden">
	商品id:${productInfo.productId }"</br>
	商家id:${productInfo.merchantId }"</br>
	商品标题:${productInfo.productTitle }</br>
	商品图片地址:${productInfo.productPicture }</br>
	秒杀价格:${productInfo.spikePrice }</br>
	商品原价:${productInfo.originalPrice }</br>
	秒杀开始时间:${startTimeString }</br>
	秒杀结束时间:${endTimeString}</br>
	秒杀商品数量:${productInfo.productCount }</br>
	库存:${productInfo.stockCount }</br>
	描述:${productInfo.description }</br>
	审核通过:<input type="radio" name="state" value="1">审核不通过:<input type="radio" name="state" value="2">
	<input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
	function submit(obj){
		obj.parent.sumbit();
	}
</script>
</html>