jQuery(document).ready(function ($) {
    $('#create_merchant').click(function () {
        $.ajax({
            type:"POST",
            url:"/ws/quote",
            data:generateQuote(),
            contentType:'application/json',
            success:function (data) {
                if (data.status == 'OK') alert('Quote has been added');
                else alert('Failed adding quote: ' + data.status + ', ' + data.errorMessage);
            }
        });
    });


    $('#category_select').select2({
        placeholder:"Category Select"
    });
});

function generateQuote() {
    var quote = {
        clientUserEmail:$('#email').val(),
        title:$('#title').val(),
        description:$('#description').val(),
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

