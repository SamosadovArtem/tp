$('#priceInput').keypress(function (event) {
    var keycode = event.which;
    if (!(event.shiftKey == false && (keycode == 46 || keycode == 8 || keycode == 37 || keycode == 39 || (keycode >= 48 && keycode <= 57)))) {
        this.setCustomValidity('only numbers');
    } else {
        this.setCustomValidity('');
    }
});
