app.factory("authService", authService);

authService.$inject = ["$http", "$cookies", "$cookieStore"];

function authService($http, $cookies, $cookieStore) {
    return {
        isUserAuthorized: function() {
            return $cookies["access_token"] != undefined;
        },

        signOut: function() {
            $cookieStore.remove("access_token");
        }
    }
}