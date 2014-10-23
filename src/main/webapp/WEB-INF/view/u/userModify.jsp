<%@include file="../globe.jsp"%><html>
<head>
    <meta name="description" content="User Modify">
    <title><spring:message code="usermodify.title" /></title>
    <link href="/assets/css/prettify_bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="page-header">

    <h1><spring:message code="usermodify.title" /></h1>

    <div class="headerdivider">

    </div>

    <input name="name" size="30" type="hidden" id="userKeyString" class="span12"
           value="${iguser.keyString}">
</div>

<div class="row-fluid top30">

    <div class="span10">
        <div class="titleborder">

            <div>

                <spring:message code="usermodify.title" />

            </div>

        </div>
        <div class="alert alert-error" id="userRsgErrorBox" style="display: none;">

            <button type="button" class="close" data-dismiss="alert">x</button>

            <strong>Oh snap!</strong> <spring:message code="usermodify.warningmessage" />

        </div>
        <form class="form-horizontal" id="merchantRegisterForm" novalidate>
            <div class="control-group">
                <label class="control-label" for="email"><spring:message code="usermodify.email" /></label>
                <div class="controls">
                    <input name="name" size="30" type="email" id="email" class="span12" placeholder="Email"
                           value="${iguser.email}" readonly>
                    <p class="help-block"></p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="nickname"><spring:message code="usermodify.nickname" /></label>
                <div class="controls">
                    <input name="nickname" size="30" class="span12" type="text"
                           maxlength="50" minlength="3"
                           pattern="[a-zA-Z0-9\s]+"
                           id="nickname" placeholder="Nickname" value="${iguser.nickname}" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="forename"><spring:message code="usermodify.forename" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="forename" class="span12" placeholder="Forename"
                           value="${iguser.forename}" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="surname"><spring:message code="usermodify.surname" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="surname" class="span12" placeholder="Surname"
                           value="${iguser.surname}" required>
                    <p class="help-block"></p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="address1"><spring:message code="usermodify.address" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address1" class="span12" placeholder="Address1"
                           value="${iguser.address1}" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="address2"></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address2" class="span12" placeholder="Address2"
                           value="${iguser.address2}" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="address3"></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address3" class="span12" placeholder="Address3"
                           value="${iguser.address3}" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="mobile"><spring:message code="usermodify.mobile" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="mobile" class="span12" placeholder="mobile"
                           value="${iguser.mobile}">
                    <p class="help-block"></p>
                </div>
            </div>

            <br/>
            <div class="form-actions">
                <button type="submit" class="btn btn-primary"><spring:message code="usermodify.update" />  <i class="icon-ok icon-white"></i></button>
            </div>
        </form>

    </div>

</div>
<!-- success dialog -->
<div class="modal fade" id="successDlg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="successDlgLabel"><spring:message code="usermodify.usermodify" /></h4>
            </div>
            <div class="modal-body">
                <spring:message code="usermodify.message" />
            </div>
            <div class="modal-footer">
                <a href="/home" class="btn btn-default" data-dismiss="modal"><spring:message code="usermodify.backhome" /></a>
                <a href="/u/profile" class="btn btn-primary"><spring:message code="usermodify.backprofile" /></a>
            </div>
        </div>
    </div>
</div>
<!-- success dialog end -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jqBootstrapValidation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/prettify.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/user/userModify.js"></script>
</body>