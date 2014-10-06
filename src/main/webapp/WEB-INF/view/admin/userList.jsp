<%@include file="../globe.jsp"%><html>
<head>
    <meta name="description" content="service job search">
    <title>Administrator - User</title>
</head>
<body>
<div class="page-header">

    <h1>User Management</h1>

    <div class="headerdivider">

    </div>

</div>
<div class="row-fluid">
    <div class="span12">
        <div class="titleborder">

            <div>

                Filter

            </div>

        </div>
        <div class="row-fluid">
            <div class="span6">
                <input name="name" size="30" type="text" id="merchantName" class="span6" placeholder="MerchantName">
            </div>
            <div class="span6">
                <button type="button" class="btn btn-primary">Filter</button>
            </div>
        </div>
        <div class="titleborder">

            <div>

                Result

            </div>

        </div>
        <div class="listContainer">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>User Name</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody id="dataTableBody">

                </tbody>
            </table>
        </div>
        <div class="pagination">

            <ul class="pagination-box">

            </ul>

        </div>

    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/ad/user/userList.js"></script>
</body>
</html>