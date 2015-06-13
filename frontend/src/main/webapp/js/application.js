var springFun = angular.module('springAngularApplication', ['ngRoute', 'springAngularController']);

springFun.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when("/list", {
            templateUrl: 'templates/list.html',
            controller: 'MessagesController'
        }).
        when('/about', {
            templateUrl: 'templates/about.html'
        }).
        otherwise({
            redirectTo: '/list'
        });
}]);