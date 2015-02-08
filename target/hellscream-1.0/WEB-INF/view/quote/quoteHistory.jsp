<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="Quote history">
    <title><spring:message code="quotehistory.heading" /></title>
</head>
<body>
<div class="page-header">

    <h1><spring:message code="quotehistory.heading" /></h1>

    <div class="headerdivider">

    </div>
    <input name="name" size="30" type="hidden" id="userKeyString" class="span12"
           value="${iguser.keyString}">
</div>
<div class="row-fluid">
    <div class="span12">
        <div class="listContainer">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>#</th>
                        <th><spring:message code="quotehistory.title" /></th>
                        <th><spring:message code="quotehistory.posttime" /></th>
                        <th><spring:message code="quotehistory.detail" /></th>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/quote/quoteHistory.js"></script>
</body>
</html>