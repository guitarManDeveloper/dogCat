<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){

		$("#logout").click(function(){
			let confirmation = confirm("로그아웃 하시겠습니까?");
			if(!confirmation){
				return false; 
			}
			$.ajax({
				url: '/logout',
				type:'POST',				
				success:function(response){					
					window.location.href = './selectItemList';
				},
				error:function(){					
				}			
			});	
		});
	});

</script>
<br/>
<body >
<div class='container'>
    <h2 class="text-center">멍멍냐옹 목록 게시판</h2>
    <br/>
    <form action="./adoptList" method="get">
        <div class="input-group" style="float:right; width: 400px; margin-bottom: 15px;">
            <input type="hidden" value="${adoptVO.viewType}" name="viewType"/>
            <input type="search" name="subject" class="form-control rounded" placeholder="상품명을 입력하세요." value="${adoptVO.subject}" aria-label="Search" aria-describedby="search-addon" />
            <button type="submit" class="btn btn-outline-primary">검색</button>

        </div>
    </form>


    <c:set var="buttonType1" value="primary"/>
    <c:set var="buttonType2" value="primary"/>
    <c:if test="${adoptVO.viewType eq 'list'}">
        <c:set var="buttonType1" value="danger"/>
    </c:if>
    <c:if test="${adoptVO.viewType eq 'photo'}">
        <c:set var="buttonType2" value="danger"/>
    </c:if>
    <a href="./adoptList?viewType=list" class="btn btn-outline-${buttonType1}">리스트형</a>
    <a href="./adoptList?viewType=photo" class="btn btn-outline-${buttonType2}">카드형</a>
    <table class="table table-hover table-bordered text-center">
    <br/>
    <a href="./adoptList?viewType=photo" class="btn btn-outline-${buttonType2}">전체</a>
    <a href="./adoptList?viewType=photo" class="btn btn-outline-${buttonType2}">진행중</a>
    <a href="./adoptList?viewType=photo" class="btn btn-outline-${buttonType2}">완료</a>
        <thead>
        <tr>
            <th scope="col">번호</th>
            <th scope="col">분류</th>
            <th scope="col">제목</th>
            <th scope="col">글쓴이</th>
            <th scope="col">날짜</th>
            <th scope="col">조회수</th>
        </tr>
        </thead>
        <colgroup>
            <col width="30px">
            <col width="60px">
            <col width="190px">
            <col width="60px">
            <col width="120px">
            <col width="30px">
        </colgroup>

        <tbody>
        <c:set var="number" value="${totalCnt-offset}"/>
        <c:forEach var="adopt" items="${adoptList}">
            <tr>
                <th scope="row">${number}</th>
                <td>${adopt.category}</td>
                <td><a href="./adoptView?id=${adopt.id}&viewType=${adoptVO.viewType}" style="text-decoration: none;"><strong>${adopt.subject}</strong></a></td>
                <td>${adopt.writer}</td>
                <td>
                    <fmt:parseDate value="${adopt.rdate}" var="dateValue" pattern="yyyyMMddHHmmss"/>
                    <fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd"/>
                </td>
                <td>${adopt.hit}</td>
            </tr>
            <c:set var="number" value="${number-1}"/>
        </c:forEach>
        </tbody>
    </table>
    <a href="./createAdopt?page=${adoptVO.page}&viewType=${adoptVO.viewType}" class="btn btn-primary border-right btn-sm" style="float: right">상품등록</a>
    <nav>
        <ul class="pagination justify-content-center">
            <li class="page-item ${currentPage == 1? 'disabled' : '' }">
                <a class="page-link" href="?page=${currentPage-1}&viewType=${adoptVO.viewType}">이전</a>
            </li>
            <c:forEach begin="1" end="${totalPage}" var="pageNumber">
                <li class="page-item ${pageNumber == currentPage ? 'active' : '' }" aria-current="page">
                    <a class="page-link" href="?page=${pageNumber}&viewType=${adoptVO.viewType}">${pageNumber}</a>
                </li>
            </c:forEach>
            <li class="page-item ${currentPage == totalPage? 'disabled' : '' }">
                <a class="page-link" href="?page=${currentPage+1}&viewType=${adoptVO.viewType}">다음</a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>