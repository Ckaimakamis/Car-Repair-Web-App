<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Car Repair</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/vehicleIndex.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
    <!-- Bootstrap Date-Picker Plugin -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
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
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Create Vehicle</b> <span class="caret"></span></a>
                <ul id="login-dp" class="dropdown-menu">
                    <li>
                        <div class="row">
                            <div class="col-md-12">
                                <form class="form" role="form" method="post" action="/admin/vehicleRegister" accept-charset="UTF-8" id="login-nav" name="vehicleRegisterForm">

                                    <div class="form-group">
                                        <label class="sr-only" for="registerPlate">Service id</label>
                                        <input type="text" class="form-control" id="registerEmail" placeholder="Enter Plate" name="plateNumber" required>
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="registerModel">Surname</label>
                                        <input type="text" class="form-control" id="registerLastName" placeholder="Enter Model"name="model" required>
                                    </div>

                                    <div class="form-group">
                                            <label class="sr-only" for="registerYear">Cost</label>
                                            <input type="text" class="form-control" id="registerYear" placeholder="Enter Year"name="year" required>
                                    </div>

                                    <div class="form-group">
                                            <label class="sr-only" for="registerColor">Works</label>
                                            <input type="text" class="form-control" id="registerColor" placeholder="Enter Color"name="color" required>
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="registerVAT">Works</label>
                                        <input type="text" class="form-control" id="registerVAT" placeholder="Enter owner's VAT"name="vat" required>
                                    </div>

                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary btn-block">Register Vehicle</button>
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


                                <form class="form" role="form" method="post" action="/admin/searchVehicle" accept-charset="UTF-8" id="login-nav" name = "vehicleSearchForm">

                                    <div class="form-group">
                                        <label class="sr-only" for="plate">Vat</label>
                                        <input type="text" class="form-control" id="plateNumber" name="plateNumber" placeholder="Enter Plate"/>
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="vat">Brand</label>
                                        <input type="text" class="form-control" id="vat" name="vat" placeholder="Enter VAT"/>
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


<div class="container-fluid text-center" id="worker">
    <div class="row content">
        <h2>${message!""}</h2>
        <h2 style="color: red">${errorMessage!""}</h2>


    </div>
</div>

<footer class="container-fluid text-center">

    <h3>Welcome to our Car Services</h3>

</footer>

</body>

</html>