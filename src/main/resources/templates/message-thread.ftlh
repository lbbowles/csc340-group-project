<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Message Thread </title>
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
    <#if thread?size == 0>
        <p>No messages yet, say something legendary.</p>
    <#else>
        <#list thread as message>
            <div class="card mb-2 p-3">
                <strong>From:
                    <#if message.tutorSender??>
                        ${message.tutorSender.username}
                    <#elseif message.customerSender??>
                        ${message.customerSender.userName}
                    </#if>
                </strong>
                <p>${message.content}</p>
                <small><em>Sent at: ${message.timestamp}</em></small>
            </div>
        </#list>
    </#if>

</div>

<br><br>

<div class="container mt-4">
<a href="/" class="btn btn-sm btn-outline-secondary">Back to Home</a>
    </div>

    <br><br>

<footer>
    <p>© 2025 Tutelage. All rights reserved.</p>
</footer>


</body>
</html>

