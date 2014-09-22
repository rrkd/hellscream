<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="page-header">

    <h1>${merchant.merchantName}</h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid">

    <div class="span6">

        <p>

            <b>Year</b> : 2013 | <b>Client</b> : ${merchant.contact1} | <b>Category</b> : Shop Online<br/>

            <b>Contribution</b> : Script & SEO | <b>Completion Time</b> : 35 Days

        </p>

        <p>

            ${merchant.description}

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

        <p class="clearfix">

            <a href="contact.html" class="btn btn-primary"><i class="icon icon-envelope"></i>&nbsp; I want to contact this Merchant</a>

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

                <h1><a href="/merchant/details/${similarMerchant.url}">${similarMerchant.tradeName}</a></h1>

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

<!-- END Carousel List -->
<script type="text/javascript" src="/assets/js/merchant/merchant-detail.js"></script>