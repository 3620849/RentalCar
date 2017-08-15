/**
 * Created by UA C on 16.07.2017.
 */
var app = angular.module("mainApp",[]);
app.controller("AppCtrl",function($scope,$http){

    $scope.arr ={};
    $scope.user={isRegistered:false,
        token : -1
    }
    $scope.sendForm = function(user){$http.post("/getToken",user)
        .then(function(data, status, headers, config){
        $scope.user.token=data.data;

            if(data.data!=-1){
            $scope.user.isRegistered=true;}
            $scope.currentUser();

            console.log(user);
    },function(error){console.log(error)})};

    $scope.currentUser = function(){$http.get("/getCurrentUser",{
         headers: {'X-Auth-Token': $scope.user.token}
    }).then(function(data){
        $scope.arr = data;
        $scope.user.id=data.data.id;
            $scope.getUserData();
             },
    function(error){

        console.log(error)
    })}


    $scope.getUserData = function(){
        $http.get("/api/getUserData/"+$scope.user.id,{
            headers: {'X-Auth-Token': $scope.user.token}})
        .then(function(response, status, headers, config){
            $scope.arr2=response.data;
        },function(error){
            console.log(error.data)
        })};


})