jQuery(document).ready(function ($) {
    $('#sendContactEmail').click(function(){
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
        userEmail:$('#userEmailTxt').val(),
        name:$('#nameTxt').val(),
        content:$('#contactUsContent').val()
    };
    return JSON.stringify(emailVO);
}