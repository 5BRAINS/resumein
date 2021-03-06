app.factory("resumeService", resumeService);

resumeService.$inject = ["$http"];

function resumeService($http) {
    return {
        getCvUrl: function() {
            return $http.get("/rest/get_short_url").then(function(response) {
                return response.data;
            });
        },

        hasUserCv: function() {
            // todo
            return false;
        },

        getUserInfo: function() {
            return $http.get("/rest/get_user_info").then(function(response) {
                return response.data;
            })
        },

        getUserName: function() {
            return $http.get("/rest/get_user").then(function(response) {
                return response.data;
            });
        },

        saveCv: function(userInfo) {
            return $http.post("/rest/save_resume", "user_info=" + userInfo + "&name='1'&template_id=1").then();
        }
    }
}