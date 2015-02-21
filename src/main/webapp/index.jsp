<!DOCTYPE html>
<html ng-app="MainApp">
<head>
    <title>ResumeIn</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <base href="/">
    <!-- Bootstrap -->
    <link href="bower_components/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="assets/css/freelancer.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    </head>
<body>

<ng-view></ng-view>

<!-- Angular -->
<script src="bower_components/angular/angular.js"></script>
<script src="bower_components/angular-route/angular-route.js"></script>

<!-- Angular Application -->
<script src="assets/js/app.js"></script>
<script src="assets/js/routers.js"></script>

<!-- Controllers -->
<script src="assets/js/controllers/homeController.js"></script>

</body>
</html>