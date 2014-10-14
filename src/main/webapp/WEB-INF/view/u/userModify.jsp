<%@include file="../globe.jsp"%><html>
<head>
    <meta name="description" content="User Modify">
    <title>User Modify</title>
    <link href="/assets/css/prettify_bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="page-header">

    <h1>User Modify</h1>

    <div class="headerdivider">

    </div>

    <input name="name" size="30" type="hidden" id="userKeyString" class="span12"
           value="${iguser.keyString}">
</div>

<div class="row-fluid top30">

    <div class="span10">
        <div class="titleborder">

            <div>

                User Modify

            </div>

        </div>
        <div class="alert alert-error" id="userRsgErrorBox" style="display: none;">

            <button type="button" class="close" data-dismiss="alert">x</button>

            <strong>Oh snap!</strong> Change a few things up and try submitting again.

        </div>
        <form class="form-horizontal" id="merchantRegisterForm" novalidate>
            <div class="control-group">
                <label class="control-label" for="email">Email</label>
                <div class="controls">
                    <input name="name" size="30" type="email" id="email" class="span12" placeholder="Email"
                           value="${iguser.email}" readonly>
                    <p class="help-block">Contact Email</p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="nickname">Nickname</label>
                <div class="controls">
                    <input name="nickname" size="30" class="span12" type="text"
                           maxlength="50" minlength="3"
                           pattern="[a-zA-Z0-9\s]+"
                           id="nickname" placeholder="Nickname" value="${iguser.nickname}" required>
                    <p class="help-block">Nickname</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="forename">Forename</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="forename" class="span12" placeholder="Forename"
                           value="${iguser.forename}" required>
                    <p class="help-block">Your Forename</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="surname">Surname</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="surname" class="span12" placeholder="Surname"
                           value="${iguser.surname}" required>
                    <p class="help-block">Your Surname</p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="address1">Address Line 1</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address1" class="span12" placeholder="Address1"
                           value="${iguser.address1}" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="address2">Address Line 2</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address2" class="span12" placeholder="Address2"
                           value="${iguser.address2}" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="address3">Address Line 3</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address3" class="span12" placeholder="Address3"
                           value="${iguser.address3}" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="mobile">Mobile</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="mobile" class="span12" placeholder="Phone"
                           value="${iguser.mobile}">
                    <p class="help-block">Mobile</p>
                </div>
            </div>

            <br/>
            <div class="form-actions">
                <button type="submit" class="btn btn-primary"> Update <i class="icon-ok icon-white"></i></button>
            </div>
        </form>

    </div>

</div>
<!-- success dialog -->
<div class="modal fade" id="successDlg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="successDlgLabel">User Modify</h4>
            </div>
            <div class="modal-body">
                Your profile has been update.
            </div>
            <div class="modal-footer">
                <a href="/home" class="btn btn-default" data-dismiss="modal">Go To Home</a>
                <a href="/u/profile" class="btn btn-primary">Go To Profile</a>
            </div>
        </div>
    </div>
</div>
<!-- success dialog end -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jqBootstrapValidation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/prettify.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/user/userModify.js"></script>
</body>