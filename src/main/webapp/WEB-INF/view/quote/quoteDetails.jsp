<%@include file="../globe.jsp"%><html>
<div class="row-fluid">

<div class="span8 span-fixed-sidebar">

    <div class="row-fluid">

        <div class="span12">

            <header class="entry-header">

                <div class="sectiontitlepost">

                    <h1>${quote.title}</h1>

                </div>

                <div class="entry-meta">

                    <a href="#"><span class="entry-date">December 11, 2012</span></a>

                    <span class="pull-right"><a href="#"><span>3</span> Comments</a></span>

                </div>

                <!-- .entry-meta -->

            </header>

            <div class="innerblogboxtwo">

                <div class="entry-content" style="min-height: 200px;">

                    <p>

                        <img src="/assets/img/demo/news.jpg" class="pull-left paddingright" alt="" style="margin-top:5px;">
                        ${quote.description}

                    </p>

                </div>

                <footer class="entry-meta">

                    Posted in <a href="#" title="View all posts in Stories">Stories</a> and tagged <a href="#" rel="tag">grace</a> by <a href="#">serenity</a>. </footer>

            </div>

            <div id="comments">

                <div class="blogbox comments-area">

                    <h3 class="commentstitle">

                        <i class="icon-comments muted"></i> List of transaction </h3>

                    <div class="comment-list left0">

                        <ul class="media">

                        <c:forEach items="${quote.quoteTransactions}" var="quoteTransaction">
                            <li class="comment">

                                <article class="comment">

                                    <footer>

										<span class="comment-author vcard">

										<span class="pull-left"><img alt="" src="http://1.gravatar.com/avatar/3d988ca07c9fc4afb310dc8fbd015f9d?s=54&amp;d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D54&amp;r=G" class="avatar avatar-54 photo" height="54" width="54"></span>

										<cite class="fn">${quoteTransaction.merchant.contact1}</cite> <span class="says">on</span></span>

                                        <!-- .comment-author .vcard -->

										<span class="comment-meta commentmetadata">

										<a href="#">

                                            ${quoteTransaction.createdOn}

                                        </a>

										</span>

                                        <!-- .comment-meta .commentmetadata -->

                                    </footer>

                                    <div class="comment-content">

                                        <p>

                                            ${quoteTransaction.comment}

                                        </p>

                                    </div>

                                    <div class="reply">
                                        <c:if test="${quoteTransaction.quoteTransactionStatus eq 'Appending'}">
                                        <a class="comment-reply-link" href="/u/c/${quoteTransaction.keyString}">I want to contact with him</a>
                                        </c:if>
                                        <c:if test="${quoteTransaction.quoteTransactionStatus ne 'Appending'}">
                                            You have contact with this merchant.
                                        </c:if>
                                    </div>

                                    <!-- .reply -->

                                </article>

                                <!-- #comment-## -->

                            </li>
                        </c:forEach>
                        </ul>

                    </div>

                    <!-- .commentlist -->

                </div>

            </div>

        </div>

        <!--/span-->

    </div>

    <!--/row-->

</div>

<!--/span-->

<div class="span4 top20">

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
