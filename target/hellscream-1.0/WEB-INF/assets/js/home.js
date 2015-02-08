jQuery(document).ready(function ($) {
    $('#searchMerchantBtn').click(function(){
        window.location.href="/search?local=" + $('#searchLocalTxt').val().split(" ").join("-") + "&q=" + $('#searchMerchantKeyTxt').val().split(" ").join("-");
    });
    $.ajax({
        type:"GET",
        url:"/ws/st/home",
        data:"",
        success:function (data) {
            $('#merchantCount').html(data.merchantCount);
            $('#commentCount').html(data.msgCount);
            $('#quoteCount').html(data.quoteCount);
            $('#feedbackCount').html(data.feedbackCount);
        }
    });
});