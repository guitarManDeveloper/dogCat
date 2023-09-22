<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


마일리지 충전

<form action="/tossIndex" method="post">

	충전금액:<input type="text" name="price" value="1000"/>
	<button type="submit">충전하기</button>
</form>