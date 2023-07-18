<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>/users/loginform2.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <style>

        html,
        body {
            height: 100%;
        }

        body {
            display: flex;
            align-items: center;
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            width: 100%;
            max-width: 330px;
            padding: 15px;
            margin: auto;
        }

        .form-signin .checkbox {
            font-weight: 400;
        }

        .form-signin .form-floating:focus-within {
            z-index: 2;
        }

        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

    </style>
</head>
<body class="text-center">
<main class="form-signin">
    <form action="login.jsp" method="post">
        <img class="mb-4" src="${pageContext.request.contextPath}/images/login/loginLogo.png" alt="" width="72" height="57">
        <h1 class="h3 mb-3 fw-normal">로그인 페이지</h1>

        <div class="form-floating">
            <input type="text" class="form-control" id="id" placeholder="아이디 입력...">
            <label for="id">아이디</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="pwd" placeholder="Password">
            <label for="pwd">비밀번호</label>
        </div>

<%--        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> 아이디 저장
            </label>
        </div>--%>
        <button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
    </form>
</main>
</body>
</html>