<%@include file="../globe.jsp"%>
<html>
<head>
    <meta name="description" content="merchant feedback ">
    <title>Merchant Feedback</title>
    <link href="/assets/css/prettify_bootstrap.css" rel="stylesheet">
    <link href="/assets/css/jquery.raty.css" rel="stylesheet">
</head>
<body>
<div class="page-header">

    <h1>I want to say something</h1>

    <div class="headerdivider">

    </div>

</div>
<div class="row-fluid top30">

    <div class="span10">
        <div class="titleborder">

            <div>

                Feedback

            </div>

        </div>
        <div class="alert alert-error" id="merchantRsgErrorBox" style="display: none;">

            <button type="button" class="close" data-dismiss="alert">x</button>

            <strong>Oh snap!</strong> Change a few things up and try submitting again.

        </div>
        <form class="form-horizontal" id="merchantRegisterForm" novalidate>
            <div class="control-group">
                <label class="control-label" for="tradeName">Merchant Name</label>
                <div class="controls">
                    <input name="tradeName" size="30" class="span12" type="text"
                           readonly value="${merchant.tradeName}"
                           id="tradeName" placeholder="TradeName" >
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="email">Email</label>
                <div class="controls">
                    <c:choose>
                      <c:when test="${not empty user}">
                        <input name="email" size="30" type="email" id="email" class="span12" placeholder="Email" required value="${user.email}" readonly>
                      </c:when>
                      <c:otherwise>
                        <input name="email" size="30" type="email" id="email" class="span12" placeholder="Email" required>
                      </c:otherwise>
                    </c:choose>

                    <p class="help-block">Contact Email</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="userName">Name</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="userName" class="span12" placeholder="Contact One">
                    <p class="help-block">Name</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tradeName">Rank</label>
                <div class="controls">
                    <div id="rankBox"></div>
                    <p class="help-block">I like to rank it</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="comment">Comment</label>
                <div class="controls">
                    <textarea id="comment" name="message" class="span12" placeholder="Description" rows="8"></textarea>
                    <p class="help-block">What you want to say</p>
                </div>
            </div>
            <input name="name" size="30" type="hidden" id="keyString" class="span12"
                   value="${merchant.keyString}">
            <br/>
            <div class="form-actions">
                <button type="submit" class="btn btn-primary"> Submit <i class="icon-ok icon-white"></i></button><br />
            </div>
        </form>

    </div>

</div>
<div class="modal fade" id="successDlg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="successDlgLabel">Feedback Created</h4>
            </div>
            <div class="modal-body">
                Your feedback has been saved.
            </div>
            <div class="modal-footer">
                <a href="/merchant/details/${merchant.url}" class="btn btn-primary">Close</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jqBootstrapValidation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/prettify.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.raty.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/feedback/merchantFeedback.js"></script>
</body>
</html>