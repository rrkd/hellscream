<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="span4">

    <ul id="myTab" class="nav nav-tabs">

        <li class="active"><a href="#recentPost" data-toggle="tab">Recent Quote</a></li>

        <li class=""><a href="#newMerchant" data-toggle="tab">New Merchant</a></li>

        <li class=""><a href="#something" data-toggle="tab">Tags</a></li>

    </ul>

    <div id="myTabContent" class="tab-content multi-sidebar">

        <div class="tab-pane fade active in" id="recentPost">

            <ul class="sidebar-latest" id="latestQuoteContainer">

            </ul>

        </div>

        <div class="tab-pane fade" id="newMerchant">

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

        <h4 class="widget-title">Last Comment</h4>

        <div class="textwidget" id="latestMsgTxt">

        </div>

    </div>

</div>
<script type="text/javascript" src="/assets/js/leftSectionTp.js"></script>