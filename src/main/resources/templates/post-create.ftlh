<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" type="text/css" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Tutor Page - Create Post</title>
</head>

<body>

<!-- Nav Bar -->
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #000000;">
    <a class="navbar-brand" href="/animals/all" style="margin: 10px;">
        <img src="/images/Tutelage.png" alt="Logo" width="80" height="60">
    </a>
    <ul class="nav justify-content-end">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/posts/all">Home / List View</a>
        </li>
    </ul>
</nav>

<!--Form for creating new post-->
<div class="container mt-4">
    <h2> Create Post</h2>

    <form action="/postings/${tutor.tutorId}/create" method="post">

    <div class="mb-3">
            <label for="title" class="form-label">Title</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="Title" required>
        </div>

        <div class="mb-3">
            <label for="course" class="form-label">Course</label>
            <input type="text" class="form-control" id="course" name="course" placeholder="Course" required>
        </div>

        <div class="mb-3">
            <label for="postDescription" class="form-label">Description</label>
            <input type="text" class="form-control" id="postDescription" name="postDescription" placeholder="Description" required>
        </div>

        <div class="mb-3">
            <label for="rate" class="form-label">Rate per Hour</label>
            <input type="text" class="form-control" id="rate" name="rate" placeholder="Rate" required>
        </div>

        <button type="submit" class="btn btn-primary">Save</button>
        <a href="/postings/tutor/${tutor.tutorId}" class="btn btn-outline-danger">Cancel</a>
    </form>

</div>

</body>
</html>
