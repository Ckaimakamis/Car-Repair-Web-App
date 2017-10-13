<!DOCTYPE html>
<html lang="en">
<head>
  <title>Car Repair</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="index.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <p class="navbar-brand"id="repairsId">CAR Repairs<p>
      </div>
      <ul class="nav navbar-nav">
        <li class="#"><a href="#">Home</a></li>
        
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Create Owner</b> <span class="caret"></span></a>
          <ul id="login-dp" class="dropdown-menu">
            <li>
              <div class="row">
                  <div class="col-md-12">
                    <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">

                        <div class="form-group">

                          <label class="sr-only" for="exampleInputEmail2">Username</label>
                          <input type="text" class="form-control" id="exampleInputEmail2" placeholder="Enter Username" name="listName" required>
                           
                        </div>

                        <div class="form-group">
                            
                          <label class="sr-only" for="exampleInputEmail2">Surname</label>
                          <input type="text" class="form-control" id="exampleInputEmail2" placeholder="Enter Surname"name="listSurname" required>
                                                      
                        </div>

                        <div class="form-group">
                            
                          <label class="sr-only" for="exampleInputEmail2">AFM</label>
                          <input type="text" class="form-control" id="exampleInputEmail2" placeholder="Enter Afm" name="listAFM"required>
                                                      
                        </div>

                        <div class="form-group">
                            
                          <label class="sr-only" for="exampleInputEmail2">Password</label>
                          <input type="text" class="form-control" id="exampleInputEmail2" placeholder="Enter Password" name="listPassword"required>
                                                      
                        </div>

                        <div class="form-group">
                            
                          <label class="sr-only" for="exampleInputEmail2">Brand</label>
                          <input type="text" class="form-control" id="exampleInputEmail2" placeholder="Enter Brand"name="listBrands" required>
                                                      
                        </div>


                        <div class="form-group">

                          <label class="sr-only" for="exampleInputPassword2">Plate</label>
                          <input type="text" class="form-control" id="exampleInputPassword2" placeholder="Enter Plate" name="listPlates"required>

                          <div class="help-block text-right"><a href="">Forget the password ?</a></div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block">Sign Up</button>
                        </div>
                    </form>
                  
            </ul>
              
          <!--  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Edit Owner <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Page 2</a></li>
              </ul>
            </li> -->
    </div>
  </nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
     
    </div>
    <div class="col-sm-8 text-left"> 
      <p>
     <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="Email or AFM">
            </div>
          <button type="submit" class="btn btn-default" >Search</button>
        </form>
      </p>
    </div>
    <div class="col-sm-2 sidenav">
      
   </div>
  </div>
</div>

<footer class="container-fluid text-center">
   <h3>Welcome to our Car Services</h3>
</footer>

</body>
</html>