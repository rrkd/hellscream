<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="Merchant Message Box">
    <title><spring:message code="merchantquotemes.title" /></title>
</head>
<body>
<div class="page-header">

    <h1><spring:message code="merchantquotemes.title" /> - ${merchant.merchantName}</h1>

    <div class="headerdivider">

    </div>
    <input name="name" size="30" type="hidden" id="merchantKeyString" class="span12"
           value="${merchant.keyString}">

</div>

<div class="row-fluid">
    <div class="span12">
        <div class="listContainer">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th><spring:message code="merchantquotemes.quotetitle" /></th>
                    <th><spring:message code="merchantquotemes.posttime" /></th>
                    <th><spring:message code="merchantquotemes.action" /></th>
                </tr>
                </thead>
                <tbody id="dataTableBody">

                </tbody>
            </table>
        </div>
        <div class="pagination">

            <ul class="pagination-box">

            </ul>

        </div>
    </div>

</div>
<!-- Modal -->
<div class="modal fade" id="msgDlg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"><spring:message code="merchantquotemes.closebutton" /></span></button>
                <h4 class="modal-title" id="myModalLabel"><b><spring:message code="merchantquotemes.message" /></b></h4>
            </div>
            <div class="modal-body">
                <div class="tabbable tabs-left">

                    <!--bootstrap tabs implementation-->

                    <ul class="nav nav-tabs">

                        <!--tabs-->

                        <li class="active">

                            <a data-toggle="tab" href="#userDetailsTab"><spring:message code="merchantquotemes.userdetail" /></a>

                        </li>

                        <li>

                            <a data-toggle="tab" href="#commentTab"><spring:message code="merchantquotemes.comment" /></a>

                        </li>

                    </ul>

                    <!--tabs content -->

                    <div class="tab-content">

                        <div id="userDetailsTab" class="tab-pane active fade in">
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold"><spring:message code="merchantquotemes.username" /></div>
                                <div class="span8 " id="userNameField">

                                </div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold"><spring:message code="merchantquotemes.email" /></div>
                                <div class="span8" id="emailField"></div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold"><spring:message code="merchantquotemes.mobile" /></div>
                                <div class="span8" id="phoneField"></div>
                            </div>
                        </div>

                        <div id="commentTab" class="tab-pane fade ">
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold"><spring:message code="merchantquotemes.comment" />Comment</div>
                                <div class="span8 " id="userComment"></div>
                            </div>
                        </div>

                        <div id="quoteMessage" class="tab-pane fade ">


                        </div>

                    </div>

                    <!--tab content -->

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/merchant/merchantQuoteMsg.js"></script>
</body>
</html>