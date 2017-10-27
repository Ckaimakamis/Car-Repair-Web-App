<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Car Repair</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container-fluid text-center" id="login">
        <form action="/login" method="post" id="loginForm" name="loginForm">
            <div class="imgcontainer">
                <img src="/images/thetida.png" alt="Avatar" class="avatar">
            </div>
            <h2 style="color: red">${errorMessage!""}</h2>

            <div class="container">
                <label><b>Enter Username</b></label>
                <input type="text" placeholder="Email" name="email" required>
                <br/>
                <label><b>Enter Password</b></label>
                <input type="text" placeholder="Password" name="password" required>
                <br/>

                <button type="submit">Login</button>

            </div>
        </form>


</div>
<footer class="container-fluid text-center"></footer>

</body>
</html>