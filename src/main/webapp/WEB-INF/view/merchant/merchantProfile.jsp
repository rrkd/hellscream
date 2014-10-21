<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="Merchant Profile">
    <title><spring:message code="merchantprofile.title" /> - ${iguser.merchantName}</title>
</head>
<body>
<div class="page-header">

    <h1><spring:message code="merchantprofile.title" /> - ${merchant.merchantName}</h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid top30">

    <div class="span10">

        <%--<div class="titleborder">--%>

            <%--<div>--%>

                <%--Basic Information--%>

            <%--</div>--%>

        <%--</div>--%>

        <!-- Left Tabs

       ================================================== -->

        <div class="tabbable tabs-left">

            <!--bootstrap tabs implementation-->

            <ul class="nav nav-tabs">

                <!--tabs-->

                <li class="active">

                    <a data-toggle="tab" href="#tab1"><spring:message code="merchantprofile.basicinfo" /></a>

                </li>

                <li>

                    <a data-toggle="tab" href="#tab2"><spring:message code="merchantprofile.contact" /></a>

                </li>

            </ul>

            <!--tabs content -->

            <div class="tab-content">

                <div id="tab1" class="tab-pane active fade in">

                    <div class="row-fluid">
                        <div class="span4"><b><spring:message code="merchantprofile.registername" /></b></div>
                        <div class="span8">${merchant.tradeName}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b><spring:message code="merchantprofile.merchantname" /></b></div>
                        <div class="span8">${merchant.merchantName}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b><spring:message code="merchantprofile.desc" /></b></div>
                        <div class="span8">${merchant.description}</div>
                    </div>
                    <a href="/merchant/modify"><spring:message code="merchantprofile.edit.button" /></a>
                </div>

                <div id="tab2" class="tab-pane fade ">
                    <div class="row-fluid">
                        <div class="span4"><b><spring:message code="merchantprofile.phone" /></b></div>
                        <div class="span8">${merchant.phone}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b><spring:message code="merchantprofile.mobile" /></b></div>
                        <div class="span8">${merchant.contact1}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"></div>
                        <div class="span8">${merchant.contact2}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b><spring:message code="merchantprofile.address" /></b></div>
                        <div class="span8">${merchant.address1} ${merchant.address2}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"></div>
                        <div class="span8">${merchant.address3}</div>
                    </div>
                    <a href="/merchant/modify"><spring:message code="merchantprofile.edit.button" /></a>
                </div>

            </div>

            <!--tab content -->

        </div>

        <!-- END Left Tabs -->

    </div>

    <div class="span10">

        <div class="titleborder">

            <div>

                <spring:message code="merchantprofile.usage" />

            </div>

        </div>

        <!-- Skills

              ================================================== -->

        <ul id="skill">

            <li><span class="thebar progressgreen" style="width:100%;"></span>

                <h3><spring:message code="merchantprofile.feedback" /></h3>

            </li>

            <li><span class="thebar progressblue" style="width:80%;"></span>

                <h3><spring:message code="merchantprofile.handshake" /></h3>

            </li>
            <li><span class="thebar progressorange" style="width:70%;"></span>

                <h3><spring:message code="merchantprofile.quote" /></h3>

            </li>
        </ul>

        <div class="clearfix">

        </div>

        <!-- END Skills -->

    </div>

</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/merchant/merchantProfile.js"></script>
</body>
</html>