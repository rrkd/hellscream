jQuery(document).ready(function ($) {
    $('#create_user').click(function () {
        $.ajax({
            type:"POST",
            url:"/ws/user",
            data:generateUser(),
            contentType:'application/json',
            success:function (data) {
                if (data.status == 'OK') alert('User has been added');
                else alert('Failed create user: ' + data.status + ', ' + data.errorMessage);
            }
        });
    });
});

function generateUser() {
    var user = {
        email:$('#email').val(),
        nickname:$('#nickname').val(),
        forename:$('#forename').val(),
        surname:$('#surname').val()
    };
    return JSON.stringify(user);
}
