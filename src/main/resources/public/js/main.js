/**
 * Created by UA C on 16.07.2017.
 */

var app = angular.module("mainApp",['ngRoute']);
app.controller("AppCtrl",function($scope,$rootScope){
    $rootScope.user={};
});
app.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'lib/allCars.html',
            controller:'allCarsCtrl'
        })

        .when('/home', {
        templateUrl: 'lib/allCars.html',
            controller:'allCarsCtrl'
    })
        .when('/account', {
        templateUrl: 'lib/account.html',
        controller: 'accountCtrl'})
        /*.when('/rent', {
        templateUrl: '/rent.html',
        controller: 'RentController'
    })
        .when('/account', {
        templateUrl: '/account.html',
        controller: 'AccountController'
    });*/
});