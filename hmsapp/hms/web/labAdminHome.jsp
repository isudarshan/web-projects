<%@page import="com.hms.domain.sub.AppUser"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HMS | PATIENT HOME</title>
        <link rel="stylesheet" type="text/css" href="view.css" media="all">
        <script type="text/javascript" src="view.js"></script>

        <style type="text/css">
            #pic{

                position:relative;
                left:502px;
                top:-50px;
            }

        </style>
    </head>
    <body id="main_body" >

        <img id="top" src="top.png" alt="">
        <div id="form_container">
            <%
        AppUser appUser = (AppUser) request.getSession().getAttribute("user");
            %>
            <h1><a>Sign-In</a></h1>
            <form id="form_571622" class="appnitro"  method="post" action="LoginController">
                <div class="form_description">


                    <h2>Welcome <%=appUser.getUserName()%> !!</h2>
                    <p>Your role is <%=appUser.getUserRole()%></p>

                    <div id="pic">
                        <img src="${pageContext.request.contextPath}/LabAdminImage?firstName=<%=appUser.getUserName()%>" width="100" height="100"/>
                        <p><a href="changePhoto.jsp">Change Photograph</a></p>
                    </div>
                    <%
        if (request.getAttribute("msg") != null) {
                    %>
                    <p><font color="green"><%=request.getAttribute("msg")%></font></p>
                    <%
        }
                    %>

                    <%
        if (request.getAttribute("success") != null) {
                    %>
                    <p><font color="green"><%=request.getAttribute("success")%></font></p>
                    <%
        }
                    %>

                </div>
                <table align="center" cellpadding="10" cellspacing="5" border="2">
                    <tr>
                        <td><a href ="changePassword.jsp">Change Password</a></td>
                        <td><a href="SignOutController">Sign Out</a></td>
                        <td><a href="LabAdminController?action=viewRequests">View Requested Tests</a></td>
                    </tr>
                    <tr>
                        <td><a href="LabAdminController?action=viewCompletedTests">View Completed Tests</a></td>
                        <td><a href="setQuestion.jsp">Set SecurityQuestion</a></td>
                    </tr>



                </table>

            </form>

            <div id="footer">

            </div>
        </div>
        <img id="bottom" src="bottom.png" alt="">
    </body>
</html>