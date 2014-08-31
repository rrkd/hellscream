<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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

        <form action="#">
            <input name="name" size="30" type="text" id="email" class="span12" placeholder="Email">
            <input name="name" size="30" type="text" id="nickname" class="span12" placeholder="Nickname">
            <input name="name" size="30" type="text" id="forename" class="span12" placeholder="Forename">
            <input name="name" size="30" type="text" id="surname" class="span12" placeholder="SureName">
            <br/>


            <input value="Register" id="create_user" class="btn btn-primary top10">

        </form>

    </div>

</div>
<script type="text/javascript" src="/assets/js/register.js"></script>