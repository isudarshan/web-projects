<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css" >
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('#adminclerkform').submit(function() {
                    var userName = $('#userName').val();
                    var password = $('#password').val();
                    var status = true;

                    if (userName.length == 0 || userName == null) {
                        $('#userNamediv').addClass('has-error');
                        status = false;
                    } else {
                        $('#userNamediv').removeClass('has-error');
                    }
                    if (password.length == 0 || password == null) {
                        $('#passworddiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#passworddiv').removeClass('has-error');
                    }
                    if (status == false) {
                        return false;
                    }

                });

            });



        </script>
        <style type="text/css">


            #well{
                position:relative;
                top:60px;
                height:370px;
                width:700px;
                left:250px;
                background-color: #ebccd1
            }
            #header{
                background-color:  antiquewhite;
            }

        </style>

        <title>Admin Clerk Login</title>
    </head>
    <body>
    

    <div class="container">
        <div class="well well-sm" id="well">
            <div class="panel panel-heading" id="header"><h3 align="center">LOGIN FORM</h3></div>
            <div class="panel panel-body">
                <form method="POST" id="adminclerkform" action="${pageContext.request.contextPath}/adcllogin">

                    <div class="form-group"id="userNamediv">
                        <label>User Id</label>
                        <input type="number" name="userId" class="form-control" id="userName"/>

                    </div>

                    <div class="form-group" id="passworddiv">
                        <label>Password</label>
                        <input type="password" name="password" class="form-control" id="password"/>

                    </div>

                    <div class="form-group">
                        <input type="submit" class='btn btn-success' value="Submit" id="submit"/>
                        <input type="reset"  class="btn btn-danger" value="Reset" id="reset"/>
                    </div>
                    <%
                        if (request.getAttribute("UserError") != null) {
                    %>
                    <h6><font color="red"><%=(request.getAttribute("UserError"))%></font></h6>
                        <%
                            }
                        %>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
