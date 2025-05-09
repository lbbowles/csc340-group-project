<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Tutelage</title>

    <link rel="stylesheet" href="/style.css">

    <#--    Pure CSS-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css"
          integrity="sha384-X38yfunGUhNzHpBaEBsWLO+A0HDYOQi8ufWDkZ0k9e0eXz/tH3II7uKZ9msv++Ls" crossorigin="anonymous">
</head>

<body>

<header>
    <div class="pure-menu pure-menu-horizontal">
        <ul class="pure-menu-list">
            <li class="pure-menu-item pure-menu-has-children pure-menu-allow-hover">
                <a href="#" id="menuLink1" class="pure-menu-link">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Hamburger_icon.svg/640px-Hamburger_icon.svg.png" alt="Menu" width="25" height="25">
                </a>
                <ul class="pure-menu-children">
                    <li class="pure-menu-item"><a href="/" class="pure-menu-link">Home</a></li>
                    <li class="pure-menu-item"><a href="/tutors/all" class="pure-menu-link">All Tutors</a></li>
                    <li class="pure-menu-item"><a href="/postings/all" class="pure-menu-link">All Posts</a></li>
                </ul>
            </li>
        </ul>
    </div>

    <div>
        <a class="navbar-brand" href="/" style="margin: 10px;">
            <img src="/images/Tutelage.png" alt="Logo" width="80" height="60">
        </a>
    </div>
</header>

<main>

    <br>
    <h2>${tutor.username} Tutor Information</h2>

    <div class="content-container">

        <!-- Profile Picture Box -->
        <div class="pfp">
            <img
                    alt="profile"
                    src="${tutor.photo?default('https://www.google.com/url?sa=i&url=https%3A%2F%2Ftwirpz.wordpress.com%2F2015%2F06%2F01%2Fegg-timer-the-history-of-twitters-default-profile-pic%2F&psig=AOvVaw0X8-mB1xJBzipKpWTatqQ3&ust=1745550541888000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCJDTudHY74wDFQAAAAAdAAAAABAE')}"
                    width="600"
                    height="400"
                    style="border: 2px solid black;">
        </div>

        <!-- User Info Box -->
        <div class="user-box">
            <br><br>
            <p>Username: <u>${tutor.username}</u></p>
            <p>Classes: <u>${tutor.courses}</u></p>
            <p>Contact Methods: <u>${tutor.socials}</u></p>
            <p>About Me: <u>${tutor.description}</u></p>

            <br>
            <p>Current Posts:</p>
            <button class="pure-button" onclick="location.href='/postings/tutor/${tutor.tutorId}'">View</button>

            <br><br>

        </div>
    </div>


    Reviews go here?:

    <br><br>

    <div class="container mt-4">
        <h2 class="mb-4">${tutor.username}'s Posts (ID: ${tutor.tutorId})</h2>

        <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
            <#list posting as post>
                <#if post.ratingScore == false>
                    <div class="col">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">${post.title}</h5>
                                <p class="card-text"><strong>Course:</strong> ${post.reviewn}</p>
                                <p class="card-text"><strong>Description:</strong> ${post.postDescription}</p>
                                <p class="card-text"><strong>Rate:</strong> $${post.rate}/hour</p>
                            </div>
                            <div class="card-footer d-flex justify-content-between">
                                <a href="/postings/${tutor.tutorId?c}/${post.postId}/update" class="btn btn-sm btn-outline-primary">Update</a>
                                <a href="/postings/${post.postId?c}/delete" class="btn btn-sm btn-outline-danger">Delete</a>
                            </div>
                        </div>
                    </div>
                </#if>
            </#list>
        </div>
    </div>


</main>

<footer>
    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/X_logo_2023_%28white%29.png/480px-X_logo_2023_%28white%29.png" alt="X" width="25" height="20">
    <img src="https://img.icons8.com/win10/512/FFFFFF/instagram-new.png" alt="Instagram" width="35" height="21">
    <img src="https://cdn.prod.website-files.com/6257adef93867e50d84d30e2/636e0a6cc3c481a15a141738_icon_clyde_white_RGB.png" alt="Discord" width="25" height="20">
    <img src="https://img.icons8.com/m_sharp/512/FFFFFF/facebook-new.png" alt="Facebook" width="25" height="20">
</footer>

</body>
</html>
