<%@include file="globe.jsp"%><html>
<head>
    <meta name="description" content="service job search">
    <title><spring:message code="home.title"/></title>
</head>
<body>
<div class="row-fluid">

    <div class="camera_wrap pattern_4 camera_emboss" id="camera_wrap_4">

        <div data-src="/assets/img/demo/slide1.jpg">

            <div class="camera_caption fadeFromTop">

                <h1><spring:message code="home.findmerchant.title" /></h1>
                <div class="form" style="margin-top:0px;">
				<span><spring:message code="home.findmerchant.category" /><br/>
                    <input id="searchMerchantKeyTxt" class="span10" type="text" name="name" placeholder="<spring:message code="home.findmerchant.category.samples" />"><br/>
                    <spring:message code="home.findmerchant.where" /><br/>
                    <input id="searchLocalTxt" class="span10" type="text" name="name" placeholder="<spring:message code="home.findmerchant.where.samples" />"><br/>
                    <input id="searchMerchantBtn" class="btn span10" value="<spring:message code="home.findmerchant.button" />">

                </span>
                </div>
            </div>

        </div>

        <div data-src="/assets/img/demo/slide2.jpg">

            <div class="camera_caption fadeFromBottom">

                <h1><spring:message code="home.postquote" /></h1>

						<span>
						<spring:message code="home.postquote.advantage" />
                        </span>

            </div>

        </div>

        <div data-src="/assets/img/demo/slide1.jpg">

            <div class="camera_caption fadeFrom">

                <h1><spring:message code="home.listmerchant" /></h1>

						<span><spring:message code="home.listmerchant.advantage" /> </span>

            </div>

        </div>

    </div>

    <div class="text-center">

        <img src="/assets/img/sha.png" class="slidershadowcam" alt="">

    </div>

</div>

<div class="row-fluid text-center intro">

    <div class="span12">

        <h1><span class="primarycolor"><spring:message code="home.introduction" /></span></h1>

        <p class="featured lead bottom10">

            <spring:message code="home.introduction.detail" />

        </p>

    </div>

</div>
<div class="row-fluid graysection">
    <div class="span3">
        <div class="grey-box-icon">
            <div class="icon-box-top grey-box-icon-pos">
                <i class="fontawesome-icon medium circle-white center icon-briefcase"></i>
            </div>
            <h4><spring:message code="home.merchant" /></h4>
            <p id="merchantCount"></p>
        </div>

    </div>
    <div class="span3">
        <div class="grey-box-icon">
            <div class="icon-box-top grey-box-icon-pos">
                <i class="fontawesome-icon medium circle-white center icon-list"></i>
            </div>
            <h4><spring:message code="home.quote" /></h4>
            <p id="quoteCount"></p>
        </div>

    </div>
    <div class="span3">
        <div class="grey-box-icon">
            <div class="icon-box-top grey-box-icon-pos">
                <i class="fontawesome-icon medium circle-white center icon-comments"></i>
            </div>
            <h4><spring:message code="home.comment" /></h4>
            <p id="commentCount"></p>
        </div>

    </div>
    <div class="span3">
        <div class="grey-box-icon">
            <div class="icon-box-top grey-box-icon-pos">
                <i class="fontawesome-icon medium circle-white center icon-thumbs-up"></i>
            </div>
            <h4><spring:message code="home.deal" /></h4>
            <p id="feedbackCount"></p>
        </div>

    </div>
</div>


<div class="row-fluid top25">

    <div class="panel1">

        <div class="span9">

            <h4 class="top0"><spring:message code="home.howitwork"/></h4>

            <spring:message code="home.howitwork.detail"/>

        </div>

        <div class="span3 text-center top15">

            <a href="/howitworks" class="btn btn-primary btn-large">

                <i class="icon icon-download-alt"></i> <spring:message code="home.howitwork.link" /> </a>

        </div>

        <div class="clearfix">

        </div>

    </div>

</div>

<div class="row-fluid">

    <div class="span6">

        <div class="titleborder">

            <div>

                <spring:message code="home.newregistermerchant"/>

            </div>

        </div>

        <div class="heightauto">

            <div class="list_carousel">

                <div class="carousel_nav">

                    <a class="prev" id="car_prev" href="#"><span>prev</span></a>

                    <a class="next" id="car_next" href="#"><span>next</span></a>

                </div>

                <div class="clearfix">

                </div>

                <ul id="recent-projects">

                    <c:forEach items="${latestMerchants}" var="merchant">

                    <li>

                        <p>

                            <img src="${merchant.imageFileName}" class="imgproject" alt="">

                            <b>${merchant.tradeName}</b><br>
                            ${merchant.shortDesc}
                            <a href="/merchant/details/${merchant.canonicalSlugId}">[...]</a>

                        </p>

                        <p>

                            <a href="/merchant/details/${merchant.canonicalSlugId}" class="btn btn-primary"><i class="icon-share-alt"></i> <spring:message code="home.newregistermerchant.more"/></a>

                        </p>

                    </li>
                    </c:forEach>

                </ul>

            </div>

        </div>

        <div class="clearfix">

        </div>

    </div>

    <div class="span6">

        <div class="titleborder">

            <div>

                <spring:message code="home.whychooseus"/>

            </div>

        </div>

        <div class="accordion">

            <h3><span><spring:message code="home.whychooseus.satisfation"/></span></h3>

            <div class="accord_cont">

                <p>

                    <spring:message code="home.whychooseus.satasfation.dt"/>

                </p>

            </div>

            <h3><span><spring:message code="home.whychooseus.ratingsystem"/></span></h3>

            <div class="accord_cont">

                <p>

                    <spring:message code="home.whychooseus.ratingsystem.dt"/>

                </p>

            </div>

            <h3><span><spring:message code="home.whychooseus.services"/></span></h3>

            <div class="accord_cont">

                <p>

                    <spring:message code="home.whychooseus.services.dt"/>

                </p>

            </div>

            <h3><span><spring:message code="home.whychooseus.convenience"/></span></h3>

            <div class="accord_cont">

                <p>

                    <spring:message code="home.whychooseus.convenience.dt"/>

                </p>

            </div>

        </div>

    </div>

</div>

<div class="row-fluid top25">

    <div class="panel1">

        <div class="span9">

            <h4 class="top0"><spring:message code="home.whyshuoldIneedtosignup"/> </h4>

            <spring:message code="home.whyshuoldIneedtosignup.dt"/>

        </div>

        <div class="span3 text-center top15">

            <a href="/register/u" class="btn btn-primary btn-large">

                <i class="icon icon-download-alt"></i> <spring:message code="home.register" /> </a>

        </div>

        <div class="clearfix">

        </div>

    </div>

</div>

<div class="row-fluid graysection">

    <div class="span3">

        <div class="grey-box-icon">

            <div class="icon-box-top grey-box-icon-pos">

                <i class="fontawesome-icon medium circle-white center icon-cogs"></i>

            </div>

            <!--span 1 -->

            <h4><spring:message code="home.bestdiscount"/></h4>

            <p>

                Lorem ipsum dolor sit adipiscing elit. Praesent tempus eleifend risus ut congue eset nec lacus.

            </p>

            <p>

                <a href="#" style="font-weight: bold;">Read more →</a>

            </p>

        </div>

        <!--grey box -->

    </div>

    <!--/span2-->

    <div class="span3">

        <div class="grey-box-icon">

            <div class="icon-box-top grey-box-icon-pos">

                <i class="fontawesome-icon medium circle-white center icon-pencil"></i>

            </div>

            <!--icon box top -->

            <h4><spring:message code="home.bestrecommeend"/></h4>

            <p>

                Lorem ipsum dolor sit adipiscing elit. Praesent tempus eleifend risus ut congue eset nec lacus.

            </p>

            <p>

                <a href="#" style="font-weight: bold;">Read more →</a>

            </p>

        </div>

        <!--grey box -->

    </div>

    <!--/span3-->

    <div class="span3">

        <div class="grey-box-icon active">

            <div class="icon-box-top grey-box-icon-pos">

                <i class="fontawesome-icon medium circle-white center icon-magic"></i>

            </div>

            <!--icon box top -->

            <h4><spring:message code="home.bestseller"/></h4>

            <p>

                Lorem ipsum dolor sit adipiscing elit. Praesent tempus eleifend risus ut congue eset nec lacus.

            </p>

            <p>

                <a href="#" style="font-weight: bold;">Read more →</a>

            </p>

        </div>

        <!--grey box -->

    </div>

    <!--/span4-->

    <div class="span3">

        <div class="grey-box-icon">

            <div class="icon-box-top grey-box-icon-pos">

                <i class="fontawesome-icon medium circle-white center icon-trophy"></i>

            </div>

            <!--icon box top -->

            <h4><spring:message code="home.bestrating"/></h4>

            <p>

                Lorem ipsum dolor sit adipiscing elit. Praesent tempus eleifend risus ut congue eset nec lacus.

            </p>

            <p>

                <a href="#" style="font-weight: bold;">Read more →</a>

            </p>

        </div>

        <!--grey box -->

    </div>

    <!--/span3-->

</div>

<div class="row-fluid graysection text-center">

    <p class="lead bottom0">

        <i class="icon-envelope"></i> <spring:message code="home.needcontact"></spring:message> <a href="mailto:wowthemesnet@gmail.com">admin.huafu@gmail.com</a>

    </p>

</div>

<div class="row-fluid graysection">
    <div class="span3">
        <div class="grey-box-icon">
            <h5><a href="#">Merchant</a></h5>
            <h5><a href="#">Merchant</a></h5>
            <h5><a href="#">Merchant</a></h5>
            <h5><a href="#">Merchant</a></h5>
        </div>

    </div>
    <div class="span3">
        <div class="grey-box-icon">
            <h5><a href="#">Merchant</a></h5>
            <h5><a href="#">Merchant</a></h5>
            <h5><a href="#">Merchant</a></h5>
            <h5><a href="#">Merchant</a></h5>
        </div>

    </div>
    <div class="span3">
        <div class="grey-box-icon">
            <h5><a href="#">Merchant</a></h5>
            <h5><a href="#">Merchant</a></h5>
            <h5><a href="#">Merchant</a></h5>
            <h5><a href="#">Merchant</a></h5>
        </div>

    </div>
    <div class="span3">
        <div class="grey-box-icon">
            <h5><a href="#">Merchant</a></h5>
            <h5><a href="#">Merchant</a></h5>
            <h5><a href="#">Merchant</a></h5>
            <h5><a href="#">Merchant</a></h5>
        </div>

    </div>
    <div class="span12">
        <div class="grey-box-icon">
            <h3><a href="/category"><spring:message code="home.viewallcategories"></spring:message> <i class="fontawesome-icon smaller middle icon-arrow-right"></i></a></h3>
        </div>
    </div>
</div>

<div class="row-fluid">

    <div class="span12">

        <div class="titleborder">

            <div>

                <spring:message code="home.latestquotes" />

            </div>

        </div>

    </div>

</div>

<div class="row-fluid recent-posts">

    <c:forEach items="${latestQuote}" var="quote" begin="0" end="3">
    <div class="span3">

        <article>

            <img src="/assets/img/quote.jpeg" alt="" class="imgOpa">

            <div class="date">

                <span class="day">${quote.postDay}</span>

                <span class="month">${quote.postMonth}</span>

            </div>

            <h4><a href="bloghome.html">${quote.title}</a></h4>

            <p>

                ${quote.description}
                    <br/>
                    <a href="bloghome.html" class="read-more">read more <i class="icon-angle-right"></i></a>

            </p>

        </article>

    </div>
    </c:forEach>
</div>
<script type="text/javascript">

    $(window).load(function(){
        if($('#recent-projects') !== null) {

            $('#recent-projects').carouFredSel({

                responsive: true,

                width: '100%',

                auto: true,

                circular	: true,

                infinite	: false,

                prev : {

                    button		: "#car_prev",

                    key			: "left"

                },

                next : {

                    button		: "#car_next",

                    key			: "right"

                },

                swipe: {

                    onMouse: true,

                    onTouch: true

                },

                scroll : 1500,

                items: {

                    visible: {

                        min: 1,

                        max: 1

                    }

                }

            });
        }

    });

</script>

<!-- CALL ACCORDION -->

<script type="text/javascript">

    $(".accordion h3").eq(0).addClass("active");

    $(".accordion .accord_cont").eq(0).show();

    $(".accordion h3").click(function(){

        $(this).next(".accord_cont").slideToggle("slow")

                .siblings(".accord_cont:visible").slideUp("slow");

        $(this).toggleClass("active");

        $(this).siblings("h3").removeClass("active");

    });

</script>

<!-- CALL CAMERA SLIDER -->

<script>

    jQuery(function(){

        jQuery('#camera_wrap_4').camera({

            height: 'auto',

            loader: 'bar',

            pagination: false,

            thumbnails: false,

            hover: true,

            opacityOnGrid: false,

            fx: 'random',

            transPeriod: 1500,

            time: 7000,

            overlayer: true,

            imagePath: 'img/'

        });

    });

</script>

<!-- CALL FEATURED WORK -->

<!-- Call opacity on hover images from recent news-->

<script type="text/javascript">

    $(document).ready(function(){

        $("img.imgOpa").hover(function() {

                    $(this).stop().animate({opacity: "0.6"}, 'slow');

                },

                function() {

                    $(this).stop().animate({opacity: "1.0"}, 'slow');

                });

    });

</script>

<script type="text/javascript" src="/assets/js/home.js"></script>
</body>
</html>