// Function to validate first name
function validateFirstName() {
  let firstname = document.getElementById("firstname").value;
  let regex = /^[A-Za-z]+$/;

  if (firstname === '') {
    document.getElementById("firstname").style.border = "1px solid red";
    document.querySelector(".first-name-div .error").innerHTML = "Please enter your first name";
    return false;
  } else if (!regex.test(firstname)) {
    document.getElementById("firstname").style.border = "1px solid red";
    document.querySelector(".first-name-div .error").innerHTML = "Please enter a valid first name";
    return false;
  } else {
    document.getElementById("firstname").style.border = "1px solid green";
    document.querySelector(".first-name-div .error").innerHTML = "";
    return true;
  }
}

// Function to validate last name
function validateLastName() {
  let lastname = document.getElementById("lastname").value;
  let regex = /^[A-Za-z]+$/;

  if (lastname === '') {
    document.getElementById("lastname").style.border = "1px solid red";
    document.querySelector(".last-name-div .error").innerHTML = "Please enter your last name";
    return false;
  } else if (!regex.test(lastname)) {
    document.getElementById("lastname").style.border = "1px solid red";
    document.querySelector(".last-name-div .error").innerHTML = "Please enter a valid last name";
    return false;
  } else {
    document.getElementById("lastname").style.border = "1px solid green";
    document.querySelector(".last-name-div .error").innerHTML = "";
    return true;
  }
}

// Function to validate email
function validateEmail() {
  let email = document.getElementById("email").value;
  let regex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;

  if (email === '') {
    document.getElementById("email").style.border = "1px solid red";
    document.querySelector(".email-div .error").innerHTML = "Please enter your email";
    return false;
  } else if (!regex.test(email)) {
    document.getElementById("email").style.border = "1px solid red";
    document.querySelector(".email-div .error").innerHTML = "Please enter a valid email";
    return false;
  } else {
    document.getElementById("email").style.border = "1px solid green";
    document.querySelector(".email-div .error").innerHTML = "";
    return true;
  }
}

// Function to validate zip code
function validateZipCode() {
  let zipcode = document.getElementById("zipcode").value;
  let regex = /^[0-9]+$/;

  if (zipcode === '') {
    document.getElementById("zipcode").style.border = "1px solid red";
    document.querySelector(".zip-code-div .error").innerHTML = "Please enter your zip code";
    return false;
  } else if (!regex.test(zipcode)) {
    document.getElementById("zipcode").style.border = "1px solid red";
    document.querySelector(".zip-code-div .error").innerHTML = "Please enter a valid zip code";
    return false;
  } else {
    document.getElementById("zipcode").style.border = "1px solid green";
    document.querySelector(".zip-code-div .error").innerHTML = "";
    return true;
  }
}

// Function to validate username
function validateUsername() {
  let username = document.getElementById("username").value;
  let regex = /^[A-Za-z]+$/;

  if (username === '') {
    document.getElementById("username").style.border = "1px solid red";
    document.querySelector(".username-div .error").innerHTML = "Please enter your username";
    return false;
  } else if (!regex.test(username)) {
    document.getElementById("username").style.border = "1px solid red";
    document.querySelector(".username-div .error").innerHTML = "Please enter a valid username";
    return false;
  } else {
    document.getElementById("username").style.border = "1px solid green";
    document.querySelector(".username-div .error").innerHTML = "";
    return true;
  }
}

// Function to validate password
function validatePassword() {
  let password = document.getElementById("password").value;
  let regex = /^[A-Za-z0-9]+$/;

  if (password === '') {
    document.getElementById("password").style.border = "1px solid red";
    document.querySelector(".password-div .error").innerHTML = "Please enter your password";
    return false;
  } else if (!regex.test(password)) {
    document.getElementById("password").style.border = "1px solid red";
    document.querySelector(".password-div .error").innerHTML = "Please enter a valid password";
    return false;
  } else {
    document.getElementById("password").style.border = "1px solid green";
    document.querySelector(".password-div .error").innerHTML = "";
    return true;
  }
}

// Function to validate confirm password
function validateConfirmPassword() {
  let password = document.getElementById("password").value;
  let confirmpassword = document.getElementById("confirmpassword").value;

  if (confirmpassword === '') {
    document.getElementById("confirmpassword").style.border = "1px solid red";
    document.querySelector(".confirm-password-div .error").innerHTML = "Please enter your confirm password";
    return false;
  } else if (password !== confirmpassword) {
    document.getElementById("confirmpassword").style.border = "1px solid red";
    document.querySelector(".confirm-password-div .error").innerHTML = "Passwords do not match";
    return false;
  } else {
    document.getElementById("confirmpassword").style.border = "1px solid green";
    document.querySelector(".confirm-password-div .error").innerHTML = "";
    return true;
  }
}

// Function to validate music genre
function validateMusicGenre() {
  let checkbox = document.getElementById("checkbox");

  if (!checkbox.checked) {
    document.querySelector(".checkbox-div .error").innerHTML = "Please select at least one music genre";
    return false;
  } else {
    document.querySelector(".checkbox-div .error").innerHTML = "";
    return true;
  }
}

// Function to validate email notifications
function validateEmailNotifications() {
  let radio = document.getElementById("radio");

  if (!radio.checked) {
    document.querySelector(".radiobtn-div .error").innerHTML = "Please select an option";
    return false;
  } else {
    document.querySelector(".radiobtn-div .error").innerHTML = "";
    return true;
  }
}

// Function to validate the form
function validateForm() {
  if (validateFirstName() && validateLastName() && validateEmail() && validateZipCode() && validateUsername() && validatePassword() && validateConfirmPassword() && validateMusicGenre() && validateEmailNotifications()) {
    return true;
  } else {
    return false;
  }
}

// Event listener to the form
document.getElementById('form').addEventListener('submit', event=>{
	const result = validateForm();
	if(result === false){
		event.preventDefault();	
	}
});