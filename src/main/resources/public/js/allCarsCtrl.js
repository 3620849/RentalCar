/*
 * Created by UA C on 25.08.2017.
 */

angular.module('mainApp').controller('allCarsCtrl', function($scope,$rootScope,carsService){
    carsService.getCarList();
    $rootScope.$on('carList:updated', function(){
        $scope.carsList = carsService.carList;
    });
});