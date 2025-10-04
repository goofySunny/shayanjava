<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Shayan Admin</title>
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/admin-panel.css">
</head>
<body>
    <%@ include file="common/admin-header.jspf" %>
    <h1>Manage showcase items below</h1>

    <table>
      <thead>
        <tr>
          <th>
            Image
          </th>
          <th>
            Title
          </th>
          <th>
            Full description
          </th>
          <th>
            Active
          </th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${showcaseItems}" var="showcase">
          <tr>
            <td><img src="/image/${showcase.id}" alt="Showcase image"></td>
            <td>${showcase.title}</td>
            <td>${showcase.desc}</td>
            <td>${showcase.active ? "True" : "False"}</td>
          </tr>
        </c:forEach >
      </tbody>
    </table>
    
    <script src="/js/loading.js"></script>
</body>