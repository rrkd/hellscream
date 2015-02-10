
jQuery(document).ready(function ($) {
    $('#successDlg').appendTo('body');

    $("#postQuoteForm").submit(function(e) {
        e.preventDefault();
    });

    prettyPrint();

    $("#quoteTitle, #description, #email").jqBootstrapValidation(
        {
            preventSubmit: true,
            submitError: function($form, event, errors) {
                // Here I do nothing, but you could do something like display
                // the error messages to the user, log, etc.
            },
            submitSuccess: function($form, event) {
                $.ajax({
                    type:"POST",
                    url:"/ws/quote/" + $('#merchantKeyString').val(),
                    data:generateQuote(),
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

    $("#postQuoteForm").submit(function(e) {
        e.preventDefault();
    });
});

function generateQuote() {
    var suburb = null;

    var quote = {
        clientUserEmail:$('#email').val(),
        title:$('#quoteTitle').val(),
        description:$('#description').val(),
        suburbKey:suburb,
        categoryList:[]
    };

    return JSON.stringify(quote);
}


