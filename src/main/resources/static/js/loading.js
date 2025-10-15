
document.addEventListener("DOMContentLoaded", () => {
    setTimeout(() => {
        loader.classList.remove("loading")
        loader.classList.add("loaded")
    }, 100);
})