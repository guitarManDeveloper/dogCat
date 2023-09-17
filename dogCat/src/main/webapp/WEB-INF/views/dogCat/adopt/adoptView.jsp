<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>
<script type="text/javascript">

	function fn_deleteAt(url) {
       if( confirm("삭제하시겠습니까?")){
           window.location = url;
       }
       return false;
    }
	
</script>


<body>
<br/>
<div class='container'>
	<div class='container'>
		<!-- 로그인 화면  -->
		<%-- <%@ include file="/WEB-INF/views/common/loginCommon.jsp" %> --%>
	</div>
	<br/>
	<h2 class="text-center">상품 상세보기</h2>
	<br/>
	<table class="table table-bordered text-center" style="width: 800px; margin-left: auto; margin-right: auto;">
		<colgroup>
			<col width="180px">
			<col>
		</colgroup>
		<tr>
			<th>제목</th>
			<td>${adopt.subject}</td>
		</tr>
		<tr>
			<th>종류</th>
			<td>${adopt.species}</td>
		</tr>
		<tr>
			<th>펫이름</th>
			<td>${adopt.name}</td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td>${adopt.writer}</td>
		</tr>
		<tr>
			<th>연락처</th>
			<td>${adopt.phone}</td>
		</tr>
        <tr>
            <th>이미지</th>
            <%--<td>/image/파랑.jpg</td>--%>
            <td>
                <img class="card-img-bottom d-block" src="/resources/userImageData/${adopt.originalFileName }" alt="Card image cap">
            </td>
        </tr>
	</table>
	<div style="margin-left: 900px; margin-right: auto;">
		<a href="./adoptList?page=${adoptVO.page}&viewType=${adoptVO.viewType}" class="btn btn-secondary btn-sm" >목록</a>
		<a href="./modifyAdopt?id=${adopt.id}&page=${adoptVO.page}&viewType=${adoptVO.viewType}" class="btn btn-primary btn-sm" >수정</a>
		<a href="./deleteAdopt?id=${adopt.id}" onclick="return fn_deleteAt(this.href)" class="btn btn-danger btn-sm" >삭제</a>
	</div>

</div>

</body>
</html>