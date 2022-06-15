function handleSubmit(e) {
    let firstname = document.getElementById("firstname").value;
    let lastname = document.getElementById("lastname").value;

    if (firstname.length < 3) {
        alert("Error: First name must be 3 or more characters.");
        return;
    }

    if (lastname.length < 2) {
        alert("Error: Last name must be 2 or more characters.");
        return;
    }

    if (!document.querySelector('input[name="gender"]:checked')) {
        alert("Error: Must select gender.");
        return;
    }

    let pwd = document.getElementById("pwd").value;
    let pwd2 = document.getElementById("pwd2").value;

    if (pwd !== pwd2) {
        alert("Error: Password must match.");
        return;
    }

    if (!document.querySelector('input[name="skills"]:checked')) {
        alert("Error: Must select skills.");
        return;
    }
}