/**
 * Created by UA C on 25.08.2017.
 */

angular.module('mainApp').factory('carsService',function($http,$rootScope) {
    var fact = {
        carList:{},
        getCarList: function(){
            $http.get("/api/getAllCars").then(function (response, status, headers, config) {
                fact.carList = response.data;
                $rootScope.$broadcast('carList:updated');
            }, function (error) {
                console.log(error.data)
            })
        }
    }
    return fact;
});
