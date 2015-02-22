app.factory("resumeService", resumeService);

resumeService.$inject = ["$http"];

function resumeService($http) {
    return {
        getCvUrl: function() {
            return $http.get("/rest/get_short_url").then(function(response) {
                return response.data;
            });
        }
    }
}