app.config(RoutersConfig);

RoutersConfig.$inject = ["$routeProvider", "$locationProvider"];

function RoutersConfig($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);

    $routeProvider
        .when("/", {
            templateUrl: "views/home.html",
            controller: "HomeController"
        })
        .when("/preview", {
            templateUrl: "views/home.html",
            controller: "HomeController"
        })
        .when("/edit", {
            templateUrl: "views/home.html",
            controller: "HomeController"
        });
}
