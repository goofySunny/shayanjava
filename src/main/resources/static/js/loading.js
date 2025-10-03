
document.addEventListener("DOMContentLoaded", () => {
    setTimeout(() => {
        loader.classList.remove("loading")
        loader.classList.add("loaded")
    }, 2000);

    setInterval(() => {
        scrollHeroItem();
    }, 5000);
})