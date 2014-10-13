<%@include file="globe.jsp" %>
<html>
<head>
    <meta name="description" content="merchant list">
    <title>Search Merchant</title>
    <link href="/assets/css/jquery.raty.css" rel="stylesheet">
</head>
<body>
<div class="row-fluid">

    <div class="span12 span-fixed-sidebar">

        <c:forEach items="${merchantList}" var="heroMerchant" begin="0" end="0">
            <div class="hero-unit" style="min-height: 400px;">

                <h1>${heroMerchant.tradeName}</h1>
                <p>
                    <div class="merchant-rank" data-rank="${heroMerchant.rank}"></div>
                </p>
                <p>

                    <img src="${heroMerchant.imageFileName}" class="pull-left paddingright" alt=""
                         style="margin-top:10px;">
                        ${heroMerchant.description}

                </p>

                <p>

                    <a href="merchant/details/${heroMerchant.keyString}" class="btn btn-primary btn-large">Read more
                        >></a>

                </p>

            </div>
        </c:forEach>

        <div class="row-fluid" id="resultContainer">


        </div>

        <!--/row-->

    </div>

    <div class="form-actions" align="center">
        <button id="loadMore" class="btn btn-primary"> Load More <i class="icon-ok icon-arrow-right"></i>
        </button>
    </div>


</div>
<script src="${pageContext.request.contextPath}/assets/js/jquery.raty.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/searchResult.js"></script>
</body>
</html>