<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="page-header">

    <h1>Create a New Merchant</h1>

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

            <input name="name" size="30" type="text" id="tradeName" class="span12" placeholder="TradeName">
            <input name="name" size="30" type="text" id="merchantName" class="span12" placeholder="MerchantName">
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
            <input name="name" size="30" type="text" id="address1" class="span12" placeholder="Address1">
            <input name="name" size="30" type="text" id="address2" class="span12" placeholder="Address2">
            <input name="name" size="30" type="text" id="address3" class="span12" placeholder="Address3">
            <input name="name" size="30" type="text" id="phone" class="span12" placeholder="Phone">
            <input name="name" size="30" type="text" id="email" class="span12" placeholder="Email">
            <input name="name" size="30" type="text" id="contact1" class="span12" placeholder="Contact One">
            <input name="name" size="30" type="text" id="contact2" class="span12" placeholder="Contact Tow">
            <br/>


            <input value="Send" id="create_merchant" class="btn btn-primary top10">

        </form>

    </div>

</div>
<script type="text/javascript" src="/assets/js/merchant/merchant-create.js"></script>