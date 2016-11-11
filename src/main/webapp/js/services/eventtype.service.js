ticketApp.service('EventType', function ($resource) {
    return $resource('/api/v1/eventtypes/:id', { id:'@id' }, {
        update: {method: 'PUT'},
        query: {method: 'GET', isArray: true},
        get: {method: 'GET'},
        delete: {method: 'DELETE'}
    })
});