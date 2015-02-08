<%@include file="../globe.jsp"%><html>
<head>
    <meta name="description" content="service job search">
    <title><spring:message code="userregister.heading" /></title>
    <link href="/assets/css/prettify_bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="page-header">

    <h1><spring:message code="userregister.heading" /></h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid top30">

    <div class="span6">
        <div class="titleborder">

            <div>

                <spring:message code="userregister.heading" />

            </div>

        </div>
        <div class="alert alert-error" id="userRsgErrorBox" style="display: none;">

            <button type="button" class="close" data-dismiss="alert">x</button>

            <strong>Oh snap!</strong> <spring:message code="userregister.warningmessage" />

        </div>
        <form class="form-horizontal" id="merchantRegisterForm" novalidate>
            <div class="control-group">
                <label class="control-label" for="email"><spring:message code="userregister.email" /></label>
                <div class="controls">
                    <input name="name" size="30" type="email" id="email" class="span12" placeholder="<spring:message code="userregister.email.placeholder" />" required>
                    <p class="help-block"><spring:message code="userregister.email.help" /></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="password"><spring:message code="userregister.password" /></label>
                <div class="controls">
                    <input name="password" size="30" type="password" id="password" class="span12" placeholder="<spring:message code="userregister.password.placeholder" />"
                           minlength="6"
                           data-validation-regex-regex="[a-zA-Z0-9\s]+"
                           data-validation-regex-message="<spring:message code="userregister.password.help" />" required>
                    <p class="help-block"><spring:message code="userregister.password.help" /></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="password2"><spring:message code="userregister.reentrypassword" /></label>
                <div class="controls">
                    <input name="password2" size="30" type="password" id="password2" class="span12" placeholder="<spring:message code="userregister.reentrypassword.placeholder" />"
                           data-validation-matches-match="password"
                          data-validation-matches-message=
                                   "<spring:message code="userregister.reentrypassword.message" />" required>
                    <p class="help-block"></p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="nickname"><spring:message code="userregister.nickname" /></label>
                <div class="controls">
                    <input name="nickname" size="30" class="span12" type="text"
                           maxlength="50" minlength="3"
                           pattern="[a-zA-Z0-9\s]+"
                           id="nickname" placeholder="<spring:message code="userregister.nickname.placeholder" />" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="forename"><spring:message code="userregister.forename" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="forename" class="span12" placeholder="<spring:message code="userregister.forename.placeholder" />" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="surname"><spring:message code="userregister.surname" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="surname" class="span12" placeholder="<spring:message code="userregister.surname.placeholder" />" required>
                    <p class="help-block"></p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="address1"><spring:message code="userregister.address1" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address1" class="span12" placeholder="<spring:message code="userregister.address1.placeholder" />" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="address2"><spring:message code="userregister.address2" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address2" class="span12" placeholder="<spring:message code="userregister.address2.placeholder" />" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="address3"><spring:message code="userregister.address3" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address3" class="span12" placeholder="<spring:message code="userregister.address3.placeholder" />" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="mobile"><spring:message code="userregister.mobile" /></label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="mobile" class="span12" placeholder="<spring:message code="userregister.mobile.placeholder" />">
                    <p class="help-block"></p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="terms-and-conditions"><spring:message code="userregister.legal" /></label>
                <div class="controls">
                    <label class="checkbox">
                        <input type="checkbox" id="terms-and-conditions" name="terms-and-conditions" required data-validation-required-message="<spring:message code="userregister.legal.requirement" />">
                        <spring:message code="userregister.iagreeto" /><a href="#">terms and conditions</a>
                    </label>
                    <p class="help-block"></p>
                </div>
            </div>

            <br/>
            <div class="form-actions">
                <button type="submit" class="btn btn-primary"><spring:message code="userregister.signup" /> <i class="icon-ok icon-white"></i></button><br />
                <spring:message code="userregister.ihaveread" />
            </div>
        </form>

    </div>

</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/sha256.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jqBootstrapValidation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/prettify.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/register/userRegister.js"></script>
</body>