<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Car Repair</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/repairEditForm.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>

<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">

            <div class="navbar-header">
                <p class="navbar-brand"id="repairsId">CAR Repairs<p>
            </div>
            <ul class="nav navbar-nav">
                <li class="#"><a href="#">Home</a></li>
            </ul>

        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <h2>${message!""}</h2>
        <h2 style="color: red">${errorMessage!""}</h2>
    <#if repairs??>
        <form  method="post" action="/admin/editRepair" name="repairEditForm">
            <#list repairs as repair>
            <div class="imgcontainer">
                <img src="img_avatar2.png" alt="Avatar" class="avatar">
            </div>

            <div class="container">
                <label><b>Enter Date</b></label>
                </br>
                <input type="text" id="date" placeholder="date" name="date" value=${repair.dateTime} required>
                </br>
                <label><b>Enter Repair Type</b></label>
                </br>
                <input type="text" id="type" placeholder="repair type" name="type" value=${repair.type} required disabled>
                </br>
                <select id="typeSelect" name="typeSelect">
                    <option value="SMALL">small</option>
                    <option value="BIG">big</option>
                </select>
                </br>
                <label><b>Enter Repair Stage</b></label>
                </br>
                <input type="text" id="stage" placeholder="repair stage" name="stage" value=${repair.stage} required disabled>
                </br>
                <select id="stageSelect" name="stageSelect">
                    <option value="PENDING">pending</option>
                    <option value="IN_PROGRESS">in progress</option>
                    <option value="DONE">done</option>
                </select>
                </br>
                <label><b>Enter Cost</b></label>
                </br>
                <input type="text" id="cost" placeholder="cost" name="cost" value=${repair.cost} required>
                </br>
                <label><b>Enter Operations</b></label>
                </br>
                <input type="text" id="operations" placeholder="operations" name="operations" value=${repair.operations} required>
                </br>
                <label><b>Vehicle</b></label>
                </br>
                <input type="text" id="vehicle" placeholder="vehicle" name="vehicle" value=${repair.vehicle.plateNumber} required>
                </br>
                <button type="submit" class=".btn-primary" OnClick="SetDest1()">Update</button>

                </br>
                <button type="submit" class="cancelbtn" OnClick="SetDest2()">Delete </button>
            </div>
        </#list>
        </form>

    </#if>
    </div>
</div>

</body>
<script language="JavaScript">

    function SetDest1() {
        document.forms["repairEditForm"].action = "/editRepair";
    }
    function SetDest2() {
        document.forms["repairEditForm"].action = "/deleteRepair";
    }

    var typeSelect = document.getElementById("typeSelect");
    var type = $('input[name="type"]');

    var stageSelect = document.getElementById("stageSelect");
    var stage = $('input[name="stage"]');

    typeSelect.addEventListener('click', function() {
        type.attr('value', typeSelect.options[typeSelect.selectedIndex].value);
    })

    stageSelect.addEventListener('click', function() {
        stage.attr('value', stageSelect.options[stageSelect.selectedIndex].value);
    })

</script>
</html>