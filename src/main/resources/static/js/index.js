// const slider = document.querySelector("#slider");
// const leftSlide = document.querySelector("#left");
// const rightSlide = document.querySelector("#right");
// const loader = document.querySelector("#loader");
// const hero = document.querySelector("#hero");


// let heroIndex = 0;

// function slide(direction) {
//     switch (direction) {
//         case "right":
//             slider.scrollLeft += 100;
//             break;
//         case "left":
//             slider.scrollLeft -= 100;
//             break;
//     }
// }


// function scrollHeroItem() {
//     let heroItems = document.querySelectorAll(".hero-item");
//     console.log(heroItems)
//     for (let i = 0; i < heroItems.length; i++) {
//         heroItems[i].classList.remove("active");
//         heroItems[i].classList.remove("deactive");
//     }
//     heroIndex++;
//     if (heroIndex >= heroItems.length) {
//         heroIndex = 0;
//     }
//     if (heroIndex == 0) {
//         heroItems[heroItems.length - 1].classList.add("deactive");
//     } else {
//         heroItems[heroIndex - 1].classList.add("deactive");
//     }
//     heroItems[heroIndex].classList.add("active");
//     console.log(heroItems[heroIndex])
// }

// leftSlide.addEventListener("click", () => {
//     slide("left");
// })

// rightSlide.addEventListener("click", () => {
//     slide("right");
// })

// // On load
// document.addEventListener("DOMContentLoaded", () => {

//     setInterval(() => {
//         scrollHeroItem();
//     }, 5000);
// })



/* Carousel */
(function(){
  const slidesWrap = document.getElementById('slides');
  const slides = slidesWrap.children;
  const dotsContainer = document.getElementById('dots');
  let current=0, total=slides.length, timer=null;

  for(let i=0;i<total;i++){
    const d=document.createElement('div');
    d.className='dot'+(i===0?' active':'');
    d.dataset.index=i;
    d.addEventListener('click',()=>{goTo(i); resetTimer();});
    dotsContainer.appendChild(d);
  }

  function update(){
    slidesWrap.style.transform=`translateX(-${current*100}%)`;
    document.querySelectorAll('.dot').forEach((el,idx)=>{el.classList.toggle('active',idx===current);});
  }
  function goTo(idx){current=(idx+total)%total; update();}
  function next(){goTo((current+1)%total);}
  function resetTimer(){if(timer) clearInterval(timer); timer=setInterval(next,4500);}
  update(); resetTimer();
  const carousel=document.querySelector('.carousel');
  carousel.addEventListener('mouseenter',()=>clearInterval(timer));
  carousel.addEventListener('mouseleave',resetTimer);
})();

/* Products scroll */
// (function(){
//   const wrap=document.getElementById('products');
//   document.getElementById('prevBtn').addEventListener('click',()=>wrap.scrollBy({left:-280, behavior:'smooth'}));
//   document.getElementById('nextBtn').addEventListener('click',()=>wrap.scrollBy({left:280, behavior:'smooth'}));
// })();

function openProject(id){alert('نمایش پروژه: '+id);}
