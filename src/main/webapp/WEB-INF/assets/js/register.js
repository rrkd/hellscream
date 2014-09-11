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
        address1:$('#address1').val(),
        address2:$('#address2').val(),
        address3:$('#address3').val(),
        mobile:$('#mobile').val(),
        surname:$('#surname').val()
    };
    return JSON.stringify(user);
}
