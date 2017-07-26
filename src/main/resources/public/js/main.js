/**
 * Created by UA C on 16.07.2017.
 */
var app = angular.module("mainApp",[]);
app.controller("AppCtrl",function($scope,$http){
    $scope.arr ={};
    $http.get("http://localhost:8080/hi").success(function(data){
        $scope.arr=data;
    })
})