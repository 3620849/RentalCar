<!DOCTYPE html>
<html lang="en" ng-app="mainApp">
<head>
    <meta charset="UTF-8">
    <!-- Bootstrap core CSS -->
    <link href="lib/bootstrap-4.0.0-beta/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body ng-controller="AppCtrl" ng-init="frName = '${username}'">
<ng-include src="'lib/navbar.html'"></ng-include>
<div class="container-fluid">

<login-pop-up></login-pop-up>

    <div class="row">

        <main class="container col-5  ml-auto"">
            <div class="card bg-light  " >
                <div class="card-header">Person</div>
                <div class="card-body">
                    <h4 class="card-title">Entered as ${username}</h4>
                    <p class="card-text">You role ${roles}</p>
                    <p class="card-text">Data from promice:{{arr}}</p>
                    <p>New Username {{frName}} </p>
                </div>
                <br>
                <div class="card bg-light" >
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
<script src="lib/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<script src="lib/bootstrap-4.0.0-beta/assets/js/vendor/popper.min.js"></script>
<script src="lib/bootstrap-4.0.0-beta/dist/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="lib/bootstrap-4.0.0-beta/assets/js/ie10-viewport-bug-workaround.js"></script>
<script src="js/loginCtrl.js"></script>
<script src="js/loginPopUpDirective.js"></script>
<script src="js/registerService.js"></script>
<script src="js/userDataService.js"></script>


</html>