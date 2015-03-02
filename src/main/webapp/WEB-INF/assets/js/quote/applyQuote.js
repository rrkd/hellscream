jQuery(document).ready(function ($) {
    $('#successDlg').appendTo('body');

    $('#type_select').select2({
        placeholder:"Type Select"
    });

    prettyPrint();

    $("#rawDay,#rawPrice").jqBootstrapValidation(
        {
            preventSubmit: true,
            submitError: function($form, event, errors) {
                // Here I do nothing, but you could do something like display
                // the error messages to the user, log, etc.
            },
            submitSuccess: function($form, event) {
                $.ajax({
                    type:"POST",
                    url:"/ws/quoteTransaction/" + $('#keyString').val(),
                    data:generateQuoteTransaction(),
                    contentType:'application/json',
                    success:function (data) {
                        if (data.status == 'OK') {
                            $('#successDlg').modal({
                                backdrop: 'static',
                                keyboard: false
                            });
                            $('#merchantRsgErrorBox').hide();
                        }
                        else {
                            $('#merchantRsgErrorBox').show();
                            $('#merchantRsgErrorBox').text(data.errorMessage);
                        }
                    }
                });

                event.preventDefault()
            },
            filter: function() {
                return $(this).is(":visible");
            }
        }
    );

    $('.faqs dd').hide(); // Hide all DDs inside .faqs

    $('.faqs dt').hover(function(){$(this).addClass('hover')},function(){$(this).removeClass('hover')}).click(function(){ // Add class "hover" on dt when hover

        $(this).next().slideToggle('normal'); // Toggle dd when the respective dt is clicked

    });
});

function generateQuoteTransaction() {
    var quoteTransaction = {
        rawPrice:parseFloat($('#rawPrice').val()),
        rawDay:parseInt($('#rawDay').val()),
        serviceType:$('#type_select').select2('data').id,
        merchantKeyString:$('#merchantKeyString').val(),
        comment:$('#description').val()
    };
    return JSON.stringify(quoteTransaction);
}
