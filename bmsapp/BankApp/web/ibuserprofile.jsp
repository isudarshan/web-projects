<%-- 
    Document   : ibuserprofile
    Created on : 22 Apr, 2014, 4:33:57 PM
    Author     : cmc11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript">

            $(document).ready(function() {

                $('#ibuserprofile').submit(function() {
                    var status = true;

                    var firstName = $('#firstName').val();
                    var lastName = $('#lastName').val();
                    var mobilenumber = $('#mobilenumber').val();
                    var email = $('#email').val();
                    var picture = $('#picture').val();
                    var signature = $('#signature').val();
                    var accountType = $('#accountType').val();
                    var minimumbalance = $('#minimumbalance').val();
                    var addressId = $('#addressId').val();
                    var doorNo = $('#doorNo').val();
                    var streatName = $('#streatName').val();
                    var city = $('#city').val();
                    var country = $('#country').val();
                    var district = $('#district').val();
                    var state = $('#state').val();
                    var pincode = $('#pincode').val();


                    if (firstName.length == 0 || firstName == null) {
                        $('#firstNameDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#firstNameDiv').removeClass('has-error');
                    }



                    if (lastName.length == 0 || lastName == null) {
                        $('#lastNameDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#lastNameDiv').removeClass('has-error');
                    }

                    if (mobilenumber.length == 0 || mobilenumber == null) {
                        $('#mobilenumberDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#mobilenumberDiv').removeClass('has-error');
                    }

                    if (email.length == 0 || email == null) {
                        $('#emailDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#emailDiv').removeClass('has-error');
                    }


                    if (picture.length == 0 || picture == null) {
                        $('#pictureDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#pictureDiv').removeClass('has-error');
                    }

                    if (signature.length == 0 || signature == null) {
                        $('#signatureDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#signatureDiv').removeClass('has-error');
                    }

                    if (accountType.length == 0 || accountType == null) {
                        $('#accountDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#accountDiv').removeClass('has-error');
                    }

                    if (minimumbalance.length == 0 || minimumbalance == null) {
                        $('#minimumbalanceDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#minimumbalanceDiv').removeClass('has-error');
                    }


                    if (addressId.length == 0 || addressId == null) {
                        $('#addressIdDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#addressIdDiv').removeClass('has-error');
                    }


                    if (addressId.length == 0 || addressId == null) {
                        $('#addressIdDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#addressIdDiv').removeClass('has-error');
                    }

                    if (doorNo.length == 0 || doorNo == null) {
                        $('#doorNoDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#doorNoDiv').removeClass('has-error');
                    }


                    if (streatName.length == 0 || streatName == null) {
                        $('#streatNameDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#streatNameDiv').removeClass('has-error');
                    }

                    if (city.length == 0 || city == null) {
                        $('#cityDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#cityDiv').removeClass('has-error');
                    }

                    if (country.length == 0 || country == null) {
                        $('#countryDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#countryDiv').removeClass('has-error');
                    }


                    if (district.length == 0 || district == null) {
                        $('#districtDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#districtDiv').removeClass('has-error');
                    }

                    if (state.length == 0 || state == null) {
                        $('#stateDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#stateDiv').removeClass('has-error');
                    }

                    if (pincode.length == 0 || pincode == null) {
                        $('#pincodeDiv').addClass('has-error');
                        status = false;

                    } else {
                        $('#pincodeDiv').removeClass('has-error');
                    }


                    if (status == false) {
                        return false;
                    }


                });
            });



        </script>
        <style type="text/css">

            #childDiv{
                position:relative;
                left:1130px;
                width:50px;
                height:50px;
                top:-50px;
                z-index: 0;
            }

            #parentDiv{
                position:absolute;
                left:1000px;
                width:300px;
                height:200px;
                top:110px;
                border:1px solid white;
                background-color: white;
                z-index: 1000;
                display:none;
            }

            #userImage{
                position:relative;
                left:-5px;
                width:100px;
                height:100px;
                top:5px;
            }
            #buttonUpdate{
                position:relative;
                left:130px;
                width:80px;
                height:10px;
                top:-100px;
            } 
            #buttonProfile{
                position:relative;
                left:130px;
                width:80px;
                height:10px;
                top:-60px;
            } 
            #changePswd{
                position:relative;
                left:130px;
                width:80px;
                height:10px;
                top:-20px;
            } 

            #buttonLogout{
                position:relative;
                left:20px;
                width:80px;
                height:10px;
                top:-8px;
            } 

        </style>
        <title>ibuserprofile</title>
    </head>
    <%@include file="logoutButton.jsp"%>
    <body>
        <div class="well well-lg" id='body'>

            <div class="panel panel-primary">

                <div class="panel panel-heading"><h2 align='center'>IB User Profile</h2><div id='childDiv'><img alt=" " src="images/Koala.jpg" width="50" height="50" class="img img-circle"> </div>
                    <div id="parentDiv" class="well"> 
                        <div id="userImage">
                            <img alt=" " src="images/Koala.jpg" width="100" height="100" class="img img-rounded">  
                            <div id="buttonUpdate">
                                <a href="#" class="btn btn-success">Update</a>
                            </div>
                            <div id="buttonProfile">
                                <a href="userhomepage.jsp" class="btn btn-primary">View Balance</a>
                            </div>
                            <div id="changePswd">
                                <a href="ibUserChangePassword.jsp" class="btn btn-warning">Change Password</a>
                            </div>
                            <div id="buttonLogout">
                                <a href="#" class="btn btn-danger">Logout</a>
                            </div>

                        </div>


                    </div>
                </div>

                <div class="panel panel-body">

                    <form method="post" id="ibuserprofile" action="${pageContext.request.contextPath}/ibuserprofile" enctype="multipart/form-data"/>

                    <div class="form-group" id="firstNameDiv">
                        <label>First Name</label>
                        <input type="text" name="firstName" class="form-control" id="firstName">
                    </div>

                    <div class="form-group" id="lastNameDiv">
                        <label>Last Name</label>
                        <input type="text" name="lastName" class="form-control" id="lastName">
                    </div>

                    <div class="form-group" id="mobilenumberDiv">
                        <label>Mobile Number</label>
                        <input type="number" name="mobilenumber" class="form-control"id="mobilenumber">
                    </div>

                    <div class="form-group"id="emailDiv">
                        <label>Email</label>
                        <input type="email" name="email" class="form-control"id="email">
                    </div>

                    <div class="form-group"id="pictureDiv">
                        <label>Picture</label>
                        <input type="file" name="picture" class="form-control"id="picture">
                    </div>

                    <div class="form-group"id="signatureDiv">
                        <label>Signature</label>
                        <input type="text" name="sign" class="form-control" id="signature">
                    </div>

                    <div class="form-group"id="accountDiv">
                        <label>Account Type</label>
                        <input type="text" name="accountType" class="form-control" id="accountType">
                    </div>

                    <div class="form-group"id="minimumbalanceDiv">
                        <label>Minimum Balance</label>
                        <input type="number" name="minimumbalance" class="form-control"id="minimumbalance">
                    </div>

                    <div class="form-group"id="addressIdDiv">
                        <label>Address Id</label>
                        <input type="text" name="addressId" class="form-control"id="addressId">
                    </div>

                    <div class="form-group"id="doorNoDiv">
                        <label>Door No</label>
                        <input type="text" name="doorNo" class="form-control"id="doorNo">
                    </div>

                    <div class="form-group" id="streatNameDiv">
                        <label>Street Name</label>
                        <input type="text" name="streatName" class="form-control"id="streatName">
                    </div>

                    <div class="form-group"id="cityDiv">
                        <label>City</label>
                        <input type="text" name="city" class="form-control"id="city">
                    </div>

                    <div class="form-group" id="countryDiv">
                        <label>Country</label>
                        <input type="text" name="country" class="form-control"id="country">
                    </div>

                    <div class="form-group"id="districtDiv">
                        <label>District</label>
                        <input type="text" name="district" class="form-control" id="district">
                    </div>

                    <div class="form-group"id="stateDiv">
                        <label>State</label>
                        <input type="text" name="state" class="form-control"id="state">
                    </div>
                    <div class="form-group"id="pincodeDiv">
                        <label>Pincode</label>
                        <input type="number" name="pincode" class="form-control"id="pincode">
                    </div>
                    <div class="form-group"id="submitDiv">
                        <input type="submit" class="btn btn-success" value="Submit" id="submit"/> 
                        <input type="reset" class="btn btn-danger" value="Reset" id="reset"/> 
                    </div>

                    </form>
                    <div id="parentDiv">
                    </div>
                </div>
            </div>

    </body>
</html>
