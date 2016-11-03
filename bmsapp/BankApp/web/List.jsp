<%-- 
    Document   : List
    Created on : 22 Apr, 2014, 3:00:36 PM
    Author     : cmc11
--%>

<%@page import="java.util.List"%>
<%@page import="org.bankapp.domain.Customer"%>
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
                left:320px;
                width:800px;
            }
        </style>

        <title>List</title>
    </head>
    
    <%@include file="logoutButton.jsp"%>
    <body>
        
        
    <c:if test="${empty BankUser}">
        <c:redirect url="index.html"/>
    </c:if>


    <div class="well well-sm" id="body">

        <div class="panel panel-primary">

            <div class="panel panel-heading"><h2 align="center">List</h2></div>


            <div class="panel panel-body">

                <form>

                    <label>List</label>
                    <select class="form-control">
                        <option>All</option>
                        <option>Clerk</option>
                        <option>User</option>
                    </select>


                    <%
                        List<Customer> list = (List) request.getAttribute("List");

                        if (list.isEmpty()) {

                    %>
                    <h3 class="text-warning">No Records Available</h3>
                    <%                                    } else {%>

                    <table class="table table-bordered">

                        <tr>
                            <th></th>
                            <th>ID</th>
                            <th>Name</th>
                            <th >Role</th>
                            <th></th>
                            <th></th>
                        </tr>

                        <%    for (Customer c : list) {
                        %>
                        <tr>
                            <td><input type="checkbox"/>
                            <td><%= c.getAccountId().getAccountId()%></td>
                            <td><%=c.getDetaildId().getFirstName()%></td>
                            <td><%=c.getUserId().getRole()%></td>
                            <td><a href="#">Edit</a></td>
                            <td><a href="#">Delete</a></td>
                        </tr>

                        <%                                        }
                            }

                        %>




                    </table>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
