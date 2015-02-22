app.controller("HomeController", HomeController);

HomeController.$inject = ["$scope", "authService", "resumeService"];

function HomeController($scope, authService, resumeService) {
    $scope.userAuthorized = authService.isUserAuthorized();

    resumeService.getCvUrl().then(function(data) {
        $scope.cvUrl = data;
    });


    $scope.signOut = function() {
        authService.signOut();
        window.location = '/';
    };

}