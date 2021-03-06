/**
 * Created by UA C on 20.08.2017.
 */
angular.module('mainApp').factory('registerService',function($http,$rootScope){

    var fact ={
        user:{
            token : -1
        },
        login: function (user) {
            $http.post("/getToken", user)
                .then(function (data, status, headers, config) {
                    //fact.user.token = data.data;
                    $rootScope.user.token = data.data;
                    $rootScope.$broadcast('userLogin:updated');

                }, function (error) {
                    console.log(error.data)
                })
        },
        register: function (user) {
            $http.post("/register", user)
                .then(function (data, status, headers, config) {
                }, function (error) {
                    console.log(error.data)
                })
        }
    }
    return fact;
});