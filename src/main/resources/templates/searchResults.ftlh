<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <title>Search Page</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap"
        rel="stylesheet">
</head>
<body>
    <div class="intro">
        <a href="/"><img src="/images/logo_2.png" class="logo"></a>
        <div class="log_or_reg">
            <a href="/students/login"><button class="login_button">Login</button></a>
            <a href="/students/register-user"><button class="register_button">Register</button></a>
        </div>
    </div>

    <div class="result_and_search">
        <div>
            <h3>Results for "${query!}"</h3>
        </div>
        <div>
            <form method="GET" action="/students/search-courses">
                <input name="query" placeholder="Search..." class="search_res" type="search">
            </form>
        </div>
    </div>

    <div class="container_grid">
        <#if matchedCourses?? && (matchedCourses?size > 0)>
            <#list matchedCourses as course>
                <div class="course-result">
                    <img src ="/images/person-fill.svg">
                    <a href="/tutelagedata/courses/${course.courseId}">
                        <h2>${course.courseName}</h2>
                        <p>Instructor: ${course.courseInstructor}</p>
                    </a>
                </div>
            </#list>
        <#else>
            <p>No courses found for "${query!}"</p>
        </#if>
    </div>

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