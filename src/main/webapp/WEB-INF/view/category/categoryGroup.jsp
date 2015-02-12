<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="page-header">

    <h1><spring:message code="home.viewallcategories"></spring:message></h1>

    <div class="headerdivider">

    </div>

</div>

<div id="content" class="top30">
    <c:forEach items="${categoryGroupList}" var="categoryGroup">

            <h4><a href="categoryGroup/${categoryGroup.url}">${categoryGroup.tradeName}</a> </h4>
            <div class="inneritem span11">
                <c:forEach items="${categoryGroup.categoryList}" var="category">
                    <a href="/category/${category.url}">${category.tradeName} (${category.merchantCount})</a>&nbsp;&nbsp;&nbsp;&nbsp;
                </c:forEach>
            </div>
    </c:forEach>

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