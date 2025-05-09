<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" type="text/css" href="/style.css">
        <link rel="stylesheet" type="text/css" href="/loggedinstyle.css">
        <title>User Posts Page</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap"
            rel="stylesheet">
    </head>
<body>
    <div class="intro">
        <a href="/"><img src="/images/Tutelage.png" class="logo"></a>
        <div class="button-container" action="/">
            <a href="/" class="button">
                <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" aria-hidden="true" viewBox="0 0 24 24" stroke-width="2" fill="none" stroke="currentColor" class="icon">
                    <path d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" stroke-linejoin="round" stroke-linecap="round"></path>
                </svg>
            </a>
            <a href="/user-profile" class="button">
                <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24" stroke-width="0" fill="currentColor" stroke="currentColor" class="icon">
                    <path d="M12 2.5a5.5 5.5 0 0 1 3.096 10.047 9.005 9.005 0 0 1 5.9 8.181.75.75 0 1 1-1.499.044 7.5 7.5 0 0 0-14.993 0 .75.75 0 0 1-1.5-.045 9.005 9.005 0 0 1 5.9-8.18A5.5 5.5 0 0 1 12 2.5ZM8 8a4 4 0 1 0 8 0 4 4 0 0 0-8 0Z"></path>
                </svg>
            </a>

            <button class="button">
                <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" stroke-linejoin="round" stroke-linecap="round" viewBox="0 0 24 24" stroke-width="2" fill="none" stroke="currentColor" class="icon">
                    <circle r="1" cy="21" cx="9"></circle>
                    <circle r="1" cy="21" cx="20"></circle>
                    <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>
                </svg>
            </button>

            <form action="/logout" method="post" style="display: inline;">
                <button class="Btn" type="submit">
                    <div class="sign">
                        <svg viewBox="0 0 512 512"><path d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z"></path></svg>
                    </div>
                    <div class="text">Logout</div>
                </button>
            </form>

        </div>
    </div>


    <h2>Your Saved Courses</h2>

    <div class="container">
        <#if customerPosts?has_content>
            <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
                <#list customerPosts as post>
                    <div class="col">
                        <div class="card h-100">
                            <div class="card-body">
                                <h3>${post.title}</h3>
                                <p><strong>Course:</strong> ${post.course}</p>
                                <p><strong>Description:</strong> ${post.postDescription}</p>
                                <p><strong>Tutor:</strong> ${post.tutor.username}</p>

                                <form action="/messages/student/send" method="post">
                                    <input type="hidden" name="tutorId" value="${post.tutor.tutorId}"/>
                                    <input type="hidden" name="customerId" value="${post.customer.customerId}"/>
                                    <input type="hidden" name="postId" value="${post.postId}"/>
                                    <div class="mb-2">
                                        <textarea class="form-control" name="content" placeholder="Write your message..." rows="2" required></textarea>
                                    </div>
                                    <button type="submit" class="btn btn-sm btn-outline-primary">Message Tutor</button>
                                </form>
                            </div>
                            <div class="card-footer text-end">
                                <a href="/messages/thread/${post.postId?c}" class="btn btn-sm btn-outline-secondary">View Thread</a>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        <#else>
            <p>You have not joined any courses yet.</p>
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