jQuery(document).ready(function ($) {
    $('#login_btn').click(function () {
        $(this).val("checking...");
        $(this).attr("disabled", true);
        $.ajax({
            type:"POST",
            url:"/ws/au/logincheck",
            contentType:'application/json',
            data:generateLoginVO(),
            success:function (data) {
                if (data.status == 'OK') {
                    $('#merchantRsgErrorBox').hide();
                    $.form(
                        '/loginrd',
                        {
                            username:$('#username').val(),
                            password:sha256_digest($('#password').val())
                        },
                        'POST').submit();
                }
                else {
                    $('#merchantRsgErrorBox').show();
                }
            }
        });
    })
});

function generateLoginVO() {
    var loginVO = {
        username:$('#username').val(),
        password:sha256_digest($('#password').val())
    };
    return JSON.stringify(loginVO);
}