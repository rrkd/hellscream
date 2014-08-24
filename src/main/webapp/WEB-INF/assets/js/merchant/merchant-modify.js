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