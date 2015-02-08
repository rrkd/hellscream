var msgVOList;
jQuery(document).ready(function ($) {
    initQuoteList();
    $('#msgDlg').appendTo('body');
});

function initQuoteList() {
    loadQuoteList(1);
    return false;
}

function loadQuoteList(pageNumber) {
    var userKeyString = $('#merchantKeyString').val();
    $.ajax({
        type:"GET",
        url:"/ws/merchant/" + userKeyString + "/cm/" + pageNumber,
        data:"",
        success:function (data) {
            msgVOList = data.voList;
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
                '<td>' + vo.title + '</td>' +
                '<td>' + vo.postDate + '</td>' +
                '<td><a href="" class="msgItem" data-index="' + index + '">Message Content</a></td>' +
                '</tr>');
        }
        msgItemListener();
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

function msgItemListener() {
    $('.listContainer').on('click', '.msgItem', function (event) {
        event.preventDefault();
        // fill up the content
        var vo = msgVOList[$(this).attr('data-index')];
        msgContentDlg(vo);
    });
}

function msgContentDlg(vo) {
    var dialog = $('#msgDlg');
    $('#userNameField').text(vo.userForename + ' ' + vo.userSurname);
    $('#emailField').text(vo.email);
    $('#phoneField').text(vo.mobile);
    $('#userComment').text(vo.comment);
    dialog.modal('toggle');
}

