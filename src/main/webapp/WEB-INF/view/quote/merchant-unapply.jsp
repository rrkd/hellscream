<%@include file="../globe.jsp" %>
<html>
<head>
  <meta name="description" content="Quote List">
  <title><spring:message code="myquote.title" /></title>
</head>
<body>
<div class="page-header">

  <h1><spring:message code="myquote.title" /></h1>

  <div class="headerdivider">

  </div>
  <input type="hidden" id="merchantKey" value="${merchant.keyString}">

</div>

<div class="row-fluid">
  <div class="span12">
    <div class="listContainer">
      <table class="table table-striped table-hover">
        <thead>
        <tr>
          <th>#</th>
          <th><spring:message code="quotehistory.title" /></th>
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

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/quote/merchant-unapply.js"></script>
</body>

<!-- /END Panels -->
</html>