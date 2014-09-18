jQuery(document).ready(function ($) {
    $('#searchMerchantBtn').click(function(){
        window.location.href="/search?local=" + $('#searchLocalTxt').val().split(" ").join("-") + "&q=" + $('#searchMerchantKeyTxt').val().split(" ").join("-");
    });

});