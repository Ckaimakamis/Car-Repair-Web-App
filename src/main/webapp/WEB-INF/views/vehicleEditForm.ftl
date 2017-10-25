<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Car Repair</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="/css/vehicleEditForm.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--jQuery -->
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
  <#--<script type="text/javascript" src="/js/vehicleEditForm.js"></script>-->
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
    <#if vehicle??>
      <form  method="post" action="/admin/editVehicle" name="vehicleEditForm">
        <div class="container">
          <label><b> Enter Plate Number</b></label>
            </br>
          <input type="text" id="plateNumber" placeholder="Plate Number" name="plateNumber" value=${vehicle.plateNumber} required>
        </br>
          <label><b>Enter Model</b></label>
            </br>
          <input type="text" id="model" placeholder="Model" name="model"  value=${vehicle.model} required>
        </br>
          <label><b>Enter Year</b></label>
            </br>
          <input type="text" id="year" placeholder="Year" name="year" value=${vehicle.year} required>
        </br>
          <label><b>Enter Color</b></label>
            </br>
          <input type="text" id="color" placeholder="Color" name="color" value=${vehicle.color} required>
        </br>
        <#if owner??>
            <label><b>First Name</b></label>
            </br>
          <input type="text" id="vat" placeholder="VAT" name="vat" value=${owner.firstName} disabled>
        </br>
            <label><b>Last Name</b></label>
            </br>
          <input type="text" id="lastName" placeholder="Last Name" name="lastName" value=${owner.lastName} disabled>
        </br>
            <label><b>VAT</b></label>
            </br>
          <input type="text" id="firstName" placeholder="First Name" name="vat" value=${owner.vat} disabled>
        </#if>
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

    function SetDest1() {
        document.forms["vehicleEditForm"].action = "/admin/editVehicle";
    }
    function SetDest2() {
        document.forms["vehicleEditForm"].action = "/admin/deleteVehicle";
    }

</script>
</html>