jQuery(document).ready(function ($) {
    $('#sendFeedbackEmail').click(function(){
        $.ajax({
            type:"POST",
            url:"/ws/email/feedback",
            data:generateFeedbackEmail(),
            contentType:'application/json',
            success:function (data) {
                if (data.status == 'OK') alert('Email has been Send.');
                else alert('Failed send email: ' + data.status + ', ' + data.errorMessage);
            }
        });
    });

});

function generateFeedbackEmail() {
    var emailVO = {
        userEmail:$('#feedbackNameTxt').val(),
        name:$('#feedbackEmailTxt').val(),
        content:$('#feedbackContent').val()
    };
    return JSON.stringify(emailVO);
}