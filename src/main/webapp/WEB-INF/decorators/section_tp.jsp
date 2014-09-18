<%@ include file="../view/globe.jsp" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="utf-8">

    <title>Merchant List</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta name="description" content="">

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

    <decorator:body/>

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

<script type="text/javascript" src="/assets/js/select2.min.js"></script>

<!-- DEMO PANEL -->

<%@include file="feedback.jsp"%>

<!-- END DEMO PANEL-->

</body>

</html>