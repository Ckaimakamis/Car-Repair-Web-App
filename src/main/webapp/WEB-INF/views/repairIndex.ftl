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

                                    <div class="form-group">
                                        <label class="sr-only" for="plateNumber">Operations</label>
                                        <input type="text" class="form-control" id="plateNumber" placeholder="Enter vehicle's Plate" name="plateNumber" required>
                                    </div>

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
                                        <input type= "datetime-local" class="form-control" id="date" name="date" placeholder="YYYY-MM-DD">
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="dateTo">DateTo</label>
                                        <input type= "datetime-local" class="form-control" id="dateTo" name="dateTo" placeholder="YYYY-MM-DD">
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="vat">Vat</label>
                                        <input type= "text" class="form-control" id="vat" name="vat" placeholder="Vat">
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="plateNumber">plateNumber</label>
                                        <input type= "text" class="form-control" id="plateNumber" name="plateNumber" placeholder="Plate Number">
                                    </div>

                                    <select id="searchType">
                                        <option value="date">By Date</option>
                                        <option value="period">By Period</option>
                                        <option value="vat">By owner's VAT</option>
                                        <option value="plate">By vehicle's Plate</option>
                                    </select>

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
        searchType.addEventListener('click', function() {
            switch(searchType.options[searchType.selectedIndex].value) {
                case 'date':

                    break;
                case 'period':

                    break;
                case 'vat':

                    break;
                case 'plate':

                    break;
            }
        }
    })

</script>

</html>