jQuery(document).ready(function ($) {
    $('#successDlg').appendTo('body');
    $('#create_merchant').click(function () {
        $.ajax({
            type:"POST",
            url:"/ws/quote",
            data:generateQuote(),
            contentType:'application/json',
            success:function (data) {
                if (data.status == 'OK') {
                    $('#successDlg').modal({
                        backdrop: 'static',
                        keyboard: false
                    });
                }
                else alert('Failed adding quote: ' + data.status + ', ' + data.errorMessage);
            }
        });
    });

    $("#postQuoteForm").submit(function(e) {
        e.preventDefault();
    });

    $('#category_select').select2({
        placeholder:"Category Select"
    });

    $('#suburb').select2({
        placeholder:"Suburb Select",
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

    $("#quoteTitle, #description, #email").jqBootstrapValidation(
        {
            preventSubmit: true,
            submitError: function($form, event, errors) {
                // Here I do nothing, but you could do something like display
                // the error messages to the user, log, etc.
            },
            submitSuccess: function($form, event) {
                $.ajax({
                    type:"POST",
                    url:"/ws/quote",
                    data:generateQuote(),
                    contentType:'application/json',
                    success:function (data) {
                        if (data.status == 'OK') {
                            alert('Merchant has been added');
                            $('#merchantRsgErrorBox').hide();
                        }
                        else {
                            $('#merchantRsgErrorBox').show();
                            $('#merchantRsgErrorBox').text(data.errorMessage);
                        }
                    }
                });

                event.preventDefault()
            },
            filter: function() {
                return $(this).is(":visible");
            }
        }
    );

    $("#postQuoteForm").submit(function(e) {
        e.preventDefault();
    });
});

function generateQuote() {
    var suburb = null;
    if ($('#suburb').select2('data') != null) {
        suburb = $('#suburb').select2('data').id;
    }
    var quote = {
        clientUserEmail:$('#email').val(),
        title:$('#quoteTitle').val(),
        description:$('#description').val(),
        suburbKey:suburb,
        categoryList:[]
    };
    generateCategoryList(quote.categoryList);
    return JSON.stringify(quote);
}

function generateCategoryList(categoryList) {
    var dataList = $('#category_select').select2('data');
    var len = dataList.length;
    for (var i=0; i< len; i++) {
        categoryList.push(dataList[i].text);
    }
    return false;
}

