<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Tutors - Tutelage</title>
    <link rel="stylesheet" href="/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>

<!-- Nav Bar -->
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #000000;">
    <a class="navbar-brand" href="/" style="margin: 10px;">
        <img src="/images/Tutelage.png" alt="Logo" width="80" height="60">
    </a>
</nav>

<div class="container mt-4">
    <h2 class="mb-4">All Tutors</h2>

    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <#list tutors as tutor>
            <div class="col">
                <div class="card h-100">
                    <img src="${tutor.photo!'/images/default.png'}" class="card-img-top" alt="Tutor Photo" style="height: 200px; object-fit: cover;">
                    <div class="card-body">
                        <h5 class="card-title">${tutor.username}</h5>
                        <p class="card-text"><strong>Courses:</strong> ${tutor.courses}</p>
                        <p class="card-text"><strong>Contact:</strong> ${tutor.socials}</p>
                        <p class="card-text"><strong>About:</strong> ${tutor.description}</p>
                        <p class="card-text"><strong>Rating:</strong> ${tutor.rating}/5</p>
                    </div>
                    <div class="card-footer text-end">
                        <a href="/tutors/${tutor.tutorId}/view" class="btn btn-primary btn-sm">View Profile</a>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>

<footer>
    <p>© 2025 Tutelage. All rights reserved.</p>
</footer>

<br><br>

</body>
</html>
