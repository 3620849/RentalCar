angular.module("mainApp").controller("loginCtrl",function($scope,registerService){
    $scope.currentForm="lib/loginForm.html";
    $scope.registerForm={};
    $scope.registerForm.name="LOGIN";
    $scope.showRegisterForm = false;
    $scope.showLoginForm = true;

    $scope.sendForm = function(op){
        registerService.login(op);
        $scope.openCloseRegform(true);
    }
    $scope.registerUser = function(user){
        registerService.register(user);
        $scope.getLoginForm(false);}


    $scope.getLoginForm = function(op){
            $scope.showLoginForm=true;
            $scope.showRegisterForm=false;
            $scope.registerForm.name="LOGIN";
            $scope.openCloseRegform(op);
    }

    $scope.getRegisterForm = function(){
        $scope.showLoginForm=false;
        $scope.showRegisterForm=true;
        $scope.registerForm.name="SIGN UP";
    }
})