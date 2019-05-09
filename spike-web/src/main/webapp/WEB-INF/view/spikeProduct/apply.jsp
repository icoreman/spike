<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="apply" method="post">
	<input name="productId" type="hidden" value="${spikeProductInfo.productId}">
	<input name="merchantId" type="hidden" value="${spikeProductInfo.merchantId}">
	
	商品标题:<input name="productTitle" value="${spikeProductInfo.productTitle}"></br>
	商品图片地址:<input name="productPicture" value="${spikeProductInfo.productPicture}"></br>
	秒杀价格:<input name="spikePrice"></br>
	商品原价:<input name="originalPrice"></br>
	
	秒杀开始时间:<input name="startTimeString"></br>
	秒杀结束时间:<input name="endTimeString"></br>
	秒杀商品数量:<input name="productCount"></br>
	库存:<input name="stockCount"></br>
	描述:<input name="description"></br>
	<input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
	function submit(obj){
		obj.parent.sumbit();
	}
</script>
</html>