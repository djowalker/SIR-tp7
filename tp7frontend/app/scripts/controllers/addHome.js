'use strict';

/**
 * @ngdoc function
 * @name tp7Yeoman.controller:AddHomesCtrl
 * @description
 * # AddHomesCtrl
 * Controller of the tp7Yeoman
 */
angular.module('tp7Yeoman')
  .controller('AddHomesCtrl', function (FactoryAddHome,$scope) {
	$scope.town="";
	$scope.address="";
	$scope.rooms="";
  $scope.surface="";

  	$scope.add = function(address,town,rooms,surface) {
  		var newHome = new FactoryAddHome();
      newHome.address=address;
      newHome.town=town;
  		newHome.rooms=rooms;
  		newHome.surface=surface;
      console.log(address + " " + town + " " + rooms + " " + surface + " ");
  		newHome.$save();
  	};

  });

// Le module va communiquer avec la méthode java grâce au path en rest en java
angular.module('tp7Yeoman').factory('FactoryAddHome', function($resource) {
  return $resource("rest/home/addHome");
});
