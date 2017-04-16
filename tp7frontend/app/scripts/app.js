'use strict';

/**
 * @ngdoc overview
 * @name tp7Yeoman
 * @description
 * # tp7Yeoman
 *
 * Main module of the application.
 */
angular
  .module('tp7Yeoman', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/list', {
        templateUrl: 'views/ListHomes.html',
        controller: 'ListHomesCtrl',
        controllerAs: 'listHomes'
      })
      .when('/', {
        templateUrl: 'views/addHome.html',
        controller: 'AddHomesCtrl',
        controllerAs: 'addHome'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
