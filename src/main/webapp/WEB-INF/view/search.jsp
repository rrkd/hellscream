<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="igooit" uri="http://www.iglooit.com.au/tags/1.0/formatutil" %>
<div class="row-fluid">

<div class="span8 span-fixed-sidebar">

    <c:forEach items="${merchantList}" var="heroMerchant" begin="0" end="0">
        <div class="hero-unit">

            <h1>${heroMerchant.tradeName}</h1>

            <p>

                <img src="/assets/img/demo/news.jpg" class="pull-left paddingright" alt="" style="margin-top:10px;">
                ${heroMerchant.description}

            </p>

            <p>

                <a href="merchant/details/${heroMerchant.keyString}" class="btn btn-primary btn-large">Read more >></a>

            </p>

        </div>
    </c:forEach>

    <div class="row-fluid">

        <c:forEach items="${merchantList}" var="merchant" begin="1" end="5">

            <div class="hero-unit">

                <h5><a href="#">${merchant.tradeName}</a></h5>

                <p class="small datepost">

                    Posted on ${igooit:formatDate(merchant.postDate)} <span class="floatright" title="3 responses"><a href="#"><img src="img/comments.png" alt=""></a></span>

                </p>

                <div class="innerblogboxtwo">

                    <p>

                        <img width="150" height="150" src="/assets/img/demo/300x200.png" class="attachment-thumbnail" alt="">

                        ${merchant.description}

                    </p>

                </div>

                <p class="continueread readmorebox">

                    <a href="merchant/details/${merchant.url}">Details</a>

                </p>

            </div>

        </c:forEach>

        <!--/span-->

    </div>

    <!--/row-->

</div>

<!--/span-->

<div class="span4">

    <ul id="myTab" class="nav nav-tabs">

        <li class="active"><a href="#home" data-toggle="tab">Recent Posts</a></li>

        <li class=""><a href="#profile" data-toggle="tab">Comments</a></li>

        <li class=""><a href="#something" data-toggle="tab">Tags</a></li>

    </ul>

    <div id="myTabContent" class="tab-content multi-sidebar">

        <div class="tab-pane fade active in" id="home">

            <ul class="sidebar-latest">

                <li class="clearfix">

                    <a href="#"><img src="img/demo/300x200.png" class="attachment-thumbnail" alt=""></a>

                    <a href="#">Android 4.3 to hit Sony Xperia smartphones, tablet</a><br>

                    <small><a href="#"><span class="entry-date">July 25, 2013</span></a></small>

                </li>

                <li class="clearfix">

                    <a href="#"><img src="img/demo/300x200.png" class="attachment-thumbnail" alt=""></a>

                    <a href="#">Geeksphone now selling Firefox OS to consumers with Peak+</a><br>

                    <small><a href="#"><span class="entry-date">June 14, 2013</span></a></small>

                </li>

                <li class="clearfix">

                    <a href="#"><img src="img/demo/300x200.png" class="attachment-thumbnail" alt=""></a>

                    <a href="#">Google goes after Apple in tablet education</a><br>

                    <small><a href="#"><span class="entry-date">May 7, 2013</span></a></small>

                </li>

                <li class="clearfix">

                    <a href="#"><img src="img/demo/300x200.png" class="attachment-thumbnail" alt=""></a>

                    <a href="#">Apple now EA's biggest retail partner, thanks to iOS</a><br>

                    <small><a href="#"><span class="entry-date">April 3, 2013</span></a></small>

                </li>

                <li class="clearfix">

                    <a href="#"><img src="img/demo/300x200.png" class="attachment-thumbnail" alt=""></a>

                    <a href="#">New video compares leaked iPhone plastic case to previous models</a><br>

                    <small><a href="#"><span class="entry-date">February 16, 2013</span></a></small>

                </li>

            </ul>

        </div>

        <div class="tab-pane fade" id="profile">

            <ul class="sidebar-latest">

                <li class="clearfix">

                    <a href="#"><img src="img/demo/avatar.jpg" class="attachment-thumbnail" alt=""></a>

                    <a href="#">"The apple- pickers on the ladders raised a hum..."</a><br>

                    <small><a href="#"><span class="entry-date">July 25, 2013</span></a></small>

                </li>

                <li class="clearfix">

                    <a href="#"><img src="img/demo/avatar.jpg" class="attachment-thumbnail" alt=""></a>

                    <a href="#">"Alice was beginning to get very tired of sitting..."</a><br>

                    <small><a href="#"><span class="entry-date">June 14, 2013</span></a></small>

                </li>

                <li class="clearfix">

                    <a href="#"><img src="img/demo/avatar.jpg" class="attachment-thumbnail" alt=""></a>

                    <a href="#">"Let us begin at the simplest point, what is a comic..."</a><br>

                    <small><a href="#"><span class="entry-date">May 7, 2013</span></a></small>

                </li>

                <li class="clearfix">

                    <a href="#"><img src="img/demo/avatar.jpg" class="attachment-thumbnail" alt=""></a>

                    <a href="#">"I assume it as self-evident that those who, at any given..."</a><br>

                    <small><a href="#"><span class="entry-date">April 3, 2013</span></a></small>

                </li>

                <li class="clearfix">

                    <a href="#"><img src="img/demo/avatar.jpg" class="attachment-thumbnail" alt=""></a>

                    <a href="#">"The greatest length or breadth of a full grown..."</a><br>

                    <small><a href="#"><span class="entry-date">February 16, 2013</span></a></small>

                </li>

            </ul>

        </div>

        <div class="tab-pane fade" id="something">

            <div class="tagcloud">

                <a href="#">mobile</a>

                <a href="#">google</a>

                <a href="#">apple</a>

                <a href="#">phones</a>

                <a href="#">ipads</a>

                <a href="#">tablets</a>

                <a href="#">desktops</a>

            </div>

        </div>

    </div>

    <!-- END Tabs -->

    <div class="sidebarBox widget-container widget_text">

        <h4 class="widget-title">Another Widget</h4>

        <div class="textwidget">

            Aenean enim urna, luctus vel sollicitudin eu, lobortis et sapien. Duis justo purus, scelerisque sed iaculis vitae, dignissim a est. Pellentesque congu. Nulla dictum auctor dui, a sagittis arcu mattis eu.

        </div>

    </div>

    <div class="sidebarBox widget-container widget_text">

        <h4 class="widget-title">Apple's Suppliers</h4>

        <div class="textwidget">

            <iframe height="250" style="width:99.3%;" allowfullscreen="" src="http://www.youtube.com/embed/6NbAAmDuv_8?feature=player_detailpage">

            </iframe>

        </div>

    </div>

</div>

<!--/span-->

</div>

<!--/row-->