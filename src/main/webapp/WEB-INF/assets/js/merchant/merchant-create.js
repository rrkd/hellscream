jQuery(document).ready(function ($) {

    $('#category_select').select2({
        placeholder:"Category Select"
    });

    prettyPrint();

    $("#tradeName,#merchantName,#address1,#address2,#address3, #email, #terms-and-conditions").jqBootstrapValidation(
        {
            preventSubmit: true,
            submitError: function($form, event, errors) {
                // Here I do nothing, but you could do something like display
                // the error messages to the user, log, etc.
            },
            submitSuccess: function($form, event) {
                $.ajax({
                    type:"POST",
                    url:"/ws/merchant",
                    data:generateMerchant(),
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

                event.preventDefault();
            },
            filter: function() {
                return $(this).is(":visible");
            }
        }
    );

    $("a[data-toggle=\"tab\"]").click(function(e) {
        e.preventDefault();
        $(this).tab("show");
    });
});

function generateMerchant() {
    var merchant = {
        tradeName:$('#tradeName').val(),
        merchantName:$('#merchantName').val(),
        description:$('#description').val(),
        address1:$('#address1').val(),
        address2:$('#address2').val(),
        address3:$('#address3').val(),
        email:$('#email').val(),
        phone:$('#phone').val(),
        mobile:$('#mobile').val(),
        contact1:$('#contact1').val(),
        contact2:$('#contact2').val(),
        categoryList:[]
    };
    generateCategoryList(merchant.categoryList);
    return JSON.stringify(merchant);
}

function generateCategoryList(categoryList) {
    var dataList = $('#category_select').select2('data');
    var len = dataList.length;
    for (var i=0; i< len; i++) {
        categoryList.push(dataList[i].text);
    }
    return false;
}

