<%--
  Created by IntelliJ IDEA.
  User: zhanibekovdamir
  Date: 02.06.2023
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/helper/css/bootstrap.css">
    <script type="text/javascript"  src="/helper/js/bootstrap.bundle.js"></script>
</head>
<body>
<%@ include file="Head.jsp" %>
<section class="vh-100" >
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-xl-9">

                <h1 class="text-white mb-4" style="color: black">Registration</h1>

                <div class="card" style="border-radius: 15px;">
                    <div class="card-body">
                        <form action="/registr" method="POST">

                            <div class="row align-items-center pt-4 pb-3">
                                <div class="col-md-3 ps-5">

                                    <h6 class="mb-0">Full name </h6>

                                </div>
                                <div class="col-md-9 pe-5">

                                    <input type="text" name="name"  class="form-control" style="margin-bottom: 20px"/>


                                </div>
                            </div>

                            <hr class="mx-n3">
                            <div class="row align-items-center py-3">
                                <div class="col-md-3 ps-5">

                                    <h6 class="mb-0">Email address</h6>

                                </div>
                                <div class="col-md-9 pe-5">

                                    <input type="email" name="email"  class="form-control" style="margin-bottom: 20px"/>


                                </div>
                            </div>

                            <hr class="mx-n3">
                            <div class="row align-items-center py-3">
                                <div class="col-md-3 ps-5">

                                    <h6 class="mb-0">Password</h6>

                                </div>
                                <div class="col-md-9 pe-5">

                                    <input type="password" name="password"  class="form-control" style="margin-bottom: 20px"/>


                                </div>
                            </div>


                            <div class="px-5 py-4">
                                <button type="submit" class="btn btn-primary btn-lg">Send application</button>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</section>
</body>
</html>
