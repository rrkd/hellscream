jQuery(document).ready(function ($) {
    $('#contactUsForm').submit(function(e){
        e.preventDefault();
        $.ajax({
            type:"POST",
            url:"/ws/email/contactUs",
            data:generateContactUsEmail(),
            contentType:'application/json',
            success:function (data) {
                if (data.status == 'OK') alert('Email has been Send.');
                else alert('Failed send email: ' + data.status + ', ' + data.errorMessage);
            }
        });
    });

});

function generateContactUsEmail() {
    var emailVO = {
        userEmail:$('#email').val(),
        name:$('#name').val(),
        content:$('#message').val()
    };
    return JSON.stringify(emailVO);
}
