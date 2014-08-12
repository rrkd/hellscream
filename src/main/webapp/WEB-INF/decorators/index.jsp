<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="../view/globe.jsp" %>
<!DOCTYPE html>

<html lang="en">

<head>
    <%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>

    <meta charset="utf-8">

    <title>Biscaya Template MultiPurpose</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta name="description" content="">

    <meta name="author" content="">

    <!-- Le styles -->

    <link href="assets/css/bootstrap.css" rel="stylesheet">

    <link href="assets/css/style.css" rel="stylesheet">

    <link href="assets/css/camera.css" rel="stylesheet">

    <link href="assets/css/icons.css" rel="stylesheet">

    <link rel="stylesheet" id="main-color" href="assets/css/skin-orange.css" media="screen"/>

    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->

    <!--[if lt IE 9]>

    <script src="assets/js/html5shiv.js"></script>

    <![endif]-->

    <!-- Fav and touch icons -->

    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/img/ico/apple-touch-icon-144-precomposed.png">

    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/img/ico/apple-touch-icon-114-precomposed.png">

    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/img/ico/apple-touch-icon-72-precomposed.png">

    <link rel="apple-touch-icon-precomposed" href="assets/img/ico/apple-touch-icon-57-precomposed.png">

    <link rel="shortcut icon" href="assets/img/ico/favicon.png">

</head>

<body class="boxed">

<div class="body">

<!-- Navigation -->

<header>

    <div class="container clearfix">

        <div class="row-fluid">

            <div class="span12">

                <h1 class="brandlogo"><a href="index.html"><img src="img/logo.png" alt=""></a></h1>

                <div class="topinfo">

                    <ul class="social-icons list-soc">

                        <li><a href="#"><i class="icon-facebook"></i></a></li>

                        <li><a href="#"><i class="icon-twitter"></i></a></li>

                        <li><a href="#"><i class="icon-linkedin"></i></a></li>

                        <li><a href="#"><i class="icon-google-plus"></i></a></li>

                        <li><a href="#"><i class="icon-pinterest"></i></a></li>

                    </ul>

                    <div class="infophone">

                        <i class="icon-phone"></i> Tel: +8 737 924 6035

                    </div>

                    <div class="infoaddress">

                        3953 Berkley Street, Fort Washington, 19034

                    </div>

                </div>

                <div class="clearfix">

                </div>

                <div class="row-nav navbar">

                    <div class="navbar-inner">

                        <ul id="nav" class="nav">

                            <li class="active selected"><a href="index.html">Home</a></li>

                            <li class="divider-vertical"></li>

                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Templates <b
                                    class="caret"></b></a>

                                <ul class="dropdown-menu js-activated" style="display: none;">

                                    <li><a href="about.html">About Us</a></li>

                                    <li><a href="services.html">Services</a></li>

                                    <li><a href="faq.html">Knowledge Base</a></li>

                                    <li><a href="icons.html">Icons</a></li>

                                    <li><a href="testimonials.html">Testimonials</a></li>

                                    <li><a href="404.html">404 Error</a></li>

                                    <!--.dropdown-->

                                </ul>

                            </li>

                            <li class="divider-vertical"></li>

                            <li><a href="elements.html">Elements</a></li>

                            <li class="divider-vertical"></li>

                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Layouts <b
                                    class="caret"></b></a>

                                <ul class="dropdown-menu js-activated" style="display: none;">

                                    <li><a href="columns.html">Columns</a></li>

                                    <li><a href="masonry4.html">Masonry 4</a></li>

                                    <li><a href="masonry3.html">Masonry 3</a></li>

                                    <li><a href="masonry2.html">Masonry 2</a></li>

                                    <!--.dropdown-->

                                </ul>

                            </li>

                            <li class="divider-vertical"></li>

                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Portfolio <b
                                    class="caret"></b></a>

                                <ul class="dropdown-menu js-activated" style="display: none;">

                                    <li><a href="portfolio.html">Portfolio List</a></li>

                                    <li><a href="projectdetail.html">Project Detail</a></li>

                                    <!--.dropdown-->

                                </ul>

                            </li>

                            <li class="divider-vertical"></li>

                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Blog <b
                                    class="caret"></b></a>

                                <ul class="dropdown-menu js-activated" style="display: none;">

                                    <li><a href="bloghome.html">Blog Home</a></li>

                                    <li><a href="blogsingle.html">Single Post</a></li>

                                    <!--.dropdown-->

                                </ul>

                            </li>

                            <li class="divider-vertical"></li>

                            <li><a href="contact.html">Contact</a></li>

                            <li class="divider-vertical"></li>

                        </ul>

                        <form id="search" action="#" method="GET">

                            <input type="text" onfocus="if(this.value =='Enter search keywords here...' ) this.value=''"
                                   onblur="if(this.value=='') this.value='Enter search keywords here...'"
                                   value="Enter search keywords here..." name="s">

                            <a href="#"></a>

                        </form>

                    </div>

                </div>

            </div>

        </div>

    </div>

</header>

<div class="text-center">

    <img src="assets/img/sha.png" class="slidershadow" alt="">

</div>

<!-- /end header -->

<div class="container">

    <decorator:body/>

</div>

<!-- FOOTER BEGIN

================================================== -->

<div class="footer footerdark">

    <div class="text-center wraptotop">

        <a class="totop"><i class="icon-chevron-up"></i></a>

    </div>

    <div class="container">

        <!-- 1st row -->

        <div class="row-fluid">

            <div class="span4">

                <h1 class="title"><i class="icon-heart"></i> About us</h1>

                <hr>

                <p>

                    Introducing a premium HTML5 & CSS3 template for multipurpose use. Responsive layout, professional
                    design & lots of features.

                </p>

                <p>

                    Made with love by <a href="http://www.wowthemes.net">WowThemes.net</a> .

                </p>

                <p class="footerlogo">

                    Biscaya

                </p>

            </div>

            <div class="span4">

                <h1 class="title">Testimonials</h1>

                <hr>

                <div id="quotes">

                    <div class="textItem">

                        <div class="avatar">

                            <img src="assets/img/demo/test1.png" alt="avatar">

                        </div>

                        "Before turning to those moral and mental aspects of the matter which present the greatest
                        difficulties, let the inquirer begin by mastering more elementary problems.<span
                            style="font-family:arial;">"</span><br/><b> Jesse T, Los Angeles </b>

                    </div>

                    <div class="textItem">

                        <div class="avatar">

                            <img src="assets/img/demo/test2.gif" alt="avatar">

                        </div>

                        "How often have I said to you that when you have eliminated the impossible, whatever remains,
                        however improbable, must be the truth?<span style="font-family:arial;">"</span><br/><b>Ralph G.
                        Flowers </b>

                    </div>

                    <div class="textItem">

                        <div class="avatar">

                            <img src="assets/img/demo/test1.png" alt="avatar">

                        </div>

                        "It is a capital mistake to theorize before one has data. Insensibly one begins to twist facts
                        to suit theories, instead of theories to suit facts.<span
                            style="font-family:arial;">"</span><br/><b>Kerry I. McClanahan </b>

                    </div>

                    <div class="textItem">

                        <div class="avatar">

                            <img src="assets/img/demo/test2.gif" alt="avatar">

                        </div>

                        "We must fall back upon the old axiom that when all other contingencies fail, whatever remains,
                        however improbable, must be the truth.<span style="font-family:arial;">"</span><br/><b>Randy K.
                        Deleon </b>

                    </div>

                </div>

            </div>

            <div class="span4">

                <h1 class="title">Questions?</h1>

                <hr>

                <div class="done">

                    <div class="alert alert-success">

                        <button type="button" class="close" data-dismiss="alert">×</button>

                        Your message has been sent. Thank you!

                    </div>

                </div>

                <form method="post" action="contact.php" id="contactform">

                    <div class="form">

                        <div class="controls controls-row">

                            <input class="span6" type="text" name="name" placeholder="Name">

                            <input class="span6" type="text" name="email" placeholder="E-mail">

                        </div>

                        <div class="controls">

                            <textarea class="span12" name="comment" rows="4" placeholder="Message"></textarea>

                        </div>

                        <input type="submit" id="submit" class="btn" value="Send">

                    </div>

                </form>

            </div>

        </div>

    </div>

</div>

<!-- 2nd row -->

<div class="footerbottom footerbottomdark">

    <div class="container">

        <div class="row-fluid">

            <!-- left -->

            <div class="span4 smallspacetop">

                <p class="smaller">

                    <span class="copyright">© </span> Copyright 2013 Biscaya. Be nice.

                </p>

            </div>

            <!-- right -->

            <div class="span8 smallspacetop">

                <div class="pull-right smaller">

                    <ul class="footermenu">

                        <li><a href="#">Home</a></li>

                        <li><a href="#">Work</a></li>

                        <li><a href="#">Pages</a></li>

                        <li><a href="#">Blog</a></li>

                        <li><a href="#">Contact</a></li>

                    </ul>

                </div>

                <div class="clearfix">

                </div>

            </div>

            <!-- end right -->

        </div>

    </div>

</div>

<!-- FOOTER END

================================================== -->

</div>

<!-- /.body -->

<!-- Le javascript

    ================================================== -->

<!-- Placed at the end of the document so the pages load faster -->

<script src="assets/js/jquery.js"></script>

<script src="assets/js/bootstrap.js"></script>

<script src="assets/js/plugins.js"></script>

<script src="assets/js/custom.js"></script>

<!-- CALL CAMERA SLIDER -->

<script>

    jQuery(function () {

        jQuery('#camera_wrap_4').camera({

            height:'auto',

            loader:'bar',

            pagination:false,

            thumbnails:false,

            hover:true,

            opacityOnGrid:false,

            fx:'random',

            transPeriod:1500,

            time:7000,

            overlayer:true,

            imagePath:'img/'

        });

    });

</script>

<!-- CALL FEATURED WORK -->

<script type="text/javascript">

    $(window).load(function () {

        $('#recent-projects').carouFredSel({

            responsive:true,

            width:'100%',

            auto:true,

            circular:true,

            infinite:false,

            prev:{

                button:"#car_prev",

                key:"left",

            },

            next:{

                button:"#car_next",

                key:"right",

            },

            swipe:{

                onMouse:true,

                onTouch:true

            },

            scroll:1500,

            items:{

                visible:{

                    min:1,

                    max:1

                }

            }

        });

    });

</script>

<!-- CALL ACCORDION -->

<script type="text/javascript">

    $(".accordion h3").eq(0).addClass("active");

    $(".accordion .accord_cont").eq(0).show();

    $(".accordion h3").click(function () {

        $(this).next(".accord_cont").slideToggle("slow")

                .siblings(".accord_cont:visible").slideUp("slow");

        $(this).toggleClass("active");

        $(this).siblings("h3").removeClass("active");

    });

</script>

<!-- Call opacity on hover images from recent news-->

<script type="text/javascript">

    $(document).ready(function () {

        $("img.imgOpa").hover(function () {

                    $(this).stop().animate({opacity:"0.6"}, 'slow');

                },

                function () {

                    $(this).stop().animate({opacity:"1.0"}, 'slow');

                });

    });

</script>

<!--BEGIN DEMO PANEL

================================================== -->

<!-- Style Switcher Files-->

<link rel="stylesheet" href="assets/demo/css/style-switcher.css" media="screen"/>

<link rel="stylesheet" href="assets/demo/css/colorpicker.css" media="screen"/>

<script type="text/javascript" src="assets/demo/js/jquery.cookie.js"></script>

<script type="text/javascript" src="assets/demo/js/styleswitch.js"></script>

<script type="text/javascript" src="assets/demo/js/colorpicker.js"></script>

<script type="text/javascript" src="assets/demo/js/switcher.js"></script>

<!-- DEMO PANEL -->

<div id="switcher-handle">

<a class="" id="handle" href="#">feedback</a>

<div id="style-switcher">

<div id="switcher-header">

    <p>

        Theme Options

    </p>

</div>

<div id="switcher-body">

    <p>

        <strong>Layout Style</strong>

    </p>

    <select id="layout">

        <option value="boxed">Boxed</option>

        <option value="wide">Wide</option>

    </select>


    <p>

        <strong>Color Schemes</strong>

    </p>


    <div class="colors-holder">

        <a href="#" class="color-box" data-rel="e7402f"></a>

        <a href="#" class="color-box" data-rel="0E8FAB"></a>

        <a href="#" class="color-box" data-rel="44cfc8"></a>

        <a href="#" class="color-box" data-rel="9DC500"></a>

        <a href="#" class="color-box" data-rel="76719a"></a>

        <a href="#" class="color-box" data-rel="f2a020"></a>

        <a href="#" class="color-box" data-rel="33bee5"></a>

        <a href="#" class="color-box" data-rel="e44884"></a>

        <a href="#" class="color-box" data-rel="18adb5"></a>

        <a href="#" class="color-box" data-rel="f0b70c"></a>


        <a href="#" class="color-box" data-rel="346b7f"></a>

        <a href="#" class="color-box" data-rel="aecdcf"></a>

        <a href="#" class="color-box" data-rel="be9869"></a>

        <a href="#" class="color-box" data-rel="bf6c2f"></a>

        <a href="#" class="color-box" data-rel="1abc9c"></a>

        <a href="#" class="color-box" data-rel="7f8c8d"></a>

        <a href="#" class="color-box" data-rel="b4ad7f"></a>

        <a href="#" class="color-box" data-rel="fe6c6c"></a>

        <a href="#" class="color-box" data-rel="e66a47"></a>

        <a href="#" class="color-box" data-rel="50e9f3"></a>

    </div>

    <div class="switcher-divider">

    </div>


    <p>

        <strong>Bg Patterns (for boxed)</strong>

    </p>

    <div class="colors-holder">

        <a data-rel="1" class="bg-box" href="#"></a>

        <a data-rel="2" class="bg-box" href="#"></a>

        <a data-rel="3" class="bg-box" href="#"></a>

        <a data-rel="4" class="bg-box" href="#"></a>

        <a data-rel="5" class="bg-box" href="#"></a>

        <a data-rel="6" class="bg-box" href="#"></a>

        <a data-rel="7" class="bg-box" href="#"></a>

        <a data-rel="8" class="bg-box" href="#"></a>

        <a data-rel="9" class="bg-box" href="#"></a>

        <a data-rel="10" class="bg-box" href="#"></a>

        <a data-rel="11" class="bg-box" href="#"></a>

        <a data-rel="12" class="bg-box" href="#"></a>

        <a data-rel="13" class="bg-box" href="#"></a>

        <a data-rel="14" class="bg-box" href="#"></a>

        <a data-rel="15" class="bg-box" href="#"></a>

        <a data-rel="16" class="bg-box" href="#"></a>

        <a data-rel="17" class="bg-box" href="#"></a>

        <a data-rel="18" class="bg-box" href="#"></a>

        <a data-rel="19" class="bg-box" href="#"></a>

        <a data-rel="20" class="bg-box" href="#"></a>

        <a data-rel="21" class="bg-box" href="#"></a>

        <a data-rel="22" class="bg-box" href="#"></a>

        <a data-rel="23" class="bg-box" href="#"></a>

        <a data-rel="24" class="bg-box" href="#"></a>

    </div>


    <div class="switcher-divider">

    </div>


    <p>

        <strong>Bg Images (for boxed)</strong>

    </p>

    <div class="colors-holder">

        <a data-rel="pic1" class="bgimg-box" href="#"></a>

        <a data-rel="pic2" class="bgimg-box" href="#"></a>

        <a data-rel="pic3" class="bgimg-box" href="#"></a>

        <a data-rel="pic4" class="bgimg-box" href="#"></a>

        <a data-rel="pic5" class="bgimg-box" href="#"></a>

        <a data-rel="pic6" class="bgimg-box" href="#"></a>

        <a data-rel="pic7" class="bgimg-box" href="#"></a>

        <a data-rel="pic8" class="bgimg-box" href="#"></a>

        <br/><br/>

    </div>


</div>


<div id="switcher-footer">

    <p>

        <a href="http://www.wowthemes.net/premium-themes-templates/" target="_blank"><img
                src="demo/images/logowowthemes.png"></a>

    </p>

</div>

</div>

</div>

<!-- END DEMO PANEL-->

</body>

</html>