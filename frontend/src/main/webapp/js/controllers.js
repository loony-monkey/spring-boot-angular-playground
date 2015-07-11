var springAngularControllers = angular.module('springAngularController', []);

springAngularControllers.controller('WeightHistoryController', function($scope,
        $http) {
    $scope.entries = [];

    $http.get('/weight/history').success(
            function(data, status, headers, config) {
                $scope.entries = data;
            }).error(
            function(data, status, headers, config) {
                $scope.errorMessage = "Can't retrieve weight history! ("
                        + status + ")";
            });
});

springAngularControllers.controller('WeightGraphController', function($scope,
        $http) {
    $scope.graph = new Dygraph(document.getElementById("graphdiv"), "weight/data", {
        drawPoints : true,
        pointSize : 2,
        color : 'rgb(0,0,255)',
        showRangeSelector : true,
        rangeSelectorHeight : 30,
        rangeSelectorPlotStrokeColor : 'green',
        rangeSelectorPlotFillColor : 'lightyellow',
    });
});
