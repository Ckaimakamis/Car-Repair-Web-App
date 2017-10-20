<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Car Repair</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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

<style>
    /* Remove the navbar's default margin-bottom and rounded borders */
    .navbar {
        margin-bottom: 0;
        border-radius: 0;
        background-color: #2B3A37;
        padding:15px;
    }
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    /* Set gray background color and 100% height */
    .sidenav {
        padding-top: 20px;
        background-color: #78909c;
        height: 100%;
    }
    /* Set black background color, white text and some padding */
    footer {
        background-color: #2B3A37;
        /* background-color: white; */
        color: white;
        padding: 20px;
    }
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
        .sidenav {
            height: auto;
            padding: 15px;
        }
        .row.content {height:auto;}
    }
    #repairsId{
        font-weight: bold;
        font-size: 200%;
        font-style: normal ;
        color: white;
    }
    #login-dp{
        min-width: 250px;
        padding: 14px 14px 0;
        overflow:hidden;
        background-color:rgba(255,255,255,.8);
    }
    #login-dp .help-block{
        font-size:12px
    }
    #login-dp .bottom{
        background-color:rgba(255,255,255,.8);
        border-top:1px solid #ddd;
        clear:both;
        padding:14px;
    }
    #login-dp .form-group {
        margin-bottom: 10px;
    }
    .btn-fb{
        color: #fff;
        background-color:#3b5998;
    }
    .btn-fb:hover{
        color: #fff;
        background-color:#496ebc
    }
    .btn-tw{
        color: #fff;
        background-color:#55acee;
    }
    .btn-tw:hover{
        color: #fff;
        background-color:#59b5fa;
    }
    @media(max-width:768px){
        #login-dp{
            background-color: inherit;
            color: #fff;
        }
        #login-dp .bottom{
            background-color: inherit;
            border-top:0 none;
        }
    }
</style>

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
                                <form class="form" role="form" method="post" action="/searchVehicle" accept-charset="UTF-8" id="login-nav" name="createRepair">

                                    <div class="form-group">
                                        <label class="sr-only" for="registerLastName">Surname</label>
                                        <input type="text" class="form-control" id="registerLastName" placeholder="Enter First Name"name="firstName" required>
                                    </div>

                                    <div class="form-group">
                                            <label class="sr-only" for="registerVAT">Cost</label>
                                            <input type="text" class="form-control" id="registerVAT" placeholder="Enter COST"name="vat" required>
                                    </div>

                                    <div class="form-group">
                                            <label class="sr-only" for="registerVAT">Operations</label>
                                            <input type="text" class="form-control" id="registerVAT" placeholder="Enter Work"name="vat" required>
                                    </div>

                                    <div class="form-group">
                                            <select id="searchType" name="searchType">
                                                <option value="User">pending</option>
                                                <option value="Repair">done</option>
                                                <option value="Repair">in progress</option>
                                            </select>
                                    </div>

                                    <div class="form-group">
                                            <select id="searchType" name="searchType">
                                                <option value="User">small</option>
                                                <option value="Repair">big</option>
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


                                <form class="form" role="form" method="post" action="/searchRepair" accept-charset="UTF-8" id="login-nav" name = "searchRepairForm">

                                    <div class="form-group">
                                        <label class="sr-only" for="email">Vat</label>
                                        <input type="text" class="form-control" id="searchEmail" placeholder="Enter Vat"name="vat" required>
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="email">PlateNumber</label>
                                        <input type="text" class="form-control" id="searchEmail" placeholder="Enter PlateNumber"name="plateNumber" >
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="date">Date</label>
                                        <input type="text" class="form-control" id="date" name="date" placeholder="YYYY-MM-DD" required/>
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="dateTo">Date To</label>
                                        <input type="text" class="form-control" id="dateTo" name="dateTo" placeholder="YYYY-MM-DD"/>
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="periodSearch">Search</label>
                                        <input type="checkbox" id="caseSearch" name="caseSearch" value="case search" placeholder="case search"> case search
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="periodSearch">Search</label>
                                        <input type="checkbox" id="periodSearch" name="periodSearch" value="period search" placeholder="period search"> period search
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

        </ul>

    </div>

</nav>


<div class="container-fluid text-center">
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
<footer class="container-fluid text-center">

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
        dateInput.datepicker({
            format: 'yyyy-mm-dd',
            container: container,
            todayHighlight: true,
            autoclose: true
        });
        dateToInput.datepicker({
            format: 'yyyy-mm-dd',
            container: container,
            todayHighlight: true,
            autoclose: true
        });

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