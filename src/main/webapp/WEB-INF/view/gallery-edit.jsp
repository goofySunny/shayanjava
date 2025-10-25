<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Shayan Admin - Edit</title>
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/admin-panel.css">
</head>
<body>
    <%@ include file="common/admin-header.jspf" %>
    <h1>Add new Gallery item</h1>
    <c:if test="${not empty message}">
        <div class="alert alert-info">
            <c:out value="${message}"/>
        </div>
    </c:if>
    
    <form:form method="POST"
           action="/admin/showcase/edit/${id}"
           modelAttribute="galleryItem">
    
        <!-- Title Field -->
        <div class="form-group">
            <form:label path="title">Title:</form:label>
            <form:input path="title" type="text" class="form-control" />
            <form:errors path="title" cssClass="error" />
        </div>
        
        <!-- Description Field -->
        <div class="form-group">
            <form:label path="desc">Description:</form:label>
            <form:textarea path="desc" class="form-control" rows="3" />
            <form:errors path="desc" cssClass="error" />
        </div>

        <!-- Featured Checkbox -->
        <div class="form-group">
            <div class="form-check">
                <form:checkbox path="active" class="form-check-input" />
                <form:label path="active" class="form-check-label">
                    Activate this item
                </form:label>
            </div>
            <form:errors path="active" cssClass="error" />
        </div>
        
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>

    <script src="/js/loading.js"></script>
</body>