<%@include file="globe.jsp" %>
<html>
<div class="page-header">

    <h1>Merchant List</h1>

    <div class="headerdivider">

    </div>

</div>

<div id="content" class="top30">

    <!-- item -->

    <c:forEach items="${searchResultList.merchantList}" var="vo">
        <div class="row-fluid">

                <%--<div class="panel1">--%>
            <div class="well well-large well-transparent clearfix">
                <c:choose>
                    <c:when test="${not empty vo.merchant.imageFileName}">
                        <img src="${vo.merchant.imageFileName}" alt="">
                    </c:when>
                    <c:otherwise>
                        <i class="icon-flag icon-4x pull-left icon-border"></i>
                    </c:otherwise>
                </c:choose>
                <p>
                <h4>
                    <a href="merchant/details/${vo.merchant.url}">${vo.merchant.tradeName}</a>
                </h4>
                <a class="btn btn-small btn-inverse" href="#">120</a>
                <a class="btn btn-small btn-success" href="#">5</a>
                <a class="btn btn-small btn-info" href="#">0</a>
                <c:forEach items="${vo.merchant.categoryList}" var="category" begin="0">
                    <a class="btn btn-small" href="#">${category}</a>
                </c:forEach>
                </p>

                <p>
                        ${vo.merchant.description}
                </p>
                <p align="right">
                        <span class="entry-date">${vo.merchant.phone}</span>, <span class="entry-date">${vo.merchant.email}</span>
                </p>
            </div>

                <%--</div>--%>

            <div class="clearfix">

            </div>

        </div>
    </c:forEach>

    <!-- item etc -->
    <c:if test="${searchResultList.total > 0}">
        <div class="pagination pagination-large">

            <ul>
                <c:choose>
                    <c:when test="${searchResultList.pageNum} == 1">
                        <li><a href="/merchant?p=1"><<</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/merchant?p=${searchResultList.pageNum - 1}"><<</a></li>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${searchResultList.total <= 3}">
                        <c:forEach begin="0" end="${searchResultList.total - 1}" varStatus="loop">
                            <c:choose>
                                <c:when test="${(loop.index+1) == searchResultList.pageNum}">
                                    <li><a class="active" href="/merchant?p=${loop.index + 1}">${loop.index + 1}</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="/merchant?p=${loop.index + 1}">${loop.index + 1}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${searchResultList.pageNum <= 3}">
                                <c:forEach begin="0" end="2" varStatus="loop">
                                    <c:choose>
                                        <c:when test="${(loop.index+1) == searchResultList.pageNum}">
                                            <li><a class="active" href="/merchant?p=${loop.index + 1}">${loop.index + 1}</a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li><a href="/merchant?p=${loop.index + 1}">${loop.index + 1}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <c:forEach begin="${searchResultList.pageNum - 2}" end="${searchResultList.pageNum}"
                                           varStatus="loop2">
                                    <c:choose>
                                        <c:when test="${loop2.index == searchResultList.pageNum}">
                                            <li><a class="active" href="/merchant?p=${loop2.index + 1}">${loop2.index + 1}</a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li><a href="/merchant?p=${loop2.index + 1}">${loop2.index + 1}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>

                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${searchResultList.pageNum >= 3}">
                        <c:if test="${searchResultList.pageNum < searchResultList.total}">
                            <li><a href="/merchant?p=${searchResultList.pageNum + 1}">...</a></li>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${searchResultList.total > 3}">
                            <li><a href="/merchant?p=4">...</a></li>
                        </c:if>
                    </c:otherwise>

                </c:choose>

                <c:choose>
                    <c:when test="${searchResultList.pageNum + 1 < searchResultList.total}">
                        <li><a href="/merchant?p=${searchResultList.pageNum + 1}">>></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/merchant?p=${searchResultList.total}">>></a></li>
                    </c:otherwise>
                </c:choose>

            </ul>

        </div>
    </c:if>

</div>


<div class="row-fluid top30">

    <div class="span12">

        <div class="info-box shadow-large bottom0">

            <div class="info-box-inner">

                <div class="info-content">

                    <h4>List Your Business</h4>

                    <p>

                        Praesent vestibulum molestie.

                    </p>

                </div>

                <a style="float: right;" class="btn btn-primary btn-large" href="#"><i class="icon-download-alt"></i>&nbsp;
                    List Your Business</a>

                <div class="clearfix">

                </div>

            </div>

        </div>

    </div>

</div>