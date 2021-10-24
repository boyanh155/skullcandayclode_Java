<%@ page language="java" 
contentType="text/html;charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Login page</title>
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/layout/main.css">
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/member/login.css">
        </head>

        <body>
            <form action="<%=request.getContextPath()%>/member/sign-in/confirm" method="post">
                <input type="hidden" name="action" value="submit">
                <div class="imgcontainer">
                    <img src="${pageContext.request.contextPath}/resource/assets/img/member/login/avt.png" alt="Avatar" class="avatar">
                </div>

                <div class="container">
                    <label for="uname">Username</label>
                    <input id="uname" type="text" placeholder="Enter Username" name="username" required>

                    <label for="psw"><b>Password</b></label>
                    <input id="psw" type="password" placeholder="Enter Password" name="password" required>
                    <p class="announce">
                    <c:out value="${sessionScope.message}" />
                    </p>
                    <button type="submit">Login</button>

                    <!-- Maybe i will do it next time -->
                    <label> 
                        <input type="checkbox" checked="checked" name="remember"> Remember me
                      </label>
                </div>

                <!-- Maybe i will do it next time -->
                <div style="background-color: #F2E1B8;" class="container" style="background-color:#f1f1f1">
                    <button type="button" class="cancelbtn">Cancel</button>
                    <span class="psw">Forgot <a href="#">password?</a></span>
                </div>
            </form>
            <script src="${pageContext.request.contextPath}/resource/assets/js/login.js"></script>
        </body>

        </html>