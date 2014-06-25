var app = angular.module("geektic", ['ngRoute', 'ui.gravatar']);

app.config(function($routeProvider){
	$routeProvider.when("/acc1",
		{templateUrl: "accueil.html",
		controller : "ListeCtrl"}
	).when("/acc2",
		{templateUrl: "cherche.html",
		controller : "MainCtrl"}
	);
});


app.controller('ListeCtrl', function($scope, $http) {
    $http.get('/api/geek').success(function(listGeeks) {
        $scope.listGeeks = listGeeks;
    });
});
app.controller('MainCtrl', function($scope, $http) {
  $scope.Search = function() {
	  $http.get("/api/geek/search", {params: {query: $scope.name}}).then(function(response) {
		   $scope.geeks = response.data;
	  });
  };
 $scope.voir = function(geek) {
	  $http.get("/api/geek/voir", {params: {id: geek.id}}).then(function(response) {
		   $scope.leGeek = response.data;
	  });
	}
  
});
