<%@ page import="DB.news" %>
<%@ page import="DB.comment" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/helper/css/bootstrap.css">
    <script type="text/javascript"  src="/helper/js/bootstrap.bundle.js"></script>
</head>
<body >
<%@ include file="Head.jsp" %>

<%
    Map<Long,ArrayList<comment>> comments=(Map<Long,ArrayList<comment>>)request.getAttribute("comments");
    ArrayList<news>news=(ArrayList<DB.news>) request.getAttribute("news");
    if(news!=null){
        for(int i=0;i<news.size();i++){
%>
<!--Section: Newsfeed-->
<%
    if(user!=null&&user.getRole_id()==1){

%>
<section style="margin: 0 auto;width: max-content;margin-top: 35px">
    <div class="card" style="width: 700px">
        <div class="card-body">
            <form method="post">
            <!-- Data -->
            <div class=" mb-3">
                <div>
                    <a href="" class="text-dark mb-0">
                        <input value="<%=news.get(i).getTitle()%>" type="text" name="title" id="form1Example1" class="form-control" style="margin-bottom: 20px"/>
                    </a>
                </div>
            </div>
            <!-- Description -->
            <div>
                <textarea  name="content" class="form-control" id="exampleFormControlTextarea1" rows="3" style="margin-bottom: 20px"><%=news.get(i).getContent()%></textarea>
            </div>
            <div class="d-flex justify-content-between text-center border-top border-bottom mb-4">
                <button formaction="/delete?id=<%=news.get(i).getId()%>"  class="btn btn-link btn-lg" data-mdb-ripple-color="dark">
                    <i class="fas fa-thumbs-up me-2"></i>delete
                </button>
                <button formaction="/change?id=<%=news.get(i).getId()%>"  class="btn btn-link btn-lg" data-mdb-ripple-color="dark">
                    <i class="fas fa-comment-alt me-2"></i>change
                </button>
            </div>
        </form>
        </div>
        <!-- Media -->
        <!-- Media -->
        <!-- Interactions -->
        <div class="card-body">
            <!-- Reactions -->
            <div class="d-flex justify-content-between mb-3">
                <div>
                    <a href="" class="text-muted"><%=news.get(i).getPost_date()%></a>
                </div>
            </div>
            <!-- Reactions -->

            <!-- Buttons -->

            <!-- Buttons -->

            <!-- Comments -->

            <!-- Input -->
            <div class="d-flex mb-3">
                <div class="form-outline w-100">
                    <form action="add-comment" method="post">
                        <textarea name="comment" class="form-control" id="textAreaExample" rows="2"></textarea>
                        <%
                            if(user!=null){
                        %>
                        <button value="<%=news.get(i).getId()%>" name="news_id"
                                type="submit" class="btn btn-primary mb-2"
                                style="margin-top: 25px">Add comment</button>
                        <%
                            }
                        %>
                    </form>
                </div>
            </div>
            <!-- Input -->

            <!-- Answers -->

            <!-- Single answer -->
            <%
                for(int j=0;j<comments.get(news.get(i).getId()).size();j++){
            %>
            <div class="d-flex mb-3">
                <div>
                    <div class="bg-light rounded-3 px-3 py-1">
                        <a href="" class="text-dark mb-0">
                            <strong><%=comments.get(news.get(i).getId()).get(j).getUser().getFull_name()%></strong>
                        </a>
                        <a href="" class="text-muted d-block">
                            <small><%=comments.get(news.get(i).getId()).get(j).getComment()%></small>
                        </a>
                    </div>
                    <a href="" class="text-muted small ms-3 me-2"><strong>Like</strong></a>
                    <a href="" class="text-muted small me-2"><strong>Reply</strong></a>
                </div>
            </div>
            <%
                }
            %>

            <!-- Answers -->

            <!-- Comments -->
        </div>
        <!-- Interactions -->
    </div>
</section>
<%
    }else{
%>
<section style="margin: 0 auto;width: max-content;margin-top: 35px">
    <div class="card" style="width: 700px">
        <div class="card-body">
            <!-- Data -->
            <div class=" mb-3">
                <div>
                    <a href="" class="text-dark mb-0">
                        <h4><%=news.get(i).getTitle()%></h4>
                    </a>
                </div>
            </div>
            <!-- Description -->
            <div>
                <p>
                    <%=news.get(i).getContent()%>
                </p>
            </div>
        </div>
        <!-- Media -->
        <!-- Media -->
        <!-- Interactions -->
        <div class="card-body">
            <!-- Reactions -->
            <div class="d-flex justify-content-between mb-3">
                <div>
                    <a href="" class="text-muted"><%=news.get(i).getPost_date()%></a>
                </div>
            </div>
            <!-- Reactions -->

            <!-- Buttons -->

            <!-- Buttons -->

            <!-- Comments -->

            <!-- Input -->
            <div class="d-flex mb-3">
                <div class="form-outline w-100">
                    <form action="add-comment" method="post">
                        <textarea name="comment" class="form-control" id="textAreaExample" rows="2"></textarea>
                        <%
                            if(user!=null){
                        %>
                        <button value="<%=news.get(i).getId()%>" name="news_id"
                                type="submit" class="btn btn-primary mb-2"
                                style="margin-top: 25px">Add comment</button>
                        <%
                            }
                        %>
                    </form>
                </div>
            </div>
            <!-- Input -->

            <!-- Answers -->

            <!-- Single answer -->
            <%
                for(int j=0;j<comments.get(news.get(i).getId()).size();j++){
            %>
            <div class="d-flex mb-3">
                <div>
                    <div class="bg-light rounded-3 px-3 py-1">
                        <a href="" class="text-dark mb-0">
                            <strong><%=comments.get(news.get(i).getId()).get(j).getUser().getFull_name()%></strong>
                        </a>
                        <a href="" class="text-muted d-block">
                            <small><%=comments.get(news.get(i).getId()).get(j).getComment()%></small>
                        </a>
                    </div>
                    <a href="" class="text-muted small ms-3 me-2"><strong>Like</strong></a>
                    <a href="" class="text-muted small me-2"><strong>Reply</strong></a>
                </div>
            </div>
            <%
                }
            %>

            <!-- Answers -->

            <!-- Comments -->
        </div>
        <!-- Interactions -->
    </div>
</section>
<%
            }
        }
    }
%>
<!--Section: Newsfeed-->
</body>
</html>
