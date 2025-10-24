<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Shayan Box</title>
  <link rel="stylesheet" href="/css/style.css">
  <script type="module" src="/js/index.js"></script>
</head>

<body class="light">
<%@ include file="common/header.jspf" %>

  <!-- Content slide -->
  <div class="content-parent">
    <div class="content-slider" id="slider">
      <div class="content">
        <c:forEach items="${providedServiceItems}" var="service">
          <div class="content-item">
            <img src="/service/images/${service.id}" alt="Service Image">
            <p>
              ${service.title}
            </p>
          </div>
        </c:forEach>
      </div>
    </div>

    <div class="content-controls">
      <button id="left">
        <img src="/images/arrow-left.svg" alt="">
      </button>
      <button id="right">
        <img src="/images/arrow-left.svg" alt="">
      </button>
    </div>
  </div>
  <!-- End of Content slide -->
   
  <!-- Hero Section -->
  <section id="hero" class="hero">
    <c:forEach items="${showcaseItems}" var="showcase">
      <div class="hero-item active">
        <div class="image">
          <a href="/showcase/${showcase.id}">
            <img src="/showcase/images/${showcase.id}" alt="Hero Item">
          </a>
        </div>
        <div>
          <p>
            ${showcase.desc}
          </p>
        </div>
      </div>
    </c:forEach>
  </section>
  <!-- End of Hero Section -->

  <!-- Photo Gallery -->
  <section class="photo-gallery">
    <div class="gallery-title">
      <h3>عنوان مثال</h3>
      <a href="">بیشتر ></a>
    </div>
    <div class="gallery-slider">
      <c:forEach items="${galleryItems}" var="gallery">
        <div class="gallery-item">
          <img src="/gallery/images/${gallery.id}" alt="Gallery Image">
          <p>
            ${gallery.desc}
          </p>
        </div>
      </c:forEach>
    </div>
  </section>
  <!-- End of Photo Gallery -->

  <%@ include file="common/footer.jspf" %>
  <script src="/js/loading.js"></script>
</body>

</html>