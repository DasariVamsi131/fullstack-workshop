let count = 0;
let step = 1;

const countDisplay = document.getElementById("count");
const incBtn = document.getElementById("increment");
const decBtn = document.getElementById("decrement");
const resetBtn = document.getElementById("reset");
const stepButtons = document.querySelectorAll(".steps button");

// Update UI
function updateDisplay() {
  countDisplay.textContent = count;

  if (count > 0) {
    countDisplay.style.color = "green";
  } else if (count < 0) {
    countDisplay.style.color = "red";
  } else {
    countDisplay.style.color = "black";
  }
}

// Increment
incBtn.addEventListener("click", () => {
  count += step;
  updateDisplay();
});

// Decrement (cannot go below 0)
decBtn.addEventListener("click", () => {
  if (count - step >= 0) {
    count -= step;
  }
  updateDisplay();
});

// Reset
resetBtn.addEventListener("click", () => {
  count = 0;
  updateDisplay();
});

// Step selection
stepButtons.forEach(button => {
  button.addEventListener("click", () => {
    step = Number(button.dataset.step);
  });
});

// Initial display
updateDisplay();
