/*
 * Created by UA C on 25.08.2017.
 */
angular.module('mainApp').controller('accountCtrl',function($scope,$rootScope,$http,registerService,userDataService){
    $scope.arr ={};// userDataService.data;
    $scope.user=registerService.user;

    $rootScope.$on('data:updated',function(){
        $scope.arr =userDataService.data;userDataService.getUserData();});

    $rootScope.$on('userData:updated',function(){
        $scope.arr2 =userDataService.userData});

    $rootScope.$on('userLogin:updated',function(){
        userDataService.getCurrentUserData()});
})