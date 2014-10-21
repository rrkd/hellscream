<%@include file="globe.jsp"%><html>
<head>
    <meta name="description" content="service job search">
    <title>Welcome to huafu</title>
</head>
<body>
<div class="row-fluid">

    <div class="camera_wrap pattern_4 camera_emboss" id="camera_wrap_4">

        <div data-src="/assets/img/demo/slide1.jpg">

            <div class="camera_caption fadeFromTop">

                <h1><spring:message code="home.findcategory" /></h1>
                <div class="form" style="margin-top:0px;">
				<span>

                    Who did you need?<br/>
                    <input id="searchMerchantKeyTxt" class="span10" type="text" name="name" placeholder="e.g. cleaner"><br/>
                    Where are you?<br/>
                    <input id="searchLocalTxt" class="span10" type="text" name="name" placeholder="enter your suburb or postcode"><br/>
                    <input id="searchMerchantBtn" class="btn span10" value="Find Service">

                </span>
                </div>
            </div>

        </div>

        <div data-src="/assets/img/demo/slide2.jpg">

            <div class="camera_caption fadeFromBottom">

                <h1>Post Quote</h1>

						<span>

						Beautiful behind the scenes too! Biscaya Template comes with top notch customer support to help you get your business online fast. </span>

            </div>

        </div>

        <div data-src="/assets/img/demo/slide1.jpg">

            <div class="camera_caption fadeFrom">

                <h1>List Your Business</h1>

						<span>

						Beautiful behind the scenes too! Biscaya Template comes with top notch customer support to help you get your business online fast. </span>

            </div>

        </div>

    </div>

    <div class="text-center">

        <img src="/assets/img/sha.png" class="slidershadowcam" alt="">

    </div>

</div>

<div class="row-fluid text-center intro">

    <div class="span12">

        <h1>Introducing Huafu, <span class="primarycolor">Multipurpose</span> Service for your Business</h1>

        <p class="featured lead bottom10">

            Highly-professional & modern website template created for you and your business prosperity. <br/>

            Biscaya has all the flexibility and features needed for building a top-notch business website.

        </p>

    </div>

</div>
<div class="row-fluid graysection">
    <div class="span3">
        <div class="grey-box-icon">
            <div class="icon-box-top grey-box-icon-pos">
                <i class="fontawesome-icon medium circle-white center icon-briefcase"></i>
            </div>
            <h4>Merchant</h4>
            <p id="merchantCount"></p>
        </div>

    </div>
    <div class="span3">
        <div class="grey-box-icon">
            <div class="icon-box-top grey-box-icon-pos">
                <i class="fontawesome-icon medium circle-white center icon-list"></i>
            </div>
            <h4>Quote</h4>
            <p id="quoteCount"></p>
        </div>

    </div>
    <div class="span3">
        <div class="grey-box-icon">
            <div class="icon-box-top grey-box-icon-pos">
                <i class="fontawesome-icon medium circle-white center icon-comments"></i>
            </div>
            <h4>Comment</h4>
            <p id="commentCount"></p>
        </div>

    </div>
    <div class="span3">
        <div class="grey-box-icon">
            <div class="icon-box-top grey-box-icon-pos">
                <i class="fontawesome-icon medium circle-white center icon-thumbs-up"></i>
            </div>
            <h4>Deal</h4>
            <p id="feedbackCount"></p>
        </div>

    </div>
</div>


<div class="row-fluid top25">

    <div class="panel1">

        <div class="span9">

            <h4 class="top0"><spring:message code="home.howitworks"/> </h4>

            Aliquam convallis, urna vel luctus consequat, urna leo adipiscing sapien, mattis molestie nulla augue sed elit. Pellentesque interdum mi non dolor facilisis porta. Cras venenatis dolor sed magna rhoncus non fermentum.

        </div>

        <div class="span3 text-center top15">

            <a href="/howitworks" class="btn btn-primary btn-large">

                <i class="icon icon-download-alt"></i> <spring:message code="home.iwanttoknowmore" /> </a>

        </div>

        <div class="clearfix">

        </div>

    </div>

</div>

<div class="row-fluid">

    <div class="span6">

        <div class="titleborder">

            <div>

                New Register Merchant

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

                            <a href="/merchant/details/${merchant.canonicalSlugId}" class="btn btn-primary"><i class="icon-share-alt"></i> More</a>

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

                Why Choose Us

            </div>

        </div>

        <div class="accordion">

            <h3><span>Quis dolor id nunc</span></h3>

            <div class="accord_cont">

                <p>

                    Nunc sit amet velit metus. At leo tincidunt felis facilisis tincidunt. Proin posuere, ligula nec porttitor eget luctus, risus lectus tristique ligula, quis pretium elit diam a nisi eget mauris vestibulum. Proin vehicula malesuada dolor, vel rutrum. quam sollicitu hasellus turpis justo, sagittis sit amet elementum eget, ultricies ac tortor. Ut est mi, consequat ut bibendum quis, vehicula vel nibh. In urna tortor, pulvinar ut.

                </p>

            </div>

            <h3><span>Mauris suspendisse laoreet imperdiet</span></h3>

            <div class="accord_cont">

                <p>

                    At leo tincidunt felis facilisis tincidunt. Nunc sit amet velit metus. Proin posuere, ligula nec porttitor eget luctus, risus lectus tristique ligula, quis pretium elit diam a nisi eget mauris vestibulum. Proin vehicula malesuada dolor, vel rutrum. quam sollicitu hasellus turpis justo, sagittis sit amet elementum eget, ultricies ac tortor. Ut est mi, consequat ut bibendum quis, vehicula vel nibh. In urna tortor, pulvinar ut.

                </p>

            </div>

            <h3><span>Quis porttitor semper mauris!</span></h3>

            <div class="accord_cont">

                <p>

                    At leo tincidunt felis facilisis tincidunt. Nunc sit amet velit metus. Proin posuere, ligula nec porttitor eget luctus, risus lectus tristique ligula, quis pretium elit diam a nisi eget mauris vestibulum. Proin vehicula malesuada dolor, vel rutrum. quam sollicitu hasellus turpis justo, sagittis sit amet elementum eget, ultricies ac tortor. Ut est mi, consequat ut bibendum quis, vehicula vel nibh. In urna tortor.

                </p>

            </div>

            <h3><span>Eros odio ornare commodo</span></h3>

            <div class="accord_cont">

                <p>

                    Ut est mi, consequat ut bibendum quis, vehicula vel nibh. At leo tincidunt felis facilisis tincidunt. Nunc sit amet velit metus. Proin posuere, ligula nec porttitor eget luctus, risus lectus tristique ligula, quis pretium elit diam a nisi eget mauris vestibulum. Proin vehicula malesuada dolor, vel rutrum. quam sollicitu hasellus turpis justo, sagittis sit amet elementum eget, ultricies ac tortor.

                </p>

            </div>

        </div>

    </div>

</div>

<div class="row-fluid top25">

    <div class="panel1">

        <div class="span9">

            <h4 class="top0"><spring:message code="home.whyshuoldIneedtosignup"/> </h4>

            Aliquam convallis, urna vel luctus consequat, urna leo adipiscing sapien, mattis molestie nulla augue sed elit. Pellentesque interdum mi non dolor facilisis porta. Cras venenatis dolor sed magna rhoncus non fermentum.

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

            <!--icon box top -->

            <h4>Modern Settings</h4>

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

        <div class="grey-box-icon">

            <div class="icon-box-top grey-box-icon-pos">

                <i class="fontawesome-icon medium circle-white center icon-pencil"></i>

            </div>

            <!--icon box top -->

            <h4>Various Styles</h4>

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

            <h4>Responsive Design</h4>

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

        <div class="grey-box-icon">

            <div class="icon-box-top grey-box-icon-pos">

                <i class="fontawesome-icon medium circle-white center icon-trophy"></i>

            </div>

            <!--icon box top -->

            <h4>Winning Theme</h4>

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
    <div class="span4">
        <div class="grey-box-icon" align="left">
            <c:forEach items="${homeCategoryList}" var="category" begin="0" end="3">
            <h5><a href="/category/${category.name}">${category.tradeName}</a></h5>
            </c:forEach>
        </div>

    </div>
    <div class="span4">
        <div class="grey-box-icon" align="left">
            <c:forEach items="${homeCategoryList}" var="category" begin="4" end="7">
                <h5><a href="/category/${category.name}">${category.tradeName}</a></h5>
            </c:forEach>
        </div>

    </div>
    <div class="span4">
        <div class="grey-box-icon" align="left">
            <c:forEach items="${homeCategoryList}" var="category" begin="8" end="11">
                <h5><a href="/category/${category.name}">${category.tradeName}</a></h5>
            </c:forEach>
        </div>

    </div>
    <div class="span12">
        <div class="grey-box-icon">
            <h3><a href="/category"><spring:message code="home.seeallcategory"></spring:message> <i class="fontawesome-icon smaller middle icon-arrow-right"></i></a></h3>
        </div>
    </div>
</div>

<div class="row-fluid">

    <div class="span12">

        <div class="titleborder">

            <div>

                Latest Quote

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