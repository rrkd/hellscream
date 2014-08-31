<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="page-header">

    <h1>${categoryGroup.name}</h1>

    <div class="headerdivider">

    </div>

</div>

<div id="content" class="top30">

    <div class="boxportfolio2">
        <div class="inneritem">
            <c:forEach items="${categoryGroup.categoryList}" var="category">
                <a href="/search/c?q=${category.name}">${category.name}</a> <br/>
            </c:forEach>
        </div>
    </div>
    <div class="boxportfolio2">
        <div class="inneritem">
            <c:forEach items="${categoryGroup.categoryList}" var="category">
                <a href="/search/c?q={category.url}">${category.name}</a> <br/>
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