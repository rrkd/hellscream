jQuery(document).ready(function ($) {
    $('#searchMerchantBtn').click(function(){
        window.location.href="/search?suburb=" + $('#searchLocalTxt').val().split(" ").join("-") + "&q=&category=" + $('#searchMerchantCategoryTxt').val().split(" ").join("-");
    });
    $('#postQuoteBtn').click(function(){
        window.location.href="/quote/c";
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