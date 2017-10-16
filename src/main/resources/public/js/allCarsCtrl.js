/*
 * Created by UA C on 25.08.2017.
 */

angular.module('mainApp').controller('allCarsCtrl', function($scope,$rootScope,carsService){
    carsService.getCarList();
    $rootScope.$on('carList:updated', function(){
        $scope.carsList = carsService.carList;


        for(var i = 0;i<$scope.carsList.length;++i){
            (function() {
                var index = i;
                console.log()
                carsService.getCarImgById($scope.carsList[index].id)
                    .then(function (response, status, headers, config) {
                        $scope.carsList[index].img = response.data.image;
                    }, function (error) {
                        console.log(error.data)
                    })


            })();
        }
        console.log( $scope.carsList)
    });

});