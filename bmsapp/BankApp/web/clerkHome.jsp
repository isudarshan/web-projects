<%-- 
    Document   : clerkHome
    Created on : 23 Apr, 2014, 2:51:37 PM
    Author     : cmc11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <style type="text/css">
            #body{
                position:relative;
                left:220px;
                width:1000px;

            }
            a:hover{
                text-decoration: none;
            }


        </style> 
    </head>
    <%@include file="logoutButton.jsp"%>
    <body>
        <div class="well well-sm" id="body">
            <c:if test="${empty BankUser}">
                <c:redirect url="index.html"/>

            </c:if>
            <div class="panel panel-primary">

                <div class="panel panel-heading"><h2 align="center">Clerk Home</h2></div>


                <div class="panel panel-body">

                    <table class="table table-striped">

                        <tr>

                            <td><a href="accountcreation.jsp">Add User</a></td>
                            <td><a href="depositform.jsp">Deposit</a></td>
                            <td><a href="WithDrawlForm.jsp">WithDrawl</a></td>
                            <td><a href="${pageContext.request.contextPath}/list">List</a></td>
                            <td><a href="cheque.jsp">Cheque Transactions</a></td>
                            <td><a href="error.jsp">Credit Card</a></td>
                            <td><a href="error.jsp">Debit Card</a></td>
                        </tr> 

                    </table>

                </div>
            </div>
        </div>
    </body>
</html>
