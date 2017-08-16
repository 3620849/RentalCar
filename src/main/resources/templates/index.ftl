<!DOCTYPE html>
<html lang="en" ng-app="mainApp">
<head>
    <meta charset="UTF-8">
    <#--<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css">-->
    <!-- Bootstrap core CSS -->
    <link href="lib/bootstrap-4.0.0-beta/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
    .navbar{
        z-index: 1001;
    }
    .sidebar {
        position: fixed;
        top: 0px;
        bottom: 0;
        left: 0;
        z-index: 1000;
        padding: 20px;
        overflow-x: hidden;
        overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
        border-right: 1px solid #eee;
    }

    main {
        position: inherit;
    }
    #loginForm{
        margin-top: 50px;
    }

</style>

<body ng-controller="AppCtrl" ng-init="frName = '${username}'">


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Features</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" ng-click="getRegForm()">Register</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" ">Disabled</a>
            </li>
        </ul>
    </div>
</nav>
<br>

<div class="container-fluid">
    <div class="row">

        <div  class="col-3 bg-light sidebar">

            <form id="loginForm" name="loginForm" ng-show ="!user.isRegistered" ng-submit="sendForm(user)" method="post">
                <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon bg-secondary" id="sizing-addon2">@</span>
                <input type="text" class="form-control" placeholder="e-mail" name="mail" ng-model="user.username" >
            </div>
            <br>
            <div class="input-group">
                <input type="password" class="form-control" placeholder="password" name="password" ng-model="user.password" >
                 <span class="input-group-btn">
                  <button class="btn btn-secondary" type="submit">Go!</button>
                </span>
            </div>
                </div>
            </form>
            <ng-include src="'lib/rform.html'"></ng-include>
        </div>
        <main class="container col-5  ml-auto">
            <div class="card bg-light  " >
                <div class="card-header">Person</div>
                <div class="card-body">
                    <h4 class="card-title">Entered as ${username}</h4>
                    <p class="card-text">You role ${roles}</p>
                    <p class="card-text">Data from promice:{{arr}}</p>
                    <p>New Username {{frName}} </p>
                </div>
                <br>
                <div class="card bg-light  " >
                    <div class="card-header">Person Data</div>
                    <div class="card-body">
                        <h4 class="card-title">Entered as ${username}</h4>
                        <p class="card-text">You role ${roles}</p>
                        <p class="card-text">Data from promice:{{arr2}}</p>
                        <p>New Username {{frName}} </p>
                    </div>
                </div>

            </div>

    </div>

    </div>
</body>
<script type="text/javascript" src="js/angular.js"></script>
<script type="text/javascript" src="js/main.js"></script>

<script src="lib/jquery-3.2.1.slim.js"</script>
<script src=""lib/bootstrap-4.0.0-beta/assets/js/vendor/popper.min.js"></script>
<script src=""lib/bootstrap-4.0.0-beta/dist/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src=""lib/bootstrap-4.0.0-beta/assets/js/ie10-viewport-bug-workaround.js"></script>

</html>