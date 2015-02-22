app.controller("PreviewController", PreviewController);

PreviewController.$inject = ["$scope"];

function PreviewController($scope) {
    $scope.education = true;
    $scope.skills = true;
    $scope.work_history = true;
    $scope.contacts = true;
    $scope.headline = true;
}