<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="Quote List">
    <title>Quote List - Merchant</title>
</head>
<body>
<div class="page-header">

    <h1>My Quote</h1>

    <div class="headerdivider">

    </div>

</div>

    <!-- Filtering Menu

        ================================================== -->

    <div class="row-fluid">

        <div class="span12 text-center">

            <div id="filter">

                <ul>

                    <li><a href="" data-filter="*" class="filter-btn selected"><i class="icon icon-reorder"></i>&nbsp; All Items</a>
                    </li>

                    <li><a href="" data-filter=".Quoting" class="filter-btn"><i class="icon icon-th-large"></i>&nbsp; Quoting</a></li>

                    <li><a href="" data-filter=".Contacting" class="filter-btn"><i class="icon icon-comment"></i>&nbsp; Contacting</a></li>

                    <li><a href="" data-filter=".Feedback" class="filter-btn"><i class="icon icon-thumbs-up"></i>&nbsp; Feedback</a></li>

                    <li><a href="/u/qa"><i class="icon icon-archive"></i>&nbsp; History</a></li>

                </ul>

            </div>

        </div>

    </div>

    <!-- END filtering menu -->

    <div id="content">

    <!-- box 1 -->
    <c:forEach items="${quoteList}" var="quote">
        <div class="boxportfolio25 item ${quote.status}">

            <div class="box">
                <p class="small datepost">
                    <a href="/quote/d/${quote.keyString}" style="font-size: 15px;">${quote.title}</a>
                </p>
                <p>
                    <span class="">${quote.quoteTransactionCount} replies</span> <br/>
                    <c:choose>
                        <c:when test="${quote.status == 'Quoting'}">
                            <a class="btn btn-small btn-info">${quote.status}</a>
                        </c:when>
                        <c:when test="${quote.status == 'Contacting'}">
                            <a class="btn btn-small btn-primary">${quote.status}</a>
                        </c:when>
                        <c:otherwise>
                            <a class="btn btn-small btn-success">${quote.status}</a>
                        </c:otherwise>
                    </c:choose>

                </p>

            </div>

        </div>
    </c:forEach>



    <!-- next box etc -->

    <!-- MASONRY ITEMS END -->

    </div>

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/quote/myQuote.js"></script>
</body>

<!-- /END Panels -->
</html>