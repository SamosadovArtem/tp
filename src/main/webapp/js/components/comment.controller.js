ticketApp.controller('CommentController', function ($scope, Comment) {

    var eventIdParam = location.search.split('eventId=')[1];
    $scope.comments = Comment.query({eventId:eventIdParam});
    $scope.commentsCount = $scope.comments.length;

    $scope.getComments = function () {
        console.log(eventIdParam);
    };

    $scope.addComment = function (userName) {

        console.log(angular.element('#commentField').val());

        var commentInput = angular.element('#commentField');
        var commentText = commentInput.val();

        console.log('CommentSaving');

        console.log(commentInput);

        var commentToSave = createComment(commentText, userName);

        Comment.save(commentToSave, function () {
            $scope.comments = Comment.query({eventId:eventIdParam});
            $scope.commentsCount = $scope.comments.length;
            commentInput.value = "";
            console.log('Comment callback');
        });
    };

    var createComment = function (commentText,userName) {

        if(userName != null || userName != undefined) {
            console.log('CommentCreating');
            var newComment = new Object();
            newComment.event = eventIdParam;
            newComment.text = commentText;
            newComment.username = userName;
            newComment.commentDate = new Date();
            console.log(newComment);
            return newComment;
        } else {
            return null;
        }
    }

});