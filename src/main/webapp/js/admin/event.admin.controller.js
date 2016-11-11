ticketApp.controller('EventAdminController', function ($scope, Event, City, Place, EventType) {

    $scope.events = Event.query();
    $scope.cities = City.query();
    $scope.places = Place.query();
    $scope.allEventTypes = EventType.query();

    $scope.getCurrentEvent = function (event) {
        $scope.currentEvent = event;
    };
    $scope.changePlace = function (newPlace) {
        $scope.currentEvent.place = newPlace;
    };
    $scope.putEventToDataBase = function () {
        if (!$scope.currentEvent.id) {
            Event.save($scope.currentEvent, function () {
                $scope.events = Event.query();
            });
        } else {
            Event.update($scope.currentEvent, function () {
                $scope.events = Event.query();
            });
        }
        $('#myModal').modal('hide');
    };
    $scope.deleteEvent = function (event) {
        Event.delete(event, function () {
            $scope.events = Event.query();
        });
    };
    $scope.getEmptyEvent = function () {
        $scope.currentEvent = {
        };
    };

    $scope.getDublicateEvent = function (userEvent) {
        $scope.currentEvent = angular.copy(userEvent);

    };
});