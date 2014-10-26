<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="Post New Quote">
    <title><spring:message code="postquote.heading" /></title>
</head>
<body>
<div class="page-header">

    <h1><spring:message code="postquote.heading" /></h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid top30">

    <div class="span10">
        <div class="titleborder">

            <div>

                <spring:message code="postquote.details" />

            </div>

        </div>
        <div class="alert alert-error" id="merchantRsgErrorBox" style="display: none;">

            <button type="button" class="close" data-dismiss="alert">x</button>

            <strong>Oh snap!</strong> <spring:message code="postquote.warningmessage" />

        </div>

        <form class="form-horizontal" id="postQuoteForm" novalidate>
            <div class="control-group">
                <label class="control-label" for="email"><spring:message code="postquote.email" /></label>

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

                    <p class="help-block"><spring:message code="postquote.emailtips" /></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="quoteTitle"><spring:message code="postquote.title" /></label>

                <div class="controls">
                    <input name="quoteTitle" size="30" type="text" id="quoteTitle" class="span12" placeholder="<spring:message code="postquote.title.placehoder" />"
                           required>

                    <p class="help-block"><spring:message code="postquote.titletips" /></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="category_select"><spring:message code="postquote.category" /></label>

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

                    <p class="help-block"><spring:message code="postquote.categorytips" /></p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="suburb"><spring:message code="postquote.suburb" /></label>

                <div class="controls">
                    <input type='hidden' name="suburb" size="30" id="suburb"
                           class="populate placeholder select2-offscreen span12"
                           style="margin-bottom: 10px; margin-left: 0;">

                    </input>
                    <p class="help-block"><spring:message code="postquote.suburbtips" /></p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="description"><spring:message code="postquote.description" /></label>

                <div class="controls">
                    <textarea id="description" name="description" class="span12" placeholder="<spring:message code="postquote.description.placeholder" />"
                              rows="8"></textarea>

                    <p class="help-block"><spring:message code="postquote.descriptiontips" /></p>
                </div>
            </div>
            <br/>

            <div class="form-actions">
                <button type="submit" class="btn btn-primary"> <spring:message code="postquote.postquote" /><i class="icon-ok icon-white"></i></button>
                <br/>
            </div>

        </form>

    </div>

</div>

<div class="modal fade" id="successDlg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="successDlgLabel"><spring:message code="postquote.quotecreated" /></h4>
            </div>
            <div class="modal-body">
                <spring:message code="postquote.createdmessage" />
            </div>
            <div class="modal-footer">
                <a href="/home" class="btn btn-default" data-dismiss="modal"><spring:message code="postquote.gohome" /></a>
                <a href="/u/q" class="btn btn-primary"><spring:message code="postquote.myquote" /></a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jqBootstrapValidation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/prettify.js"></script>
<script type="text/javascript" src="/assets/js/quote/postQuote.js"></script>
</body>
</html>