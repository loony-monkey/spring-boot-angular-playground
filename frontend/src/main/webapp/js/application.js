var springFun = angular.module('springAngularApplication', ['ngRoute', 'springAngularController']);

springFun.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when("/list", {
            templateUrl: 'templates/list.html',
            controller: 'WeightHistoryController'
        }).
        when('/graph', {
            templateUrl: 'templates/graph.html',
            controller: 'WeightGraphController'
        }).
        when('/about', {
            templateUrl: 'templates/about.html'
        }).
        otherwise({
            redirectTo: '/list'
        });
}]);
