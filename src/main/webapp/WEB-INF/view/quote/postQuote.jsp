<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="Post New Quote">
    <title>Post New Quote</title>
</head>
<body>
<div class="page-header">

    <h1>Post Quote</h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid top30">

    <div class="span10">
        <div class="titleborder">

            <div>

                Quote Details

            </div>

        </div>
        <div class="alert alert-error" id="merchantRsgErrorBox" style="display: none;">

            <button type="button" class="close" data-dismiss="alert">x</button>

            <strong>Oh snap!</strong> Change a few things up and try submitting again.

        </div>

        <form class="form-horizontal" id="postQuoteForm" novalidate>
            <div class="control-group">
                <label class="control-label" for="email">Email</label>

                <div class="controls">
                    <sec:authorize access="isAuthenticated()">
                        <sec:authentication property='principal.email' var="userEmail"/>
                        <input name="email" size="30" type="text" id="email" value="${userEmail}" class="span12"
                               placeholder="Email" required>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        <input name="email" size="30" type="text" id="email" class="span12" placeholder="Email"
                               required>
                    </sec:authorize>

                    <p class="help-block">Your email address</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="quoteTitle">Title</label>

                <div class="controls">
                    <input name="quoteTitle" size="30" type="text" id="quoteTitle" class="span12" placeholder="Title"
                           required>

                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="category_select">Category</label>

                <div class="controls">
                    <select multiple="multiple" name="category" size="30" id="category_select"
                            class="populate placeholder select2-offscreen span12"
                            style="margin-bottom: 10px; margin-left: 0;">
                        <c:forEach items="${categoryGroupList}" var="categoryGroup">
                            <optgroup label="${categoryGroup.name}">
                                <c:forEach items="${categoryGroup.categoryList}" var="category">
                                    <option value="${category.name}">${category.name}</option>
                                </c:forEach>
                            </optgroup>
                        </c:forEach>
                    </select>

                    <p class="help-block"></p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="suburb">Suburb</label>

                <div class="controls">
                    <input type='hidden' name="suburb" size="30" id="suburb"
                           class="populate placeholder select2-offscreen span12"
                           style="margin-bottom: 10px; margin-left: 0;">

                    </input>
                    <p class="help-block"></p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="description">Description</label>

                <div class="controls">
                    <textarea id="description" name="description" class="span12" placeholder="Description"
                              rows="8"></textarea>

                    <p class="help-block">Descripte your requirement </p>
                </div>
            </div>
            <br/>

            <div class="form-actions">
                <button type="submit" class="btn btn-primary"> Post Quote <i class="icon-ok icon-white"></i></button>
                <br/>
            </div>

        </form>

    </div>

</div>

<div class="modal fade" id="successDlg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="successDlgLabel">Quote Created</h4>
            </div>
            <div class="modal-body">
                Your Quote has been posted.
            </div>
            <div class="modal-footer">
                <a href="/home" class="btn btn-default" data-dismiss="modal">Go To Home</a>
                <a href="/u/q" class="btn btn-primary">Go To My Quote</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jqBootstrapValidation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/prettify.js"></script>
<script type="text/javascript" src="/assets/js/quote/postQuote.js"></script>
</body>
</html>