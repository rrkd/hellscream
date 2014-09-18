<%@ include file="../view/globe.jsp" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="utf-8">

    <title><decorator:title default="Welcome to ..."></decorator:title></title>

    <decorator:head />

    <meta name="viewport" content="width=device-width, initial-scale=1.0">



    <meta name="author" content="">

    <!-- Le styles -->

    <link href="/assets/css/bootstrap.css" rel="stylesheet">

    <link href="/assets/css/style.css" rel="stylesheet">

    <link href="/assets/css/camera.css" rel="stylesheet">

    <link href="/assets/css/icons.css" rel="stylesheet">

    <link rel="stylesheet" id="main-color" href="/assets/css/skin-orange.css" media="screen"/>

    <link href="/assets/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->

    <!--[if lt IE 9]>

    <script src="/assets/js/html5shiv.js"></script>

    <![endif]-->

    <!-- Fav and touch icons -->

    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/ico/apple-touch-icon-144-precomposed.png">

    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/ico/apple-touch-icon-114-precomposed.png">

    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/ico/apple-touch-icon-72-precomposed.png">

    <link rel="apple-touch-icon-precomposed" href="img/ico/apple-touch-icon-57-precomposed.png">

    <link rel="shortcut icon" href="img/ico/favicon.png">

    <!-- jquery -->
    <script src="/assets/js/jquery.js"></script>

</head>

<body class="boxed">

<div class="body">

<!-- Navigation -->

<header>

    <%@include file="menu.jsp"%>

</header>

<div class="text-center">

    <img src="/assets/img/sha.png" class="slidershadow" alt="">

</div>

<!-- /end header -->

<div class="container">

    <decorator:body />

</div>

<!-- FOOTER BEGIN

================================================== -->
<div>
    <%@include file="footer.jsp"%>
</div>

<!-- FOOTER END

================================================== -->

</div>

<!-- /.body -->

<!-- Le javascript

    ================================================== -->

<!-- Placed at the end of the document so the pages load faster -->

<script src="/assets/js/bootstrap.js"></script>

<script src="/assets/js/plugins.js"></script>

<script src="/assets/js/custom.js"></script>

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

                    min: 1,

                    max: 1

                }

            }

        });

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

<!--BEGIN DEMO PANEL

================================================== -->

<%@include file="feedback.jsp"%>

</body>

</html>