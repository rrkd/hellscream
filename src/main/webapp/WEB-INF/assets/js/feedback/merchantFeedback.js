jQuery(document).ready(function ($) {
    $('#rankBox').raty();
    $("#email,#userName, #comment").jqBootstrapValidation(
        {
            preventSubmit: true,
            submitError: function($form, event, errors) {
                // Here I do nothing, but you could do something like display
                // the error messages to the user, log, etc.
            },
            submitSuccess: function($form, event) {
                $.ajax({
                    type:"POST",
                    url:"/ws/fd/m/"+$('#keyString').val(),
                    data:generateFeedbackMsg(),
                    contentType:'application/json',
                    success:function (data) {
                        if (data.status == 'OK') {
                            alert('You feedback has been submit');
                            $('#merchantRsgErrorBox').hide();
                        }
                        else {
                            $('#merchantRsgErrorBox').show();
                            $('#merchantRsgErrorBox').text(data.errorMessage);
                        }
                    }
                });

                event.preventDefault();
            },
            filter: function() {
                return $(this).is(":visible");
            }
        }
    );
});
function generateFeedbackMsg() {
    var msg = {
        userEmail:$('#email').val(),
        userName:$('#userName').val(),
        comment:$('#comment').val(),
        rank:$('#rankBox').raty('score')
    };
    return JSON.stringify(msg);
}