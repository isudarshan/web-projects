<%-- 
    Document   : cheque
    Created on : Apr 20, 2014, 5:51:08 PM
    Author     : user
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript"></script>



        <style type="text/css">

            body{
                background-color: bisque;
            } 

        </style>

        <title>Cheque</title>
    </head>
    <%@include file="logoutButton.jsp"%>
    <body>
        <div class="container">

            <div class="well well-sm">

                <div class="panel panel-primary">
                    <c:if test="${empty BankUser}">
                        <c:redirect url="bankLogin.jsp"/>

                    </c:if>
                    <div class="panel panel-heading"><h2 align="center">Cheque Book Status online</h2></div>

                    <div class="panel panel-body">
                        <%
                            if (request.getAttribute("Status") != null) {
                                String status = (String) request.getAttribute("Status");
                                if (status.equalsIgnoreCase("Transaction Success")) {

                        %>
                        <h4 class="text-success"><%=status%></h4> 
                        <%  } else {

                        %>
                        <h4 class="text-danger"><%=status%></h4>
                        <%                                }
                            }
                        %>
                        <form class="form-group" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/cheque">

                            <div class="form-group" id="date">
                                <label class="control-label">Date</label>
                                <input type="text" placeholder="YYYY-MM-DD" class="form-control" name="date" id="dateOfBirth" />

                            </div>

                            <div class="form-group" id="branch">
                                <label>Branch Name</label>
                                <input type="text" name="branchName" class="form-control"/>
                            </div>   

                            <div class="form-group">
                                <label>Pay At</label>
                                <input type="text" name="payAt" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label>Account ID</label>
                                <input type="text" name="accountnumber" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label>User Name</label>
                                <input type="text" name="accountname" class="form-control"/>
                            </div>



                            <div class="form-group">
                                <label>Amount in Rupees</label>
                                <input type="text" name="amountrupees" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label>Amount in Words</label>
                                <input type="text" name="amountwords" class="form-control"/>
                            </div> 

                            <div class="form-group">
                                <label>Transaction Mode</label>

                                <select class="form-control" name="Transaction" id="transaction" >
                                    <option>Select Your Transaction</option>
                                    <option>Withdrawal</option>
                                    <option>Deposit</option>



                                </select>
                            </div> 


                            <div class="form-group">
                                <label>Signature</label>
                                <input type="file" name="sign" class="form-control"/>
                            </div> 
                            <div class ="form-group">
                                <input type="submit" class="btn btn-success" value="Submit" />
                                <input type="reset" class="btn btn-danger" value="Reset"/> </div>



                        </form>



                    </div>


                </div>
            </div>
    </body>
</html>
