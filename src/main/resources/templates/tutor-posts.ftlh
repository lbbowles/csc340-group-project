<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${tutor.username}'s Posts</title>
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
    <h2 class="mb-4">${tutor.username}'s Unclaimed Posts (ID: ${tutor.tutorId})</h2>

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

    <br><br>


<div class="container">
    <h2 class="mb-4">${tutor.username}'s Claimed Posts: </h2>
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <#list postings as post>
            <#if post.status == true>
                <div class="col">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${post.title}</h5>
                            <p class="card-text"><strong>Course:</strong> ${post.course}</p>
                            <p class="card-text"><strong>Description:</strong> ${post.postDescription}</p>
                            <p class="card-text"><strong>Rate:</strong> $${post.rate}/hour</p>
                            <p class="card-text"><strong>Student:</strong> ${post.customer.userName}</p>

                            <!-- Message form to student -->
                            <form action="/messages/tutor/send" method="post">
                                <input type="hidden" name="tutorId" value="${tutor.tutorId}"/>
                                <input type="hidden" name="customerId" value="${post.customer.customerId}"/>
                                <input type="hidden" name="postId" value="${post.postId}"/>
                                <div class="mb-2">
                                    <textarea class="form-control" name="content" placeholder="Write your message..." rows="2" required></textarea>
                                </div>
                                <button type="submit" class="btn btn-sm btn-outline-primary">Message Student</button>
                            </form>
                        </div>
                        <div class="card-footer d-flex justify-content-between">
                            <a href="/postings/${post.postId?c}/delete" class="btn btn-sm btn-outline-danger">Delete</a>
                            <a href="/messages/thread/${post.postId?c}" class="btn btn-sm btn-outline-secondary">View Thread</a>
                        </div>
                    </div>
                </div>
            </#if>
        </#list>
    </div>
</div>


    <div class="text-center">
        <a href="/postings/${tutor.tutorId}/create" class="btn btn-secondary btn-lg">Create New Post</a>
    </div>

<br><br><br><br><br>
<footer>
    <p>© 2025 Tutelage. All rights reserved.</p>
</footer>

</body>
</html>
