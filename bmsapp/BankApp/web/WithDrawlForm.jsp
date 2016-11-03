<%-- 
    Document   : WithDrawlForm
    Created on : 22 Apr, 2014, 5:31:17 PM
    Author     : Lalli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css" >
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>JSP Page</title>
        <script type="text/javascript">
            $(document).ready(function() {
                $('#withdraw').submit(function() {


                    var status = true;

                    var branchname = $('#branchname').val();

                    var date = $('#date').val();

                    var accountnumber = $('#accountnumber').val();

                    var customername = $('#customername').val();

                    var amountrupees = $('#amountrupees').val();
                    var amountwords = $('#amountwords').val();
                    var mobilenumber = $('#mobilenumber').val();
                    var depositorid = $('#depositorid').val();


                    if (branchname.length == 0 || branchname == null || branchname == '') {

                        $('#bDiv').addClass('has-error');
                        status = false;
                        //alert('in branchnam');

                    } else {
                        $('#bDiv').removeClass('has-error');
                    }

                    if (date.length == 0 || date == null) {

                        $('#dateDiv').addClass('has-error');
                        status = false;
                        //alert('in date');
                    } else {
                        $('#dateDiv').removeClass('has-error');
                    }

                    if (accountnumber.length == 0 || accountnumber == null) {
                        $('#accountnumberDiv').addClass('has-error');
                        status = false;
                        //alert('in acctNumber');
                    } else {
                        $('#accountnumberDiv').removeClass('has-error');
                    }

                    if (customername.length == 0 || customername == null) {
                        $('#customernameDiv').addClass('has-error');
                        status = false;
                        //alert('in custoname');
                    } else {
                        $('#customernameDiv').removeClass('has-error');
                    }

                    if (amountrupees.length == 0 || amountrupees == null) {
                        $('#amountrupeesDiv').addClass('has-error');
                        status = false;
                        //alert('in amtrupeess');
                    } else {
                        $('#amountrupeesDiv').removeClass('has-error');
                    }

                    if (amountwords.length == 0 || amountwords == null) {
                        $('#amountwordsDiv').addClass('has-error');
                        status = false;
                        //alert('in amntwrdswDiv');
                    } else {
                        $('#amountwordsDiv').removeClass('has-error');
                    }

                    if (mobilenumber.length == 0 || mobilenumber == null) {
                        $('#mobilenumberDiv').addClass('has-error');
                        status = false;
                        //alert('in MobileNumberDiv');
                    } else {
                        $('#mobilenumberDiv').removeClass('has-error');
                    }

                    if (depositorid.length == 0 || depositorid == null) {
                        $('#depositoridDiv').addClass('has-error');
                        status = false;
                        //alert('in depositoridDiv');
                    } else {
                        $('#depositoridDiv').removeClass('has-error');
                    }

                    if (status == false) {
                        return false;
                    }


                });


            });


        </script>
        <style type="text/css">

            #small{

                background-color: #428bca;

            }
            #form{

                background-color: #afd9ee;

            }

        </style>
    </head>
    <%@include file="logoutButton.jsp"%>
    <body>
        <div class="container">
            <div class="well well-sm" id="small" >
                <div class="panel panel-primary">
                    <c:if test="${empty BankUser}">
                        <c:redirect url="index.html"/>

                    </c:if>
                    <div class="panel panel-heading"><h3 align="center"> WITHDRAWL FORM</h3></div>
                    <div class="panel panel-body" id="form">
                        <form class="form-group" method="POST" id="withdraw" action="${pageContext.request.contextPath}/withdraw"> 

                            <%
                                if (request.getAttribute("msg") != null) {


                            %>
                            <h4 align='center' class='text-success'><b><%=(request.getAttribute("msg"))%></b></h4>
                                    <% }%>
                            <table class="table table-bordered table-responsive table-condensed"  name="table1">

                                <tr>


                                    <td><label>Branch Name</label></td>
                                    <td id="bDiv"><input type="text" class="form-control" name="branchName" id="branchname"></td>



                                    <td><label>Date</label></td>

                                    <td id="dateDiv"><input type="text" class="form-control" name="date" id="date"></td>

                                </tr>

                                <tr>

                                    <td><label>Account ID</label></td>
                                    <td id="accountnumberDiv"><input type="number" class="form-control" name="accountNumber" id="accountnumber"></td>

                                </tr>
                                <tr>

                                    <td><label>Customer Name</label></td>
                                    <td id="customernameDiv"><input type="text" class="form-control" name="customerName" id="customername"></td>

                                </tr>
                            </table>


                            <table class="table table-bordered table-hover " name="table3">
                                <tr>

                                    <td><label>Amount in Rupees</label></td>
                                    <td id="amountrupeesDiv"><input type="number" class="form-control" name="amount" id="amountrupees"/></td>

                                </tr>  
                                <tr>

                                    <td><label>Amount in Words</label></td>
                                    <td id="amountwordsDiv"><input type="text" class="form-control" name="amt" id="amountwords"/></td>

                                </tr> 
                                <tr>

                                    <td><label>Mobile Number</label></td>
                                    <td id="mobilenumberDiv"><input type="number" class="form-control" name="mobileNumber" id="mobilenumber"/></td>

                                </tr>        
                                <tr>

                                    <td><label>Signature</label></td>
                                    <td id="depositoridDiv"><input type="file" class="form-control" name="depositorId" id="depositorid"/></td>

                                </tr>     
                            </table> 
                            <div class="form-group">
                                <input data-loading-text="please Wait" type="submit" class="btn btn-success" value="Submit"/> 
                                <input type="reset"  align="center"class="btn btn-danger" value="Reset"/> 
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
