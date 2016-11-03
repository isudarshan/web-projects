

<%@page import="com.hms.domain.sub.AppUser"%>
<%@page import="java.util.List"%>
<%@page import="com.hms.domain.sub.Prescription"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign-In</title>
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
    <h1><a>HMS | ADMIN HOME</a></h1>
    <form id="form_571622" class="appnitro"  method="post" action="PharmacyController">
        <div class="form_description">


            <h2>Welcome <%=appUser.getUserName()%> !!</h2>
            <p>Your role is <%=appUser.getUserRole()%></p>


            <div id="pic">
                <img src="${pageContext.request.contextPath}/ImageController3?pharmacistName=<%=appUser.getUserName()%>" width="100" height="100"/>
                <br/>
                <p><a href="changePhoto.jsp">Change Photograph</a></p>
            </div>
            <%
        if (request.getAttribute("msg") != null) {

            %>
            <p><font color ="green"><%=request.getAttribute("msg")%></p></font>

            <%
        }
            %>
            <%

        if (request.getAttribute("success") != null) {

            %>
            <p><font color ="green"><%=request.getAttribute("success")%></p></font>
            <%
        }
            %>
            <%
        if (request.getAttribute("created") != null) {

            %>
            <p><font color="green"><%=request.getAttribute("created")%></font></p>
            <%
        }


            %>
            <%

        if (request.getAttribute("success1") != null) {

            %>
            <p><font color ="green"><%=request.getAttribute("success1")%></p></font>
            <%
        }
            %>
            <%
        if (request.getAttribute("patientMsg") != null) {

            %>
            <p><font color="red"><%=request.getAttribute("patientMsg")%></font></p>
            <%
        }
            %>
        </div>
        <table align="center" cellpadding="10" cellspacing="5" >
            <tr>
                <td>Enter Patient Name or ID</td>
                <td><input type ="text" name ="patientName" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="View Presciption"></td>
            </tr>



        </table>


    </form>

    <div id="footer">
        <a href="SignOutController">Sign Out</a>
    </div>
</div>
<img id="bottom" src="bottom.png" alt="">
</body>
</html>
