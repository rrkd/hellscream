<!-- FOOTER BEGIN

================================================== -->

<div class="footer footerdark">

    <div class="text-center wraptotop">

        <a class="totop"><i class="icon-chevron-up"></i></a>

    </div>

    <div class="container">

        <!-- 1st row -->

        <div class="row-fluid">

            <div class="span4">

                <h1 class="title"><i class="icon-heart"></i> <spring:message code="footer.aboutus" /></h1>

                <hr>

                <p>

                    <spring:message code="footer.aboutus.dt" />
                    <a href="/aboutus" style="font-weight: bold;"><spring:message code="footer.aboutus.more" /></a>

                </p>


                <p class="footerlogo">

                    <a href="/aboutus"></a>

                </p>

            </div>

            <div class="span4">

                <h1 class="title"><spring:message code="footer.testimonials" /></h1>

                <hr>

                <div id="quotes">

                    <div class="textItem">

                        <div class="avatar">

                            <img src="/assets/img/demo/test1.png" alt="avatar">

                        </div>

                        <spring:message code="footer.testimonials.dt1" /><span
                            style="font-family:arial;">"</span><br/><b> Johney </b>

                    </div>

                    <div class="textItem">

                        <div class="avatar">

                            <img src="/assets/img/demo/test2.gif" alt="avatar">

                        </div>

                        <spring:message code="footer.testimonials.dt2" /><span style="font-family:arial;">"</span><br/><b>Jessica </b>

                    </div>

                    <div class="textItem">

                        <div class="avatar">

                            <img src="/assets/img/demo/test1.png" alt="avatar">

                        </div>

                        <spring:message code="footer.testimonials.dt3" /><span
                            style="font-family:arial;">"</span><br/><b>Tom </b>

                    </div>

                    <div class="textItem">

                        <div class="avatar">

                            <img src="/assets/img/demo/test2.gif" alt="avatar">

                        </div>

                        <spring:message code="footer.testimonials.dt4" /><span style="font-family:arial;">"</span><br/><b>Tara</b>

                    </div>

                </div>

            </div>

            <div class="span4">

                <h1 class="title"><spring:message code="footer.contactus" /></h1>

                <hr>

                <div class="done">

                    <div class="alert alert-success">

                        <button type="button" class="close" data-dismiss="alert">×</button>

                        Your message has been sent. Thank you!

                    </div>

                </div>

                <form method="post"  action="#" id="contactform">

                    <div class="form">

                        <div class="controls controls-row">

                            <input id="nameTxt" class="span6" type="text" name="name" placeholder="<spring:message code="footer.contactus.name" />">

                            <input id="userEmailTxt" class="span6" type="text" name="email" placeholder="<spring:message code="footer.contactus.email" />">

                        </div>

                        <div class="controls">

                            <textarea id="contactUsContent" class="span12" name="comment" rows="4" placeholder="<spring:message code="footer.contactus.message" />"></textarea>

                        </div>

                        <input id="sendContactEmail" class="btn" value="<spring:message code="footer.contactus.send" />">

                    </div>

                </form>

            </div>

        </div>

    </div>

</div>

<!-- 2nd row -->

<div class="footerbottom footerbottomdark">

    <div class="container">

        <div class="row-fluid">

            <!-- left -->

            <div class="span4 smallspacetop">

                <p class="smaller">

                    <span class="copyright">©</span> Copyright 2014 Huafu.

                </p>

            </div>

            <!-- right -->

            <div class="span8 smallspacetop">

                <div class="pull-right smaller">

                    <ul class="footermenu">

                        <li><a href="/home">Home</a></li>

                        <li><a href="/faq">FAQ</a></li>

                        <li><a href="/contactus">Contact</a></li>

                    </ul>

                </div>

                <div class="clearfix">

                </div>

            </div>

            <!-- end right -->

        </div>

    </div>

</div>

<!-- FOOTER END

================================================== -->