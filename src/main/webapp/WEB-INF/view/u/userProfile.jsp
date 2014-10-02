<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="User Profile">
    <title>User Profile - ${iguser.nickname}</title>
</head>
<body>
<div class="page-header">

    <h1>User Profile - ${iguser.nickname}</h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid top30">

    <div class="span12">

        <div class="titleborder">

            <div>

                Basic Information

            </div>

        </div>

        <!-- Left Tabs

              ================================================== -->

        <div class="tabbable tabs-left">

            <!--bootstrap tabs implementation-->

            <ul class="nav nav-tabs">

                <!--tabs-->

                <li class="active">

                    <a data-toggle="tab" href="#tab1">About Me</a>

                </li>

                <li>

                    <a data-toggle="tab" href="#tab2">Contact Info</a>

                </li>

            </ul>

            <!--tabs content -->

            <div class="tab-content">

                <div id="tab1" class="tab-pane active fade in">

                    <div class="row-fluid">
                        <div class="span4"><b>Nickname</b></div>
                        <div class="span8">${iguser.nickname}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b>Email</b></div>
                        <div class="span8">${iguser.email}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b>Forename</b></div>
                        <div class="span8">${iguser.forename}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b>Surname</b></div>
                        <div class="span8">${iguser.surname}</div>
                    </div>
                    <a href="">Edit</a>
                </div>

                <div id="tab2" class="tab-pane fade ">

                    <div class="row-fluid">
                        <div class="span4"><b>Mobile</b></div>
                        <div class="span8">${iguser.mobile}</div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4"><b>Address</b></div>
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
                    <a href="">Edit</a>
                </div>

            </div>

            <!--tab content -->

        </div>

        <!-- END Left Tabs -->

    </div>

    <div class="span12">
        <div class="titleborder">

            <div>

                Usage

            </div>

        </div>

        <div class="row-fluid">

            <div class="span4">

                <a href="#">

                    <div class="service-box">

                        <h3>Quote</h3>

                        <div class="circleicon">

                            <i class="icon-list"></i>

                        </div>

                        <p>

                            100 Quote

                        </p>

                    </div>

                </a>

            </div>

            <div class="span4">

                <a href="#">

                    <div class="service-box black">

                        <h3>Message</h3>

                        <div class="circleicon">

                            <i class="icon-envelope"></i>

                        </div>

                        <p>

                            100 Message

                        </p>

                    </div>

                </a>

            </div>

            <div class="span4">

                <a href="#">

                    <div class="service-box black">

                        <h3>Feedback</h3>

                        <div class="circleicon">

                            <i class="icon-thumbs-up"></i>

                        </div>

                        <p>

                            100 Feedback

                        </p>

                    </div>

                </a>

            </div>

        </div>
    </div>

    <div class="span12">

        <div class="titleborder">

            <div>

                Latest Quotes

            </div>

        </div>

        <div class="listContainer">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Title</th>
                    <th>Post Time</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody id="dataTableBody">
                    <c:forEach items="${quoteList.voList}" var="vo" varStatus="loop">
                        <tr>
                            <td>${loop.index}</td>
                            <td>${vo.title}</td>
                            <td>${vo.postDate}</td>
                            <td><a href="">details >></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <p align="right">
            <a href="/u/q"> All Quotes</a>
        </p>
    </div>

</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/user/userProfile.js"></script>
</body>
</html>