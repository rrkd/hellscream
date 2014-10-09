<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="page-header">

    <h1>Merchant Register</h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid">

    <div class="span8">
        <div class="titleborder">

            <div>

                Step 1 - Sign In As a User

            </div>

        </div>

        <p>
            You have Sign In as a valid User.
        </p>

        <p>
            Go to the <a href="/login">Login Page</a>
        </p>

    </div>
</div>
<div class="row-fluid">
    <div class="span8">
        <div class="titleborder">

            <div>

                Step 2 - List Your Business

            </div>

        </div>

        <p>
            Go to the <a href="/merchant/create">List Your Business</a> page to fill up your business information.
        </p>
        <p>
            <a href="/merchant/create" class="btn btn-primary btn-large">

                <i class="icon icon-download-alt"></i> List Your Business </a>

        </p>

    </div>

</div>
<script type="text/javascript" src="/assets/js/register.js"></script>