document.addEventListener('DOMContentLoaded', function () {
    const alert = document.getElementById('alert');
    const progress = document.getElementById('alertProgress');
    const closeBtn = document.querySelector('.alert-close');

    // Duration in milliseconds
    const duration = 5000;

    // Start the countdown
    const startTime = Date.now();
    const endTime = startTime + duration;

    function updateProgress() {
        const currentTime = Date.now();
        const timeLeft = endTime - currentTime;

        if (timeLeft <= 0) {
            removeAlert();
            return;
        }

        const progressWidth = (timeLeft / duration) * 100;
        progress.style.width = `${progressWidth}%`;

        requestAnimationFrame(updateProgress);
    }

    function removeAlert() {
        alert.style.display = 'none';
    }

    // Close button event
    closeBtn.addEventListener('click', removeAlert);

    // Auto-remove after duration
    setTimeout(removeAlert, duration);

    // Start progress animation
    updateProgress();
});