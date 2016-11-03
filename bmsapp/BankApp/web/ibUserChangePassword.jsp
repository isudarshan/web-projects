<%-- 
    Document   : ibUserChangePassword
    Created on : Apr 23, 2014, 10:15:30 AM
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
                $('#ibuserchangepassword').submit(function() {
                    var accountNumber = $('#accountNumber').val();
                    var oldpswd = $('#oldpswd').val();
                    var newpswd = $('#newpswd').val();
                    var confirmpswd = $('#confirmpswd').val();
                    var status = true;

                    if (accountNumber.length == 0 || userName == null) {
                        $('#accountNumberdiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#accountNumberdiv').removeClass('has-error');
                    }

                    if (oldpswd.length == 0 || oldpswd == null) {
                        $('#oldPassworddiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#oldPassworddiv').removeClass('has-error');
                    }

                    if (newpswd.length == 0 || newpswd == null) {
                        $('#newPassworddiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#newPassworddiv').removeClass('has-error');
                    }

                    if (confirmpswd.length == 0 || confirmpswd == null) {
                        $('#confirmpswddiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#confirmpswddiv').removeClass('has-error');
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
                height:530px;
                width:700px;
                left:250px;
                background-color: #d0e9c6;
            }
            #header{
                background-color:  #e1edf7;
            }

        </style>

        <title>Ib User Change Password</title>
    </head>
    <%@include file="logoutButton.jsp"%>
    <body>

        <div class="container">
            <div class="well well-sm" id="well">
                <div class="panel panel-heading" id="header"><h3 align="center">IB User Change Password</h3></div>
                <div class="panel panel-body">
                    <form id="ibuserchangepassword" method="POST" action="${pageContext.request.contextPath}/ibchangepassword">

                        <div class="form-group"id="accountNumberdiv">
                            <label>User ID</label>
                            <% if (session.getAttribute("user") != null) {
                                    Long userId = (Long) (session.getAttribute("user"));

                            %>


                            <input type="number" name="accountNumber" readonly="readonly" value="<%= userId%>"class="form-control" id="accountNumber"/>
                        </div>
                        <%}%>

                        <div class="form-group"id="oldPassworddiv">
                            <label>Old Password</label>
                            <input type="password" name="oldpswd" class="form-control" id="oldpswd"/>
                        </div>

                        <div class="form-group"id="newPassworddiv">
                            <label>New Password</label>
                            <input type="password" name="newpswd" class="form-control" id="newpswd"/>
                        </div>

                        <div class="form-group"id="confirmpswddiv">
                            <label>Confirm Password</label>
                            <input type="password" name="confirmpswd" class="form-control" id="confirmpswd"/>
                        </div>
                        <div class="form-group">
                            <input type="submit" class='btn btn-success' value="Submit" id="submit"/>
                            <input type="reset"  class="btn btn-danger" value="Reset" id="reset"/>
                        </div>

                    </form>
                    <%
                        if (request.getAttribute("msg") != null) {

                    %>
                    <h6><%=request.getAttribute("msg")%></h6>
                    <h6>Please Logout & Login for <strong><a href="index.html" class="text-info">Changes To effect</a></strong></h6>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
