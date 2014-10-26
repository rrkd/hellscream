<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="Apply Quote">
    <title><spring:message code="applyquote.title" /></title>
    <link href="/assets/css/prettify_bootstrap.css" rel="stylesheet">
</head>
<body>
<c:choose>
    <c:when test="${bApplied}">
        <div class="page-header">

            <h1><spring:message code="applyquote.applied" /></h1>

            <div class="headerdivider">

            </div>

        </div>
        <div class="row-fluid top30">
            <div class="span10">
                <div class="form-actions">
                    <button class="btn btn-primary" onclick="location.href = '/merchant/msg';"><spring:message code="applyquote.appliedlist" /><i class="icon-reorder icon-white"></i>
                    </button>
                    <br/>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="page-header">

            <h1><spring:message code="applyquote.applyquote" /></h1>

            <div class="headerdivider">

            </div>

        </div>

        <div class="row-fluid top30">
            <div class="span10">
                <div class="titleborder">

                    <div>

                        <spring:message code="applyquote.quotedetail" />

                    </div>

                </div>
                <dl class="faqs" style="border:0px;">

                    <dt class="">${quote.title}</dt>

                    <dd style="display: none;">
                        <div class="row-fluid">
                            <div class="span4"><spring:message code="applyquote.category" /></div>
                            <div class="span8">
                                <c:forEach items="${quote.categoryList}" var="category" begin="0">
                                    <a class="btn btn-small" href="#">${category}</a>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span4"><spring:message code="applyquote.location" /></div>
                            <div class="span8"></div>
                        </div>
                        <div class="row-fluid">
                            <div class="span4"><spring:message code="applyquote.description" /></div>
                            <div class="span8">${quote.description}</div>
                        </div>
                    </dd>

                </dl>
            </div>

            <div class="span10">
                <div class="titleborder">

                    <div>
                        <spring:message code="applyquote.basicinfo" />
                    </div>

                </div>
                <div class="alert alert-error" id="merchantRsgErrorBox" style="display: none;">

                    <button type="button" class="close" data-dismiss="alert">x</button>

                    <strong>Oh snap!</strong> <spring:message code="applyquote.warningmessage" />

                </div>

                <form class="form-horizontal" id="merchantRegisterForm" novalidate>
                    <div class="control-group">
                        <label class="control-label" for="tradeName"><spring:message code="applyquote.tradename" /></label>

                        <div class="controls">
                            <input name="name" size="30" type="text" id="tradeName" class="span12" placeholder="TradeName"
                                   readonly value="${merchant.tradeName}">

                            <p class="help-block"></p>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="tradeName"><spring:message code="applyquote.days" /></label>

                        <div class="controls">
                            <input name="name" size="30" type="number" id="rawDay" class="span12" placeholder="<spring:message code="applyquote.rawdays" />">

                            <p class="help-block"><spring:message code="applyquote.daysneed" /></p>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="tradeName"><spring:message code="applyquote.price" /></label>

                        <div class="controls">
                            <input name="name" size="30" data-symbol="$" type="number" min="0.01" step="0.01" id="rawPrice"
                                   class="span12" placeholder="<spring:message code="applyquote.rawprice" />">

                            <p class="help-block"><spring:message code="applyquote.price" /></p>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="tradeName"><spring:message code="applyquote.starttime" /></label>

                        <div class="controls">
                            <select name="name" size="30" id="type_select"
                                    class="populate placeholder select2-offscreen span12"
                                    style="margin-bottom: 10px; margin-left: 0;">
                                <option value="Immediately"><spring:message code="applyquote.immediately" /></option>
                                <option value="Scheduled"><spring:message code="applyquote.scheduled" /></option>
                            </select>

                            <p class="help-block"><spring:message code="applyquote.whencanstart" /></p>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="tradeName"><spring:message code="applyquote.description" /></label>

                        <div class="controls">
                            <textarea id="description" name="message" class="span12" placeholder="<spring:message code="applyquote.description.placeholder" />"
                                      rows="8"></textarea>

                            <p class="help-block"><spring:message code="applyquote.description.tip" /></p>
                        </div>
                    </div>
                    <input name="name" size="30" type="hidden" id="keyString" class="span12"
                           value="${quote.keyString}">
                    <input name="name" size="30" type="hidden" id="merchantKeyString" class="span12"
                           value="${merchant.keyString}">
                    <br/>

                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary"><spring:message code="applyquote.wanttoapply" /> <i class="icon-ok icon-white"></i>
                        </button>
                        <br/>
                        <spring:message code="applyquote.wanttoapply.placeholder" />
                    </div>

                </form>

            </div>

        </div>
    </c:otherwise>
</c:choose>
<div class="modal fade" id="successDlg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="successDlgLabel"> <spring:message code="applyquote.quoteapplied" /></h4>
            </div>
            <div class="modal-body">
                <spring:message code="applyquote.quoteapplied.message" />
            </div>
            <div class="modal-footer">
                <a href="/home" class="btn btn-default" data-dismiss="modal"> <spring:message code="applyquote.gotohome" /></a>
                <a href="/m/q" class="btn btn-primary"> <spring:message code="applyquote.gotoappliedpage" /></a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jqBootstrapValidation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/prettify.js"></script>
<script type="text/javascript" src="/assets/js/quote/applyQuote.js"></script>
</body>