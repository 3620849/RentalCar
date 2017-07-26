<!DOCTYPE html>
<html lang="en" ng-app="mainApp">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css">
</head>
<body ng-controller="AppCtrl">
<h1>My page</h1>

<div class="container-fluid" style="margin: 30px">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">Zagolovok</div>
                <div class="panel-body">
                    <p>{{arr}}</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="js/angular.js"></script>
<script type="text/javascript" src="js/main.js"></script>

</html>