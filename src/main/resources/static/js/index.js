const slider = document.querySelector("#slider");
const leftSlide = document.querySelector("#left");
const rightSlide = document.querySelector("#right");
const loader = document.querySelector("#loader");
const hero = document.querySelector("#hero");

let heroIndex = 0;

function slide(direction) {
    switch (direction) {
        case "right":
            slider.scrollLeft += 100;
            break;
        case "left":
            slider.scrollLeft -= 100;
            break;
    }
}


function scrollHeroItem() {
    let heroItems = document.querySelectorAll(".hero-item");
    for (let i = 0; i < heroItems.length; i++) {
        heroItems[i].classList.remove("active");
        heroItems[i].classList.remove("deactive");
    }
    heroIndex++;
    if (heroIndex >= heroItems.length) {
        heroIndex = 0;
    }
    if (heroIndex == 0) {
        heroItems[heroItems.length - 1].classList.add("deactive");
    } else {
        heroItems[heroIndex - 1].classList.add("deactive");
    }
    heroItems[heroIndex].classList.add("active");
    console.log(heroItems[heroIndex])
}

leftSlide.addEventListener("click", () => {
    slide("left");
})

rightSlide.addEventListener("click", () => {
    slide("right");
})

// On load
document.addEventListener("DOMContentLoaded", () => {
    setTimeout(() => {
        loader.classList.remove("loading")
        loader.classList.add("loaded")
    }, 2000);

    setInterval(() => {
        scrollHeroItem();
    }, 5000);
})