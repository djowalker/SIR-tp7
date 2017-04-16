'use strict';

/**
 * @ngdoc function
 * @name tp7Yeoman.controller:ListHomesCtrl
 * @description
 * # ListHomesCtrl
 * Controller of the tp7Yeoman
 */
angular.module('tp7Yeoman')
  .controller('ListHomesCtrl', function ($scope,FactoryHome) {
  	$scope.homes=[];
  	var res= FactoryHome.query(function(){
  		for(var i=0;i<res.length;i++){
        console.log(res[i]);
  			$scope.homes.push({"address":res[i]['address'],"town":res[i]['town'],"rooms":res[i]['room'],"surface":res[i]['surface']});
  		}
  	});
  });


 angular.module('tp7Yeoman').factory('FactoryHome', function($resource) {
  return $resource("rest/home/list");
});
