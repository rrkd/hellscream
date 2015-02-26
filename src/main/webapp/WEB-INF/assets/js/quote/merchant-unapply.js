var merchantQuoteVOList;
jQuery(document).ready(function ($) {
    initQuoteList();
});

function initQuoteList() {
    loadQuoteList(1);
    return false;
}

function loadQuoteList(pageNumber) {
    var merchantKeyString = $('#merchantKey').val();
    $.ajax({
        type:"GET",
        url:"/ws/quote/unapply/" + merchantKeyString + "/" + pageNumber,
        data:"",
        success:function (data) {
            merchantQuoteVOList = data.voList;
            refreshListAll(data);
        }
    });
}

function refreshListAll(data) {
    refreshListContainer(data);
    refreshPagination(data);
}

function refreshListContainer(searchResult) {
    var dataTableBody = $('#dataTableBody');
    dataTableBody.empty();
    if (searchResult.voList.length > 0) {
        for (var index = 0; index < searchResult.voList.length; index++) {
            var vo = searchResult.voList[index];
            dataTableBody.append('' +
                '<tr>' +
                '<td>' + index + '</td>' +
                '<td>' + vo.quote.title + '</td>' +
                '<td><a href="/quote/d/' + vo.quote.key + '">details</a></td>' +
                '</tr>');
        }
        quoteItemListener();
    }
}

function refreshPagination(searchResult) {
    var paginationBox = $('.pagination-box');
    paginationBox.empty();
    var total = searchResult.total;
    var pageNumber = searchResult.pageNum;
    if (total > 0) {
        // first button
        if (pageNumber == 1) {
            paginationBox.append('<li><a class="paginationTag" href="#" data-page="1"><<</a></li>');
        } else {
            paginationBox.append('<li><a class="paginationTag" href="#" data-page="' + pageNumber - 1 + '"><<</a></li>');
        }
        // middle buttons
        if (total <= 3) {
            for (var i = 0; i < total - 1; i++) {
                var index = i + 1;
                if (i + 1 == pageNumber) {
                    paginationBox.append('<li><a class="active paginationTag" href="#" data-page="' + index + '"><<</a></li>');
                } else {
                    paginationBox.append('<li><a class="paginationTag" href="#" data-page="' + index + '"><<</a></li>');
                }
            }
        } else {
            if (pageNumber <= 3) {
                for (var i = 0; i < 2; i++) {
                    var index = i + 1;
                    if (i + 1 == pageNumber) {
                        paginationBox.append('<li><a class="active paginationTag" href="#" data-page="' + index + '"><<</a></li>');
                    } else {
                        paginationBox.append('<li><a class="paginationTag" href="#" data-page="' + index + '"><<</a></li>');
                    }
                }
            } else {
                for (var i = pageNumber - 2; i < pageNumber; i++) {
                    var index = i + 1;
                    if (i + 1 == pageNumber) {
                        paginationBox.append('<li><a class="active paginationTag" href="#" data-page="' + index + '"><<</a></li>');
                    } else {
                        paginationBox.append('<li><a class="paginationTag" href="#" data-page="' + index + '"><<</a></li>');
                    }
                }
            }
        }
        // the "..." button
        if (pageNumber >= 3) {
            if (pageNumber < total) {
                paginationBox.append('<li><a class="paginationTag" href="#" data-page="' + (pageNumber + 1) + '">...</a></li>');
            }
        } else {
            if (total > 3) {
                paginationBox.append('<li><a class="paginationTag" href="#" data-page="4">...</a></li>');
            }
        }
        // the last button
        if (pageNumber + 1 < total) {
            paginationBox.append('<li><a class="paginationTag" href="#" data-page="' + (pageNumber + 1) + '">>></a></li>');
        } else {
            paginationBox.append('<li><a class="paginationTag" href="#" data-page="' + total + '">>></a></li>');
        }

        // register the listener
        registerPaginationListener();
    }
}

function registerPaginationListener() {
    $('.pagination-box').on('click', 'a', function (event) {
        loadQuoteList($(this).attr("data-page"));
        event.stopPropagation();
    });
}

function quoteItemListener() {
    $('.listContainer').on('click', '.quoteItem', function (event) {
        // fill up the content
        var vo = merchantQuoteVOList[$(this).attr('data-index')];
        quoteDetailsPage(vo.keyString);
        event.stopPropagation();
    });
}

function quoteDetailsPage(quoteKeyString) {
    window.location.href = "/quote/d/" + quoteKeyString;
}

