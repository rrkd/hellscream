jQuery(document).ready(function ($) {
    initLatestMerchant($);
    initLatestFeedbackQuoteMsg($);
    initLatestQuote($);
});

function initLatestMerchant($) {
    $.ajax({
        type:"GET",
        url:"/ws/merchant/latest",
        data:{},
        contentType:'application/json',
        success:function (data) {
            if (!$.isEmptyObject(data)) {
                $('#latestMerchantContain').append('<p>' +
                    '<a href="/merchant/details/'+data.url+'">'+data.tradeName+'</a><br/>' +
                    '<span>'+data.shortDesc+'</span>' +
                    '</p>');
                $('#latestComment').text(data.comment)
                $('#testimonialName').text(data.userName);
                var merchantLink = $("<a href='merchant/details/" + data.canonicalSlugId + "'>" + data.merchantTradeName + "</a>")
                $('#feedbackMerchant').append(merchantLink);
            }
        }
    });
}

function initLatestFeedbackQuoteMsg($) {
    $.ajax({
        type:"GET",
        url:"/ws/fd/m/latest",
        data:{},
        contentType:'application/json',
        success:function (data) {
            if (!$.isEmptyObject(data)) {
                $('#latestComment').text(data.comment)
                $('#testimonialName').text(data.userName);
                var merchantLink = $("<a href='merchant/details/" + data.canonicalSlugId + "'>" + data.merchantTradeName + "</a>")
                $('#feedbackMerchant').append(merchantLink);
            }
        }
    });
}

function initLatestQuote($) {
    $.ajax({
        type:"GET",
        url:"/ws/ss/latestQuote",
        data:{},
        contentType:'application/json',
        success:function (data) {
            if (!$.isEmptyObject(data)) {
                for (var i = 0; i < data.length; i++) {
                    $('#latestQuoteContainer').append(
                        '<li class="clearfix">' +
                            '<a href="#"><img src="img/demo/300x200.png" class="attachment-thumbnail" alt=""></a>' +
                            '<a href="/quote/d/' + data[i].key + '">' + data[i].title + '</a><br>' +
                            '<small><a href="#"><span class="entry-date">' + data[i].postDate + '</span></a></small>' +
                            '</li>');
                }
            }
        }
    });
}