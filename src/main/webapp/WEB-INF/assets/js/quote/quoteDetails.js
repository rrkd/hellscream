jQuery(document).ready(function ($) {
    $('#quoteDetailsDlg').appendTo('body');

    quoteTransactionDetailsListener();
});

function quoteTransactionDetailsListener() {
    $('ul.media').on('click', '.application-details', function (event) {
        // fill up the content
        fillUpQuoteTransactionDlg($(this).attr('data-key'));
        event.stopPropagation();
    });
}

function fillUpQuoteTransactionDlg(keyString) {
    $.ajax({
        type:"GET",
        url:"/ws/quoteTransaction/"+keyString,
        success:function (data) {
            if(data != null) {
                var dialog = $('#quoteDetailsDlg');
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
                if(data.status == 'Appending') {
                    $('.modal-contact-merchant').show();
                    $('.modal-contact-merchant').click(function(){
                        contactWithMerchant(keyString);

                    });
                }  else {
                    $('.modal-contact-merchant').hide();
            }
                dialog.modal('toggle');
            }

        }
    });

}

function contactWithMerchant(transactionKeyString) {
    window.location.href="/u/c/" + transactionKeyString;
}