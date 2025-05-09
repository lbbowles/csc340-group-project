<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <title>Login Page</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap"
          rel="stylesheet">
</head>
<body>

<form class="tutor_login" method="POST" action="/login">
    <h1>User Login</h1>
    <label>Username</label>
    <label>
        <input type="text" name="username" placeholder="username" class="username" required>
    </label><br />
    <label>Password</label>
    <label>
        <input type="password" name="password" placeholder="password" class="password" required>
    </label><br />
    <input type="submit" value="Login">
</form>

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