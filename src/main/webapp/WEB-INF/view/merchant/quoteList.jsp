<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="merchant quote list">
    <title><spring:message code="merchantquotelist.title" /></title>
    <link href="/assets/css/jquery.raty.css" rel="stylesheet">
</head>
<body>
<div class="page-header">

    <h1><spring:message code="merchantquotelist.title" /></h1>

    <div class="headerdivider">

    </div>
    <input name="name" size="30" type="hidden" id="merchantKeyString" class="span12"
           value="${merchant.keyString}">

</div>

<div class="row-fluid top30">
    <div class="span12">

        <!-- Tabs

              ================================================== -->

        <ul id="myTab" class="nav nav-tabs">

            <li class="active"><a href="#latestQuote" data-toggle="tab"><spring:message code="merchantquotelist.latestquote" /></a></li>

            <li class=""><a href="#allQuote" data-toggle="tab"><spring:message code="merchantquotelist.allquote" /></a></li>

        </ul>

        <div id="myTabContent" class="tab-content">

            <div class="tab-pane fade active in" id="latestQuote">

                <c:forEach items="${latestQuote.voList}" var="transaction">
                    <div class="boxblog">

                        <h5><a href="#">${transaction.quoteTitle}</a></h5>

                        <p class="small datepost">

                            <spring:message code="merchantquotelist.quotepostday" /> ${transaction.quotePostDate} <span class="floatright" title="3 responses"><a href="#"><img src="/assets/img/comments.png" alt=""></a></span>

                        </p>

                        <div class="innerblogboxtwo">

                            <div class="row-fluid">
                                <div class="span4"><spring:message code="merchantquotelist.rawday" /></div>
                                <div class="span8">${transaction.rawDay}</div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4"><spring:message code="merchantquotelist.price" /></div>
                                <div class="span8">${transaction.rawPrice}</div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4"><spring:message code="merchantquotelist.desc" /></div>
                                <div class="span8">${transaction.comment}</div>
                            </div>

                        </div>

                    </div>
                </c:forEach>

            </div>

            <div class="tab-pane fade" id="allQuote">
                <div class="listContainer">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th><spring:message code="merchantquotelist.quotetitle" /></th>
                            <th><spring:message code="merchantquotelist.quotepostday" /></th>
                            <th><spring:message code="merchantquotelist.action" /></th>
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

        <!-- END Tabs -->

    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="quoteTransactionDetail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"><spring:message code="merchantprofile.address" />Close</span></button>
                <h4 class="modal-title" id="myModalLabel"><spring:message code="merchantprofile.address" />Quote Details</h4>
            </div>
            <div class="modal-body">
                <div class="tabbable tabs-left">

                    <!--bootstrap tabs implementation-->

                    <ul class="nav nav-tabs">

                        <!--tabs-->

                        <li class="active">

                            <a data-toggle="tab" href="#quoteDetailsTab"><spring:message code="merchantprofile.address" />Quote Details</a>

                        </li>

                        <li>

                            <a data-toggle="tab" href="#quoteApplyTab"><spring:message code="merchantprofile.address" />Apply</a>

                        </li>

                        <li>

                            <a data-toggle="tab" href="#quoteMessage"><spring:message code="merchantprofile.address" />Message</a>

                        </li>

                    </ul>

                    <!--tabs content -->

                    <div class="tab-content">

                        <div id="quoteDetailsTab" class="tab-pane active fade in">
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold"><spring:message code="merchantprofile.address" />Category</div>
                                <div class="span8 " id="quoteCategory">

                                </div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold"><spring:message code="merchantprofile.address" />Location</div>
                                <div class="span8" id="quoteSuburb"></div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold"><spring:message code="merchantprofile.address" />Description</div>
                                <div class="span8" id="quoteComment"></div>
                            </div>
                        </div>

                        <div id="quoteApplyTab" class="tab-pane fade ">
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold"><spring:message code="merchantprofile.address" />Days</div>
                                <div class="span8 " id="applyRawDays"></div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold"><spring:message code="merchantprofile.address" />Price</div>
                                <div class="span8" id="applyRawPrice"></div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold"><spring:message code="merchantprofile.address" />Service Type</div>
                                <div class="span8" id="applyServiceType"></div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold"><spring:message code="merchantprofile.address" />Comment</div>
                                <div class="span8" id="applyComment"></div>
                            </div>

                        </div>

                        <div id="quoteMessage" class="tab-pane fade ">


                        </div>

                    </div>

                    <!--tab content -->

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal"><spring:message code="merchantprofile.address" />Close</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/merchant/merchantQuoteList.js"></script>
</body>
</html>