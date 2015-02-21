app.factory("authService", authService);

authService.$inject = ["$http", "$cookies", "$cookieStore"];

function authService($http, $cookies, $cookieStore) {
    return {
        isUserAuthorized: function() {
            console.log($cookies["access_token"]);
            console.log($cookieStore.get("access_token"));
            console.log($cookies)
        }
    }
}