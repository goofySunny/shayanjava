<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${showcase.title}</title>
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/admin-panel.css">
</head>
<body>
    <%@ include file="common/header.jspf" %>
    <div class="main-container">
        <img src="/showcase/images/${showcase.id}" alt="واقعه غیر منتظر اتفاق افتاد...">
        <div>
          <h6>${showcase.title}</h6>
          <hr>
          <p>${showcase.desc}</p>
        </div>
    </div>
    <script src="/js/loading.js"></script>
</body>