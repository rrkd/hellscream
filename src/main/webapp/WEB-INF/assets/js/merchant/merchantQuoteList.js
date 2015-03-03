var transactionVOList;
jQuery(document).ready(function ($) {

    initQuoteList();
    $('#quoteTransactionDetail').appendTo('body');

})

function initQuoteList() {
    loadQuoteList(1);
    return false;
}

function loadQuoteList(pageNumber) {
    $.ajax({
        type:"GET",
        url:"/ws/quoteTransaction/list/" + $('#merchantKeyString').val() + "/" + pageNumber,
        data:"",
        success:function (data) {
            transactionVOList = data.voList;
            refreshListAll(data);
        }
    });
}

function refreshListAll(data) {
    refreshListContainer(data);
    refreshPagination(data);
}

function refreshListContainer(searchResult) {
    var listContainer = $('#dataTableBody');
    listContainer.empty();
    if (searchResult.voList.length > 0) {
        for (var index = 0; index < searchResult.voList.length; index++) {
            var vo = searchResult.voList[index];
            listContainer.append('<tr>' +
                '<td>'+index+'</td>' +
                '<td>'+vo.quoteTitle + '</td>' +
                '<td>'+vo.quotePostDate + '</td>' +
                '<td><a class="quoteItem" href="#" data-index="'+index+'">details >></a></td>' +
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
    $('#latestQuote').on('click', '.quoteItem', function (event) {
        // fill up the content
        var quoteKeyString = $(this).attr('data-index');
        $.ajax({
            type:"GET",
            url:"/ws/quoteTransaction/" + quoteKeyString,
            data:"",
            success:function (data) {
                var dialog = $('#quoteTransactionDetail');
                fillUpQuoteDetails(dialog, data);
                dialog.modal('toggle');
            }
        });
        event.stopPropagation();
    });
    $('.listContainer').on('click', '.quoteItem', function (event) {
        // fill up the content
        var vo = transactionVOList[$(this).attr('data-index')];
        var dialog = $('#quoteTransactionDetail');
        fillUpQuoteDetails(dialog, vo);
        dialog.modal('toggle');
        event.stopPropagation();
    });
}

function fillUpQuoteDetails(dialog, data) {
    dialog.find('#myModalLabel').html('Quote Details - <b>' + data.quoteTitle + '</b>');
    // quote detail tab
    $('#quoteCategory').empty();
    for(var i=0; i<data.quoteCategoryList.length; i++) {
        $('#quoteCategory').append('<a class="btn btn-small" href="#">'+data.quoteCategoryList[i]+'</a>');
    }
    $('#quoteComment').text(data.quoteComment);
    //  application detail tab
    $('#applyRawDays').text(data.rawDay);
    $('#applyRawPrice').text(data.rawPrice);
    $('#applyServiceType').text(data.serviceType);
    $('#applyComment').text(data.comment);
}