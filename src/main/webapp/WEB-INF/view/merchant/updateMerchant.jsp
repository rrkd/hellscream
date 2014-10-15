<%@include file="../globe.jsp"%><html>
<head>
    <meta name="description" content="service job search">
    <title>Register Merchant</title>
    <link href="/assets/css/prettify_bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="page-header">

    <h1>Update Merchant</h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid top30">

    <div class="span10">
        <div class="titleborder">

            <div>

                Basic Information

            </div>

        </div>
        <div class="alert alert-error" id="merchantRsgErrorBox" style="display: none;">

            <button type="button" class="close" data-dismiss="alert">x</button>

            <strong>Oh snap!</strong> Change a few things up and try submitting again.

        </div>
        <form class="form-horizontal" id="merchantUpdateForm"  novalidate>
            <div class="control-group">
                <label class="control-label" for="tradeName">Trade Name</label>
                <div class="controls">
                    <input name="tradeName" size="30" class="span12" type="text"
                           maxlength="50" minlength="3"
                           pattern="[a-zA-Z0-9\s]+"
                           id="tradeName" placeholder="TradeName" value="${vo.tradeName}"  required >
                    <p class="help-block">Your trade name</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName">Merchant Name</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="merchantName" class="span12" placeholder="MerchantName" value="${vo.merchantName}" required>
                    <p class="help-block">Your Merchant Name</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName">Email</label>
                <div class="controls">
                    <input name="name" size="30" type="email" id="email" class="span12" placeholder="Email" value="${vo.email}" required>
                    <p class="help-block">Contact Email</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName">Category</label>
                <div class="controls">
                    <select multiple="multiple" name="name" size="30" id="category_select"
                            class="populate placeholder select2-offscreen span12" style="margin-bottom: 10px; margin-left: 0;">
                        <c:forEach items="${categoryGroupList}" var="categoryGroup">
                            <optgroup label="${categoryGroup.name}">
                                <c:forEach items="${categoryGroup.categoryList}" var="category">
                                    <option value="${category.name}">${category.name}</option>
                                </c:forEach>
                            </optgroup>
                        </c:forEach>
                    </select>
                    <p class="help-block">Your Service Category</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName">Description</label>
                <div class="controls">
                    <textarea id="description" name="message" class="span12" placeholder="Description" rows="8">${vo.description}</textarea>
                    <p class="help-block">What is your service about</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName">Address Line 1</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address1" value="${vo.address1}" class="span12" placeholder="Address1" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName">Address Line 2</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address2" value="${vo.address2}" class="span12" placeholder="Address2" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName">Address Line 3</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address3" value="${vo.address3}" class="span12" placeholder="Address3" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName">phone</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="phone" value="${vo.phone}" class="span12" placeholder="Phone">
                    <p class="help-block">Phone</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName">Contact One</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="contact1" value="${vo.contact1}" class="span12" placeholder="Contact One">
                    <p class="help-block">Contact Person</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName">Contact two</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="contact2" value="${vo.contact2}" class="span12" placeholder="Contact Tow">
                    <p class="help-block"></p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="tradeName">Merchant Logo</label>
                <div class="controls">
                    <p><img src="${vo.imageFileName}" alt="Merchant Logo" width="200" height="200"></p>
                    <input name="name" size="30" type="file" id="merchantLogo" class="span12" placeholder="MerchantLogo" accept="image/gif, image/jpeg, image/png">
                    <p class="help-block">gif, png or jpeg file, max size is 200K</p>
                </div>
            </div>

            <%--<div class="control-group">--%>
                <%--<label class="control-label" for="tradeName">Merchant Images</label>--%>
                <%--<div class="controls">--%>
                    <%--<input name="name" size="30" type="file" id="merchantImages" class="span12" placeholder="MerchantImages" multiple />--%>
                    <%--<p class="help-block"></p>--%>
                <%--</div>--%>
            <%--</div>--%>

            <br/>
            <input name="name" size="30" type="hidden" id="keyString" class="span12"
                   value="${vo.keyString}">
            <input name="name" size="30" type="hidden" id="imageResourceId" class="span12"
                   value="${vo.imageResourceId}">
            <input name="name" size="30" type="hidden" id="keyId" class="span12"
                   value="${vo.keyId}">
            <div class="form-actions">
                <input value="Update" id="modify_merchant" class="btn btn-primary top10">
            </div>
        </form>

    </div>

</div>
<!-- uploading dialog -->
<div class="modal fade" id="uploadImgDlg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">Uploading Image</h4>
            </div>
            <div class="modal-body">
                Please wait for a second...
            </div>
            <div class="modal-footer">

            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jqBootstrapValidation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/prettify.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/merchant/merchant-modify.js"></script>

</body>