jQuery(document).ready(function ($) {
    $('#applyQuote').click(function () {
        $.ajax({
            type:"POST",
            url:"/ws/quoteTransaction/" + $('#keyString').val(),
            data:generateQuoteTransaction(),
            contentType:'application/json',
            success:function (data) {
                if (data.status == 'OK') alert('Your application has been saved.');
                else alert('Failed adding merchant: ' + data.status + ', ' + data.errorMessage);
            }
        });
    });

    $('#type_select').select2({
        placeholder:"Type Select"
    });
});

function generateQuoteTransaction() {
    var quoteTransaction = {
        rawPrice:parseFloat($('#rawPrice').val()),
        rawDay:parseInt($('#rawDay').val()),
        serviceType:$('#type_select').select2('data').text,
        merchantKeyString:$('#merchantKeyString').val(),
        comment:$('#description').val()
    };
    return JSON.stringify(quoteTransaction);
}
