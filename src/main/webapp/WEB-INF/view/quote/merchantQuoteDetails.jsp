<%@include file="../globe.jsp" %>
<html>
<head>
    <meta name="description" content="Quote List">
    <title>Quote List - Merchant</title>
</head>
<body>
<div class="row-fluid">

    <div class="span12 span-fixed-sidebar">

        <div class="row-fluid">

            <div class="span12">

                <header class="entry-header">

                    <div class="sectiontitlepost">

                        <h1>${quote.title}</h1>

                    </div>

                    <div class="entry-meta">

                        <a href="#"><span class="entry-date">${quote.postDate}</span></a>

                        <span class="pull-right"><a href="#"><span>3</span> Comments</a></span>

                    </div>

                    <!-- .entry-meta -->

                </header>

                <div class="innerblogboxtwo">

                    <div class="entry-content" style="min-height: 200px;">

                        <div class="row-fluid">
                            <div class="span4">Category</div>
                            <div class="span8">
                                <c:forEach items="${quote.categoryList}" var="category" begin="0">
                                    <a class="btn btn-small" href="#">${category}</a>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span4">Location</div>
                            <div class="span8"></div>
                        </div>
                        <div class="row-fluid">
                            <div class="span4">Description</div>
                            <div class="span8">${quote.description}</div>
                        </div>
                    </div>

                    <footer class="entry-meta">

                        Posted in <a href="#" title="View all posts in Stories">Stories</a> and tagged <a href="#"
                                                                                                          rel="tag">grace</a>
                        by <a href="#">serenity</a>.
                    </footer>

                </div>

                <div>
                    <p class="clearfix">

                        <a href="/quote/t/${quote.keyString}" class="btn btn-primary"><i class="icon icon-envelope"></i>&nbsp;
                            I want to reply this quote</a>

                    </p>
                </div>

            </div>

            <!--/span-->

        </div>

        <!--/row-->

    </div>
</div>
</body>
</html>