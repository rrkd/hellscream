jQuery(document).ready(function ($) {
    $('#successDlg').appendTo('body');

    prettyPrint();

    $("#nickname, #forename, #surname,#address1,#address2,#address3").jqBootstrapValidation(
        {
            preventSubmit: true,
            submitError: function($form, event, errors) {
                // Here I do nothing, but you could do something like display
                // the error messages to the user, log, etc.
            },
            submitSuccess: function($form, event) {
                $.ajax({
                    type:"PUT",
                    url:"/ws/user/" + $('#userKeyString').val(),
                    data:generateUser(),
                    contentType:'application/json',
                    success:function (data) {
                        if (data.status == 'OK') {
                            $('#userRsgErrorBox').hide();
                            $('#successDlg').modal({
                                backdrop: 'static',
                                keyboard: false
                            });
                        }
                        else {
                            $('#userRsgErrorBox').show();
                            $('#userRsgErrorBox').text(data.errorMessage);
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

function generateUser() {
    var user = {
        email:$('#email').val(),
        nickname:$('#nickname').val(),
        forename:$('#forename').val(),
        address1:$('#address1').val(),
        address2:$('#address2').val(),
        address3:$('#address3').val(),
        mobile:$('#mobile').val(),
        surname:$('#surname').val()
    };
    return JSON.stringify(user);
}
