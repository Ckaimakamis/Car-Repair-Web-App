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
                                    </div>

                                    <div class="form-group">
                                            <input type="text" class="form-control" id="cost" placeholder="Enter COST"name="cost" required>
                                    </div>

                                    <div class="form-group">
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
        <h2>${errorMessage!""}</h2>

    <#if repairs??>

        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Repair Found</h2></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <h3>Here's the review of repair's details:</h3>
                </td>
            </tr>
            <#list repairs as repair>
                <tr>
                    <td>Cost:</td>
                    <td>${repair.cost}</td>
                </tr>
                <tr>
                    <td>Date:</td>
                    <td>${repair.dateTime}</td>
                </tr>
            </#list>
        </table>
    </#if>
    </div>
</div>    
<footer class="container-fluid text-center"  >

    <h3>Welcome to our Car Services</h3>

</footer>

</body>

<script>
    $(document).ready(function(){
        var vatInput = $('input[name="vat"]');
        var plateNumberInput=$('input[name="plateNumber"]');

        var dateInput = $('input[name="date"]');
        var dateToInput=$('input[name="dateTo"]');
        var checkboxPeriodSearch = $('input[name="periodSearch"]');
        var checkBoxPeriodSearch = document.querySelector("input[name=periodSearch]");

        var checkboxCaseSearch = $('input[name="caseSearch"]');
        var checkBoxCaseSearch = document.querySelector("input[name=caseSearch]");

        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";

        dateToInput.hide();

        checkBoxPeriodSearch.addEventListener('change', function() {
            if(this.checked) {
                dateToInput.required = true;
                dateToInput.show();
                dateInput.attr('placeholder', 'Select Date From');
                dateToInput.attr('placeholder', 'Select Date To');
            } else {
                dateToInput.required = false;
                dateToInput.hide();
                dateInput.attr('placeholder', 'YYYY-MM-DD');
            }
        });

        plateNumberInput.hide();
        checkBoxCaseSearch.addEventListener('change', function() {
            if(this.checked) {
                vatInput.required = false;
                plateNumberInput.required = true;
                plateNumberInput.show();
                vatInput.hide();
            } else {
                vatInput.required = true;
                plateNumberInput.required = false;
                plateNumberInput.hide();
                vatInput.show();
            }
        });

    })

</script>

</html>