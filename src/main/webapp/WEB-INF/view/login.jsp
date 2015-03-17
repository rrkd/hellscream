<%@include file="globe.jsp" %>
<html>
<head>
    <meta name="description" content="Login">
    <title><spring:message code="login.title" /></title>
</head>
<body>
<div class="page-header">

    <h1><spring:message code="login.userlogin" /></h1>

    <div class="headerdivider">

    </div>

</div>
    <div class="row-fluid">
        <div class="span6">
            <div class="titleborder">

                <div>

                    <spring:message code="login.login" />

                </div>

            </div>
            <div class="span12">
                <div class="alert alert-error" id="merchantRsgErrorBox" style="display: none;">

                    <button type="button" class="close" data-dismiss="alert">x</button>

                    <strong>Error!</strong> You username or password is invalid.</span>

                </div>
                <form action="#">

                    <input name="name" size="30" type="text" id="username" class="span6" placeholder="<spring:message code="login.username" />"><br/>

                    <input name="name" size="30" type="password" id="password" class="span6" placeholder="<spring:message code="login.password" />">
                    <br/>


                    <input value="Login" id="login_btn" class="btn btn-primary top10">

                </form>
            </div>
        </div>
        <div class="span6">
            <div class="titleborder">

                <div>

                    <spring:message code="login.signinas" />

                </div>

            </div>
            <div class="span12">
                <p>
                    <a class="btn btn-large btn-success" href="${googleUrl}">
                        <i class="icon-google-plus-sign"></i>
                        <spring:message code="login.googlesignin" /></a>

                </p>
                <p>

                </p>
                    <a class="btn btn-large btn-success" href="${facebookUrl}">
                        <i class="icon-facebook-sign"></i>
                        <spring:message code="login.facebooksignin" /></a>
                <br/>
            </div>
        </div>
    </div>
    <div class="row-fluid">

        <div class="span6">
            <div class="titleborder">

                <div>

                    <spring:message code="login.signupasuser" />

                </div>

            </div>
            <div class="boxblue">

                <p><spring:message code="login.signupbenefits" /></p>
                <ul class="icons-ul">

                    <li><i class="icon-li icon-ok"></i><spring:message code="login.benefit1" /></li>

                    <li><i class="icon-li icon-ok"></i><spring:message code="login.benefit2" /></li>

                    <li><i class="icon-li icon-ok"></i><spring:message code="login.benefit3" /></li>

                    <li><i class="icon-li icon-ok"></i><spring:message code="login.benefit4" /></li>

                </ul>
                <p>
                    <a class="btn btn-large btn-primary" href="/register/user">
                    <i class="icon-user"></i>
                        <spring:message code="login.signupasuser" /></a>
                </p>
            </div>
        </div>
        <div class="span6">
            <div class="titleborder">

                <div>

                    <spring:message code="login.signupasmerchant" />

                </div>

            </div>
            <div class="boxgreen" >

                <p><spring:message code="login.merchantbenefits" /></p>
                <ul class="icons-ul">

                    <li><i class="icon-li icon-ok"></i><spring:message code="login.merchantbenefit1" /></li>

                    <li><i class="icon-li icon-ok"></i><spring:message code="login.merchantbenefit2" /></li>

                    <li><i class="icon-li icon-ok"></i><spring:message code="login.merchantbenefit3" /></li>

                    <li><i class="icon-li icon-ok"></i><spring:message code="login.merchantbenefit4" /></li>

                </ul>
                <p>
                    <a class="btn btn-large btn-primary" href="/register/merchant">
                    <i class="icon-suitcase"></i>
                        <spring:message code="login.signupasmerchant" /></a>
                </p>
            </div>
        </div>
    </div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/sha256.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/login.js"></script>
</body>
</html>