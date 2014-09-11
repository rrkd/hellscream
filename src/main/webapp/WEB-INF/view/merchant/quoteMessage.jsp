<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="page-header">

    <h1>Message Box</h1>

    <div class="headerdivider">
        ${merchant.merchantName}
    </div>

</div>

<div class="row-fluid">

    <div class="span12">

        <div class="titleborder">

            <div>

                List of Message

            </div>

        </div>

        <!-- Tabs

              ================================================== -->

        <ul id="myTab" class="nav nav-tabs">

            <li class="active"><a href="#home" data-toggle="tab">Latest Message</a></li>

            <li class=""><a href="#profile" data-toggle="tab">History</a></li>

        </ul>

        <div id="myTabContent" class="tab-content">

            <div class="tab-pane fade active in" id="home">

                <c:forEach items="${latestMsgList}" var="msg">
                <div class="row-fluid">

                    <div class="panel">

                        User ${msg.userName} is interest in your response and you can contact him by <br>
                        Email : ${msg.userEmail}
                        Mobile: ${msg.mobile}
                    </div>

                    <div class="clearfix">

                    </div>

                </div>
                </c:forEach>

            </div>

            <div class="tab-pane fade" id="profile">

                <p>

                    Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.

                </p>

                <p>

                    Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum.

                </p>

            </div>

            <div class="tab-pane fade" id="something">

                <p>

                    Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.

                </p>

                <p>

                    Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum.

                </p>

            </div>

        </div>

        <!-- END Tabs -->

    </div>

</div>