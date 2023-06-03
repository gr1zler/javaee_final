<%@ page import="java.util.ArrayList" %>
<%@ page import="DB.news_categories" %>
<%@ page import="DB.users" %>
<nav class="navbar navbar-expand-lg " style="background-color: #0dcaf0 ">
    <h4 style="margin : 0 0 0 20px; width : 120px "> Mugiwara News </h4>
    <div class="dropdown">
        <button style="margin-right: 30px" class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
            Categories
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
            <%
                ArrayList<news_categories>categories=(ArrayList<news_categories>) request.getAttribute("categories");
                if(categories!=null){
                for(int i=0;i<categories.size();i++){
            %>
            <li><a class="dropdown-item" href="/"><%=categories.get(i).getName()%></a></li>
            <%
                }
                }
            %>
        </ul>
    </div>
    <!-- Collapsible content -->
    <div class="collapse navbar-collapse" id="navbarSupportedContent" >
        <ul class="navbar-nav me-auto" style="font-size: 30px;gap: 20px">
            <li class="nav-item active" >
                <a class="nav-link" href= "/">Home</a>
            </li>
            <%
                users user=(users)request.getAttribute("user");
                if(user!=null&&user.getRole_id()==1){
            %>
            <li class="nav-item active" >
                <a class="nav-link" href= "/add-category">Add Category</a>
            </li>
            <li class="nav-item active" >
                <a class="nav-link" href= "/add-news">Add News</a>
            </li>
            <%
                }
            %>
        </ul>
        <form class="form-check-inline my-2 my-lg-0">
            <%
                if(user!=null){
            %>
            <a class="btn btn-success my-2 my-sm-0 btn-lg" type="submit" href="/" style="color: #0d6efd"><%=user.getFull_name()%></a>
            <a class="btn btn-success my-2 my-sm-0 btn-lg" type="submit" href="/log" style="color: #0d6efd">Log out</a>
            <%
                }else{
            %>
            <a class="btn btn-success my-2 my-sm-0 btn-lg" type="submit" href="/sign" style="color: #0d6efd">Login</a>
            <a class="btn btn-success my-2 my-sm-0 btn-lg" type="submit" href="/registr" style="color: #0d6efd">Registration</a>
            <%
                }
            %>
        </form>
    </div>
</nav>