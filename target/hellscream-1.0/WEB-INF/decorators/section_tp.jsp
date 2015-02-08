<%@ include file="../view/globe.jsp" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="utf-8">

    <title><decorator:title default="Welcome to ..."></decorator:title></title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta name="description" content="">

    <meta name="author" content="">

    <!-- Le styles -->

    <link href="/assets/wro/section-2-header.min.css" rel="stylesheet">

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

    <script src="/assets/wro/section-2-header.min.js"></script>

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

<script src="/assets/wro/section-2-footer.min.js"></script>

<!-- DEMO PANEL -->

<%@include file="feedback.jsp"%>

<!-- END DEMO PANEL-->

</body>

</html>