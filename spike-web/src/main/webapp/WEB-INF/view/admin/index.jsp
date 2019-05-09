<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商家</title>
</head>
<body>
欢迎商家：${merchant.merchantAccount}
<a href="/spike-web/merichantAdmin/toregister">商家注册</a></br>
<a href="/spike-web/merichantAdmin/tologin">商家登录</a>
<a href="/spike-web/merichantAdmin/logout">商家退出登录</a><br>
<a href="/spike-web/product/list">商品管理</a>
<a href="/spike-web/spikeProduct/list">秒杀商品管理</a>

</body>
</html>