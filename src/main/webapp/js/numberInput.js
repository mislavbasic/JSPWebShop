(function($) {
    $('.input-number').each(function() {
        var $this = $(this),
            $input = $this.find('input[type="number"]'),
            up = $this.find('.qty-up'),
            down = $this.find('.qty-down');

        down.on('click', function () {
            var value = parseInt($input.val()) - 1;
            value = value < 1 ? 1 : value;
            $input.val(value);
            $input.change();
        });

        up.on('click', function () {
            var value = parseInt($input.val()) + 1;
            $input.val(value);
            $input.change();
        })
    });
})(jQuery);