<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tutelage - Registration Page</title>
    <link rel="stylesheet" href="/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>

<!-- Nav Bar -->
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #000000;">
    <a class="navbar-brand" href="/animals/all" style="margin: 10px;">
        <img src="/images/Tutelage.png" alt="Logo" width="80" height="60">
    </a>
    <ul class="nav justify-content-end">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/tutors">All Tutors</a>
        </li>
    </ul>
</nav>

<!-- Form for creating a new tutor -->
<div class="container mt-4">
    <h2>Update Your Profile!</h2>

    <form action="/tutors/update/${tutor.tutorId}" method="post">

    <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" id="username" name="username"
                   value="${tutor.username}" required>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Password (8 characters)</label>
            <input type="password" class="form-control" id="password" name="password"
                   value="${tutor.password}" maxlength="8" required>
        </div>

        <div class="mb-3">
            <label for="description" class="form-label">About Me</label>
            <textarea class="form-control" id="description" name="description"
                      rows="3" required>${tutor.description}</textarea>
        </div>

        <div class="mb-3">
            <label for="courses" class="form-label">Courses You Are Proficient in</label>
            <input type="text" class="form-control" id="courses" name="courses"
                   value="${tutor.courses}" required>
        </div>

        <div class="mb-3">
            <label for="socials" class="form-label">Contact Methods</label>
            <input type="text" class="form-control" id="socials" name="socials"
                   value="${tutor.socials}" required>
        </div>

        <#--Set this to 5 as the default of course.-->
        <input type="hidden" name="rating" value="5">

        <div class="mb-3">
            <label for="photo" class="form-label">Photo URL</label>
            <input type="text" class="form-control" id="photo" name="photo"
                   value="${tutor.photo}" required>
        </div>

        <button type="submit" class="btn btn-primary">Save</button>
        <a href="/tutors/${tutor.tutorId}" class="btn btn-outline-danger">Cancel</a>
    </form>

</div> <br>

</body>
</html>
