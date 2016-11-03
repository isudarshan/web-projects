<%-- 
    Document   : clerkLogin
    Created on : Apr 23, 2014, 4:57:41 PM
    Author     : cmc9lab2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css" >
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('#clerkLogin').submit(function() {
                    var clerkId = $('#clerkId').val();
                    var password = $('#password').val();
                    var status = true;

                    if (clerkId.length == 0 || clerkId == null) {
                        $('#clerkIdDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#clerkIdDiv').removeClass('has-error');
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
                height:380px;
                width:700px;
                left:320px;
                background-color: #f7e1b5;
            }
            #header{
                background-color:#faf2cc;
            }

        </style>

        <title>Clerk Login Form</title>
    </head>
    <body>
    <body>
        <c:if test="${empty BankUser}">
            <c:redirect url="bankLogin.jsp"/>

        </c:if>
        <div class="well well-sm" id="well">
            <div class="panel panel-heading" id="header"><h3 align="center">Clerk Login Form</h3></div>
            <div class="panel panel-body">
                <form id="clerkLogin" method="POST" action="${pageContext.request.contextPath}/clerkLogin">

                    <div class="form-group" id="clerkIdDiv">
                        <label>Clerk ID</label>
                        <input type="number" name="clerkId" class="form-control" id="clerkId">
                    </div>
                    <div class="form-group" id="passworddiv">
                        <label>Password</label>
                        <input type="password" name="password" class="form-control" id="password">
                    </div>
                    <div class="form-group">
                        <input type="submit" class='btn btn-success' value="Submit" id="submit">
                        <input type="reset"  class="btn btn-danger" value="Reset" id="reset">
                    </div>

                </form>
            </div>
        </div>

    </body>
</html>
