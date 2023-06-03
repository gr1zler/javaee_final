<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/helper/css/bootstrap.css">
    <script type="text/javascript"  src="/helper/js/bootstrap.bundle.js"></script>
</head>
<body>
<%@ include file="Head.jsp" %>
<form action="/add-category" method="post" style="margin: 50px">
    <!-- Email input -->
    <div class="col-3">
        <label class="form-label" for="form1Example1">Write category name :</label>
        <input type="name" name="name" id="form1Example1" class="form-control" style="margin-bottom: 20px"/>
    </div>
    <!-- Submit button -->
    <button type="submit" class="btn btn-primary btn-block">Add category</button>
</form>
</body>
</html>
