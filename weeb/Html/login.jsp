
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/helper/css/bootstrap.css">
    <script type="text/javascript"  src="/helper/js/bootstrap.bundle.js"></script>
</head>
<body>
<%@ include file="Head.jsp" %>
<section class="vh-80" >
    <div class="container py-5 h-80">
        <div class="row d-flex justify-content-center align-items-center h-80">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card shadow-2-strong" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">
                        <h3 class="mb-5">Sign in</h3>
                        <form action="/sign" method="post">

                            <div class="form-outline mb-4">
                                <label class="form-label" for="typeEmailX-2">Email</label>
                                <input type="text" name="email" id="form1Example1" class="form-control" style="margin-bottom: 20px"/>
                            </div>

                            <div class="form-outline mb-4">
                                <label class="form-label" for="typePasswordX-2">Password</label>
                                <input type="password" name="password" id="form1Example1" class="form-control" style="margin-bottom: 20px"/>
                            </div>

                            <!-- Checkbox -->
                            <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>

                            <hr class="my-4">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
