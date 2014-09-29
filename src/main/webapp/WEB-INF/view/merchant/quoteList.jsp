<%@include file="../globe.jsp" %>
<head>
    <meta name="description" content="merchant list">
    <title>My Quote List</title>
    <link href="/assets/css/jquery.raty.css" rel="stylesheet">
</head>
<body>
<div class="page-header">

    <h1>My Quote List</h1>

    <div class="headerdivider">

    </div>
    <input name="name" size="30" type="hidden" id="merchantKeyString" class="span12"
           value="${merchant.keyString}">

</div>

<div class="row-fluid">
    <div class="span12">

        <!-- Tabs

              ================================================== -->

        <ul id="myTab" class="nav nav-tabs">

            <li class="active"><a href="#latestQuote" data-toggle="tab">Latest Quote</a></li>

            <li class=""><a href="#allQuote" data-toggle="tab">All Quote</a></li>

        </ul>

        <div id="myTabContent" class="tab-content">

            <div class="tab-pane fade active in" id="latestQuote">

                <c:forEach items="${latestQuote.voList}" var="transaction">
                    <div class="boxblog">

                        <h5><a href="#">${transaction.quoteTitle}</a></h5>

                        <p class="small datepost">

                            Posted on ${transaction.quotePostDate} <span class="floatright" title="3 responses"><a href="#"><img src="img/comments.png" alt=""></a></span>

                        </p>

                        <div class="innerblogboxtwo">

                            <div class="row-fluid">
                                <div class="span4">Days</div>
                                <div class="span8">${transaction.rawDay}</div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4">Price</div>
                                <div class="span8">${transaction.rawPrice}</div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4">Description</div>
                                <div class="span8">${transaction.comment}</div>
                            </div>

                        </div>

                    </div>
                </c:forEach>

            </div>

            <div class="tab-pane fade" id="allQuote">
                <div class="listContainer">

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
<div class="modal hide fade" id="quoteTransactionDetail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Quote Details</h4>
            </div>
            <div class="modal-body">
                <div class="tabbable tabs-left">

                    <!--bootstrap tabs implementation-->

                    <ul class="nav nav-tabs">

                        <!--tabs-->

                        <li class="active">

                            <a data-toggle="tab" href="#quoteDetailsTab">Quote Details</a>

                        </li>

                        <li>

                            <a data-toggle="tab" href="#quoteApplyTab">Apply</a>

                        </li>

                        <li>

                            <a data-toggle="tab" href="#quoteMessage">Message</a>

                        </li>

                    </ul>

                    <!--tabs content -->

                    <div class="tab-content">

                        <div id="quoteDetailsTab" class="tab-pane active fade in">
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold">Category</div>
                                <div class="span8 " id="quoteCategory">

                                </div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold">Location</div>
                                <div class="span8" id="quoteSuburb"></div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold">Description</div>
                                <div class="span8" id="quoteComment"></div>
                            </div>
                        </div>

                        <div id="quoteApplyTab" class="tab-pane fade ">
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold">Days</div>
                                <div class="span8 " id="applyRawDays"></div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold">Price</div>
                                <div class="span8" id="applyRawPrice"></div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold">Service Type</div>
                                <div class="span8" id="applyServiceType"></div>
                            </div>
                            <div class="row-fluid">
                                <div class="span4" style="font-family:open_sansbold">Comment</div>
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
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/merchant/merchantQuoteList.js" />
</body>