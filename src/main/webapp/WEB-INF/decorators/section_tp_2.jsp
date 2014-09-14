<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ include file="../view/globe.jsp" %>
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

    <link href="/assets/css/icons.css" rel="stylesheet">

    <link href="/assets/css/bootstrap-responsive.css" rel="stylesheet">

    <link href="/assets/css/select2.css" rel="stylesheet">

    <link rel="stylesheet" id="main-color" href="/assets/css/skin-orange.css" media="screen"/>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->

    <!--[if lt IE 9]>

    <script src="assets/js/html5shiv.js"></script>

    <![endif]-->

    <!-- Fav and touch icons -->

    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/assets/img/ico/apple-touch-icon-144-precomposed.png">

    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/assets/img/ico/apple-touch-icon-114-precomposed.png">

    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/assets/img/ico/apple-touch-icon-72-precomposed.png">

    <link rel="apple-touch-icon-precomposed" href="/assets/img/ico/apple-touch-icon-57-precomposed.png">

    <link rel="shortcut icon" href="/assets/img/ico/favicon.png">

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

        <div class="row-fluid">
            <div class="span8 span-fixed-sidebar">
                <decorator:body/>
            </div>
            <%@include file="left_section_tp.jsp"%>
        </div>


    </div>

    <%@include file="footer.jsp"%>

</div>

<!-- /.body -->

<!-- Le javascript

================================================== -->

<!-- Placed at the end of the document so the pages load faster -->

<script src="/assets/js/bootstrap.js"></script>

<script src="/assets/js/plugins.js"></script>

<script src="/assets/js/custom.js"></script>

<script src="/assets/js/search.js"></script>



<!--BEGIN DEMO PANEL

================================================== -->

<!-- Style Switcher Files-->

<link rel="stylesheet" href="/assets/demo/css/style-switcher.css" media="screen"/>

<link rel="stylesheet" href="/assets/demo/css/colorpicker.css" media="screen"/>

<script type="text/javascript" src="/assets/demo/js/jquery.cookie.js"></script>

<script type="text/javascript" src="/assets/demo/js/styleswitch.js"></script>

<script type="text/javascript" src="/assets/demo/js/colorpicker.js"></script>

<script type="text/javascript" src="/assets/demo/js/switcher.js"></script>

<script type="text/javascript" src="/assets/js/select2.min.js"></script>

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