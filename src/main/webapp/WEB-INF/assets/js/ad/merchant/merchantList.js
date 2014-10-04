var merchantList;
jQuery(document).ready(function ($) {
    initMerchantList();
});

function initMerchantList() {
    loadMerchantList("", 1);
    return false;
}

function loadMerchantList(keyword, pageNumber) {
    $.ajax({
        type:"GET",
        url:"/ws/ad/m/" + pageNumber + "?q=" + keyword,
        data:"",
        success:function (data) {
            merchantList = data.voList;
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
            var html = '<tr>' +
                '<td>' + index + '</td>' +
                '<td>' + vo.merchant.tradeName + '</td>' +
                '<td>' + vo.merchant.valid + '</td>';
            if(vo.merchant.valid) {
                html = html + '<td><a href="#" data-index="' + index + '">Disable</a></td>';
            } else {
                html = html + '<td><a href="#" data-index="' + index + '">Enable</a></td>';
            }
            html = html + '</tr>';

            dataTableBody.append(html);
        }
        merchantItemListener();
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

function merchantItemListener() {
    $('.dataTableBody').on('click', 'a', function (event) {
        var vo = merchantList[$(this).attr('data-index')];
        event.stopPropagation();
    });
}
