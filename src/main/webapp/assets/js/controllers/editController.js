app.controller("EditController", EditController);

EditController.$inject = ["$scope"];

function EditController($scope) {
    $scope.education = true;
    $scope.skills = true;
    $scope.work_history = true;
    $scope.contacts = true;
    $scope.headline = true;
}