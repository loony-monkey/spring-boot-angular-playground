var springFunControllers = angular.module('springAngularController', []);

springFunControllers.controller('MessagesController', function($scope, $http) {
    $scope.messages = [];

    // $http.get('/message/all').success(function (data, status, headers,
    // config) {
    // $scope.messages = data;
    // }).error(function (data, status, headers, config) {
    // $scope.errorMessage = "Can't retrieve messages list!";
    // });
    single_message = {
        "id" : "123",
        "name" : "Test"
    }
    $scope.messages.push(single_message)

});
