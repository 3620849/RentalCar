/*
 * Created by UA C on 25.08.2017.
 */
angular.module('mainApp').controller('accountCtrl',function($scope,$rootScope,$http,registerService,userDataService){


    $rootScope.$on('data:updated',function(){
        $rootScope.arr = userDataService.data;
        userDataService.getUserData();});

    $rootScope.$on('userData:updated',function(){
        $rootScope.arr2 =userDataService.userData});

    $rootScope.$on('userLogin:updated',function(){
        userDataService.getCurrentUserData()});
})