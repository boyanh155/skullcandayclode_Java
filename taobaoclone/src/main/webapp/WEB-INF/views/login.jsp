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
            <form action="<%=request.getContextPath()%>/sign-in/confirm" method="post">
                <div class="imgcontainer">
                    <img src="https://lh3.googleusercontent.com/proxy/TkyCKvBiO_7Ng_l_LWVX2rGZ-Tb_CF0chlx6lA9JqRGwY-U9lLjTPDIVG7Mu2Ko14o7w8BYJBfs147PxpiXFDtG4M6AaiEiQGlpEhnt1gZFAye_o8oe5Gg-aSt139kxmHo4_h3UDVA" alt="Avatar" class="avatar">
                </div>

                <div class="container">
                    <label for="uname">Username</label>
                    <input id="uname" type="text" placeholder="Enter Username" name="username" required>

                    <label for="psw"><b>Password</b></label>
                    <input id="psw" type="password" placeholder="Enter Password" name="password" required>

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
        </body>

        </html>