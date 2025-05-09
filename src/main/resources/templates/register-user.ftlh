<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel ="stylesheet" type="text/css" href="/style.css">
    <title>Registration Page</title>
</head>

<body>
<div class = "intro">
    <a href ="landingPage.ftlh"><img src = "/images/logo_2.png" class="logo"></a>
</div>
<hr/>
<form class="register_student" method="POST" action="/students/new/customer">
    <h1>Student Registration</h1>
    <label for ="username">Username</label>
    <label>
        <input type="text" name="username" placeholder="username" class="username" required>
    </label><br />
    <label for="firstName">First Name</label>
    <label>
        <input type="text" name="firstName" placeholder="First Name" class="firstName" required>
    </label><br />
    <label for="lastName">Last Name</label>
    <label>
        <input type="text" name="lastName" placeholder="Last Name" class="lastName" required>
    </label><br />
    <label for="email">Email</label>
    <label>
        <input type="email" name="email" placeholder="Email" class="email" required>
    </label><br />
    <label for = "password">Password</label>
    <label>
        <input type="password" name="password" placeholder="password" class="password" required>
    </label><br />
    <div class="mb-3">
        <label for="photo" class="form-label">Photo URL</label>
        <input type="text" class="form-control" id="photo" name="photo" placeholder="Link to profile picture">
    </div>
    <input type="submit" placeholder="submit">
</form>
<hr/>

<footer class="the_footer">
    <div>
        <h2>About us</h2>
        <p>This is a website demonstration</p>
    </div>
    <div>
        <h2>Contact Us</h2>
        <p>336-0000-0000</p>
    </div>
</footer>
</body>
</html>