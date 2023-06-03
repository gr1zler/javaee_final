<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/helper/css/bootstrap.css">
    <script type="text/javascript"  src="/helper/js/bootstrap.bundle.js"></script>
</head>
<body>
<%@ include file="Head.jsp" %>
<form action="/add-news" method="post" style="margin: 50px">
    <div class="col-3">
        <label for="exampleFormControlSelect1">Category</label>
        <select name="category" class="form-control" id="exampleFormControlSelect1" style="margin-bottom: 20px">
           <%
               if(categories!=null){
              for(int i=0;i<categories.size();i++) {
           %>
            <option value="<%=categories.get(i).getId()%>"><%=categories.get(i).getName()%></option>
            <%
                }
                }
            %>
        </select>
    </div>
    <div class="col-3">
        <label class="form-label" for="form1Example1">Write news title :</label>
        <input type="text" name="title" id="form1Example1" class="form-control" style="margin-bottom: 20px"/>
    </div>
    <div class="col-3">
        <label class="form-label" for="form1Example1">Write news content :</label>
        <textarea name="content" class="form-control" id="exampleFormControlTextarea1" rows="3" style="margin-bottom: 20px"></textarea>
    </div>
    <!-- Submit button -->
    <button type="submit" class="btn btn-primary btn-block">Add news</button>
</form>
</body>
</html>
