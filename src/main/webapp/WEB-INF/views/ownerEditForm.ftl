<!DOCTYPE html>
<html lang="en">
<head>
  <title>Car Repair</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="editForm.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
      <form  method="post" action="/editOwner" ><#--TODO make an endpoint for this-->
        <div class="imgcontainer">
          <img src="img_avatar2.png" alt="Avatar" class="avatar">
        </div>
      
        <div class="container">
          <label><b>Enter Username</b></label>
          <input type="text" placeholder="Username" name="listName" required>
        </br>
          <label><b> Enter Surnames</b></label>
          <input type="password" placeholder="Surname" name="listSurname" required>
        </br>
          <label><b>Enter Your AFM</b></label>
          <input type="text" placeholder="AFM" name="listAFM" required>
        </br>
          <label><b>Enter Password</b></label>
          <input type="text" placeholder="Password" name="listPassword" required>
        </br>     
          <label><b>Vehicle - Brand</b></label>
          <input type="text" placeholder="Enter Brand" name="listBrands" required>
        </br>
          <label><b>Vehicle - Plates</b></label>
          <input type="text" placeholder="Enter Plate" name="listPlates" required>

        </br>
                <div class="col-25">
                  <label for="country">Type</label>
                </div>
                <div class="col-75">
                  <select id="country" name="Type">
                    <option value="User">Admin</option>
                    <option value="Owner">Owner</option>
    
                  </select>
                </div>
              

          <button type="submit">Edit</button><button type="button" class=".btn-primary">Update</button>
          
              </br>
              <button type="button" class="cancelbtn">Delete</button>
        </div>
      </form>
    
    
  </div>
</div>

</body>
</html>