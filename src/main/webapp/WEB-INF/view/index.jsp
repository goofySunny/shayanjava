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
        <div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div>
        <div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div><div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div><div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div><div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div><div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div>
        <div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div>
        <div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div><div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div><div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div>
        <div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div>
        <div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div>
        <div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div>
        <div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div>
        <div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div>
        <div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div>
        <div class="content-item">
          <img src="/images/person.svg" alt="">
          <p>This is a Example</p>
        </div>
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
          <img src="/showcase/images/${showcase.id}" alt="Hero Item">
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
      <div class="gallery-item">
        <img src="/images/photo_2_2025-09-15_14-33-23.jpg" alt="">
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam consectetur venenatis blandit. Praesent
          vehicula, libero non pretium vulputate, lacus arcu facilisis lectus, sed feugiat tellus nulla eu dolor. Nulla
          porta bibendum lectus quis euismod. Aliquam volutpat ultricies porttitor. Cras risus nisi, accumsan vel cursus
          ut, sollicitudin vitae dolor. Fusce scelerisque eleifend lectus in bibendum. Suspendisse lacinia egestas felis
          a volutpat.</p>
      </div>

      <div class="gallery-item">
        <img src="/images/photo_2_2025-09-15_14-33-23.jpg" alt="">
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam consectetur venenatis blandit. Praesent
          vehicula, libero non pretium vulputate, lacus arcu facilisis lectus, sed feugiat tellus nulla eu dolor. Nulla
          porta bibendum lectus quis euismod. Aliquam volutpat ultricies porttitor. Cras risus nisi, accumsan vel cursus
          ut, sollicitudin vitae dolor. Fusce scelerisque eleifend lectus in bibendum. Suspendisse lacinia egestas felis
          a volutpat.</p>
      </div>
      <div class="gallery-item">
        <img src="/images/photo_2_2025-09-15_14-33-23.jpg" alt="">
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam consectetur venenatis blandit. Praesent
          vehicula, libero non pretium vulputate, lacus arcu facilisis lectus, sed feugiat tellus nulla eu dolor. Nulla
          porta bibendum lectus quis euismod. Aliquam volutpat ultricies porttitor. Cras risus nisi, accumsan vel cursus
          ut, sollicitudin vitae dolor. Fusce scelerisque eleifend lectus in bibendum. Suspendisse lacinia egestas felis
          a volutpat.</p>
      </div>
    </div>
  </section>
  <!-- End of Photo Gallery -->

  <%@ include file="common/footer.jspf" %>
  <script src="/js/loading.js"></script>
</body>

</html>