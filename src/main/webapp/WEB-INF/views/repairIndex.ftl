<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Car Repair</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/repairIndex.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <!-- Bootstrap Date-Picker Plugin -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <#--<script type="text/javascript" src="/js/repairIndex.js"></script>-->
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
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Create Repairs</b> <span class="caret"></span></a>
                <ul id="login-dp" class="dropdown-menu">
                    <li>
                        <div class="row">
                            <div class="col-md-12">
                                <form class="form" role="form" method="post" action="/admin/registerRepair" accept-charset="UTF-8" id="login-nav" name="createRepair">

                                    <div class="form-group">
                                        <input type="datetime-local" class="form-control" id="date" name="date" placeholder="YYYY-MM-DD" required/>
                                        <label class="sr-only" for="dateTime">Date</label>
                                        <input type="datetime-local" class="form-control" id="dateTime" name="dateTime" required/>
                                    </div>

                                    <div class="form-group">
                                            <label class="sr-only" for="registerVAT">Cost</label>
                                            <input type="text" class="form-control" id="cost" placeholder="Enter COST"name="cost" required>
                                    </div>

                                    <div class="form-group">
                                            <label class="sr-only" for="registerVAT">Operations</label>
                                            <input type="text" class="form-control" id="operations" placeholder="Enter Work"name="operations" required>
                                    </div>


                                    <div class="form-group">
                                        <input type="text" class="form-control" id="plateNumber" placeholder="Enter Vehicle's Plate" name="plateNumber" required>
                                    </div>

                                    <div class="form-group">
                                            <select id="repairStage" name="repairStage">
                                                <option value="PENDING">pending</option>
                                                <option value="IN_PROGRESS">in progress</option>
                                                <option value="DONE">done</option>
                                            </select>
                                    </div>

                                    <div class="form-group">
                                            <select id="repairType" name="repairType">
                                                <option value="SMALL">small</option>
                                                <option value="BIG">big</option>
                                            </select>
                                    </div>

                                     <div id="extra-repairs"></div>
                                     <button type="button" class="addService"><span class="glyphicon glyphicon-plus"></span></button>

                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary btn-block">Create Repair</button>
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


                                <form class="form" role="form" method="post" action="/admin/searchRepair" accept-charset="UTF-8" id="login-nav" name = "searchRepairForm">

                                    <div class="form-group">
                                        <label class="sr-only" for="date">Date</label>
                                        <input type= "datetime-local" class="form-control" id="date" name="date" placeholder="YYYY-MM-DD"/>
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="dateTo">DateTo</label>
                                        <input type= "datetime-local" class="form-control" id="dateTo" name="dateTo" placeholder="YYYY-MM-DD"/>
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="vat">Vat</label>
                                        <input type= "text" class="form-control" id="vat" name="vat" placeholder="Vat" />
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="plateNumber">plateNumber</label>
                                        <input type= "text" class="form-control" id="plateNumberSearch" name="plateNumber" placeholder="Plate Number"/>
                                    </div>

                                    <select id="searchType" name="searchType">
                                        <option value="dateSel">By Date</option>
                                        <option value="periodSel">By Period</option>
                                        <option value="vatSel">By owner's VAT</option>
                                        <option value="plateNumberSel">By vehicle's Plate</option>
                                    </select>

                                    </br>

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
        <table class="table">
            <thead>
            <tr id="headTable">
                <th style="text-align:center">Date Time</th>
                <th style="text-align:center">Type</th>
                <th style="text-align:center">Operations</th>
                <th style="text-align:center">Stage</th>
                <th style="text-align:center">Cost</th>
                <th style="text-align:center">Plate</th>
                <th style="text-align:center">Vehicle</th>
                <th style="text-align:center">Owner</th>
            </tr>
            </thead>
            <tbody >
            <#list repairs as newRepair>
            <tr id="bodyTable">
                <td style="text-align:center">${newRepair.dateTime}</td>
                <td style="text-align:center">${newRepair.type}</td>
                <td style="text-align:center">${newRepair.operations}</td>
                <td style="text-align:center"> ${newRepair.stage}</td>
                <td style="text-align:center">${newRepair.cost} $</td>
                <td style="text-align:center">${newRepair.vehicle.plateNumber}</td>
                <td style="text-align:center">${newRepair.vehicle.model} ${newRepair.vehicle.year}</td>
                <td style="text-align:center">${newRepair.vehicle.owner.firstName} ${newRepair.vehicle.owner.lastName}</td>
            </tr>
            </#list>
            </tbody>
        </table>
        <h2>${message!""}</h2>
        <h2 style="color: red">${errorMessage!""}</h2>
    </div>
</div>    
<footer class="container-fluid text-center">

    <h3>Welcome to our Car Services</h3>

</footer>

</body>

<script>
    $(document).ready(function(){
        var searchType = document.getElementById("searchType");
        var date = $('#date');
        var dateTo = $('#dateTo');
        var vat = $('#vat');
        var plateNumber = $('#plateNumberSearch');

        dateTo.hide();
        vat.hide();
        plateNumber.hide();

        searchType.addEventListener("click", function() {
            console.log(searchType.options[searchType.selectedIndex].value);
            switch(searchType.options[searchType.selectedIndex].value) {
                case 'dateSel':
                    date.show();
                    dateTo.hide();
                    vat.hide();
                    plateNumber.hide();
                    break;
                case 'periodSel':
                    date.show();
                    dateTo.show();
                    vat.hide();
                    plateNumber.hide();
                    break;
                case 'vatSel':
                    date.hide();
                    dateTo.hide();
                    vat.show();
                    plateNumber.hide();
                    break;
                case 'plateNumberSel':
                    date.hide();
                    dateTo.hide();
                    vat.hide();
                    plateNumber.show();
                    break;
            }
        })
    })
    var $newCost = "<select><option value='TIRES'>TIRES</option>" +
            "<option value='BRAKES'>BRAKES</option>" +
            "<option value='FENDER'>FENDER</option>" +
            "<option value='WINDOWS'>WINDOWS</option>" +
            "</select><input type='text' />";

    var $el=$('#extra-repairs');
    $('.addService').click(function(){
        $el.append($newCost);
    });

     /* var operations= ('#operations').val();
        var dateTime=('#dateTime').val();
        var plateNumber=('#plateNumber').val();
        var repairStage=('#repairStage').val();
        var repairType=('#repairType').val();
        var cost=('#cost').val();    */

</script>

</html>