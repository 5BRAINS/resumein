app.config(RoutersConfig);

RoutersConfig.$inject = ["$routeProvider", "$locationProvider"];

function RoutersConfig($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);

    $routeProvider
        .when("/", {
            templateUrl: "views/cv_preview.html",
            controller: "HomeController"
        })

        .otherwise({
            redirectTo: "/"
        });
}
