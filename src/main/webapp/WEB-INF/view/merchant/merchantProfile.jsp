<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="Merchant Profile ${merchant.merchantName}">
    <title><spring:message code="merchantprofile.title" /> - ${merchant.merchantName}</title>
</head>
<body>
<div class="page-header">

    <h1><spring:message code="merchantprofile.title" /> - ${merchant.merchantName}</h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid top30">

    <div class="span12">

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

    <div class="span12">

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

    <div class="span12">

        <div class="titleborder">

            <div>

                <spring:message code="merchantprofile.bill" />

            </div>

        </div>

        <!-- Bill Type

              ================================================== -->

        <div class="row-fluid">

            <div class="vuzz-pricing-table span4">

                <div class="vuzz-pricing">

                    <div class="vuzz-pricing-header">

                        <h5>Normal</h5>

                        <div class="vuzz-pricing-cost">

                            Free

                        </div>

                        <div class="vuzz-pricing-per">



                        </div>

                    </div>

                    <div class="vuzz-pricing-content">

                        <ul>

                            <li>5 products</li>

                            <li>1 image per product</li>

                            <li>basic stats</li>

                            <li>non commercial</li>

                        </ul>

                    </div>

                    <div class="vuzz-pricing-button">

                        <form enctype='application/json' action="https://dulcet-glazing-737.appspot.com/app/pay" method="POST">
                            <input name='userId' value='ahFzcHJpbmctZm9yZXN0LTUzOHIVCxIITWVyY2hhbnQYgICAgICc_QsM' type="hidden">
                            <input name='payEmail' value='zumaexhaust-buyer1@gmail.com' type="hidden">
                            <input name='planId' value='' type="hidden">
                            <input name='money' value='1.0' type="hidden">
                            <input name='description' value='Huafu Normal Monthly Fee' type="hidden">
                            <input name='callback' value='http://spring-forest-538.appspot.com/merchant/payFeeCB' type="hidden">
                            <input name='applicationId' value='spring-forest-538.appspot.com' type="hidden">
                            <input name='applicationToken' value='testtoken' type="hidden">

                            <a href="#" onclick="$(this).closest('form').submit()" class="vuzz-button buttonprice" target="_self" rel="nofollow"><span class="vuzz-button-inner">Order now</span></a>
                        </form>


                    </div>

                </div>

            </div>

            <div class="vuzz-pricing-table span4">

                <div class="vuzz-pricing">

                    <div class="vuzz-pricing-header popular">

                        <h5>Gold</h5>

                        <div class="vuzz-pricing-cost">

                            $29.99

                        </div>

                        <div class="vuzz-pricing-per">

                            per year

                        </div>

                    </div>

                    <div class="vuzz-pricing-content">

                        <ul>

                            <li>5 products</li>

                            <li>1 image per product</li>

                            <li>basic stats</li>

                            <li>non commercial</li>

                        </ul>

                    </div>

                    <div class="vuzz-pricing-button popular">

                        <form enctype='application/json' action="https://dulcet-glazing-737.appspot.com/app/pay" method="POST">
                            <input name='userId' value='ahFzcHJpbmctZm9yZXN0LTUzOHIVCxIITWVyY2hhbnQYgICAgICc_QsM' type="hidden">
                            <input name='payEmail' value='zumaexhaust-buyer1@gmail.com' type="hidden">
                            <input name='planId' value='' type="hidden">
                            <input name='money' value='29.99' type="hidden">
                            <input name='description' value='Huafu Normal Monthly Fee' type="hidden">
                            <input name='callback' value='http://spring-forest-538.appspot.com/merchant/payFeeCB' type="hidden">
                            <input name='applicationId' value='spring-forest-538.appspot.com' type="hidden">
                            <input name='applicationToken' value='testtoken' type="hidden">

                            <a href="#" onclick="$(this).closest('form').submit()" class="vuzz-button buttonprice" target="_self" rel="nofollow"><span class="vuzz-button-inner">Order now</span></a>
                        </form>

                    </div>

                </div>

            </div>

            <div class="vuzz-pricing-table span4">

                <div class="vuzz-pricing">

                    <div class="vuzz-pricing-header">

                        <h5>Premium</h5>

                        <div class="vuzz-pricing-cost">

                            $59.99

                        </div>

                        <div class="vuzz-pricing-per">

                            per year

                        </div>

                    </div>

                    <div class="vuzz-pricing-content">

                        <ul>

                            <li>5 products</li>

                            <li>1 image per product</li>

                            <li>basic stats</li>

                            <li>non commercial</li>

                        </ul>

                    </div>

                    <div class="vuzz-pricing-button">

                        <form enctype='application/json' action="https://dulcet-glazing-737.appspot.com/app/pay" method="POST">
                            <input name='userId' value='ahFzcHJpbmctZm9yZXN0LTUzOHIVCxIITWVyY2hhbnQYgICAgICc_QsM' type="hidden">
                            <input name='payEmail' value='zumaexhaust-buyer1@gmail.com' type="hidden">
                            <input name='planId' value='' type="hidden">
                            <input name='money' value='59.99' type="hidden">
                            <input name='description' value='Huafu Normal Monthly Fee' type="hidden">
                            <input name='callback' value='http://spring-forest-538.appspot.com/merchant/payFeeCB' type="hidden">
                            <input name='applicationId' value='spring-forest-538.appspot.com' type="hidden">
                            <input name='applicationToken' value='testtoken' type="hidden">

                            <a href="#" onclick="$(this).closest('form').submit()" class="vuzz-button buttonprice" target="_self" rel="nofollow"><span class="vuzz-button-inner">Order now</span></a>
                        </form>

                    </div>

                </div>

            </div>

        </div>

        <div class="clearfix">

        </div>

        <!-- END Skills -->

    </div>

</div>
<!-- paypal dialog -->
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
                <a href="/logout" class="btn btn-primary"><spring:message code="home.ok" /></a>
            </div>
        </div>
    </div>
</div>
<!-- paypal dialog end -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/merchant/merchantProfile.js"></script>
</body>
</html>