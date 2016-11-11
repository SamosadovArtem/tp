/**
 * Created by Admin on 28.07.2016.
 */

var ticketApp = angular.module('ticketApp', ['ngResource']);

ticketApp.config(function($locationProvider) {
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
});