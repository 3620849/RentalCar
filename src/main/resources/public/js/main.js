/**
 * Created by UA C on 16.07.2017.
 */

var app = angular.module("mainApp",[]);
app.controller("AppCtrl",function($scope,$http){
    $scope.showLogForm=false;
    $scope.registerForm={};
    $scope.currentForm="lib/loginForm.html";
    $scope.arr ={};
    $scope.user={
        isRegistered:false,
        token : -1
    }
    $scope.getRegisterForm = function(){
        $scope.currentForm="lib/rform.html";
        $scope.registerForm.name="SIGN UP";
    }
    $scope.getLoginForm = function(op){

        $scope.currentForm="lib/loginForm.html";
        $scope.registerForm.name="LOGIN";
        openCloseRegform(op);
    }
    var openCloseRegform = function(op){
        if(op)
        $scope.showLogForm?$scope.showLogForm=false:$scope.showLogForm=true;
    }
    $scope.sendForm = function(user){$http.post("/getToken",user)
        .then(function(data, status, headers, config){
        $scope.user.token=data.data;
            $scope.currentUser();
            openCloseRegform(true);
            console.log(user);
    },function(error){console.log(error.data)})};

    $scope.currentUser = function(){$http.get("/getCurrentUser",{
         headers: {'X-Auth-Token': $scope.user.token}
    }).then(function(data){
        $scope.arr = data;
        $scope.user.id=data.data.id;
            $scope.getUserData();
             },
    function(error){

        console.log(error.data)
    })}


    $scope.getUserData = function(){
        $http.get("/api/getUserData/"+$scope.user.id,{
            headers: {'X-Auth-Token': $scope.user.token}})
        .then(function(response, status, headers, config){
            $scope.arr2=response.data;
        },function(error){
            console.log(error.data)
        })};

    $scope.registerUser = function(user){$http.post("/register",user)
        .then(function(data, status, headers, config){
            openCloseRegform(true);
        },function(error){console.log(error.data)})};


})