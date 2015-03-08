<%@include file="globe.jsp" %>
<html>
<head>
    <meta name="description" content="About Us">
    <title><spring:message code="howitworks.title" /></title>
</head>
<body>
<div class="page-header">

    <h1><spring:message code="howitworks.image" /></h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid services">


        <img src="/assets/img/howitwork.png">

</div>

<div class="row-fluid graysection text-center">

    <p class="lead bottom0">

        <i class="icon-phone"></i><spring:message code="howitworks.contact" /> <a><spring:message code="howitworks.contact.number" /></a>

    </p>

</div>

<div class="row-fluid services">

    <div class="span4">

        <h2><i class="icon-bolt"></i><spring:message code="howitworks.quote" /></h2>

        <p>

            <spring:message code="howitworks.quote.detail" /><br/><a href="/quote/c" class="more"><spring:message code="howitworks.quote.button" /></a>

        </p>

    </div>

    <div class="span4">

        <h2><i class="icon-google-plus"></i><spring:message code="howitworks.merchant" /></h2>

        <p>

            <spring:message code="howitworks.merchant.detail" /><br/><a href="/category" class="more"><spring:message code="howitworks.merchant.button" /></a>

        </p>

    </div>

    <div class="span4">

        <h2><i class="icon-dashboard"></i><spring:message code="howitworks.feedback" /></h2>

        <p>

            <spring:message code="howitworks.feedback.detail" /> <br/><a href="/faq" class="more"><spring:message code="howitworks.feedback.button" /></a>

        </p>

    </div>

</div>

<div class="row-fluid top30">

    <div class="span12">

        <div class="info-box shadow-large bottom0">

            <div class="info-box-inner">

                <div class="info-content">

                    <h4><spring:message code="howitworks.register" /></h4>

                    <p>

                        <spring:message code="howitworks.register.detail" />

                    </p>

                </div>

                <a style="float: right;" class="btn btn-primary btn-large" href="/m/create"><i class="icon-download-alt"></i><spring:message code="howitworks.register.button" /> </a>

                <div class="clearfix">

                </div>

            </div>

        </div>

    </div>

</div>
</body>
</html>