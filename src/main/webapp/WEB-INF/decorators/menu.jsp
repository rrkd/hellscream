<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property='principal.isUser' var="isUser"/>
    <sec:authentication property='principal.isMerchant' var="isMerchant"/>
    <sec:authentication property='principal.isAdmin' var="isAdmin"/>
</sec:authorize>
<div class="container clearfix">

    <div class="row-fluid">

        <div class="span12">

            <div class="brandlogo">

                <a href="/home"><img src="/assets/img/logo.png" alt="huafu"></a><br/>
                <a href="/home?lang=en" style="margin: 1px;"><img src="/assets/img/au_logo.png" alt="English"></a>
                <a href="/home?lang=zh_CN" style="margin: 1px;"><img src="/assets/img/cn_logo.png" alt="China"></a>
            </div>

            <div class="topinfo">

                <ul class="social-icons list-soc">

                    <li><a href="#"><i class="icon-facebook"></i></a></li>

                    <li><a href="#"><i class="icon-twitter"></i></a></li>

                    <li><a href="#"><i class="icon-linkedin"></i></a></li>

                    <li><a href="#"><i class="icon-google-plus"></i></a></li>

                    <li><a href="#"><i class="icon-pinterest"></i></a></li>

                </ul>

                <div class="infophone">

                    <i class="icon-phone"></i> Tel: +61 433 274 987

                </div>

                <div class="infoaddress">

                    1 Berkley Street, Fort Washington, 2009

                </div>
                <div>
                    <sec:authorize access="isAuthenticated()">
                        Welcome back <sec:authentication property="principal.nickname"/>.<a href="/logout">Logout</a>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        Welcome Guest.<a href="/login">Login</a>
                    </sec:authorize>

                </div>

            </div>

            <div class="clearfix">

            </div>

            <div class="row-nav navbar">

                <div class="navbar-inner">

                    <ul id="nav" class="nav">

                        <li><a href="/home">Home</a></li>

                        <li class="divider-vertical"></li>

                        <li><a href="/howitworks">How it works</a></li>

                        <li class="divider-vertical"></li>

                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Service
                            <b class="caret"></b></a>
                            <ul class="dropdown-menu js-activated" style="display: none;">
                                <sec:authorize access="isAuthenticated()">
                                    <c:if test="${isUser}">
                                        <li><a href="/quote/c">Post Quotes</a></li>
                                    </c:if>
                                </sec:authorize>
                                <sec:authorize access="isAnonymous()">
                                    <li><a href="/quote/c">Post Quotes</a></li>
                                </sec:authorize>
                                <sec:authorize access="isAuthenticated()">
                                    <c:if test="${not isMerchant}">
                                        <li><a href="/m/create">List Your Business</a></li>
                                    </c:if>
                                </sec:authorize>
                                <sec:authorize access="isAnonymous()">
                                    <li><a href="/m/create">List Your Business</a></li>
                                </sec:authorize>
                            </ul>
                        <li class="divider-vertical"></li>

                        <sec:authorize access="isAuthenticated()">

                            <c:if test="${isUser}">
                                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">My Account
                                <b class="caret"></b></a>
                                <ul class="dropdown-menu js-activated" style="display: none;">

                                    <li><a href="/u/profile">User Profile</a></li>
                                    <li><a href="/u/q">Posted Quote</a></li>
                                    <!--.dropdown-->

                                </ul>
                                <li class="divider-vertical"></li>
                            </c:if>
                            <c:if test="${isMerchant}">
                                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">My Business
                                    <b class="caret"></b></a>
                                    <ul class="dropdown-menu js-activated" style="display: none;">

                                        <li><a href="/merchant/p">Merchant Profile</a></li>
                                        <li><a href="/m/q">Applied Quote</a></li>
                                        <li><a href="/merchant/msg">Message Box</a></li>
                                        <!--.dropdown-->

                                    </ul>
                                <li class="divider-vertical"></li>
                            </c:if>
                            <c:if test="${isAdmin}">
                                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Admin
                                    <b class="caret"></b></a>
                                    <ul class="dropdown-menu js-activated" style="display: none;">

                                        <li><a href="/admin/user">User Management</a></li>
                                        <li><a href="/admin/merchant">Merchant Management</a></li>
                                        <!--.dropdown-->

                                    </ul>
                                <li class="divider-vertical"></li>
                            </c:if>

                        </sec:authorize>

                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">About Us
                            <b class="caret"></b></a>

                            <ul class="dropdown-menu js-activated" style="display: none;">

                                <li><a href="/aboutus">About Us</a></li>

                                <li><a href="/contactus">Contact Us</a></li>

                                <li><a href="/faq">FAQ</a></li>

                                <!--.dropdown-->

                            </ul>

                        </li>

                        <li class="divider-vertical"></li>

                    </ul>

                    <form id="search">

                        <input id="keyWord_text" type="text" onfocus="if(this.value =='Find service...' ) this.value=''"
                               onblur="if(this.value=='') this.value='Find service...'"
                               value="Find service..." name="q">

                        <a id="searchBtn" href="#"></a>
                    </form>

                </div>

            </div>

        </div>

    </div>

</div>