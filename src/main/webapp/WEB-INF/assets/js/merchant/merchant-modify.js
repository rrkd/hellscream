jQuery(document).ready(function ($) {
    $('#modify_merchant').click(function () {
        $.ajax({
            type:"PUT",
            url:"/ws/merchant/" + $('#keyString').val(),
            data:generateMerchant(),
            contentType:'application/json',
            success:function (data) {
                if (data.status == 'OK') alert('Merchant has been modified');
                else alert('Failed to modify merchant: ' + data.status + ', ' + data.errorMessage);
            }
        });
    });
    var selectedItem = $('#selectedCategory').find("li");
    if (selectedItem !== undefined && selectedItem.length > 0) {
        var selectedValue = [];
        for (var i = 0; i < selectedItem.length; i++) {
            selectedValue.push($(selectedItem[i]).text());
        }
        $('#category_select').select2().val(selectedValue).trigger("change");
    }
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
    for (var i = 0; i < len; i++) {
        categoryList.push(dataList[i].text);
    }
    return false;
}