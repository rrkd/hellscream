<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="Merchant Profile">
    <title>Merchant Profile - ${iguser.tradename}</title>
</head>
<body>
<div class="page-header">

    <h1>Merchant Profile - ${merchant.tradeName}</h1>

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

        <!-- Left Tabs

       ================================================== -->

        <div class="tabbable tabs-left">

            <!--bootstrap tabs implementation-->

            <ul class="nav nav-tabs">

                <!--tabs-->

                <li class="active">

                    <a data-toggle="tab" href="#tab1">Merchant Info</a>

                </li>

                <li>

                    <a data-toggle="tab" href="#tab2">Contact Info</a>

                </li>

            </ul>

            <!--tabs content -->

            <div class="tab-content">

                <div id="tab1" class="tab-pane active fade in">

                    <div class="row-fluid">
                        <div class="span4"><b>Trade Name</b></div>
                        <div class="span8">${merchant.tradeName}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b>Merchant Name</b></div>
                        <div class="span8">${merchant.merchantName}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b>Description</b></div>
                        <div class="span8">${merchant.description}</div>
                    </div>
                    <a href="/merchant/modify">Edit</a>
                </div>

                <div id="tab2" class="tab-pane fade ">

                    <div class="row-fluid">
                        <div class="span4"><b>Mobile</b></div>
                        <div class="span8">${merchant.mobile}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b>Phone</b></div>
                        <div class="span8">${merchant.phone}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b>Address</b></div>
                        <div class="span8">${merchant.address1}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"></div>
                        <div class="span8">${merchant.address2}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"></div>
                        <div class="span8">${merchant.address3}</div>
                    </div>
                    <a href="/merchant/modify">Edit</a>
                </div>

            </div>

            <!--tab content -->

        </div>

        <!-- END Left Tabs -->

    </div>

    <div class="span10">

        <div class="titleborder">

            <div>

                Usage

            </div>

        </div>

        <!-- Skills

              ================================================== -->

        <ul id="skill">

            <li><span class="thebar progressgreen" style="width:100%;"></span>

                <h3>Feedback 100%</h3>

            </li>

            <li><span class="thebar progressblue" style="width:80%;"></span>

                <h3>Quote 80%</h3>

            </li>
            <li><span class="thebar progressorange" style="width:70%;"></span>

                <h3>Applied Quote 70%</h3>

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