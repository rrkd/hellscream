<%@include file="../globe.jsp" %>
<head>
    <meta name="description" content="merchant list">
    <title>${vo.merchant.merchantName}</title>
    <link href="/assets/css/jquery.raty.css" rel="stylesheet">
</head>
<body>
<div class="page-header">

    <h1>${vo.merchant.merchantName}</h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid">

    <div class="span6">

        <p>

            <b><spring:message code="merchantdetail.registdate" /></b> : ${igooit:formatDate(vo.merchant.postDate)}

        </p>

        <p>

        <div class="merchant-rank" data-rank="${vo.rank}"></div>

        </p>
        <p>
            <c:forEach items="${category}" var="category" begin="0">
                <a class="btn btn-small" href="/category/${category.url}">${category.tradeName}</a>
            </c:forEach>
        </p>

        <p>

            ${vo.merchant.description.value}

        </p>

        <br/>
        <c:if test="${not empty vo.merchant.email}">
            <div class="row-fluid">
                <div class="span4" ><spring:message code="merchantdetail.email" /></div>
                <div class="span8">${vo.merchant.email}</div>
            </div>
        </c:if>
        <c:if test="${not empty vo.merchant.phone}">
            <div class="row-fluid">
                <div class="span4" ><spring:message code="merchantdetail.phone" /></div>
                <div class="span8">${vo.merchant.phone}</div>
            </div>
        </c:if>
        <c:if test="${not empty vo.merchant.contact1}">
            <div class="row-fluid">
                <div class="span4" ><spring:message code="merchantdetail.mobile" /></div>
                <div class="span8">${vo.merchant.contact1}</div>
            </div>
        </c:if>
        <c:if test="${not empty vo.merchant.contact2}">
            <div class="row-fluid">
                <div class="span4" ></div>
                <div class="span8">${vo.merchant.contact2}</div>
            </div>
        </c:if>
        <div class="row-fluid">
            <div class="span4" ><spring:message code="merchantdetail.address" /></div>
            <div class="span8">${vo.merchant.address1}</div>
        </div>
        <div class="row-fluid">
            <div class="span4" ></div>
            <div class="span8">${vo.merchant.address2}</div>
        </div>
        <div class="row-fluid">
            <div class="span4" ></div>
            <div class="span8">${vo.merchant.address3}</div>
        </div>
        <br/>
        <p class="clearfix">

            <a href="/quote/merchant/${vo.merchant.canonicalSlugId}" class="btn btn-primary"><i class="icon icon-envelope"></i>&nbsp; <spring:message code="merchantdetail.wanttocontact" /></a>

        </p>

    </div>

    <!-- end description area -->

    <!-- begin slider area -->

    <div class="span6 top10">

        <div class="flexslider">

            <ul class="slides">

                <li>

                    <img src="${vo.merchant.imageFileName}" alt="" style="width: 200px;">

                </li>

                <li>

                    <img src="http://www.wowthemes.net/demo/serenity/img/temp/masonry/15.jpg" alt="">

                </li>

            </ul>

        </div>

        <div class="clearfix"></div>

    </div>

    <!-- end slider area -->

</div>
<div class="row-fluid">
    <div class="span12">

        <ul id="myTab" class="nav nav-tabs">

            <li class="active"><a href="#recentPost" data-toggle="tab"><spring:message code="merchantdetail.recentfeedback" /></a></li>

            <li class=""><a href="#something" data-toggle="tab"><spring:message code="merchantprofile.title" /></a></li>

        </ul>

        <div id="myTabContent" class="tab-content multi-sidebar">

            <div class="tab-pane fade active in" id="recentPost">

                <ul class="sidebar-latest">
                    <c:forEach items="${feedBackList}" var="feedback">

                    <li class="clearfix">

                        <a href="#"><img src="/assets/img/demo/avatar.jpg" class="attachment-thumbnail" alt=""></a>

                        <a href="#">${feedback.userName}</a><br>
                        <div class="merchant-rank" data-rank="${feedback.rank}"></div>
                        <a href="#">"${feedback.comment}"</a><br>
                        <small><a href="#"><span class="entry-date">${igooit:formatDate(feedback.postDate)}</span></a></small>

                    </li>
                    </c:forEach>
                    <div class="form-actions">
                        <button class="btn btn-primary" onclick="location.href = '/fd/m/${vo.merchant.keyString}';"><spring:message code="merchantdetail.feedback" />  <i class="icon-comment icon-white"></i></button><br />

                    </div>

                </ul>

            </div>

            <div class="tab-pane fade" id="something">

                <div class="tagcloud">

                    <a href="#"><spring:message code="merchantprofile.title" />mobile</a>

                    <a href="#"><spring:message code="merchantprofile.title" />google</a>

                    <a href="#"><spring:message code="merchantprofile.title" />apple</a>

                    <a href="#"><spring:message code="merchantprofile.title" />phones</a>

                    <a href="#"><spring:message code="merchantprofile.title" />ipads</a>

                    <a href="#"><spring:message code="merchantprofile.title" />tablets</a>

                    <a href="#"><spring:message code="merchantprofile.title" />desktops</a>

                </div>

            </div>

        </div>

    </div>
</div>


<div class="titleborder top40 clearfix">

    <div>

        <spring:message code="merchantdetail.similarmerchant" />

    </div>

</div>

<div class="row-fluid">

    <div class="span12">

        <div class="list_carousel" style="height:230px;">

            <div class="carousel_nav">

                <a class="prev" id="car_prev" href="#"><span><spring:message code="merchantdetail.prev" /></span></a>

                <a class="next" id="car_next" href="#"><span><spring:message code="merchantdetail.next" />next</span></a>

            </div>

            <div class="clearfix">

            </div>

            <div class="heightauto">

                <ul id="recent-projects" class="heightauto">

                    <c:forEach items="${similarMerchants}" var="similarMerchant">

                        <li>

                            <div class="featured-projects">

                                <div class="featured-projects-image">

                                    <a href="#"><img src="${similarMerchant.imageFileName}" class="imgOpa" alt="" style="width: 100px;"></a>

                                </div>

                                <div class="featured-projects-content">

                                    <h1>
                                        <a href="/merchant/details/${similarMerchant.url}">${similarMerchant.tradeName}</a>
                                    </h1>

                                    <p>

                                            ${similarMerchant.merchantName}

                                    </p>

                                </div>

                            </div>

                        </li>
                    </c:forEach>

                </ul>

            </div>

        </div>

    </div>

</div>

<script src="${pageContext.request.contextPath}/assets/js/jquery.raty.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/merchant/merchant-detail.js"></script>
<script type="text/javascript">

    $(window).load(function(){

        $('#recent-projects').carouFredSel({

            responsive: true,

            width: '100%',

            auto: true,

            circular	: true,

            infinite	: false,

            prev : {

                button		: "#car_prev",

                key			: "left",

            },

            next : {

                button		: "#car_next",

                key			: "right",

            },

            swipe: {

                onMouse: true,

                onTouch: true

            },

            scroll : 1500,

            items: {

                visible: {

                    min: 4,

                    max: 4

                }

            }

        });

    });

</script>
</body>
