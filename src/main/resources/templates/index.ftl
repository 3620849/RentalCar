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
        <div ng-view></div>


    </div>

</div>
</body>
<script type="text/javascript" src="lib/angular.js"></script>
<script type="text/javascript" src="lib/angular-route.min.js"></script>
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