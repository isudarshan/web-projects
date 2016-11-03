

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('#loginForm').submit(function() {
                    var status = true;
                    var userName = $('#userName').val();
                    if (userName.length == 0 || userName == null) {
                        $('#userNameDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#userNameDiv').removeClass('has-error');
                    }
                    var accountNumber = $('#accountNumber').val();
                    if (accountNumber.length == 0 || accountNumber == null) {
                        $('#AccNoDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#AccNoDiv').removeClass('has-error');
                    }
                    var verificationCode = $('#verificationCode').val();
                    if (verificationCode.length == 0 || verificationCode == null) {
                        $('#verificationCodeDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#verificationCodeDiv').removeClass('has-error');
                    }
                    var password = $('#password').val();
                    if (password.length == 0 || password == null) {
                        $('#passwardDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#passwardDiv').removeClass('has-error');
                    }
                    if (status == false) {
                        return false;
                    }
                });
            });
        </script>
        <style type="text/css">
            #Design{
                position: relative;
                width: 400px;
                left: 470px;
            }
            body{
                background-color: bisque;
            } 
        </style>
        <title>Login Form</title>
    </head>
    <body>
        <h1 align='center'>LOGIN FORM</h1>
        <br/>

        <div class ="form-group">
            <div class ="well  well-lg" id="Design" >
                <form method="post" id="loginForm" action="${pageContext.request.contextPath}/login">
                    <div class ="form-group" id="userNameDiv">
                        <label class="control-label" align ="center">User Id</label>
                        <input type="text" name="userName" class ="form-control" id="userName"/>
                    </div>

                    <div class ="form-group" id="AccNoDiv">
                        <label class="control-label" align ="center">Account Id</label>
                        <input type="text" name="accountNumber" class ="form-control" id="accountNumber" />
                    </div>

                    <div class ="form-group" id="verificationCodeDiv">
                        <label class="control-label" align ="center">Verification Code </label>
                        <input type="text" name="verificationCode" class ="form-control" id="verificationCode"/>
                    </div>

                    <div class ="form-group" id="passwardDiv">
                        <label class="control-label" align ="center">Password</label>
                        <input type="password" name="password" class ="form-control" id="password"/>
                    </div>

                    <div class ="form-group">
                        <input type="submit" class="btn btn-success" value="Submit" id="submit"/>
                        <input type="reset" class="btn btn-danger" value="Reset" id="reset"/> </div>
                </form>

            </div>

        </div>





    </body>
</html>


