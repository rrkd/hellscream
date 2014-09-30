<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="Quote Details">
    <title>Quote Details - ${quote.title}</title>
</head>
<body>
<div class="page-header">

    <h1>Quote Details</h1>

    <div class="headerdivider">

    </div>

</div>
<div class="row-fluid">

    <div class="span12 span-fixed-sidebar">

        <div class="row-fluid">

            <div class="span12">

                <header class="entry-header">

                    <div class="sectiontitlepost">

                        <h1>${quote.title}</h1>

                    </div>

                    <div class="entry-meta">

                        <a href="#"><span class="entry-date">${quote.postDate}</span></a>

                        <span class="pull-right"><a href="#"><span>3</span> Comments</a></span>

                    </div>

                    <!-- .entry-meta -->

                </header>

                <div class="innerblogboxtwo">

                    <div class="entry-content" style="min-height: 200px;">

                        <div class="row-fluid">
                            <div class="span4">Category</div>
                            <div class="span8">
                                <c:forEach items="${quote.categoryList}" var="category" begin="0">
                                    <a class="btn btn-small" href="#">${category}</a>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span4">Location</div>
                            <div class="span8"></div>
                        </div>
                        <div class="row-fluid">
                            <div class="span4">Description</div>
                            <div class="span8">${quote.description}</div>
                        </div>
                    </div>

                    <footer class="entry-meta">

                        Posted in <a href="#" title="View all posts in Stories">Stories</a> and tagged <a href="#"
                                                                                                          rel="tag">grace</a>
                        by <a href="#">serenity</a>.
                    </footer>

                </div>

            </div>

            <!--/span-->
            <div id="comments">

                <div class="blogbox comments-area">

                    <h3 class="commentstitle">

                        <i class="icon-comments muted"></i> List of Application </h3>

                    <div class="comment-list left0">

                        <ul class="media">

                            <c:forEach items="${quote.quoteTransactions}" var="quoteTransaction">
                                <li class="comment">

                                    <article class="comment">

                                        <div class="row-fluid">
                                            <div class="span8">
                                                <footer>

                                                    <span class="comment-author vcard">

                                                    <span class="pull-left"><img alt=""
                                                                                 src="http://1.gravatar.com/avatar/3d988ca07c9fc4afb310dc8fbd015f9d?s=54&amp;d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D54&amp;r=G"
                                                                                 class="avatar avatar-54 photo" height="54"
                                                                                 width="54"></span>

                                                    <cite class="fn">${quoteTransaction.merchant.contact1}</cite> <span
                                                            class="says">on</span></span>

                                                                <!-- .comment-author .vcard -->

                                                    <span class="comment-meta commentmetadata">

                                                    <a href="#">

                                                            ${igooit:formatDate(quoteTransaction.createdOn)}

                                                    </a>

                                                    </span>

                                                    <!-- .comment-meta .commentmetadata -->

                                                </footer>
                                            </div>
                                            <div class="span4">
                                                <div class="reply">
                                                    <c:if test="${quoteTransaction.quoteTransactionStatus eq 'Appending'}">
                                                        <a class="badge" href="/u/c/${quoteTransaction.keyString}">Contact
                                                            Merchant</a>
                                                    </c:if>
                                                    <c:if test="${quoteTransaction.quoteTransactionStatus ne 'Appending'}">
                                                        <a class="badge badge-success">Contacted.</a>
                                                    </c:if>
                                                </div>

                                                <!-- .reply -->
                                            </div>
                                        </div>


                                        <div class="comment-content">

                                            <div class="row-fluid">
                                                <div class="span4">Merchant</div>
                                                <div class="span8">
                                                    <a href="/merchant/details/${quoteTransaction.merchant.canonicalSlugId}">${quoteTransaction.merchant.tradeName}</a>
                                                </div>
                                            </div>
                                            <div class="row-fluid">
                                                <div class="span4">Days</div>
                                                <div class="span8">${quoteTransaction.rawDay}</div>
                                            </div>
                                            <div class="row-fluid">
                                                <div class="span4">Price</div>
                                                <div class="span8">${quoteTransaction.rawPrice}</div>
                                            </div>
                                            <p align="right">
                                                <a href="#" class="application-details" data-key="${quoteTransaction.keyString}">Application Details >></a>
                                            </p>

                                        </div>


                                    </article>

                                    <!-- #comment-## -->

                                </li>
                            </c:forEach>
                        </ul>

                    </div>

                    <!-- .commentlist -->

                </div>
            </div>
        </div>

        <!--/row-->

    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="quoteDetailsDlg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
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
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary modal-contact-merchant" >Contact Merchant</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/quote/quoteDetails.js" />
</body>
</html>