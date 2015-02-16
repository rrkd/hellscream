<%@include file="globe.jsp" %>
<html>
<head>
    <meta name="description" content="About Us">
    <title><spring:message code="contactus.title"></spring:message></title>
</head>
<body>
<div class="page-header">

    <h1><spring:message code="contactus.title"></spring:message></h1>

    <div class="headerdivider">

    </div>
    </p>

    <spring:message code="contactus.brief"></spring:message>

    <p>

</div>

<div class="row-fluid top30">

    <div class="span6">

        <form action="#" name="MYFORM" id="contactUsForm">

            <input name="name" size="30" type="text" id="name" class="span12" placeholder="<spring:message code="contactus.name"></spring:message>">

            <input name="email" size="30" type="text" id="email" class="span12" placeholder="<spring:message code="contactus.email"></spring:message>">

            <textarea id="message" name="message" class="span12" placeholder="<spring:message code="contactus.content"></spring:message>" rows="8"></textarea>

            <br/>

            <input value="<spring:message code="contactus.send"></spring:message>" type="submit" id="Send" class="btn btn-primary top10">

        </form>

    </div>

    <div class="span6">

        <div class="box3">

            <iframe class="gmap" style="width:98.2%;height:240px;" src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d3310.224948956142!2d150.989126!3d-33.935342!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6b12be5d54548671%3A0x9c40b8b113b6ecd6!2s66+Ashford+Ave%2C+Milperra+NSW+2214!5e0!3m2!1sen!2sau!4v1413373089701">

            </iframe>

            <i class="icon-map-marker"></i> &nbsp;&nbsp;<i><spring:message code="contactus.location"></spring:message></i>: 66 Ashford Ave Milperra NSW 2214

            <p>

            </p>

            <i class="icon-reorder"></i> &nbsp;<i><spring:message code="contactus.hours"></spring:message></i>: Monday - Friday, 09:00 - 17:00

            <p>

            </p>

            <i class="icon-envelope"></i> &nbsp;<i>E-mail</i>: &nbsp;<a href="mailto:wowthemesnet@gmail.com">wowthemesnet@gmail.com</a>

            <p>

            </p>

        </div>

    </div>

</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/contact-us.js"></script>
</body>
</html>