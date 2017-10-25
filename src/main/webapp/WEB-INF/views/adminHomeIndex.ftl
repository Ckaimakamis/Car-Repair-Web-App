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
                                <form class="form" role="form" method="post" action="/admin/registerOwner" accept-charset="UTF-8" id="login-nav" name="user">

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
                                        <input type="text" class="form-control" id="registerRole" placeholder="Select Role" name="role" value="ADMIN" required>

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

                                <form class="form" role="form" method="post" action="/admin/searchOwner" accept-charset="UTF-8" id="login-nav" name = "searchForm">
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
            <div class="navbar-brand right-container">

            <li class="LogOut" id="logout"><a href="/logout">Log Out</a></li> </div>
        </ul>
    </div>
</nav>


<div class="container-fluid text-center">
    <div class="row content">
        <table class="table">
            <thead>
            <tr>
                <th>Date Time</th>
                <th>Type</th>
                <th>Operations</th>
                <th>Stage</th>
                <th>Cost</th>
                <th>Plate</th>
                <th>Vehicle</th>
                <th>Owner</th>
            </tr>
            </thead>
            <tbody align="left">
            <#list repairs as newRepair>
            <tr>
                <td>${newRepair.dateTime}</td>
                <td>${newRepair.type}</td>
                <td>${newRepair.operations}</td>
                <td>${newRepair.stage}</td>
                <td>${newRepair.cost} $</td>
                <td>${newRepair.vehicle.plateNumber}</td>
                <td>${newRepair.vehicle.model} ${newRepair.vehicle.year}</td>
                <td>${newRepair.vehicle.owner.firstName} ${newRepair.vehicle.owner.lastName}</td>
            </tr>
            </#list>
            </tbody>
        </table>
        <h2 style="color: limegreen">${message!""}</h2>
        <h2 style="color: red">${errorMessage!""}</h2>
    </div>
</div>



<footer class="container-fluid text-center">

    <h3>Welcome to our Car Services</h3>

</footer>

</body>

<script language="JavaScript">

    $('#registerRole').hide();
    var roleSelect = document.getElementById("roleSelect");
    var role = $('input[name="role"]');

    roleSelect.addEventListener('click', function() {
        role.attr('value', roleSelect.options[roleSelect.selectedIndex].value);
    })

    function changeDisable() {
        role.attr('disabled', false);
    }

</script>

</html>