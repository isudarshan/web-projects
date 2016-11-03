

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

        </script>


        <style type="text/css">
            #MyModal{
                position: relative;
                background-color: white;
                width: 300px;


            }

            body{
                background-color: pink;
            } 


            #Registrationdiv {

                height: 21px;
                left: -6px;
                position: relative;
                top: 0px;
                width: 160px;

            }
            #LoginDiv {

                height: 22px;
                left: 202px;
                position: relative;
                top: -21px;
                width: 160px;

            }
            #Design{
                position: relative;
                width: 400px;
                left: 470px;
            }
            body{
                background-color: bisque;
            } 
        </style>
        <title>WELCOME ADMINISTRATOR FORM</title>
    </head>
    <body>
        <c:if test="${empty BankUser}">
            <c:redirect url="index.html"/>
        </c:if>
        <c:if test="${not empty BankUser}">

            <div>

                <h2 align="center">WELCOME <c:out value="${BankUser.role}"/> 
                    <span align="right" class="right close"><a href="LogOutController" class="btn btn-danger">Logout</a></span>
                </h2>

            </div>


        </c:if>


        <br>

        <div class ="form-group">
            <div class ="well  well-lg" id="Design" >
                <form id="loginForm">

                    <div id="Registrationdiv">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle"><font color="blue">CLERK MANAGEMENT</font><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="clerkRegistration.jsp">Add</a></li>
                            <li><a href="${pageContext.request.contextPath}/list">Edit</a></li>

                        </ul>


                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">


                                <div id="LoginDiv">

                                    <a href="#" data-toggle="dropdown" class="dropdown-toggle"><font color="blue">USER MANAGEMENT</font><b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="accountcreation.jsp">Add</a></li>
                                        <li><a href="${pageContext.request.contextPath}/list">Edit</a></li>


                                    </ul>    
                                </div>
                            </li>
                        </ul>


                    </div>

                </form>


            </div>

        </div>
    </body>
</html>
