<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Current Posts</title>
    <link rel="stylesheet" href="/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #000000;">
    <a class="navbar-brand" href="/" style="margin: 10px;">
        <img src="/images/Tutelage.png" alt="Logo" width="80" height="60">
    </a>
</nav>


<div class="container mt-4">
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <#list postings as post>
            <#if post.status == false>
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${post.title}</h5>
                        <p class="card-text"><strong>Course:</strong> ${post.course}</p>
                        <p class="card-text"><strong>Description:</strong> ${post.postDescription}</p>
                        <p class="card-text"><strong>Rate:</strong> $${post.rate}/hour</p>
                        <p class="card-text"><strong>Tutor:</strong> ${post.tutor.username}</p>
                        <div style="display: flex; gap: 10px; align-items: center;">
                            <a href="/tutors/${post.tutor.tutorId?c}" class="btn btn-sm btn-outline-danger">View Tutor</a>
                            <form action="/students/savePosting" method="post">
                                <input type="hidden" name="postId" value="${post.postId}" />
                                <button type="submit" class="button">
                                    <span class="button__text">Add Item</span>
                                    <span class="button__icon">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none"
                                             stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                                             class="svg" viewBox="0 0 24 24">
                                            <line x1="12" y1="5" x2="12" y2="19"></line>
                                            <line x1="5" y1="12" x2="19" y2="12"></line>
                                        </svg>
                                    </span>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            </#if>
        </#list>
    </div>
</div>

<br><br>

</body>
</html>
