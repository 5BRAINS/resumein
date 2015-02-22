app.config(RoutersConfig);

RoutersConfig.$inject = ["$routeProvider", "$locationProvider"];

function RoutersConfig($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);

    $routeProvider
        .when("/", {
            templateUrl: "views/home.html",
            controller: "HomeController"
        })
        .when("/edit", {
            templateUrl: "views/cv_edit.html",
            controller: "HomeController"
        })
        .when("/:resumeId", {
            templateUrl: "views/cv_preview.html",
            controller: "HomeController",
            resolve: {
                checkHasCv: checkHasCv
            }
        });

}

checkHasCv.$inject = ["$q", "$location", "resumeService"];

function checkHasCv($q, $location, resumeService) {
    var defer = $q.defer();
    if (!resumeService.hasUserCv()) {
        $location.path("/edit");
    }
    defer.resolve();
    return defer.promise;
}