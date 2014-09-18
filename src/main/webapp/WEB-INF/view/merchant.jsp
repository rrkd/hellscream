<%@include file="globe.jsp"%><html>
<div class="page-header">

    <h1>Merchant List</h1>

    <div class="headerdivider">

    </div>

</div>

<div id="content" class="top30">

<!-- item -->

    <c:forEach items="${merchantList}" var="merchant">

        <div class="boxportfolio3">

            <div class="testimonial">

                <h4><img class="avatarspic" src="assets/img/demo/avatar.jpg" alt=""/><a href="merchant/details/${merchant.url}">${merchant.tradeName}</a></h4>

                ${merchant.description}

            </div>

            <div class="author-wrapper">

                <div class="arrow">

                </div>

                <div class="testimonial-name">

                    ${merchant.contact1} <span>${merchant.phone}</span>

                </div>

            </div>

        </div>
    </c:forEach>

<!-- item etc -->

</div>


<div class="row-fluid top30">

    <div class="span12">

        <div class="info-box shadow-large bottom0">

            <div class="info-box-inner">

                <div class="info-content">

                    <h4>Responsive, Smart Design, Easy Customization</h4>

                    <p>

                        Praesent vestibulum molestie lacus. Aenean nonummy hendrerit mauris. Fusce suscipit.

                    </p>

                </div>

                <a style="float: right;" class="btn btn-primary btn-large" href="#"><i class="icon-download-alt"></i>&nbsp;
                    Get this Theme</a>

                <div class="clearfix">

                </div>

            </div>

        </div>

    </div>

</div>