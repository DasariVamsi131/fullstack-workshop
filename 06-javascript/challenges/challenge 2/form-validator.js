const username = document.getElementById("username");
const email = document.getElementById("email");
const password = document.getElementById("password");
const confirmPassword = document.getElementById("confirmPassword");
const submitBtn = document.getElementById("submitBtn");

const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{8,}$/;

// Helper functions
function showError(input, message) {
  const error = input.parentElement.querySelector(".error");
  const check = input.parentElement.querySelector(".check");

  error.textContent = message;
  input.classList.remove("success");
  check.style.display = "none";
}

function showSuccess(input) {
  const error = input.parentElement.querySelector(".error");
  const check = input.parentElement.querySelector(".check");

  error.textContent = "";
  input.classList.add("success");
  check.style.display = "inline";
}

// Validators
function validateUsername() {
  const value = username.value.trim();
  if (!/^[a-zA-Z0-9]{3,15}$/.test(value)) {
    showError(username, "3–15 characters, letters & numbers only");
    return false;
  }
  showSuccess(username);
  return true;
}

function validateEmail() {
  if (!emailRegex.test(email.value.trim())) {
    showError(email, "Invalid email format");
    return false;
  }
  showSuccess(email);
  return true;
}

function validatePassword() {
  if (!passwordRegex.test(password.value)) {
    showError(password, "8+ chars, 1 uppercase, 1 number, 1 special char");
    return false;
  }
  showSuccess(password);
  return true;
}

function validateConfirmPassword() {
  if (confirmPassword.value !== password.value || confirmPassword.value === "") {
    showError(confirmPassword, "Passwords do not match");
    return false;
  }
  showSuccess(confirmPassword);
  return true;
}

// Enable / disable submit button
function checkFormValidity() {
  const isValid =
    validateUsername() &&
    validateEmail() &&
    validatePassword() &&
    validateConfirmPassword();

  submitBtn.disabled = !isValid;
  submitBtn.classList.toggle("enabled", isValid);
}

// Blur events
username.addEventListener("blur", () => {
  validateUsername();
  checkFormValidity();
});

email.addEventListener("blur", () => {
  validateEmail();
  checkFormValidity();
});

password.addEventListener("blur", () => {
  validatePassword();
  checkFormValidity();
});

confirmPassword.addEventListener("blur", () => {
  validateConfirmPassword();
  checkFormValidity();
});

// Prevent invalid submission
document.getElementById("registerForm").addEventListener("submit", e => {
  checkFormValidity();
  if (submitBtn.disabled) {
    e.preventDefault();
  }
});
