/* Carousel */
(function () {
  const slidesContainer = document.getElementById('slides');
  const slides = slidesContainer.children;

  const dotsContainer = document.getElementById('dots');
  const carousel = document.querySelector('.carousel');

  let currentIndex = 0;
  let timer = null;
  const totalSlides = slides.length;

  // Create navigation dots
  for (let i = 0; i < totalSlides; i++) {
    const dot = document.createElement('div');
    dot.className = 'dot' + (i === 0 ? ' active' : '');
    dot.dataset.index = i;

    dot.addEventListener('click', () => {
      goToSlide(i);
      resetTimer();
    });

    dotsContainer.appendChild(dot);
  }

  function updateCarousel() {
    // Move slides
    slidesContainer.style.transform = `translateX(-${currentIndex * 100}%)`;

    // Update dot states
    document
      .querySelectorAll('.dot')
      .forEach((dot, i) => dot.classList.toggle('active', i === currentIndex));
  }

  function goToSlide(index) {
    currentIndex = (index + totalSlides) % totalSlides;
    updateCarousel();
  }

  function nextSlide() {
    goToSlide(currentIndex + 1);
  }

  function resetTimer() {
    if (timer) clearInterval(timer);
    timer = setInterval(nextSlide, 4500);
  }

  // Initialize carousel
  updateCarousel();
  resetTimer();

  // Pause rotation on hover
  carousel.addEventListener('mouseenter', () => clearInterval(timer));
  carousel.addEventListener('mouseleave', resetTimer);
})();

// Make products scroll automatically
(function () {
  const productContainer = document.querySelector('.products');

  let scrollAmount = 0;
  const scrollStep = 1; // pixels to scroll each interval
  const scrollInterval = 20; // interval in milliseconds

  function autoScroll() {
    scrollAmount += scrollStep;
    if (scrollAmount >= productContainer.scrollWidth - productContainer.clientWidth) {
      scrollAmount = 0; // Reset to start
    }
    productContainer.scrollTo({
      left: scrollAmount,
      behavior: 'smooth'
    });
  }

  let scrollTimer = setInterval(autoScroll, scrollInterval);

  // Pause scrolling on hover
  productContainer.addEventListener('mouseenter', () => clearInterval(scrollTimer));
  productContainer.addEventListener('mouseleave', () => {
    scrollTimer = setInterval(autoScroll, scrollInterval);
  });
})();