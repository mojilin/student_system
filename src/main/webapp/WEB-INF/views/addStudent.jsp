<%--
  Created by IntelliJ IDEA.
  User: laolintou
  Date: 2019-04-21
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>
<head>
    <title>新增学生信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    学生信息系统
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增学生信息</small>
                </h1>
            </div>
        </div>
    </div>
    <form  action="/student/addStudent" method="post" name="userForm" onsubmit="return formCheck(this)">
        学号：<input type="text" id="studentId" name="studentId"><br><br><br>
        姓名：<input type="text" id="name" name="name"><br><br><br>
        性别：<input type="radio" name="gender" value="男" checked>男
             <input type="radio" name="gender" value="女">女<br><br><br>
        年龄：<input type="text" id="age" name="age">
        <c:forEach var="error" items="${errors}">
            <small>${error.value}</small><br>
        </c:forEach>
        <br><br><br>
        生日：<input type="date" id="birthday" name="birthday"><br><br><br>
        <input type="submit" value="添加">
    </form>

    <script type="text/javascript">
        function formCheck(f) {
            var id = f.studentId.value;
            var name = f.name.value;
            var age = f.age.value;
            if (id == "" || name == "" || age == ""){
                alert("学号、姓名、年龄不能为空");
                return false;
            }
            if (!(/^\d{8}$/.test(id))){
                alert("学号必须为8位数字");
                f.studentId.focus();
                return false;
            }
            return true;
        }
    </script>
</div>
</body>
</html>