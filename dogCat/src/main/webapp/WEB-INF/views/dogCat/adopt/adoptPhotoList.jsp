<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
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
					window.location.href = './adoptList';
				},
				error:function(){					
				}			
			});	
		});
	});

	function fn_deleteAt(url) {
        if( confirm("삭제하시겠습니까?")){
            window.location = url;
        }
        return false;
    }
</script>
<br/>
<body >
<div class='container'>
    <div class='container'>
        <%@ include file="/WEB-INF/views/common/loginCommon.jsp" %>
    </div>
    <br/>
    <h2 class="text-center">상품 목록 게시판</h2>
    <br/>
    
    <form action="./adoptList" method="get">
	    <input type="date" name="searchStartDate" value="${adoptVO.searchStartDate}" > ~ 
	    <input type="date" name="searchEndDate" value="${adoptVO.searchEndDate}" >
	    <input type="submit" value="Submit">
    </form>
    
    <c:set var="buttonType1" value="primary"/>
    <c:set var="buttonType2" value="primary"/>
    <c:if test="${adoptVO.viewType eq 'list'}">
        <c:set var="buttonType1" value="danger"/>
    </c:if>
    <c:if test="${adoptVO.viewType eq 'photo'}">
        <c:set var="buttonType2" value="danger"/>
    </c:if>
    <a href="./adoptList?viewType=list&category=${adoptVO.category}&hitOrder=${adoptVO.hitOrder}" class="btn btn-outline-${buttonType1}" >리스트형</a>
    <a href="./adoptList?viewType=photo&category=${adoptVO.category}&hitOrder=${adoptVO.hitOrder}" class="btn btn-outline-${buttonType2}" >카드형</a>
   <br/>
   
    <c:set var="categoryButtonType1" value="primary"/>
    <c:set var="categoryButtonType2" value="primary"/>
    <c:set var="categoryButtonType3" value="primary"/>
    <c:set var="categoryButtonType4" value="primary"/>
    <c:set var="categoryButtonType5" value="primary"/>
    
    
    <c:if test="${empty adoptVO.category}">
        <c:set var="categoryButtonType1" value="danger"/>
    </c:if>
    <c:if test="${adoptVO.category eq '진행중'}">
        <c:set var="categoryButtonType2" value="danger"/>
    </c:if>
    <c:if test="${adoptVO.category eq '완료'}">
        <c:set var="categoryButtonType3" value="danger"/>
    </c:if>
    <c:if test="${adoptVO.hitOrder eq 'DESC'}">
        <c:set var="categoryButtonType4" value="danger"/>
    </c:if>
    <c:if test="${adoptVO.hitOrder eq 'ASC'}">
        <c:set var="categoryButtonType5" value="danger"/>
    </c:if>
    
    <a href="./adoptList?viewType=${adoptVO.viewType}&category=&hitOrder=${adoptVO.hitOrder}" class="btn btn-outline-${categoryButtonType1}">전체</a>
    <a href="./adoptList?viewType=${adoptVO.viewType}&category=진행중&hitOrder=${adoptVO.hitOrder}" class="btn btn-outline-${categoryButtonType2}">진행중</a>
    <a href="./adoptList?viewType=${adoptVO.viewType}&category=완료&hitOrder=${adoptVO.hitOrder}" class="btn btn-outline-${categoryButtonType3}">완료</a>
    <a href="./adoptList?viewType=${adoptVO.viewType}&hitOrder=DESC&category=${adoptVO.category}" class="btn btn-outline-${categoryButtonType4}">조회수↓</a>
    <a href="./adoptList?viewType=${adoptVO.viewType}&hitOrder=ASC&category=${adoptVO.category}" class="btn btn-outline-${categoryButtonType5}">조회순↑</a>
    <div class="row">
        <form action="./adoptList" method="get">
            <div class="input-group" style="float:right; width: 400px; margin-bottom: 15px;">
            	
            	<input type='checkbox' name='searchContentAt' value='Y' <c:if test="${adoptVO.searchContentAt eq 'Y'}">checked</c:if>/>내용포함
                <input type="hidden" value="${adoptVO.viewType}" name="viewType"/>
                <input type="search" name="subject" class="form-control rounded" placeholder="검색어를 입력하세요." value="${adoptVO.subject}" aria-label="Search" aria-describedby="search-addon" />
                <button type="submit" class="btn btn-outline-primary">검색</button>

            </div>
        </form>


        <c:set var="number" value="${totalCnt-offset}"/>
        <c:forEach var="adopt" items="${adoptList}">
            <div class="col-3" style="margin-top: 15px;">
                <div class="card" >
                    <img class="card-img-top" style="width: 304px; height: 304px;" src="/resources/userImageData/${adopt.originalFileName}" alt="" />
                    <div class="card-body">
                        <h5 class="card-title">${adopt.subject}</h5>
                        <p class="card-text">${adopt.writer }</p>
                        <a href="./adoptView?id=${adopt.id}&page=${adoptVO.page}&viewType=${adoptVO.viewType}" class="btn btn-primary btn-sm">상세보기</a>
                        <td>조회수 : ${adopt.hit}</td>
                    </div>
                </div>
            </div>
            <c:set var="number" value="${number-1}"/>
        </c:forEach>
    </div>

    <br/>

    <a href="./createAdopt?page=${adoptVO.page}&viewType=${adoptVO.viewType}" class="btn btn-primary border-right btn-sm" style="float: right">상품등록</a>
    <nav>
        <ul class="pagination justify-content-center">
            <li class="page-item ${currentPage == 1? 'disabled' : '' }">
                <a class="page-link" href="?page=${currentPage-1}&viewType=${adoptVO.viewType}&category=${adoptVO.category}&hitOrder=${adoptVO.hitOrder}">이전</a>
            </li>
            <c:forEach begin="1" end="${totalPage}" var="pageNumber">
                <li class="page-item ${pageNumber == currentPage ? 'active' : '' }" aria-current="page">
                    <a class="page-link" href="?page=${pageNumber}&viewType=${adoptVO.viewType}&category=${adoptVO.category}&hitOrder=${adoptVO.hitOrder}">${pageNumber}</a>
                </li>
            </c:forEach>
            <li class="page-item ${currentPage == totalPage? 'disabled' : '' }">
                <a class="page-link" href="?page=${currentPage+1}&viewType=${adoptVO.viewType}&category=${adoptVO.category}&hitOrder=${adoptVO.hitOrder}">다음</a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>