app.controller("HomeController", HomeController);

HomeController.$inject = ["$scope", "authService", "$http"];

function HomeController($scope, authService, $http) {
    $scope.userAuthorized = authService.isUserAuthorized();

    $scope.signOut = function() {
        authService.signOut();
        location.reload();
    };

    $scope.test = function() {
        $http.post("/rest/save_pdf", {"html": document.documentElement.outerHTML});
    }
}