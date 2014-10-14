<%@include file="globe.jsp" %>
<html>
<head>
    <meta name="description" content="About Us">
    <title>About Us</title>
</head>
<body>
<div class="page-header">

    <h1>F.A.Q.</h1>

    <div class="headerdivider">

    </div>

</div>

<!-- 1ST ROW

================================================== -->

<div class="row-fluid">

    <!-- BLOCK 1 -->

    <div class="span6">

        <h1 class="faqstitle"><span class="icon-tags faqsicon"></span><spring:message code="faq.individual"></spring:message></h1>

        <dl class="faqs">
            <dt><spring:message code="faq.individual.procedures"></spring:message></dt>

            <dd><spring:message code="faq.procedures.detail"></spring:message></dd>

            <dt><spring:message code="faq.individual.quote"></spring:message></dt>

            <dd><spring:message code="faq.quote.procedure"></spring:message></dd>

            <dt><spring:message code="faq.individual.registration"></spring:message></dt>

            <dd><spring:message code="faq.registration.required"></spring:message></dd>

            <dt><spring:message code="faq.individual.quotedisplay"></spring:message></dt>

            <dd><spring:message code="faq.quotedisplay.detail"></spring:message></dd>

            <dt><spring:message code="faq.individual.quotemodify"></spring:message></dt>

            <dd><spring:message code="faq.quotemodify.answer"></spring:message></dd>


        </dl>

    </div>

    <!-- end block 1 -->

    <!-- BLOCK 2 -->

    <div class="span6">

        <h1 class="faqstitle"><span class="icon-flag faqsicon"></span><spring:message code="faq.merchants"></spring:message></h1>

        <dl class="faqs">

            <dt><spring:message code="faq.merchants.listing"></spring:message></dt>

            <dd><spring:message code="faq.listing.procedure"></spring:message></dd>

            <dt><spring:message code="faq.merchants.why"></spring:message></dt>

            <dd><spring:message code="faq.why.detail"></spring:message></dd>

            <dt><spring:message code="faq.merchants.ad"></spring:message></dt>

            <dd><spring:message code="faq.ad.detail"></spring:message></dd>

            <dt><spring:message code="faq.merchants.feedback"></spring:message></dt>

            <dd><spring:message code="faq.feedback.detail"></spring:message></dd>

            <dt><spring:message code="faq.merchants.rating"></spring:message></dt>

            <dd><spring:message code="faq.rating.detail"></spring:message></dd>
        </dl>

    </div>

    <!-- end block 2 -->

</div>

<!-- 2ND ROW

================================================== -->

<div class="row-fluid">

    <!-- BLOCK 3 -->

    <div class="span6">

        <h1 class="faqstitle"><span class="icon-tasks faqsicon"></span> <spring:message code="faq.hottopics"></spring:message></h1>

        <dl class="faqs">

            <dt><spring:message code="faq.ht.whyquotes"></spring:message></dt>

            <dd><spring:message code="faq.ht.whyquotes.detail"></spring:message></dd>

            <dt><spring:message code="faq.ht.howsearch"></spring:message></dt>

            <dd><spring:message code="faq.ht.howsearch.detail"></spring:message></dd>

            <dt><spring:message code="faq.ht.howchoose"></spring:message></dt>

            <dd><spring:message code="faq.ht.howchoose.detail"></spring:message></dd>

            <dt><spring:message code="faq.ht.badfeedback"></spring:message></dt>

            <dd><spring:message code="faq.ht.badfeedback.detail"></spring:message></dd>

            <dt><spring:message code="faq.ht.rating"></spring:message></dt>

            <dd><spring:message code="faq.ht.rating.detail"></spring:message></dd
        </dl>

    </div>

    <!-- end block 3 -->

    <!-- BLOCK 4 -->

    <div class="span6">

        <h1 class="faqstitle"><span class="icon-tint faqsicon"></span> Terms of Use (5)</h1>

        <dl class="faqs">

            <dt><spring:message code="faq.termsofuse.privacy"></spring:message></dt>

            <dd><spring:message code="faq.termsofuse.privacy.detail"></spring:message></dd>

            <dt><spring:message code="faq.termsofuse.conducts"></spring:message></dt>

            <dd><spring:message code="faq.termsofuse.conductsdetail"></spring:message></dd>
            <dd><spring:message code="faq.termsofuse.conductsdetail2"></spring:message></dd>
            <dd><spring:message code="faq.termsofuse.conductsdetail3"></spring:message></dd>
            <dd><spring:message code="faq.termsofuse.conductsdetail4"></spring:message></dd>

            <dt><spring:message code="faq.disclaimer"></spring:message></dt>

            <dd><spring:message code="faq.disclaimer.detail"></spring:message></dd>

        </dl>

    </div>

    <!-- end block 4 -->

</div>

<!-- CONTACT PANEL

================================================== -->

<div class="row-fluid top15">

    <div class="panel1">

        <div class="span9">

            <h4 class="top0">YOUR QUESTION NOT ON THE LIST?</h4>

            Aliquam convallis, urna vel luctus consequat, urna leo adipiscing sapien, mattis molestie nulla augue sed elit. Pellentesque interdum mi non dolor facilisis porta. Cras venenatis dolor sed magna rhoncus non fermentum.

        </div>

        <div class="span3 text-center top15">

            <a href="/contactus" class="btn btn-primary btn-large">

                <i class="icon icon-envelope"></i>&nbsp; CONTACT US </a>

        </div>

        <div class="clearfix">

        </div>

    </div>

</div>
<script type="text/javascript">

    $(document).ready(function () {

// ---- FAQs ---------------------------------------------------------------------------------------------------------------

        $('.faqs dd').hide(); // Hide all DDs inside .faqs

        $('.faqs dt').hover(function(){$(this).addClass('hover')},function(){$(this).removeClass('hover')}).click(function(){ // Add class "hover" on dt when hover

            $(this).next().slideToggle('normal'); // Toggle dd when the respective dt is clicked

        });

    });

</script>
</body>
</html>