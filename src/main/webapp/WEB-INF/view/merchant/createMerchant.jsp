<%@include file="../globe.jsp"%>
<html>
<head>
    <meta name="description" content="service job search">
    <title><spring:message code="createmerchant.register" /></title>
    <link href="/assets/css/prettify_bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="page-header">

    <h1><spring:message code="createmerchant.register" /></h1>

    <div class="headerdivider">

    </div>
    <input name="name" size="30" type="hidden" id="userKeyString" class="span12"
           value="${user.keyString}">

</div>

<div class="row-fluid top30">

    <div class="span10">
        <div class="titleborder">

            <div>

                <spring:message code="createmerchant.basicinfo" />

            </div>

        </div>
        <div class="alert alert-error" id="merchantRsgErrorBox" style="display: none;">

            <button type="button" class="close" data-dismiss="alert">x</button>

            <strong>Oh snap!</strong> Change a few things up and try submitting again.

        </div>
        <form class="form-horizontal" id="merchantRegisterForm" novalidate>
            <div class="control-group">
                <label class="control-label" for="email">Email</label>
                <div class="controls">
                    <input name="name" size="30" type="email" id="email" class="span12" placeholder="<spring:message code="createmerchant.email.placeholder" />" value="${user.email}" readonly>
                    <p class="help-block"><spring:message code="createmerchant.email.help" /></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName"><spring:message code="createmerchant.tradename" /></label>
                <div class="controls">
                    <input name="tradeName" size="30" class="span12" type="text"
                           maxlength="50" minlength="3"
                           pattern="[a-zA-Z0-9\s]+"
                           id="tradeName" placeholder="<spring:message code="createmerchant.tradename.placeholder" />" required>
                    <p class="help-block"><spring:message code="createmerchant.tradename.help" /></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName"><spring:message code="createmerchant.merchantname" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="merchantName" class="span12" placeholder="<spring:message code="createmerchant.merchantname.placeholder" />" maxlength="500" required>
                    <p class="help-block"><spring:message code="createmerchant.merchantname.help" /></p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="tradeName"><spring:message code="createmerchant.category" /></label>
                <div class="controls">
                    <select multiple="multiple" name="name" size="30" id="category_select"
                            class="populate placeholder select2-offscreen span12" style="margin-bottom: 10px; margin-left: 0;">
                        <c:forEach items="${categoryGroupList}" var="categoryGroup">
                            <optgroup label="${categoryGroup.tradeName}">
                                <c:forEach items="${categoryGroup.categoryList}" var="category">
                                    <option value="${category.name}">${category.tradeName}</option>
                                </c:forEach>
                            </optgroup>
                        </c:forEach>
                    </select>
                    <p class="help-block"><spring:message code="createmerchant.category.help" /></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName"><spring:message code="createmerchant.description" /></label>
                <div class="controls">
                    <textarea id="description" name="message" class="span12" placeholder="<spring:message code="createmerchant.description.placeholder" />" rows="8" maxlength="500"></textarea>
                    <p class="help-block"><spring:message code="createmerchant.description.help" /></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName"><spring:message code="createmerchant.address1" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address1" class="span12" placeholder="<spring:message code="createmerchant.address1.placeholder" />" maxlength="500" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName"><spring:message code="createmerchant.address2" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address2" class="span12" placeholder="<spring:message code="createmerchant.address2.placeholder" />" maxlength="500" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName"><spring:message code="createmerchant.address3" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address3" class="span12" placeholder="<spring:message code="createmerchant.address3.placeholder" />" maxlength="500" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName"><spring:message code="createmerchant.phone" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="phone" class="span12" placeholder="<spring:message code="createmerchant.phone.placeholder" />" maxlength="500">
                    <%--<p class="help-block">Phone</p>--%>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName"><spring:message code="createmerchant.contact1" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="contact1" class="span12" placeholder="<spring:message code="createmerchant.contact1.placeholder" />" maxlength="500">
                    <%--<p class="help-block">Contact Person</p>--%>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName"><spring:message code="createmerchant.contact2" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="contact2" class="span12" placeholder="<spring:message code="createmerchant.contact2.placeholder" />" maxlength="500">
                    <p class="help-block"></p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="terms-and-conditions"><spring:message code="createmerchant.legal" /></label>
                <div class="controls">
                    <label class="checkbox">
                        <input type="checkbox" id="terms-and-conditions" name="terms-and-conditions" required data-validation-required-message="You must agree to the terms and conditions">
                        <spring:message code="createmerchant.agreement" /> <a href="<spring:message code="createmerchant.terms.link" />"><spring:message code="createmerchant.terms" /></a>
                    </label>
                    <p class="help-block"><spring:message code="createmerchant.terms.required" /></p>
                </div>
            </div>

            <br/>
            <div class="form-actions">
                <button type="submit" class="btn btn-primary"> <spring:message code="createmerchant.button" /> <i class="icon-ok icon-white"></i></button><br />
                <spring:message code="createmerchant.agreement" /><spring:message code="createmerchant.terms" />
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
<!-- uploading dialog end -->

<!-- success dialog -->
<div class="modal fade" id="successDlg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="successDlgLabel"><spring:message code="createmerchant.register.success" /></h4>
            </div>
            <div class="modal-body">
                <spring:message code="createmerchant.register.success.info" />
            </div>
            <div class="modal-footer">
                <a href="/logout" class="btn btn-primary"><spring:message code="createmerchant.relogin" /></a>
            </div>
        </div>
    </div>
</div>
<!-- success dialog end -->

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jqBootstrapValidation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/prettify.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/merchant/merchant-create.js"></script>
</body>
</html>