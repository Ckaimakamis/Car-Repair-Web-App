<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <title>Car Repair</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/userHomeIndex.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
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
        <div class="column content">
        </div>
        <ul class="nav navbar-nav">
            <li class="LogOut"><a href="/logout">Log Out</a></li>
        </ul>
    </div>
</nav>

<div class="container-fluid text-center" id="worker">
    <div class="row content">
        <table class="table">
            <thead>
            <tr>
                <th>Date Time</th>
                <th>Type</th>
                <th>Operations</th>
                <th>Stage</th>
                <th>Cost</th>
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
            </tr>
            </#list>
            </tbody>
        </table>
        <div class="text-center">
        <#if repairs?size == 0>
            <#if vehicle??>
                <h2>You have no Repairs for your ${vehicle.plateNumber} ${vehicle.model} yet</h2>
            <#else>
                <h2>You have no Vehicle and no Repairs registered yet</h2>
            </#if>
        </#if>
        </div>
    </div>
</div>

<footer class="container-fluid text-center">

    <h3>Welcome to our Car Services</h3>

</footer>

</body>

</html>