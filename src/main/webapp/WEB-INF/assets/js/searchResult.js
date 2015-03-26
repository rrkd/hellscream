var keyword = "";
var suburb = "";
var category = "";
var size = 5;
var currentIndex = 1;
jQuery(document).ready(function ($) {
    keyword = getUrlParameter('q') === undefined ? "" : getUrlParameter('q');
    suburb = getUrlParameter('suburb') === undefined ? "" : getUrlParameter('suburb');
    category = getUrlParameter('category') === undefined ? "" : getUrlParameter('category');
    initRank();
    initSearchResult();
    initSuburb();
    $('#loadMore').click(function () {
        currentIndex = currentIndex + size;
        loadDate(currentIndex, size);
    });

    $('#filterCategory').select2({
        placeholder:"Category Select",
        allowClear: true
    });

    $('#filterSuburb').select2({
        placeholder:"Suburb Select",
        allowClear: true,
        minimumInputLength: 3,
        ajax: { // instead of writing the function to execute the request we use Select2's convenient helper
            url: "/ws/geo/suburb",
            dataType: 'json',
            data: function (term, page) {
                return {
                    q: term,
                    page:page
                };
            },
            results: function (data, page) { // parse the results into the format expected by Select2.
                // since we are using custom formatting functions we do not need to alter remote JSON data
                return {results: data.suburbVOList};
            }
        }
    });

    prettyPrint();

    $('#filterBtn').click(function(){
        var filterWord = $('#filterWord').val().split(" ").join("-");
        var filterSuburb = "";
        var filterCategory = "";
        if ($('#filterSuburb').select2('data') != null) {
            filterSuburb = $('#filterSuburb').select2('data').id;
        }
        if ($('#filterCategory').select2('data') != null) {
            filterCategory = $('#filterCategory').select2('data').id;
        }
        window.location.href = "/search?q=" + filterWord + "&suburb=" + filterSuburb + "&category=" + filterCategory;
    });

});

function initRank() {
    $('.merchant-rank').raty({
        score: function () {
            return $(this).attr('data-rank');
        },
        readOnly: true
    });
}

function initSearchResult() {
    loadDate(currentIndex, size)
}

function loadDate(from, size) {
    $.ajax({
        type:"GET",
        url:"/ws/search?q=" + keyword + "&suburb=" + suburb + "&from=" + from + "&size=" + size + "&category=" + category,
        success:function (data) {
            appendToResultBox(data);
        }
    });
}

function appendToResultBox(data) {
    if (data.length <=0 ) {
        $(".load-more").hide();
    } else {
        $(".load-more").show();
    }
    for (var i = 0; i < data.length; i++) {
        $('#resultContainer').append('<div class="hero-unit">' +
            '<h5><a href="/merchant/details/'+ data[i].canonicalSlugId + '" onmouseover="this.style.textDecoration=\'underline\'"'+ ' onmouseout="this.style.textDecoration=\'none\'"' +
            '>'+ data[i].merchantName + '</a></h5>' +
            '<div class="merchant-rank" data-rank="' + data[i].rank + '"></div>' +
            '<p class="small datepost">' +
            'Posted on ' + formatDate(data[i].postDate) +
            '<span class="floatright"title="3 responses"><a href="#"><img src="/assets/img/comments.png" alt=""></a></span>' +
            '</p>' +
            '<div class="innerblogboxtwo">' +
            '<p>' +
            '<img width="150" height="150" src="'+data[i].imageFileName+'" class="attachment-thumbnail" alt="">' + data[i].shortDesc +
            '</p>' +
            '</div>' +
            '<p class="continueread readmorebox">' +
            '<a href="/merchant/details/' + data[i].url + '">Details</a>' +
            '</p>' +
            '</div>');
    }
    initRank();
}

function initSuburb(){
    if(suburb) {
        $.ajax({
            type:"GET",
            url:"/ws/geo/suburb/" + suburb,
            contentType:'application/json',
            success:function (data) {
                if (data && data.suburbVOList) {
                    if(data.suburbVOList.length > 0){
                        $('#filterSuburb').select2('data',data.suburbVOList[0])
                    }
                }
            }
        });
    }
}