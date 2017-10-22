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
    
        <div class="navbar-header">
            <p class="navbar-brand"id="repairsId">CAR Repairs<p>
        </div>
        <ul class="nav navbar-nav">
            <li class="LogOut"><a href="/logout">Log Out</a></li>
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
    <#if owner??>
      <form  method="post" action="/editOwner" name="ownerEditForm">
      
        <div class="container">
          <label><b>Username</b></label>
            </br>
          <input type="text" id="email" placeholder="email" name="email"  value=${owner.email} required>
        </br>
          <label><b>First Name</b></label>
            </br>
          <input type="text" id="firstName" placeholder="firstName" name="firstName" value=${owner.firstName} required>
        </br>
          <label><b>Last Name</b></label>
            </br>
          <input type="text" id="lastName" placeholder="lastName" name="lastName" value=${owner.lastName} required>
        </br>
          <label><b>Password</b></label>
            </br>
          <input type="password" id="password" placeholder="password" name="password" value=${owner.password} required>
        </br>     
          <label><b>VAT</b></label>
            </br>
          <input type="text" id="vat" placeholder="vat" name="vat" value=${owner.vat} required>
        </br>
          <label><b>Role</b></label>
            </br>
            <input type="text" id="role" placeholder="Role" name="role" value=${owner.role} required disabled>
            </br>
            <select id="roleSelect" name="roleSelect">
                <option value="ADMIN">Admin</option>
                <option value="USER">User</option>
            </select>

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

    var roleSelect = document.getElementById("roleSelect");
    var role = $('input[name="role"]');

    roleSelect.addEventListener('click', function() {
        role.attr('value', roleSelect.options[roleSelect.selectedIndex].value);
    })

    function SetDest1() {
        role.attr('disabled', false);
        document.forms["ownerEditForm"].action = "/editOwner";
    }

    function SetDest2() {
        document.forms["ownerEditForm"].action = "/deleteOwner";
    }

</script>
</html>