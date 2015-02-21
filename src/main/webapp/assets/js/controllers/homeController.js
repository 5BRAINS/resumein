app.controller("HomeController", HomeController);

HomeController.$inject = ["$cookies", "authService"];

function HomeController($cookies, authService) {
    authService.isUserAuthorized()
}