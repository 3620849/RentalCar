/**
 * Created by UA C on 20.08.2017.
 */
angular.module('mainApp').factory('userDataService',function($http,$rootScope){
    var fact = {
        data:{},
        userData:{},
        getCurrentUserData:function(){$http.get("/getCurrentUser",{
            headers: {'X-Auth-Token': $rootScope.user.token}
        }).then(function(response){
                fact.data = response.data;
                $rootScope.$broadcast('data:updated');
            },
            function(errorResponse){
                console.log(errorResponse.data)
            })},

        getUserData:function(){
            $http.get("/api/getUserData/"+fact.data.id,{
                    headers: {'X-Auth-Token': $rootScope.user.token}})
                .then(function(response, status, headers, config){
                    fact.userData=response.data;
                    $rootScope.$broadcast('userData:updated');
                },function(error){
                    console.log(error.data)
                })}
    }
    return fact;
});