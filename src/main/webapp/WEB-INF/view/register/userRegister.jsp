<%@include file="../globe.jsp"%><html>
<head>
    <meta name="description" content="service job search">
    <title>Register User</title>
    <link href="/assets/css/prettify_bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="page-header">

    <h1>Register</h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid top30">

    <div class="span6">
        <div class="titleborder">

            <div>

                User Information

            </div>

        </div>
        <div class="alert alert-error" id="userRsgErrorBox" style="display: none;">

            <button type="button" class="close" data-dismiss="alert">x</button>

            <strong>Oh snap!</strong> Change a few things up and try submitting again.

        </div>
        <form class="form-horizontal" id="merchantRegisterForm" novalidate>
            <div class="control-group">
                <label class="control-label" for="nickname">Nickname</label>
                <div class="controls">
                    <input name="nickname" size="30" class="span12" type="text"
                           maxlength="50" minlength="3"
                           pattern="[a-zA-Z0-9\s]+"
                           id="nickname" placeholder="Nickname" required>
                    <p class="help-block">Nickname</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="forename">Forename</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="forename" class="span12" placeholder="MerchantName" required>
                    <p class="help-block">Your Forename</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="surname">Surname</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="surname" class="span12" placeholder="MerchantName" required>
                    <p class="help-block">Your Surname</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="email">Email</label>
                <div class="controls">
                    <input name="name" size="30" type="email" id="email" class="span12" placeholder="Email" required>
                    <p class="help-block">Contact Email</p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="address1">Address Line 1</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address1" class="span12" placeholder="Address1" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="address2">Address Line 2</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address2" class="span12" placeholder="Address2" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="address3">Address Line 3</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="address3" class="span12" placeholder="Address3" required>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="phone">phone</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="phone" class="span12" placeholder="Phone">
                    <p class="help-block">Phone</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="mobile">Mobile</label>
                <div class="controls">
                    <input name="name" size="30" type="text" id="mobile" class="span12" placeholder="Phone">
                    <p class="help-block">Mobile</p>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="terms-and-conditions">Legal</label>
                <div class="controls">
                    <label class="checkbox">
                        <input type="checkbox" id="terms-and-conditions" name="terms-and-conditions" required data-validation-required-message="You must agree to the terms and conditions">
                        I agree to the <a href="#">terms and conditions</a>
                    </label>
                    <p class="help-block"></p>
                </div>
            </div>

            <br/>
            <div class="form-actions">
                <button type="submit" class="btn btn-primary"> Post My Service <i class="icon-ok icon-white"></i></button><br />
                (I've read all documents.)
            </div>
        </form>

    </div>

</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jqBootstrapValidation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/prettify.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/register.js"></script>
</body>