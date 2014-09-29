<%@include file="../globe.jsp" %>
<html>
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

<div class="row-fluid">

    <div class="span12">

        <div class="titleborder">

            <div>

                List of Message

            </div>

        </div>

        <!-- Tabs

              ================================================== -->

        <ul id="myTab" class="nav nav-tabs">

            <li class="active"><a href="#quoting" data-toggle="tab">Quoting</a></li>

            <li class=""><a href="#contacting" data-toggle="tab">Contacting</a></li>

            <li class=""><a href="#feedback" data-toggle="tab">Feedback</a></li>

            <li class=""><a href="#all" data-toggle="tab">All</a></li>

        </ul>

        <div id="myTabContent" class="tab-content">

            <div class="tab-pane fade active in" id="quoting">

                <c:if test="${not empty quoteList['Quoting']}">
                    <c:set var="quotingList" value="${quoteList['Quoting']}"/>
                    <div class="quoteList">
                        <!-- Panels ================================================== -->

                        <c:forEach items="${quotingList}" var="quotingItem">
                            <div class="row-fluid">

                                <div class="panel">

                                    <div class="info-box-inner">

                                        <div class="info-content">

                                            <h4><a href="/quote/d/${quotingItem.keyString}">${quotingItem.title}</a>
                                            </h4>

                                            <p>

                                                    ${quotingItem.description}

                                            </p>

                                        </div>
                                        <div class="clearfix">

                                        </div>

                                    </div>

                                </div>

                            </div>
                        </c:forEach>
                    </div>
                    <div class="form-actions" align="center">
                        <button type="submit" class="btn btn-primary">Load More >> <i class="icon-ok icon-white"></i>
                        </button>
                        <br/>
                        (100 more)
                    </div>
                </c:if>


            </div>

            <div class="tab-pane fade" id="contacting">

                <c:if test="${not empty quoteList['Contacting']}">
                    <c:set var="quotingList" value="${quoteList['Contacting']}"/>

                    <!-- Panels ================================================== -->

                    <c:forEach items="${quotingList}" var="quotingItem">
                        <div class="row-fluid">

                            <div class="panel">

                                <div class="info-box-inner">

                                    <div class="info-content">

                                        <h4><a href="/quote/d/${quotingItem.keyString}">${quotingItem.title}</a></h4>

                                        <p>

                                                ${quotingItem.description}

                                        </p>

                                    </div>
                                    <div class="clearfix">

                                    </div>

                                </div>

                            </div>

                        </div>
                    </c:forEach>

                </c:if>

            </div>

            <div class="tab-pane fade" id="feedback">

                <c:if test="${not empty quoteList['Feedback']}">
                    <c:set var="quotingList" value="${quoteList['Feedback']}"/>

                    <!-- Panels ================================================== -->

                    <c:forEach items="${quotingList}" var="quotingItem">
                        <div class="row-fluid">

                            <div class="panel">

                                <div class="info-box-inner">

                                    <div class="info-content">

                                        <h4><a href="/quote/d/${quotingItem.keyString}">${quotingItem.title}</a></h4>

                                        <p>

                                                ${quotingItem.description}

                                        </p>

                                    </div>
                                    <div class="clearfix">

                                    </div>

                                </div>

                            </div>

                        </div>
                    </c:forEach>

                </c:if>

            </div>

            <div class="tab-pane fade" id="all">

            </div>

        </div>

        <!-- END Tabs -->

    </div>

</div>
</body>

<!-- /END Panels -->
<script type="text/javascript" src="/assets/js/postQuote.js"></script>