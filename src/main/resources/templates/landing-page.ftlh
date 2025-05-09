<html>

<head>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <title>Home Page</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap"
        rel="stylesheet">
</head>

<body>
    <div class="intro">
        <a href="/"><img src="/images/logo_2.png" class="logo"></a>
        <div class="log_or_reg">
           <a href ="/login"> <button class="login_button">Login</button></a>
            <a href="/register"><button class="register_button">Register
                </button></a>

        </div>
    </div>

        <form method="GET" action="/postings/search" class="container_search">
            <h1>What are you looking for?</h1>
            <label>
                <input placeholder="Search..." class="main_searchbar" name="course" type="search">
            </label>
            <button class="search_button" type="submit">
                <img src="/images/search_glass.svg" alt="seach glass image"> Search
            </button>
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