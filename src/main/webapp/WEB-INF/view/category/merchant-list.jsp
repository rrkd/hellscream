<%@include file="../globe.jsp" %>
<html>
<head>
  <meta name="description" content="${category.tradeName}">
  <meta name="keywords" content="${category.keywords}"/>
  <title>${category.tradeName}</title>
</head>
<body>
<div class="page-header">

  <h1>${category.tradeName}</h1>

  <div class="headerdivider">

  </div>

</div>

<div class="row-fluid top30">

  <div class="span10">

      <div class="inneritem">
        <c:forEach items="${merchantList}" var="merchant">
          <div class="hero-unit">
            <h5><a href="/merchant/details/${merchant.canonicalSlugId}">${merchant.tradeName}</a></h5>
            <div class="merchant-rank" data-rank="${merchant.rank}"></div>
            <p class="small datepost">
                <%--<spring:message code="merchantlist.posteddate"></spring:message> <fmt:formatDate type="both" value="${merchant.postDate}" />--%>
              <span class="floatright"title="3 responses"><a href="#"><img src="/assets/img/comments.png" alt=""></a></span>
            </p>
            <div class="innerblogboxtwo">
              <p>
                <img width="150" height="150" src="${merchant.imageFileName}" class="attachment-thumbnail" alt="">${merchant.shortDesc}
              </p>
            </div>
            <p class="continueread readmorebox">
              <a href="/merchant/details/${merchant.canonicalSlugId}"><spring:message code="merchantlist.detail"></spring:message></a>
            </p>
          </div>

        </c:forEach>
      </div>
  </div>

</div>

<script>

  $(window).load(function () {

    var $container = $('#content')

// initialize Isotope

    $container.isotope({

      // options...

      resizable:false, // disable normal resizing

      // set columnWidth to a percentage of container width

      masonry:{ columnWidth:$container.width() / 2 }

    });

// update columnWidth on window resize

    $(window).smartresize(function () {

      $container.isotope({

        // update columnWidth to a percentage of container width

        masonry:{ columnWidth:$container.width() / 2 }

      });

    });

  });

</script>
</body>
</html>