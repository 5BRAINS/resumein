app.controller("EditController", EditController);

EditController.$inject = ["$scope", "resumeService", "authService"];

function EditController($scope, resumeService, authService) {
    $scope.education = true;
    $scope.skills = true;
    $scope.work_history = true;
    $scope.contacts = true;
    $scope.headline = true;

    $scope.loadFromLinkedIn = function() {
        $scope.info = {};

        resumeService.getUserInfo().then(function(data) {
            $scope.info.skills = "";
            for (var i = 0; i < data.skills._total; i++) {
                $scope.info.skills += data.skills.values[i].skill.name + "; "
            }

            $scope.info.work = [];
            for (var i = 0; i < data.threeCurrentPositions._total; i++) {
                $scope.info.work.push(data.threeCurrentPositions.values[i]);
            }
            for (var i = 0; i < data.threePastPositions._total; i++) {
                $scope.info.work.push(data.threePastPositions.values[i]);
            }

            $scope.info.languages = data.languages;
            $scope.info.education = data.educations;
            $scope.info.interests = data.interests;
        });

        resumeService.getUserName().then(function(data) {
            $scope.info.firstName = data.name;
            $scope.info.lastName = data.lastName;
        });

    };

    $scope.userAuthorized = authService.isUserAuthorized();
    $scope.signOut = function() {
        authService.signOut();
        location.reload();
    };

    $scope.save = function() {
        resumeService.saveCv($scope.info);
    }
}