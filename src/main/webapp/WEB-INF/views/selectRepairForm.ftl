<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Car Repair</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/ownerEditForm.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<#--<script type="text/javascript" src="/js/adminHomeIndex.js"></script>-->
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
        </div>
        <ul class="nav navbar-nav">
            <li class="Home"><a href="/admin/home">Home</a></li>
            <li class="LogOut"><a href="/logout">Log Out</a></li>
        </ul>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <#if repairs??>
            <#list repairs as repair>
                <a href="/admin/showRepair/${repair.ID}">${repair.vehicle.plateNumber} at ${repair.dateTime}</a>
            </br>
            </#list>
        </#if>
    </div>
</div>