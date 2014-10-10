<%@include file="globe.jsp"%><html>
<div class="row-fluid">

<div class="span8 span-fixed-sidebar">

    <c:forEach items="${merchantList}" var="heroMerchant" begin="0" end="0">
        <div class="hero-unit">

            <h1>${heroMerchant.tradeName}</h1>

            <p>

                <img src="${heroMerchant.imageFileName}" class="pull-left paddingright" alt="" style="margin-top:10px;">
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


</div>

<!--/row-->