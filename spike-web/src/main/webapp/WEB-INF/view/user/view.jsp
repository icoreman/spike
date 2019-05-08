<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="add">
	用户姓名:${user.userName}</br>
	用户账号:${user.userAccount}</br>
	用户密码:${user.userPassword}</br>
	用户性别:${user.userGender}</br>
	用户年龄:${user.userAge}</br>
	用户地址:${user.userAddress}</br>
	用户邮箱:${user.userEmail}</br>
</form>
</body>
</html>