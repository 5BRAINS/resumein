<!DOCTYPE html>
<html ng-app="MainApp">
<head>
    <title>ResumeIn</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <base href="/">
    <!-- Bootstrap -->
    <link href="/bower_components/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="assets/css/freelancer.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>

<ng-view></ng-view>

<!-- Angular -->
<script src="/bower_components/angular/angular.js"></script>
<script src="/bower_components/angular-route/angular-route.js"></script>
<script src="/bower_components/angular-cookies/angular-cookies.js"></script>

<script src="/bower_components/angular-bootstrap/ui-bootstrap.js"></script>

<!-- Angular Application -->
<script src="/assets/js/app.js"></script>
<script src="/assets/js/routers.js"></script>

<!-- Controllers -->
<script src="/assets/js/controllers/homeController.js"></script>
<script src="/assets/js/controllers/editController.js"></script>
<script src="/assets/js/controllers/previewController.js"></script>

<!-- Services -->
<script src="/assets/js/services/authService.js"></script>
<script src="/assets/js/services/resumeService.js"></script>

<!-- Directives -->
<script src="/assets/js/directives/compile.js"></script>

</body>
</html>