<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row-fluid">

<div class="span8 span-fixed-sidebar">

    <div class="row-fluid">

        <div class="span12">

            <header class="entry-header">

                <div class="sectiontitlepost">

                    <h1>${merchant.tradeName}</h1>

                </div>

                <div class="entry-meta">

                    <a href="#"><span class="entry-date">${merchant.merchantName}</span></a>

                    <span class="pull-right"><a href="#"><span>I want to</span> Send Email</a></span>

                </div>

                <!-- .entry-meta -->

            </header>

            <div class="innerblogboxtwo">

                <div class="entry-content">

                    <p>

                        <img src="img/demo/news.jpg" class="pull-left paddingright" alt="" style="margin-top:5px;"> It was agreeable to see the graceful figures of the blooming sisters, twined together, lingering among the trees, conversing thus, with earnestness opposed to lightness, yet, with love responding tenderly to love. And it was very curious indeed to see the younger sister’s eyes suffused with tears, and something fervently and deeply felt, breaking through the wilfulness of what she said, and striving with it painfully.

                    </p>

                    <p>

                        ${merchant.description}

                    </p>

                </div>

                <footer class="entry-meta">

                    Posted in <a href="#" title="View all posts in Stories">Stories</a> and tagged <a href="#" rel="tag">grace</a> by <a href="#">serenity</a>. </footer>

            </div>

            <div class="box3">

                <iframe class="gmap" style="width:98.2%;height:240px;" src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=disney+paris&amp;aq=&amp;sll=37.0625,-95.677068&amp;sspn=39.371738,86.572266&amp;ie=UTF8&amp;hq=disney&amp;hnear=Paris,+%C3%8Ele-de-France,+France&amp;t=m&amp;fll=48.881877,2.535095&amp;fspn=0.512051,1.352692&amp;st=103241701817924407489&amp;rq=1&amp;ev=zo&amp;split=1&amp;ll=49.027964,2.772675&amp;spn=0.315159,0.585022&amp;z=10&amp;iwloc=D&amp;output=embed&amp;output=embed">

                </iframe>

                <i class="icon-map-marker"></i> &nbsp;&nbsp;<i>Location</i>: 2536 Zamora Road, Missisipi, 74C

                <p>

                </p>

                <i class="icon-reorder"></i> &nbsp;<i>Hours</i>: Monday – Friday, 09:00 – 17:00

                <p>

                </p>

                <i class="icon-envelope"></i> &nbsp;<i>E-mail</i>: &nbsp;<a href="mailto:wowthemesnet@gmail.com">wowthemesnet@gmail.com</a>

                <p>

                </p>

            </div>

            <div id="respond">

                <h3 id="reply-title"><i class="icon-edit muted"></i> I want to send a message </h3>

                <form method="post" action="#" id="#">

                    <div class="form">

                        <div class="controls controls-row">

                            <input class="span4" type="text" name="subject" placeholder="Subject *">

                            <input class="span4" type="email" name="email" placeholder="E-mail (not published) *">

                            <input class="span4" type="text" name="email" placeholder="Website">

                        </div>

                        <div class="controls">

                            <textarea class="span12" name="message" rows="8" placeholder="Message *"></textarea>

                        </div>

                        <input id="sendMessageBtn" type="submit" class="btn btn-inverse" value="Send Message">

                    </div>

                </form>

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

<!--/row-->