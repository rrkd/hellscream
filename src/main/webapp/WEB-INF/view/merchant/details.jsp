<%@include file="../globe.jsp" %>
<head>
    <meta name="description" content="merchant list">
    <title>Merchant List</title>
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

            <b>Year</b> : 2013 | <b>Client</b> : ${vo.merchant.contact1} | <b>Category</b> : Shop Online<br/>

            <b>Contribution</b> : Script & SEO | <b>Completion Time</b> : 35 Days

        </p>

        <p>

        <div class="merchant-rank" data-rank="${vo.rank}"></div>

        </p>

        <p>

            ${vo.merchant.description}

        </p>

        <ul class="icons-ul">

            <li><i class="icon-li icon-ok"></i>Nesciunt tofu stumptown aliqua</li>

            <li><i class="icon-li icon-ok"></i>Retro synth master</li>

            <li><i class="icon-li icon-ok"></i>Mustache cliche tempor</li>

            <li><i class="icon-li icon-ok"></i>Williamsburg carles vegan</li>

            <li><i class="icon-li icon-ok"></i>Reprehenderit butcher retro</li>

            <li><i class="icon-li icon-ok"></i>Butcher retro keffiyeh</li>

        </ul>
        <br/>
        <div class="row">
            <div class="span4" align="right">Email</div>
            <div class="span8">${vo.merchant.email}</div>
        </div>
        <div class="row">
            <div class="span4" align="right">Phone</div>
            <div class="span8">${vo.merchant.phone}</div>
        </div>
        <div class="row">
            <div class="span4" align="right">Address</div>
            <div class="span8">${vo.merchant.address1}</div>
        </div>
        <div class="row">
            <div class="span4" align="right"></div>
            <div class="span8">${vo.merchant.address2}</div>
        </div>
        <div class="row">
            <div class="span4" align="right"></div>
            <div class="span8">${vo.merchant.address3}</div>
        </div>
        <br/>
        <p class="clearfix">

            <a href="contact.html" class="btn btn-primary"><i class="icon icon-envelope"></i>&nbsp; I want to contact
                this Merchant</a>

        </p>

    </div>

    <!-- end description area -->

    <!-- begin slider area -->

    <div class="span6 top10">

        <div class="flexslider">

            <ul class="slides">

                <li>

                    <img src="http://www.wowthemes.net/demo/serenity/img/temp/masonry/12.jpg" alt="">

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

            <li class="active"><a href="#recentPost" data-toggle="tab">Recent Feedback</a></li>

            <li class=""><a href="#something" data-toggle="tab">Tags</a></li>

        </ul>

        <div id="myTabContent" class="tab-content multi-sidebar">

            <div class="tab-pane fade" id="recentPost">

                <ul class="sidebar-latest">

                    <li class="clearfix">

                        <a href="#"><img src="/assets/img/demo/avatar.jpg" class="attachment-thumbnail" alt=""></a>

                        <a href="#">"The apple- pickers on the ladders raised a hum..."</a><br>

                        <small><a href="#"><span class="entry-date">July 25, 2013</span></a></small>

                    </li>

                    <li class="clearfix">

                        <a href="#"><img src="/assets/img/demo/avatar.jpg" class="attachment-thumbnail" alt=""></a>

                        <a href="#">"Alice was beginning to get very tired of sitting..."</a><br>

                        <small><a href="#"><span class="entry-date">June 14, 2013</span></a></small>

                    </li>

                    <li class="clearfix">

                        <a href="#"><img src="/assets/img/demo/avatar.jpg" class="attachment-thumbnail" alt=""></a>

                        <a href="#">"Let us begin at the simplest point, what is a comic..."</a><br>

                        <small><a href="#"><span class="entry-date">May 7, 2013</span></a></small>

                    </li>

                    <li class="clearfix">

                        <a href="#"><img src="/assets/img/demo/avatar.jpg" class="attachment-thumbnail" alt=""></a>

                        <a href="#">"I assume it as self-evident that those who, at any given..."</a><br>

                        <small><a href="#"><span class="entry-date">April 3, 2013</span></a></small>

                    </li>

                    <li class="clearfix">

                        <a href="#"><img src="/assets/img/demo/avatar.jpg" class="attachment-thumbnail" alt=""></a>

                        <a href="#">"The greatest length or breadth of a full grown..."</a><br>

                        <small><a href="#"><span class="entry-date">February 16, 2013</span></a></small>

                    </li>

                </ul>

            </div>

            <div class="tab-pane fade" id="something">

                <div class="tagcloud">

                    <a href="#">mobile</a>

                    <a href="#">google</a>

                    <a href="#">apple</a>

                    <a href="#">phones</a>

                    <a href="#">ipads</a>

                    <a href="#">tablets</a>

                    <a href="#">desktops</a>

                </div>

            </div>

        </div>

    </div>
</div>


<div class="titleborder top40 clearfix">

    <div>

        Similar Merchant

    </div>

</div>

<div class="row-fluid">

    <div class="span12">

        <div class="list_carousel" style="height:230px;">

            <div class="carousel_nav">

                <a class="prev" id="car_prev" href="#"><span>prev</span></a>

                <a class="next" id="car_next" href="#"><span>next</span></a>

            </div>

            <div class="clearfix">

            </div>

            <div class="heightauto">

                <ul id="recent-projects" class="heightauto">

                    <c:forEach items="${similarMerchants}" var="similarMerchant">

                        <li>

                            <div class="featured-projects">

                                <div class="featured-projects-image">

                                    <a href="#"><img src="/assets/img/demo/300x200.png" class="imgOpa" alt=""></a>

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
</body>