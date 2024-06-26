<%--
  Created by IntelliJ IDEA.
  User: qinaichen
  Date: 2024/5/31
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #eee;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin .checkbox {
            font-weight: 400;
        }
        .form-signin .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }
        .form-signin .form-control:focus {
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
<body>
<div class="container">
    <form class="form-signin" method="post" action="/login">
        <h2 class="form-signin-heading">请登录</h2>
        <p>
            <label for="username" class="sr-only">用户名</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="用户名" required autofocus>
        </p>
        <p>
            <label for="password" class="sr-only">密码</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="密码" required>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>
</div>
</body>
</html>
