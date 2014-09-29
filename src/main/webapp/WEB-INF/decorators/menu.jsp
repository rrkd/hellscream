<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container clearfix">

    <div class="row-fluid">

        <div class="span12">

            <h1 class="brandlogo"><a href="/home"><img src="/assets/img/logo.png" alt=""></a></h1>

            <div class="topinfo">

                <ul class="social-icons list-soc">

                    <li><a href="#"><i class="icon-facebook"></i></a></li>

                    <li><a href="#"><i class="icon-twitter"></i></a></li>

                    <li><a href="#"><i class="icon-linkedin"></i></a></li>

                    <li><a href="#"><i class="icon-google-plus"></i></a></li>

                    <li><a href="#"><i class="icon-pinterest"></i></a></li>

                </ul>

                <div class="infophone">

                    <i class="icon-phone"></i> Tel: +8 737 924 6035

                </div>

                <div class="infoaddress">

                    3953 Berkley Street, Fort Washington, 19034

                </div>
                <div>
                    <sec:authorize access="isAuthenticated()">
                        Welcome back <sec:authentication property="principal.nickname"/>.<a href="/logout">Logout</a>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        Welcome Guest.<a href="/u/p">Login</a>
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

                        <sec:authorize access="isAuthenticated()">
                            <sec:authentication property='principal.isUser' var="isUser"/>
                            <c:if test="${isUser}">
                                <li><a href="/quote/c">Post Quotes</a></li>

                                <li class="divider-vertical"></li>
                            </c:if>
                        </sec:authorize>
                        <sec:authorize access="isAnonymous()">
                            <li><a href="/quote/c">Post Quotes</a></li>

                            <li class="divider-vertical"></li>
                        </sec:authorize>




                        <li><a href="/merchant/create">List Your Business</a></li>

                        <li class="divider-vertical"></li>
                        <sec:authorize access="isAuthenticated()">
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">My Account
                                <b class="caret"></b></a>
                                <sec:authentication property='principal.isUser' var="isUser"/>
                                <c:choose>
                                    <c:when test="${isUser}">
                                        <ul class="dropdown-menu js-activated" style="display: none;">

                                            <li><a href="/u/p/<sec:authentication property='principal.keyString'/>">Profile</a></li>
                                            <li><a href="/u/q">My Quote</a></li>
                                            <li><a href="/u/msg">My Message</a></li>
                                            <!--.dropdown-->

                                        </ul>
                                    </c:when>
                                    <c:otherwise>
                                        <ul class="dropdown-menu js-activated" style="display: none;">

                                            <li><a href="/u/p/<sec:authentication property='principal.keyString'/>">Profile</a></li>
                                            <li><a href="/merchant/q">My Quote List</a></li>
                                            <li><a href="/merchant/msg">My Message</a></li>
                                            <!--.dropdown-->

                                        </ul>
                                    </c:otherwise>
                                </c:choose>


                            <li class="divider-vertical"></li>
                        </sec:authorize>

                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">About Us
                            <b class="caret"></b></a>

                            <ul class="dropdown-menu js-activated" style="display: none;">

                                <li><a href="/merchant">About Us</a></li>

                                <li><a href="/merchant">Contact Us</a></li>

                                <li><a href="/merchant?p=1">List Merchant</a></li>

                                <li><a href="/search">Search</a></li>

                                <li><a href="/ad/merchant/create">Create Merchant</a></li>

                                <li><a href="/category">List Category</a></li>

                                <li><a href="/u/q">My Quote</a></li>

                                <li><a href="/quote/t/ahFzcHJpbmctZm9yZXN0LTUzOHISCxIFUXVvdGUYgICAgICAkQgM">Test Apply Quote</a></li>

                                <!--.dropdown-->

                            </ul>

                        </li>

                        <li class="divider-vertical"></li>

                    </ul>

                    <form id="search" action="search" method="GET">

                        <input id="keyWord_text" type="text" onfocus="if(this.value =='Enter search keywords here...' ) this.value=''"
                               onblur="if(this.value=='') this.value='Enter search keywords here...'"
                               value="Enter search keywords here..." name="q">

                        <a id="searchBtn" href="#"></a>
                    </form>

                </div>

            </div>

        </div>

    </div>

</div>