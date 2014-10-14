<%@include file="globe.jsp" %>
<html>
<head>
    <meta name="description" content="merchant list">
    <title>Search Merchant</title>
    <link href="/assets/css/jquery.raty.css" rel="stylesheet">
</head>
<body>
<div class="page-header">

    <h1>Search Result</h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid">
    <div class="titleborder">

        <div>

            Filter

        </div>

    </div>
    <div class="form-actions" align="center">
        <div class="row-fluid">
            <div class="span12">
                <input id="filterWord" class="span12" type="text" name="name" placeholder="Keyword">
            </div>
            <div class="span12">
                <div class="span4">
                    <input type='hidden' name="suburb" size="30" id="filterSuburb"
                           class="span12 populate placeholder select2-offscreen"
                           style="margin-bottom: 10px; margin-left: 0;">
                    </input>
                </div>
                <div class="span4">
                    <select name="name" size="30" id="filterCategory"
                            class="populate placeholder select2-offscreen span12" style="margin-bottom: 10px; margin-left: 0;">
                        <option value="">All Category</option>
                        <c:forEach items="${categoryGroupList}" var="categoryGroup">
                            <optgroup label="${categoryGroup.name}">
                                <c:forEach items="${categoryGroup.categoryList}" var="category">
                                    <option value="${category.name}">${category.name}</option>
                                </c:forEach>
                            </optgroup>
                        </c:forEach>
                    </select>

                </div>
                <div class="span4">
                    <button id="filterBtn" class="btn btn-primary span8"> Filter</button>
                </div>
            </div>
        </div>

    </div>
</div>
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

    <div class="form-actions load-more" align="center">
        <button id="loadMore" class="btn btn-primary"> Load More <i class="icon-ok icon-arrow-right"></i>
        </button>
    </div>


</div>
<script src="${pageContext.request.contextPath}/assets/js/jquery.raty.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/prettify.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/searchResult.js"></script>
</body>
</html>