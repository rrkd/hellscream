<%@include file="globe.jsp" %>
<html>
<head>
    <meta name="description" content="Login">
    <title>Login</title>
</head>
<body>
<div class="page-header">

    <h1>User Login</h1>

    <div class="headerdivider">

    </div>

</div>
    <div class="row-fluid">
        <div class="span6">
            <div class="titleborder">

                <div>

                    Login

                </div>

            </div>
            <div class="span12">
                <div class="alert alert-error" id="merchantRsgErrorBox" style="display: none;">

                    <button type="button" class="close" data-dismiss="alert">x</button>

                    <strong>Error!</strong> You username or password is invalid.</span>

                </div>
                <form action="#">

                    <input name="name" size="30" type="text" id="username" class="span6" placeholder="Username"><br/>

                    <input name="name" size="30" type="password" id="password" class="span6" placeholder="Password">
                    <br/>


                    <input value="Login" id="login_btn" class="btn btn-primary top10">

                </form>
            </div>
        </div>
        <div class="span6">
            <div class="titleborder">

                <div>

                    Sign In As

                </div>

            </div>
            <div class="span12">
                <p>
                    <a class="btn btn-large btn-success" href="${googleUrl}">
                        <i class="icon-google-plus-sign"></i>
                        Log in Use Google</a>

                </p>
                <p>

                </p>
                    <a class="btn btn-large btn-success" href="${facebookUrl}">
                        <i class="icon-facebook-sign"></i>
                        Log in Use Facebook</a>
                <br/>
            </div>
        </div>
    </div>
    <div class="row-fluid">

        <div class="span6">
            <div class="titleborder">

                <div>

                    Sign Up As User

                </div>

            </div>
            <div class="boxblue">

                <p>Sign up as user means you can:</p>
                <ul class="icons-ul">

                    <li><i class="icon-li icon-ok"></i>Post your quote</li>

                    <li><i class="icon-li icon-ok"></i>Search Service</li>

                    <li><i class="icon-li icon-ok"></i>Choose Merchant</li>

                    <li><i class="icon-li icon-ok"></i>Send Message to Merchant</li>

                </ul>
                <p>
                    <a class="btn btn-large btn-primary" href="/register/user">
                    <i class="icon-user"></i>
                    Sign Up As User</a>
                </p>
            </div>
        </div>
        <div class="span6">
            <div class="titleborder">

                <div>

                    Sign Up As Merchant

                </div>

            </div>
            <div class="boxgreen" >

                <p>Sign up as Merchant means you can:</p>
                <ul class="icons-ul">

                    <li><i class="icon-li icon-ok"></i>List Your Business</li>

                    <li><i class="icon-li icon-ok"></i>Receive Quote</li>

                    <li><i class="icon-li icon-ok"></i>Contact With Customer</li>

                    <li><i class="icon-li icon-ok"></i>Update Your News</li>

                </ul>
                <p>
                    <a class="btn btn-large btn-primary" href="/register/merchant">
                    <i class="icon-suitcase"></i>
                    Sign Up As Merchant</a>
                </p>
            </div>
        </div>
    </div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/sha256.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/login.js"></script>
</body>
</html>