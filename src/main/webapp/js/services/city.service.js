ticketApp.service('City', function ($resource) {
    return $resource('/api/v1/cities/:id', { id:'@id' }, {
        update: {method: 'PUT'},
        query: {method: 'GET', isArray: true},
        get: {method: 'GET'},
        delete: {method: 'DELETE'}
    })
});