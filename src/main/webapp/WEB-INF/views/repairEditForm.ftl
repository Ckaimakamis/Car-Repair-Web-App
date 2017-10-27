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
                <li class="Home"><a href="/admin/home">Home</a></li>
                <li class="LogOut"><a href="/logout">Log Out</a></li>
            </ul>

        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <h2 style="color: limegreen">${message!""}</h2>
        <h2 style="color: red">${errorMessage!""}</h2>
    <#if repair??>
        <form  method="post" action="/admin/editRepair" name="repairEditForm">
            <div class="imgcontainer">
            </div>

            <div class="container">
                <input class="ID" type="text" id="ID" name="ID" value=${repair.ID}/>
                <label><b>Enter Date</b></label>
                </br>
                <input type="datetime-local" id="dateTime" placeholder="dateTime" name="dateTime" value=${repair.dateTime} required/>
                </br>
                </br>
                <label><b>Enter Repair Type</b></label>
                </br>
                <input type="text" id="repairType" placeholder="repair type" name="repairType" value=${repair.type} required readonly="readonly"/>
                </br>
                <select id="typeSelect" name="typeSelect">
                    <option value="SMALL">small</option>
                    <option value="BIG">big</option>
                </select>
                </br>
                <label><b>Enter Repair Stage</b></label>
                </br>
                <input class="ID" type="text" id="repairStage" placeholder="repair stage" name="repairStage" value=${repair.stage} required readonly="readonly"/>
                </br>
                <select id="stageSelect" name="stageSelect">
                    <option value="PENDING">pending</option>
                    <option value="IN_PROGRESS">in progress</option>
                    <option value="DONE">done</option>
                </select>
                </br>
                <label><b>Enter Cost</b></label>
                </br>
                <input type="text" id="cost" placeholder="cost" name="cost" value=${repair.cost} required readonly="readonly"/>
                </br>
                </br>
                <#if repair.parts??>
                    <label><b>Part(s)</b></label></br>
                    <#list repair.parts as part>
                        <input type="text" id="partType" placeholder="partType" name="partType" value="${part.type} (${part.cost} $)" required readonly="readonly"/>
                        <br/>
                    </#list>
                </#if>
                </br>
                </br>
                <label><b>Vehicle</b></label>
                </br>
                <input type="text" id="plateNumbe" placeholder="plateNumber" name="plateNumber" value=${repair.vehicle.plateNumber} required readonly="readonly"/>
                </br>
                <button type="submit" class=".btn-primary" OnClick="SetDest1()">Update</button>

                </br>
                <button type="submit" class="cancelbtn" OnClick="SetDest2()">Delete </button>
            </div>
        </form>

    </#if>
    </div>
</div>

</body>
<script language="JavaScript">

    var typeSelect = document.getElementById("typeSelect");
    var repairType = $('input[name="repairType"]');
    $('#ID').hide();

    var stageSelect = document.getElementById("stageSelect");
    var repairStage = $('input[name="repairStage"]');

    typeSelect.addEventListener('click', function() {
        repairType.attr('readonly', false);
        repairType.attr('value', typeSelect.options[typeSelect.selectedIndex].value);
        repairType.attr('readonly', true);
    })

    stageSelect.addEventListener('click', function() {
        repairStage.attr('value', stageSelect.options[stageSelect.selectedIndex].value);
    })

    function SetDest1() {
        document.forms["repairEditForm"].action = "/admin/editRepair";
    }
    function SetDest2() {
        document.forms["repairEditForm"].action = "/admin/deleteRepair";
    }

//    var repairType = $('input[name="repairType"]');
//    var typeSelect = document.getElementById("typeSelect");
//
//    typeSelect.addEventListener('click', function() {
//        repairType.attr('readonly', false);
//        repairType.attr('value', repairType.options[repairType.selectedIndex].value);
//        repairType.attr('readonly', true);
//    })
//
//    var repairStage = $('input[name="repairStage"]');
//    var stageSelect = document.getElementById("stageSelect");
//
//    stageSelect.addEventListener('click', function() {
//        repairStage.attr('readonly', false);
//        repairStage.attr('value', repairStage.options[repairStage.selectedIndex].value);
//        repairStage.attr('readonly', true);
//    })

</script>
</html>