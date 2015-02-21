app.config(RoutersConfig);

RoutersConfig.$inject = ["$routeProvider", "$locationProvider"];

function RoutersConfig($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);

    $routeProvider
        .when("/home", {
            templateUrl: "views/home.html",
            controller: "HomeController"
        })
        .otherwise({
            redirectTo: "/"
        });
}
