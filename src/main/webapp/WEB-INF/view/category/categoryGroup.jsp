<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="page-header">

    <h1>Category</h1>

    <div class="headerdivider">

    </div>

</div>

<div id="content" class="top30">
    <c:forEach items="${categoryGroupList}" var="categoryGroup">
        <div class="boxportfolio3">
            <h4><a href="category/${categoryGroup.keyString}">${categoryGroup.name}</a> </h4>
            <div class="inneritem">
                <c:forEach items="${categoryGroup.categoryList}" var="category">
                    <a href="search/category/${category.keyString}">${category.name}</a> <br/>
                </c:forEach>
            </div>
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

            masonry:{ columnWidth:$container.width() / 3 }

        });

// update columnWidth on window resize

        $(window).smartresize(function () {

            $container.isotope({

                // update columnWidth to a percentage of container width

                masonry:{ columnWidth:$container.width() / 3 }

            });

        });

    });

</script>