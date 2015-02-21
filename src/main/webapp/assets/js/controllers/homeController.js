app.controller("HomeController", HomeController);

HomeController.$inject = ["$scope", "authService"];

function HomeController($scope, authService) {
    $scope.userAuthorized = authService.isUserAuthorized();

    $scope.signOut = function() {
        authService.signOut();
        location.reload();
    }
}