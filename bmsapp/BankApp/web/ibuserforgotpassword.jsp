<%-- 
    Document   : ibuserforgotpassword
    Created on : 20 Apr, 2014, 3:48:20 PM
    Author     : cmc5
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
                $('#passwordForm').submit(function() {
                    var accountNumber = $('#accountNumber').val();
                    var email = $('#email').val();
                    var securityQuestion = $('#secQuestion').val();
                    var answer = $('#answer').val();
                    var status = true;

                    if (accountNumber.length == 0 || accountNumber == null) {
                        $('#accountNumberDiv').addClass('has-error');
                        status = false;
                    }
                    else {
                        $('#accountNumberDiv').removeClass('has-error');
                    }

                    if (email.length == 0 || email == null) {
                        $('#emailDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#emailDiv').removeClass('has-error');
                    }

                    if (securityQuestion.length == 0 || securityQuestion == null || securityQuestion == 'select') {
                        $('#secQuestionDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#secQuestionDiv').removeClass('has-error');
                    }

                    if (answer.length == 0 || answer == null) {
                        $('#answerDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#answerDiv').removeClass('has-error');
                    }

                    if (status == false) {
                        return false;
                    }
                });
            });
        </script>
        <style type="text/css">

            #clerkcreationDiv {
                background-color: #428BCA;

            }

        </style>

    </head>
    <%@include file="logoutButton.jsp"%>
    <body>
        <div class="container">
            <div class="jumbotron" id="clerkcreationDiv">
                <h2 align="center" class='bg-primary'>Forgot Password</h2>
            </div>

            <div class="well well-lg">

                <div class="panel panel-primary">

                    <div class="panel panel-heading">Password Details</div>

                    <div class="panel panel-body">
                        <form method="post" action="${pageContext.request.contextPath}/forgotPassword" id="passwordForm">


                            <div class="form-group" id="accountNumberDiv">
                                <label>Account ID</label>
                                <input type="text" name="accountNumber" class="form-control" id="accountNumber"/>

                            </div>
                            <div class="form-group" id="emailDiv">
                                <label>Email</label>
                                <input type="email" name="email" class="form-control" id="email" />
                            </div>

                            <div class="form-group" id="secQuestionDiv">
                                <label>Security Question</label>
                                <select class="form-control" name="secQuestion" id="secQuestion" >

                                    <option>select</option>
                                    <option>What is your birth place</option>
                                    <option>What is your nickname </option>
                                    <option>Who is your favourite classTeacher</option>
                                    <option>What is your close Friend's name</option>
                                </select>
                            </div>


                            <div class="form-group" id="answerDiv">
                                <label>Answer</label>
                                <input type="text" name="email" class="form-control" id="answer" />
                            </div>



                            <div class="form-group">
                                <input type="submit" class='btn btn-success' value="Submit"/>
                                <input type="reset"  class="btn btn-danger" value="Reset"/>
                            </div>
                        </form> 

                        <% if (request.getAttribute("msg") != null) {


                        %>
                            <h6><%=(request.getAttribute("msg"))%></h6>
                            <% }
                            %>


                    </div>
                </div>
            </div>
        </div>


    </body>
</html>

