<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="User Profile">
    <title><spring:message code="userprofile.userprofile" /> - ${iguser.nickname}</title>
</head>
<body>
<div class="page-header">

    <h1><spring:message code="userprofile.userprofile" /> - ${iguser.nickname}</h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid top30">

    <div class="span12">

        <div class="titleborder">

            <div>

                <spring:message code="userprofile.basicinfo" />

            </div>

        </div>

        <!-- Left Tabs

              ================================================== -->

        <div class="tabbable tabs-left">

            <!--bootstrap tabs implementation-->

            <ul class="nav nav-tabs">

                <!--tabs-->

                <li class="active">

                    <a data-toggle="tab" href="#tab1"><spring:message code="userprofile.aboutme" /></a>

                </li>

                <li>

                    <a data-toggle="tab" href="#tab2"><spring:message code="userprofile.contactinfo" /></a>

                </li>

            </ul>

            <!--tabs content -->

            <div class="tab-content">

                <div id="tab1" class="tab-pane active fade in">

                    <div class="row-fluid">
                        <div class="span4"><b><spring:message code="userprofile.nickname" /></b></div>
                        <div class="span8">${iguser.nickname}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b><spring:message code="userprofile.email" /></b></div>
                        <div class="span8">${iguser.email}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b><spring:message code="userprofile.forename" /></b></div>
                        <div class="span8">${iguser.forename}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b><spring:message code="userprofile.surname" /></b></div>
                        <div class="span8">${iguser.surname}</div>
                    </div>
                    <a href="/u/modify"><spring:message code="userprofile.edit.button" /></a>
                </div>

                <div id="tab2" class="tab-pane fade ">

                    <div class="row-fluid">
                        <div class="span4"><b><spring:message code="userprofile.mobile" /></b></div>
                        <div class="span8">${iguser.mobile}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b><spring:message code="userprofile.address" /></b></div>
                        <div class="span8">${iguser.address1}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"></div>
                        <div class="span8">${iguser.address2}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"></div>
                        <div class="span8">${iguser.address3}</div>
                    </div>
                    <a href="/u/modify"><spring:message code="userprofile.edit.button" /></a>
                </div>

            </div>

            <!--tab content -->

        </div>

        <!-- END Left Tabs -->

    </div>

    <div class="span12">
        <div class="titleborder">

            <div>

                <spring:message code="userprofile.usage" />

            </div>

        </div>

        <div class="row-fluid">

            <div class="span4">

                <a href="#">

                    <div class="service-box">

                        <h3><spring:message code="userprofile.quote" /></h3>

                        <div class="circleicon">

                            <i class="icon-list"></i>

                        </div>

                        <p>

                          ${userStatistic.countQuote} <spring:message code="userprofile.quotenumber" />

                        </p>

                    </div>

                </a>

            </div>

            <div class="span4">

                <a href="#">

                    <div class="service-box black">

                        <h3><spring:message code="userprofile.message" /></h3>

                        <div class="circleicon">

                            <i class="icon-envelope"></i>

                        </div>

                        <p>

                            ${userStatistic.countMsg} <spring:message code="userprofile.messagenumber" />

                        </p>

                    </div>

                </a>

            </div>

            <div class="span4">

                <a href="#">

                    <div class="service-box black">

                        <h3><spring:message code="userprofile.feedback" /></h3>

                        <div class="circleicon">

                            <i class="icon-thumbs-up"></i>

                        </div>

                        <p>

                          ${userStatistic.countFeedback} <spring:message code="userprofile.feedbacknumber" />

                        </p>

                    </div>

                </a>

            </div>

        </div>
    </div>

    <div class="span12">

        <div class="titleborder">

            <div>

                <spring:message code="userprofile.latesquote" />

            </div>

        </div>

        <div class="listContainer">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th><spring:message code="userprofile.title" /></th>
                    <th><spring:message code="userprofile.posttime" /></th>
                    <th><spring:message code="userprofile.action" /></th>
                </tr>
                </thead>
                <tbody id="dataTableBody">
                    <c:forEach items="${quoteList.voList}" var="vo" varStatus="loop">
                        <tr>
                            <td>${loop.index}</td>
                            <td>${vo.title}</td>
                            <td>${vo.postDate}</td>
                            <td><a href="/quote/d/${vo.key}"><spring:message code="userprofile.detail" /></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <p align="right">
            <a href="/u/q"><spring:message code="userprofile.allquote" /></a>
        </p>
    </div>

</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/user/userProfile.js"></script>
</body>
</html>