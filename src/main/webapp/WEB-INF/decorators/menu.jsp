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

                    <i class="icon-phone"></i><spring:message code="menu.tel" />

                </div>

                <div class="infoaddress">

                    <spring:message code="menu.address" />

                </div>
                <div>
                    <sec:authorize access="isAuthenticated()">
                        <spring:message code="menu.welcomeback" /><sec:authentication property="principal.nickname"/>.<a href="/logout"><spring:message code="menu.logout" /></a>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        <spring:message code="menu.welcomeguest" /><a href="/login"><spring:message code="menu.login" /></a>
                    </sec:authorize>

                </div>

            </div>

            <div class="clearfix">

            </div>

            <div class="row-nav navbar">

                <div class="navbar-inner">

                    <ul id="nav" class="nav">

                        <li><a href="/home"><spring:message code="menu.home" /></a></li>

                        <li class="divider-vertical"></li>

                        <li><a href="/howitworks"><spring:message code="menu.howitwork" /></a></li>

                        <li class="divider-vertical"></li>

                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="menu.service" />
                            <b class="caret"></b></a>
                            <ul class="dropdown-menu js-activated" style="display: none;">
                              <li><a href="/category"><spring:message code="menu.allcategory" /></a></li>
                                <sec:authorize access="isAuthenticated()">
                                    <c:if test="${isUser && not isMerchant}">
                                        <li><a href="/quote/c"><spring:message code="menu.postquote" /></a></li>
                                    </c:if>
                                </sec:authorize>
                                <sec:authorize access="isAnonymous()">
                                    <li><a href="/quote/c"><spring:message code="menu.postquote" /></a></li>
                                </sec:authorize>
                                <sec:authorize access="isAuthenticated()">
                                    <c:if test="${isMerchant}">
                                        <li><a href="/m/create"><spring:message code="menu.listyourbusiness" /></a></li>
                                    </c:if>
                                </sec:authorize>
                                <sec:authorize access="isAnonymous()">
                                    <li><a href="/m/create"><spring:message code="menu.listyourbusiness" /></a></li>
                                </sec:authorize>
                            </ul>
                        <li class="divider-vertical"></li>

                        <sec:authorize access="isAuthenticated()">

                            <c:if test="${isUser}">
                                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="menu.myaccount" />
                                <b class="caret"></b></a>
                                <ul class="dropdown-menu js-activated" style="display: none;">

                                    <li><a href="/u/profile"><spring:message code="menu.userprofile" /></a></li>
                                    <li><a href="/u/q"><spring:message code="menu.postedquotes" /></a></li>
                                    <!--.dropdown-->

                                </ul>
                                <li class="divider-vertical"></li>
                            </c:if>
                            <c:if test="${isMerchant}">
                                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="menu.mybusiness" />
                                    <b class="caret"></b></a>
                                    <ul class="dropdown-menu js-activated" style="display: none;">
                                      <li><a href="/quote/merchant/unapply"><spring:message code="menu.merchantUnapply" /></a></li>
                                        <li><a href="/merchant/p"><spring:message code="menu.merchantprofile" /></a></li>
                                        <li><a href="/m/q"><spring:message code="menu.appliedquote" /></a></li>
                                        <li><a href="/merchant/msg"><spring:message code="menu.messagebox" /></a></li>
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

                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="menu.aboutus" />
                            <b class="caret"></b></a>

                            <ul class="dropdown-menu js-activated" style="display: none;">

                                <li><a href="/aboutus"><spring:message code="menu.aboutus" /></a></li>

                                <li><a href="/contactus"><spring:message code="menu.contactus" /></a></li>

                                <li><a href="/faq"><spring:message code="menu.faq" /></a></li>

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