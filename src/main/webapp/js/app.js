var app = angular.module("geektic", ['ngRoute']);



app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/geek').success(function(listGeeks) {
        $scope.listGeeks = listGeeks;
    });


  $scope.Search = function() {
	  $http.get("/api/geek/search", {params: {query: $scope.name}}).then(function(response) {
		   $scope.geeks = response.data;
	  });
  };
});
