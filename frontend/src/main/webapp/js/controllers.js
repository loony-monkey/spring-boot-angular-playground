var springAngularControllers = angular.module('springAngularController', []);

springAngularControllers.controller('WeightHistoryController', function($scope,
        $http) {
    $scope.entries = [];

    $http.get('/weight/history').success(
            function(data, status, headers, config) {
                $scope.entries = data;
            }).error(function(data, status, headers, config) {
        $scope.errorMessage = "Can't retrieve weight history! (" + status + ")";
    });
    // single_entryy = {
    // "id" : "123",
    // "name" : "Test"
    // }
    // $scope.entries.push(single_message)

});
