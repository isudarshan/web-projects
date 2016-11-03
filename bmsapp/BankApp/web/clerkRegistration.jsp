<%-- 
    Document   : clerkRegistration
    Created on : Apr 18, 2014, 7:02:41 PM
    Author     : cmc
--%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('#clerkForm').submit(function() {

                    if (accountType.length == 0 || accountType == null || accountType == 'Select Your Account type') {
                        $('#accountDiv').addClass('has-error');
                        $('#mbDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#accountDiv').removeClass('has-error');
                        $('#mbDiv').removeClass('has-error');
                    }

                    var firstName = $('#firstName').val();
                    var status = true;
                    if (firstName.length == 0 || firstName == null) {
                        $('#firstNameDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#firstNameDiv').removeClass('has-error');
                    }

                    var lastName = $('#lastName').val();
                    if (lastName.length == 0 || lastName == null) {
                        $('#lastNameDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#lastNameDiv').removeClass('has-error');
                    }

                    var parentName = $('#parentName').val();
                    if (parentName.length == 0 || parentName == null) {
                        $('#parentNameDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#parentNameDiv').removeClass('has-error');
                    }

                    var dateOfBirth = $('#dateOfBirth').val();
                    alert(dateOfBirth);
                    if (dateOfBirth.length == 0 || dateOfBirth == null) {
                        $('#dateOfBirthDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#dateOfBirthDiv').removeClass('has-error');
                    }

                    var email = $('#email').val();
                    if (email.length == 0 || email == null) {
                        $('#emailDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#emailDiv').removeClass('has-error');
                    }

                    var phNo = $('#phNo').val();
                    if (phNo.length == 0 || phNo == null) {
                        $('#phNoDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#phNoDiv').removeClass('has-error');
                    }

                    var SecurityQuestion = $('#SecurityQuestion').val();
                    if (SecurityQuestion.length == 0 || SecurityQuestion == null || SecurityQuestion == 'Select Your Option') {
                        $('#SecurityQuestionDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#SecurityQuestionDiv').removeClass('has-error');
                    }

                    var answer = $('#answer').val();
                    if (answer.length == 0 || answer == null) {
                        $('#answerDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#answerDiv').removeClass('has-error');
                    }

                    if (doorNo.length == 0 || doorNo == null) {
                        $('#doorNoDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#doorNoDiv').removeClass('has-error');
                    }
                    if (streetName.length == 0 || streetName == null) {
                        $('#streetNameDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#streetNameDiv').removeClass('has-error');
                    }

                    if (city.length == 0 || city == null) {
                        $('#cityDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#cityDiv').removeClass('has-error');
                    }

                    if (districtName.length == 0 || districtName == null) {
                        $('#districtNameDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#districtNameDiv').removeClass('has-error');
                    }

                    if (stateName.length == 0 || stateName == null) {
                        $('#stateNameDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#stateNameDiv').removeClass('has-error');
                    }



                    if (country.length == 0 || country == null) {
                        $('#countryDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#countryDiv').removeClass('has-error');
                    }
                    if (pinCode.length == 0 || pinCode == null) {
                        $('#pinCodeDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#pinCodeDiv').removeClass('has-error');
                    }

                    var image = $('#image').val();
                    if (image.length == 0 || image == null) {
                        $('#imageDiv').addClass('has-error');
                        status = false;
                    } else {
                        $('#imageDiv').removeClass('has-error');
                    }
                    if (status == false) {
                        return false;
                    }
                    $('#gender').attr('checked', 'checked');
                });

                $('#dateOfBirth').blur(function() {
                    var past = new Date($('#dateOfBirth').val());
                    var now = new Date();
                    var pastYear = past.getFullYear();
                    var nowYear = now.getFullYear();
                    var age = nowYear - pastYear;
                    $('#age').focus(function() {
                        $('#age').val(age);
                    });

                    $('#account').blur(function() {
                        var accountType = $('#account').val();
                        if (accountType == 'Savings Account') {
                            $('#minimumbalance').val(1000);

                        }

                    });

                });

            });
        </script>

        <style type="text/css">
            #clerkcreationDiv {
                background-color: #428BCA;
            }
        </style>
        <title>APP | CLERK</title>

    </head>
    <%@include file="logoutButton.jsp"%>

    <body>
        <c:if test="${empty BankUser}">
            <c:redirect url="index.html"/>

        </c:if>

        <div class="container">
            <div class="jumbotron" id="clerkcreationDiv">
                <h2 align="center" class="bg-primary"> CLERK CREATION </h2>
            </div>

            <div class="well well-lg">

                <div class="panel panel-primary">

                    <div class="panel panel-heading">Clerk Details</div>

                    <div class="panel panel-body">

                        <%
                            if (request.getAttribute("Msg") != null) {
                        %>
                        <h4 align="center" class="text-success"><b><%=(request.getAttribute("Msg"))%></b></h4>
                                <% }%>

                        <form method="POST" id="clerkForm" enctype="multipart/form-data" action="${pageContext.request.contextPath}/createClerk">




                            <div class="form-group" id="accountDiv">
                                <label class="control-label" >Account Type</label>
                                <select class="form-control" name="AccountType" id="account" >
                                    <option>Savings Account</option>
                                </select>
                            </div>

                            <div class="form-group" id="mbDiv">
                                <label class="control-label">Minimum Balance</label>
                                <input type="text" name="minimumbalance" value="1000" readonly="readonly"class="form-control" id="minimumbalance"/>
                            </div>

                            <div class="form-group" id="firstNameDiv">
                                <label class="control-label">FirstName</label>
                                <input type="text" name="firstName" class="form-control" id="firstName"/>
                            </div>

                            <div class="form-group" id="lastNameDiv">
                                <label class="control-label">LastName</label>
                                <input type="text" name="lastName" class="form-control" id="lastName"/>
                            </div>

                            <div class="form-group" id="parentNameDiv">
                                <label class="control-label">Father/Mother Name</label>
                                <input type="text" name="parentName" class="form-control" id="parentName"/>
                            </div>

                            <div class="form-group" id="designationDiv">
                                <label class="control-label" >Designation</label>
                                <select class="form-control" name="designation" id="designation" >
                                    <option>Select Your Option</option>
                                    <option>Student</option>
                                    <option> Government Employee</option>
                                    <option>PrivateSector Employee</option>
                                    <option>Unemployee</option>
                                    <option>Senior Citizens</option>
                                </select>
                            </div>

                            <div class="form-group" id="dateOfBirthDiv">
                                <label class="control-label">Date Of Birth</label>
                                <input type="text" placeholder="YYYY-MM-DD" class="form-control" id="dateOfBirth" name="dob"/>
                            </div>

                            <div class="form-group" id="ageDiv">
                                <label class="control-label">Age</label>
                                <input type="text" readonly="readonly" class="form-control" id="age" name="age"/>
                            </div>

                            <div class="form-group" id="genderDiv">
                                <label class="control-label" >Gender:</label><br/>
                                &nbsp;&nbsp;&nbsp;<input type="radio" class="radio radio-inline" value="Male" name="gender" id="gender"/>Male
                                <input type="radio" class="radio radio-inline" value="Female" name="gender"/>Female
                            </div>

                            <div class="form-group" id="emailDiv">
                                <label class="control-label">Email</label>
                                <input type="email" name="email" class="form-control" id="email"/>
                            </div>

                            <div class="form-group" id="phNoDiv">
                                <label class="control-label">Phone No</label>
                                <input type="number" name="phNo" class="form-control" id="phNo"/>
                            </div>

                            <div class="form-group" id="SecurityQuestionDiv">
                                <label class="control-label" >Security Question</label>
                                <select class="form-control" id="SecurityQuestion" name="SecurityQuestion" >
                                    <option>Select Your Option</option>
                                    <option>What is nick name?</option>
                                    <option>Your favourite movie?</option>
                                    <option>Your favourite game?</option>
                                    <option>Book you like?</option>
                                    <option>Your habit?</option>
                                </select>                           
                            </div>

                            <div class="form-group" id="answerDiv">
                                <label class="control-label">Answer</label>
                                <input type="text" name="answer" class="form-control" id="answer"/>
                            </div>

                            <div class="form-group" id="doorNoDiv">
                                <label class="control-label">Door No</label>
                                <input type="text" name="doorNo" class="form-control" id="doorNo"/>
                            </div>

                            <div class="form-group" id="streetNameDiv">
                                <label class="control-label">Street Name</label>
                                <input type="text" name="streetName" class="form-control" id="streetName"/>
                            </div>

                            <div class="form-group" id="cityDiv">
                                <label class="control-label">City</label>
                                <input type="text" name="city" class="form-control" id="city"/>
                            </div>

                            <div class="form-group" id="districtNameDiv">
                                <label class="control-label">District Name</label>
                                <input type="text" name="districtName" class="form-control" id="districtName"/>
                            </div> 


                            <div class="form-group" id="stateNameDiv">
                                <label class="control-label">State Name</label>
                                <input type="text" name="stateName" class="form-control" id="stateName"/>
                            </div>    

                            <div class="form-group" id="countryDiv">
                                <label class="control-label">Country</label>
                                <input type="text" name="country" class="form-control" id="country"/>
                            </div>

                            <div class="form-group" id="pinCodeDiv">
                                <label class="control-label">Pin code</label>
                                <input type="text" name="pincode" class="form-control" id="pinCode"/>
                            </div>


                            <div class="form-group" id="formDiv">
                                <label class="control-label">Role</label>
                                <input type="text" name="role" class="form-control" id="formText" readonly="readonly" value="Clerk"/>
                            </div>

                            <br>

                            <div class="form-group" id="imageDiv">
                                <label class="control-label">Upload Image</label>
                                <input type="file" class="form-control" id="image" name="profilePicture"/> 
                            </div>

                            <div class="form-group" id="imageDiv">
                                <label class="control-label">Upload Signature</label>
                                <input type="file" class="form-control" id="signature" name="signature"/> 
                            </div>

                            <div class="form-group" id="doccumentDiv">
                                <label>Upload Documents</label>
                                <input type="file" name="document" class="form-control" id="document"/> 
                            </div>

                            <br>

                            <div class="form-group">
                                <input type="submit" class="btn btn-success" value="Submit" id="submit"/> 
                                <input type="reset" class="btn btn-warning" value="Reset" id="reset"/> 
                            </div>

                        </form>

                    </div>
                </div>
            </div>
        </div>
    </body>  
</html>

