var app = angular.module('fpl-app', ['ngResource']);

app.controller("PlayerController", [ '$scope', '$resource',
                                function($scope, $resource) {
        var Player = $resource('/player/:name', {name:'@name'});
        Player.get( {name:"Emre Can"}, function(player) {
            $scope.player = user;
        });
}]);