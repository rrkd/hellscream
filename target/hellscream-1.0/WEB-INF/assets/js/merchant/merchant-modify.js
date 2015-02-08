var merchantLogo;
var merchantImages;
var resourceId = '';
jQuery(document).ready(function ($) {
    resourceId = $('#imageResourceId').val();
    resourceId = resourceId === null || resourceId === undefined ? '' : resourceId;
    $('#uploadImgDlg').appendTo('body');
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


    $('#merchantLogo').on('change', function (event) {

        uploadMerchantLogo(event);
    });


    $('#merchantImages').on('change', function (event) {
        $('#uploadImgDlg').modal('show');
        merchantImages = uploadMerchantImages(event);
    });
});

function displayImages() {

}

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
        imageResourceId:merchantLogo === undefined || merchantLogo === null ? '' : merchantLogo.resourceId,
        imageFileName:merchantLogo === undefined || merchantLogo === null ? '' : merchantLogo.fileUrl,
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


function uploadMerchantLogo(event) {
    var merchantKey = $('#keyId').val();
    var files = event.target.files;
    var file = files[0];
    var reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function () {
        var fileContent = reader.result.match(/,(.*)$/)[1];
        if(file.size > 204800) {
            alert("Max size is 200K.")
        } else {
            $('#uploadImgDlg').modal({
                backdrop: 'static',
                keyboard: false
            });
            var fileClient = {
                resourceId:resourceId,
                title:merchantKey + "-logo" + file.name.substring(file.name.lastIndexOf(".")),
                description:"merchant logo",
                mimeType:file.type,
                content:fileContent,
                parents:[]
            };
            $.ajax({
                type:"POST",
                url:"/ws/drive",
                data:JSON.stringify(fileClient),
                contentType:'application/json',
                success:function (data) {

                    if (data.status == 'OK') {
                        merchantLogo = {};
                        merchantLogo.resourceId = data.resourceId;
                        merchantLogo.fileUrl = data.fileUrl;
                    }
                    else {
                        $('#merchantRsgErrorBox').show();
                        $('#merchantRsgErrorBox').text(data.errorMessage);
                        merchantLogo = null;
                    }
                    $('#uploadImgDlg').modal('hide');
                }
            });
        }
    };
}

function uploadMerchantImages(event) {
    $.each(event.target.files, function (index, file) {
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function (event) {
            var fileContent = reader.result.match(/,(.*)$/)[1];
            if(file.size > 204800) {
                alert("Max size is 200K.")
            } else {
                var fileClient = {
                    resource_id:"",
                    title:merchantKey + "-img" + file.name.substring(file.name.lastIndexOf(".")),
                    description:"merchant image",
                    mimeType:file.type,
                    content:fileContent,
                    parents:[]
                };
                $.ajax({
                    type:"POST",
                    url:"/ws/drive",
                    data:JSON.stringify(fileClient),
                    contentType:'application/json',
                    success:function (data) {
                        if (data.status == 'OK') {
                            var merchantInfo;
                            merchantInfo.resourceId = data.resourceId;
                            merchantInfo.fileUrl = data.fileUrl;
                            return merchantInfo;
                        }
                        else {
                            $('#merchantRsgErrorBox').show();
                            $('#merchantRsgErrorBox').text(data.errorMessage);
                            var merchantInfo;
                            merchantInfo.resourceId = "";
                            merchantInfo.fileUrl = "";
                            return merchantInfo;
                        }

                    }
                });
            }
        };
        $('#uploadImgDlg').modal('hide');
    })
}
