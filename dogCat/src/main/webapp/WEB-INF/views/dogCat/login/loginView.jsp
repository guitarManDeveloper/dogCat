<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <title>Insert title here</title>
</head>


<body>
<h2>로그인</h2>
<form name="form1" method="post" action="/login">
<table border="1" width="400px">
<tr>
 <td>아이디</td>
 <td><input type="text" id="userId" name="userId" value="${loginVO.message}"></td>
</tr>
<tr>
 <td>비밀번호</td>
 <td><input type="text" id="userPw" name="userPw"></td>
</tr>
<tr>
 <td colspan="2" align="center">
 <button type="submit" id="btnLogin">로그인 </button>
</td>
</tr>
</table>
</form>
</body>
</html>