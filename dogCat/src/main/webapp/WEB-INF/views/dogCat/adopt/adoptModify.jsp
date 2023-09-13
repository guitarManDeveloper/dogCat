<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="UTF-8"> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정화면</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>



<body>
<br/>
<div class='container'>
    <div class='container'>
        <%@ include file="/WEB-INF/views/common/loginCommon.jsp" %>
    </div>
    <br/>
    <h2 class="text-center">상품 수정</h2>
    <br/>
	<form action="./modifyAdopt" method="post">
        <input type="hidden" name="id" value="${adopt.id}">
        <table class="table table-bordered">
            <colgroup>
                <col width="180px">
                <col>
            </colgroup>
            <tr>
                <th>카테고리</th>
                <td><select id="commonCodeSelect" name="f_id" style="width: 150px"  class="form-select" aria-label="Default select example"></select></td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" style="width: 150px" class="form-control" id="subject" name="subject" value="${adopt.subject}" placeholder="제목을 입력하세요"></td>
            </tr>
            <tr>
                <th>글쓴이</th>
                <td><input type="text" style="width: 150px"  class="form-control" id="writer" name="writer" value="${adopt.writer }" placeholder="이름을 입력하세요"></td>
            </tr>
        </table>
		<button id='btn_modify' type="submit" class="btn btn-primary btn-sm" style="float: right;margin-left: 5px">수정</button>
		<!-- <button id='btn_delete' class="btn btn-danger btn-sm" style="float: right;margin-left: 5px">삭제</button> -->
        <a href="./adoptList?page=${adoptVO.page}&viewType=${adoptVO.viewType}" class="btn btn-secondary btn-sm" style="float: right;margin-left: 5px">목록</a>
	</form>
</div>
</body>
</html>