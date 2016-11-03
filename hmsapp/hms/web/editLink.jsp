

<%@page import="com.hms.domain.sub.AppUser"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign-In</title>
        <link rel="stylesheet" type="text/css" href="view.css" media="all">
        <script type="text/javascript" src="view.js"></script>

    </head>
    <body id="main_body" >

        <img id="top" src="top.png" alt="">
        <div id="form_container">
            <%
        AppUser appUser = (AppUser) request.getSession().getAttribute("user");
            %>
            <h1><a>HMS | ADMIN HOME</a></h1>
            <form id="form_571622" class="appnitro" method="POST" action="GetDetailsController">
                <div class="form_description">


                    <h2>Welcome <%=appUser.getUserName()%> !!</h2>
                    <p>Your role is <%=appUser.getUserRole()%></p>

                    <br/><br/><br/><br/>

                    <p align="center">
                        Enter DoctorId <input type="text" name="docId" id="docId"/>

                        <input type="submit" value="Get details">
                    </p>
                </div>
            </form>

            <div id="footer">
                <a href="<%=appUser.getUserRole()%>Home.jsp">Cancel</a>
            </div>
        </div>
        <img id="bottom" src="bottom.png" alt="">
    </body>
</html>