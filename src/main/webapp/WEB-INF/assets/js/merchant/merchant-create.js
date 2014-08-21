jQuery(document).ready(function ($) {
    $('#create_merchant').click(function () {
        $.ajax({
            type:"POST",
            url:"/ws/merchant",
            data:generateMerchant(),
            contentType:'application/json',
            success:function (data) {
                if (data.status == 'OK') alert('Merchant has been added');
                else alert('Failed adding merchant: ' + data.status + ', ' + data.errorMessage);
            }
        });
    });
});

function generateMerchant() {
    return JSON.stringify({
        tradeName:$('#tradeName').val(),
        merchantName:$('#merchantName').val(),
        description:$('#description').val(),
        address1:$('#address1').val(),
        address2:$('#address2').val(),
        address3:$('#address3').val(),
        email:$('#email').val(),
        phone:$('#phone').val(),
        mobile:$('#mobile').val(),
        contact1:$('#contact1').val(),
        contact2:$('#contact2').val()
    });
}