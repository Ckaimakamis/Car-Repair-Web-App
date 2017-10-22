<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <title>Car Repair</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/adminHomeIndex.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <!-- Bootstrap Date-Picker Plugin -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <#--<script type="text/javascript" src="/js/adminHomeIndex.js"></script>-->
</head>

<body>

<nav class="navbar navbar-inverse">

    <div class="container-fluid">

        <div class="navbar-header">

            <p class="navbar-brand"id="repairsId">CAR Repairs<p>

        </div>

        <ul class="nav navbar-nav">

            <li class="Owners"><a href="/admin/home">Owners</a></li>

            <li class="Vehicles"><a href="/admin/vehicles">Vehicles</a></li>

            <li class="Repairs"><a href="/admin/repairs">Repairs</a></li>

            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Create Owner</b> <span class="caret"></span></a>
                <ul id="login-dp" class="dropdown-menu">
                    <li>
                        <div class="row">
                            <div class="col-md-12">
                                <form class="form" role="form" method="post" action="/registerUser" accept-charset="UTF-8" id="login-nav" name="user">

                                    <div class="form-group">
                                        <label class="sr-only" for="registerEmail">Username</label>
                                        <input type="text" class="form-control" id="registerEmail" placeholder="Enter Email" name="email" required>
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="registerLastName">Surname</label>
                                        <input type="text" class="form-control" id="registerLastName" placeholder="Enter First Name"name="firstName" required>
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="registerLastName">AFM</label>
                                        <input type="text" class="form-control" id="registerLastName" placeholder="Enter Last Name" name="lastName"required>
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="registerLastName">Password</label>
                                        <input type="text" class="form-control" id="registerLastName" placeholder="Enter Password" name="password"required>
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="registerRole">Brand</label>
                                        <input type="text" class="form-control" id="registerRole" placeholder="Select Role" name="role" value="USER" required disabled>

                                        <div class="sub-form-group">
                                            <select id="roleSelect" name="roleSelect">
                                                <option value="ADMIN">Admin</option>
                                                <option value="USER">User</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="registerVAT">Brand</label>
                                        <input type="text" class="form-control" id="registerVAT" placeholder="Enter vat"name="vat" required>
                                    </div>

                                    <div class="form-group">
                                        <button type="submit" OnClick="changeDisable()" class="btn btn-primary btn-block">Register User</button>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </li>
                </ul>
            </li>

            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Search</b> <span class="caret"></span></a>
                <ul id="login-dp" class="dropdown-menu">
                    <li>
                        <div class="row">
                            <div class="col-md-12">

                                <form class="form" role="form" method="post" action="/searchOwner" accept-charset="UTF-8" id="login-nav" name = "searchForm">
                                    <div class="form-group">
                                        <label class="sr-only" for="email">Email</label>
                                        <input type="text" class="form-control" id="searchEmail" placeholder="Enter Email or VAT"name="email" required>
                                    </div>

                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary btn-block">Search</button>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </li>
                </ul>
            </li>

            <li class="LogOut"><a href="/logout">Log Out</a></li>
        </ul>
    </div>
</nav>


<div class="container-fluid text-center">
    <div class="row content">
        <h2>${message!""}</h2>
        <h2 style="color: red">${errorMessage!""}</h2>
    </div>
</div>



<footer class="container-fluid text-center">

    <h3>Welcome to our Car Services</h3>

</footer>

</body>

<#--<script language="JavaScript">-->

    <#--var roleSelect = document.getElementById("roleSelect");-->
    <#--var role = $('input[name="role"]');-->

    <#--roleSelect.addEventListener('click', function() {-->
        <#--role.attr('value', roleSelect.options[roleSelect.selectedIndex].value);-->
    <#--})-->

    <#--function changeDisable() {-->
        <#--role.attr('disabled', false);-->
    <#--}-->

<#--</script>-->

</html>