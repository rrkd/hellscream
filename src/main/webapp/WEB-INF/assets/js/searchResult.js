var keyword = "";
var suburb = "";
var size = 5;
var currentIndex = 1;
jQuery(document).ready(function ($) {
    keyword = getUrlParameter('q');
    suburb = getUrlParameter('local');
    initRank();
    initSearchResult();
    $('#loadMore').click(function () {
        currentIndex = currentIndex + size;
        loadDate(currentIndex, size);
    });

});

function initRank() {
    $('.merchant-rank').raty({readOnly: true});
    $('.merchant-rank').each(function () {
        $(this).raty('score', $(this).attr("data-rank"));
    });
}

function initSearchResult() {
    loadDate(currentIndex, size)
}

function loadDate(from, size) {
    $.ajax({
        type:"GET",
        url:"/ws/search?q=" + keyword + "&local=" + suburb + "&from=" + from + "&size=" + size,
        success:function (data) {
            appendToResultBox(data);
        }
    });
}

function appendToResultBox(data) {
    if (data.length <=0 ) {
        $("#loadMore").prop('disabled', true);
    }
    for (var i = 0; i < data.length; i++) {
        $('#resultContainer').append('<div class="hero-unit">' +
            '<h5><a href="#">' + data[i].tradeName + '</a></h5>' +
            '<div class="merchant-rank" data-rank="' + data[i].rank + '"></div>' +
            '<p class="small datepost">' +
            'Posted on ' + data[i].postDate +
            '<span class="floatright"title="3 responses"><a href="#"><img src="/assets/img/comments.png" alt=""></a></span>' +
            '</p>' +
            '<div class="innerblogboxtwo">' +
            '<p>' +
            '<img width="150" height="150" src="'+data[i].imageFileName+'" class="attachment-thumbnail" alt="">' + data[i].shortDesc +
            '</p>' +
            '</div>' +
            '<p class="continueread readmorebox">' +
            '<a href="merchant/details/' + data[i].url + '">Details</a>' +
            '</p>'
            + '</div>');
    }
    initRank();
}