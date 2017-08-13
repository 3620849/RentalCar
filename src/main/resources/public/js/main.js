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
        .success(function(data, status, headers, config){
        $scope.user.token=data;
            $scope.user.isRegistered=true;
            $scope.updatePage();
            console.log(user);
    })};
    $scope.updatePage = function(){$http.get("/getCurrentUser",{
         headers: {'X-Auth-Token': $scope.user.token}
    }).success(function(data){
        $scope.arr = data;
        $scope.frName=data.username})}

})