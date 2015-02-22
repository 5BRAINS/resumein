app.controller("EditController", EditController);

EditController.$inject = ["$scope", "resumeService"];

function EditController($scope, resumeService) {
    $scope.education = true;
    $scope.skills = true;
    $scope.work_history = true;
    $scope.contacts = true;
    $scope.headline = true;

    $scope.info = {};

    $scope.loadFromLinkedIn = function() {
        console.log("test");
        resumeService.getUserInfo().then(function(data) {
            $scope.info = data;
        })
    }

    $scope.userAuthorized = authService.isUserAuthorized();
    $scope.signOut = function() {
        authService.signOut();
        location.reload();
    };
}