<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="page-header">

    <h1>${merchant.tradeName}</h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid top30">

    <div class="span6">

        <form action="#">

            <input name="name" size="30" type="text" id="tradeName" class="span12" placeholder="TradeName"
                   value="${merchant.tradeName}">
            <input name="name" size="30" type="text" id="merchantName" class="span12" placeholder="MerchantName"
                   value="${merchant.merchantName}">
            <select multiple="multiple" name="name" size="30" id="category_select"
                    class="populate placeholder select2-offscreen span12" style="margin-bottom: 10px; margin-left: 0;">
                <c:forEach items="${categoryGroupList}" var="categoryGroup">
                    <optgroup label="${categoryGroup.tradeName}">
                        <c:forEach items="${categoryGroup.categoryList}" var="category">
                            <option value="${category.name}">${category.tradeName}</option>
                        </c:forEach>
                    </optgroup>
                </c:forEach>
            </select>
            <textarea id="description" name="message" class="span12" placeholder="Description" rows="8"
                    value="${merchant.description}"></textarea>
            <input name="name" size="30" type="text" id="address1" class="span12" placeholder="Address1"
                    value="${merchant.address1}">
            <input name="name" size="30" type="text" id="address2" class="span12" placeholder="Address2"
                    value="${merchant.address2}">
            <input name="name" size="30" type="text" id="address3" class="span12" placeholder="Address3"
                    value="${merchant.address3}">
            <input name="name" size="30" type="text" id="phone" class="span12" placeholder="Phone"
                    value="${merchant.phone}">
            <input name="name" size="30" type="text" id="email" class="span12" placeholder="Email"
                    value="${merchant.email}">
            <input name="name" size="30" type="text" id="contact1" class="span12" placeholder="Contact One"
                    value="${merchant.contact1}">
            <input name="name" size="30" type="text" id="contact2" class="span12" placeholder="Contact Tow"
                    value="${merchant.contact2}">
            <br/>
            <input name="name" size="30" type="hidden" id="keyString" class="span12"
                   value="${merchant.keyString}">

            <ul id="selectedCategory" style="visibility: hidden">
                <c:forEach items="${merchant.categoryList}" var="name">
                    <li>${name}</li>
                </c:forEach>
            </ul>

            <input value="Update" id="modify_merchant" class="btn btn-primary top10">

        </form>

    </div>

    <div class="span6">

        <div class="box3">

            <p></p>

        </div>

    </div>

</div>
<script type="text/javascript" src="/assets/js/merchant/merchant-modify.js"></script>