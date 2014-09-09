<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="page-header">

    <h1>My Quote</h1>

    <div class="headerdivider">

    </div>

</div>

<c:if test="${not empty quoteList['Quoting']}">
    <c:set var="quotingList" value="${quoteList['Quoting']}"/>
    <div class="break">

    </div>

    <div class="titleborder">

        <div>

            Quoting

        </div>

    </div>

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

<c:if test="${not empty quoteList['Contacting']}">
    <c:set var="quotingList" value="${quoteList['Contacting']}"/>
    <div class="break">

    </div>

    <div class="titleborder">

        <div>

            Contacting

        </div>

    </div>

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

<c:if test="${not empty quoteList['Feedback']}">
    <c:set var="quotingList" value="${quoteList['Feedback']}"/>
    <div class="break">

    </div>

    <div class="titleborder">

        <div>

            Feedback

        </div>

    </div>

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


<!-- /END Panels -->
<script type="text/javascript" src="/assets/js/postQuote.js"></script>