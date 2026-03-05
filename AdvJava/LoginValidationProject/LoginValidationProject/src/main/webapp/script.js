/**
 * 
 */
function validateForm() {

    let username = document.getElementById("username").value.trim();
    let password = document.getElementById("password").value.trim();
    let question = document.getElementById("securityQuestion").value;
    let answer = document.getElementById("answer").value.trim();

    if (username === "" || password === "" || question === "" || answer === "") {
        alert("All fields are mandatory!");
        return false;
    }

    if (password.length < 8) {
        alert("Password must be at least 6 characters long!");
        return false;
    }

    alert("Signup Successful!");
    return true;
}
