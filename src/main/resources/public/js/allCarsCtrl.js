/*
 * Created by UA C on 25.08.2017.
 */

angular.module('mainApp').controller('allCarsCtrl', function($scope,$rootScope,carsService){
    $scope.carsList =[{model:"13"},{model:"133"}];
    carsService.getCarList();
    $rootScope.$on('carList:updated', function(){
        $scope.carsList = carsService.carList;
        console.log($scope.carsList);
    });
});