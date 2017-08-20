/**
 * Created by UA C on 20.08.2017.
 */
angular.module('mainApp').directive('loginPopUp',function(){
    return {
        restrict:'E',
        scope:false,
        templateUrl: 'lib/loginForm.html',
        controller:function($scope){
            $scope.showPopUpDialog=false ;
            $scope.openCloseRegform = function(op){
                if(op)$scope.showPopUpDialog?$scope.showPopUpDialog=false:$scope.showPopUpDialog=true;
            }
        }
    };
});