(function($) {
    $('.input-number').each(function() {
        var $this = $(this),
            $input = $this.find('input[type="number"]'),
            up = $this.find('.qty-up'),
            down = $this.find('.qty-down');

        down.on('click', function () {
            var itemID = $input.attr('id');
            var value = parseInt($input.val()) - 1;
            value = value < 1 ? 1 : value;
            $input.val(value);
            $input.change();
            $.ajax({
                type: "POST",
                url: "cart",
                data: { qty: value, itemId: itemID, operation: "update" },
                success: function() {
                    location.reload();
                }
            });
        });

        up.on('click', function () {
            var itemID = $input.attr('id');
            var value = parseInt($input.val()) + 1;
            $input.val(value);
            $input.change();
            $.ajax({
                type: "POST",
                url: "cart",
                data: { qty: value, itemId: itemID, operation: "update" },
                success: function() {
                    location.reload();
                }
            });
        })
    });
    $('.btn').on('click', function () {
        var value = $(this).val();
        $.ajax({
            type: "POST",
            url: "cart",
            data: { itemId: value, operation: "remove" },
            success: function() {
                location.reload();
            }
        });
    })
})(jQuery);