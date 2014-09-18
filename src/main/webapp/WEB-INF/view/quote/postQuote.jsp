<%@include file="../globe.jsp"%><html>
<div class="page-header">

    <h1>Post Quote</h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid top30">

    <div class="span10">
        <div class="titleborder">

            <div>

                Basic Information

            </div>

        </div>

        <form action="#">

            <input name="name" size="30" type="text" id="email" class="span12" placeholder="Email">
            <input name="name" size="30" type="text" id="title" class="span12" placeholder="Title">
            <select multiple="multiple" name="name" size="30" id="category_select"
                    class="populate placeholder select2-offscreen span12" style="margin-bottom: 10px; margin-left: 0;">
                <c:forEach items="${categoryGroupList}" var="categoryGroup">
                    <optgroup label="${categoryGroup.name}">
                        <c:forEach items="${categoryGroup.categoryList}" var="category">
                            <option value="${category.name}">${category.name}</option>
                        </c:forEach>
                    </optgroup>
                </c:forEach>
            </select>
            <textarea id="description" name="message" class="span12" placeholder="Description" rows="8"></textarea>
            <br/>


            <input value="Post" id="create_merchant" class="btn btn-primary top10">

        </form>

    </div>

</div>
<script type="text/javascript" src="/assets/js/postQuote.js"></script>