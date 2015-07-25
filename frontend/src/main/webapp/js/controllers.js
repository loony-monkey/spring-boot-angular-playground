var springAngularControllers = angular.module('springAngularControllers', []);

springAngularControllers.controller('WeightHistoryController', function($scope, $http) {

    $scope.weightTable = {
        enableSorting: true,
        columnDefs: [
             {name: 'Date', field: 'date', enableColumnMenu: false },
             {name: 'Weight', field: 'weight', enableColumnMenu: false, cellFilter: 'number:1'}
          ]
    };

    $http.get('/weight/history').success(
            function(data, status, headers, config) {
                $scope.weightTable.data = data;
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
