<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="${categoryGroup.tradeName}">
    <title><spring:message code="aboutus.title"></spring:message></title>
</head>
<body>
<div class="page-header">

    <h1>${categoryGroup.tradeName}</h1>

    <div class="headerdivider">

    </div>

</div>

<div id="content" class="top30">

    <div class="boxportfolio2">
        <div class="inneritem">
            <c:forEach items="${categoryGroup.categoryList}" var="category">
                <a href="/category/${category.url}">${category.name}</a> <br/>
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