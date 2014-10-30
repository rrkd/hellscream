<%@include file="../globe.jsp"%>
<div class="page-header">

    <h1><spring:message code="merchantregister.heading" /></h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid">

    <div class="span8">
        <div class="titleborder">

            <div>

                <spring:message code="merchantregister.step1" /><a href="/login"><spring:message code="merchantregister.signin" /></a>

            </div>

        </div>

        <p>
            <spring:message code="merchantregister.step1.help" />
        </p>

    </div>
</div>
<div class="row-fluid">
    <div class="span8">
        <div class="titleborder">

            <div>

                <spring:message code="merchantregister.step2" /><a href="/merchant/create"><spring:message code="merchantregister.register" /></a>

            </div>

        </div>

        <p>
            <spring:message code="merchantregister.step2.help" />
        </p>
        <p>
            <a href="/merchant/create" class="btn btn-primary btn-large">

                <i class="icon icon-download-alt"></i><spring:message code="merchantregister.register" /></a>

        </p>

    </div>

</div>
<script type="text/javascript" src="/assets/js/register.js"></script>