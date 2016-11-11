ticketApp.service('Comment', function ($resource) {
    return $resource('/api/v1/comments/:id', { id:'@id' }, {
        update: {method: 'PUT'},
        query: {method: 'GET', isArray: true},
        get: {method: 'GET'},
        delete: {method: 'DELETE'},
        save:{method:'POST'}
    })
});