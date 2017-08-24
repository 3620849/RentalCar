/**
 * Created by UA C on 16.07.2017.
 */

var app = angular.module("mainApp",['ngRoute']);
app.controller("AppCtrl",function($scope,$rootScope,$http,registerService,userDataService){
    $scope.arr ={};// userDataService.data;
    $scope.user=registerService.user;

    $rootScope.$on('data:updated',function(){
        $scope.arr =userDataService.data;userDataService.getUserData();});

    $rootScope.$on('userData:updated',function(){
        $scope.arr2 =userDataService.userData});

    $rootScope.$on('userLogin:updated',function(){
        userDataService.getCurrentUserData()});
});
app.config(function($routeProvider) {
    $routeProvider
    .when('/home', {
        templateUrl: 'lib/allCars.html'
    })
        .when('/account', {
        templateUrl: 'lib/account.html',
        controller: 'AppCtrl'})
        /*.when('/rent', {
        templateUrl: '/rent.html',
        controller: 'RentController'
    })
        .when('/account', {
        templateUrl: '/account.html',
        controller: 'AccountController'
    });*/
});