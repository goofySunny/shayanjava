<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login - Shayan</title>
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/admin-panel.css">
  <style>
    form {
        width: 50%;
        margin: auto;

        div {
            display: flex;
            flex-direction: row;
        }

        button, a {
            all: unset;
            cursor: pointer;
            text-align: center;
            padding: 0.5rem;
            border-radius: 15px;
            background-color: blue;
            color: white;
            width: 50%;
        }

        button:hover, a:hover {
            background-color: aqua;
        }
    }
  </style>
</head>
<body>
    <%@ include file="common/admin-header.jspf" %>

    <div>
        <form action="/login" method="post">
            <label for="username">Username: </label>
            <input type="text" name="username" id="username">
            <label for="password">Password: </label>
            <input type="text" name="password" id="password">
            <div>
                <a href="/">Cancel</a>
                <button type="submit">Login</button>
            </div>
        </form>    
    </div>

    <%@ include file="common/footer.jspf" %>
    <script src="/js/loading.js"></script>
</body>