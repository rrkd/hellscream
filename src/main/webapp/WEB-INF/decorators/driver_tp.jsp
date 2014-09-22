<%@ include file="../view/globe.jsp" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
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
<body>
<!--Add a file picker for the user to start the upload process -->
<input type="file" name="uploadfile">
<decorator:body />
<button class="btn btn-primary btn-lg" id="testBtn">
    Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/assets/js/drive/drive.js"></script>
<script src="/assets/js/bootstrap.js"></script>

<script src="/assets/js/plugins.js"></script>

<script src="/assets/js/custom.js"></script>
</body>
</html>