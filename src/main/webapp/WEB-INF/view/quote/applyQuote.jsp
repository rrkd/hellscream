<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="Apply Quote">
    <title>Apply Quote</title>
    <link href="/assets/css/prettify_bootstrap.css" rel="stylesheet">
</head>
<body>
<c:choose>
    <c:when test="${bApplied}">
        <div class="page-header">

            <h1>You have applied this quote.</h1>

            <div class="headerdivider">

            </div>

        </div>
        <div class="row-fluid top30">
            <div class="span10">
                <div class="form-actions">
                    <button class="btn btn-primary" onclick="location.href = '/merchant/msg';"> Browser My Applied List <i class="icon-reorder icon-white"></i>
                    </button>
                    <br/>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="page-header">

            <h1>Apply Quote</h1>

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
                <dl class="faqs" style="border:0px;">

                    <dt class="">${quote.title}</dt>

                    <dd style="display: none;">
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
                    </dd>

                </dl>
            </div>

            <div class="span10">
                <div class="titleborder">

                    <div>

                        Basic Information

                    </div>

                </div>
                <div class="alert alert-error" id="merchantRsgErrorBox" style="display: none;">

                    <button type="button" class="close" data-dismiss="alert">x</button>

                    <strong>Oh snap!</strong> Change a few things up and try submitting again.

                </div>

                <form class="form-horizontal" id="merchantRegisterForm" novalidate>
                    <div class="control-group">
                        <label class="control-label" for="tradeName">Trade Name</label>

                        <div class="controls">
                            <input name="name" size="30" type="text" id="tradeName" class="span12" placeholder="TradeName"
                                   readonly value="${merchant.tradeName}">

                            <p class="help-block"></p>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="tradeName">Days</label>

                        <div class="controls">
                            <input name="name" size="30" type="number" id="rawDay" class="span12" placeholder="rawDays">

                            <p class="help-block">How many days you need</p>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="tradeName">Price</label>

                        <div class="controls">
                            <input name="name" size="30" data-symbol="$" type="number" min="0.01" step="0.01" id="rawPrice"
                                   class="span12" placeholder="rawPrice">

                            <p class="help-block">Price</p>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="tradeName">Start Time</label>

                        <div class="controls">
                            <select name="name" size="30" id="type_select"
                                    class="populate placeholder select2-offscreen span12"
                                    style="margin-bottom: 10px; margin-left: 0;">
                                <option value="Immediately">Immediately</option>
                                <option value="Scheduled">Scheduled</option>
                            </select>

                            <p class="help-block">When can you start</p>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="tradeName">Description</label>

                        <div class="controls">
                            <textarea id="description" name="message" class="span12" placeholder="Description"
                                      rows="8"></textarea>

                            <p class="help-block">Description</p>
                        </div>
                    </div>
                    <input name="name" size="30" type="hidden" id="keyString" class="span12"
                           value="${quote.keyString}">
                    <input name="name" size="30" type="hidden" id="merchantKeyString" class="span12"
                           value="${merchant.keyString}">
                    <br/>

                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary"> I want to apply <i class="icon-ok icon-white"></i>
                        </button>
                        <br/>
                        (I want to apply this.)
                    </div>

                </form>

            </div>

        </div>
    </c:otherwise>
</c:choose>

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jqBootstrapValidation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/prettify.js"></script>
<script type="text/javascript" src="/assets/js/quote/applyQuote.js"></script>
</body>