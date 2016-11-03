<%@page import="com.hms.domain.sub.AppUser"%>
<%@page import="com.hms.domain.sub.RegisteredDoctor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registered Doctors </title>
        <link rel="stylesheet" type="text/css" href="view.css" media="all">
        <script type="text/javascript" src="view.js"></script>

    </head>
    <body id="main_body" >

        <%
        AppUser appUser = (AppUser) request.getSession().getAttribute("user");
        %>

         <%
        RegisteredDoctor doctor = (RegisteredDoctor) request.getAttribute("doctor");
        %>
        <img id="top" src="top.png" alt="">
        <div id="form_container">

            <h1><a>Update Doctors </a></h1>
            <form id="form_571654" class="appnitro"  method="post" action="EditDoctorController">
                <div class="form_description">
                    <h2>Welcome <%=appUser.getUserName()%> !!</h2>
                    <p>Your role is <%=appUser.getUserRole()%></p>
                    <%
        if (request.getAttribute("msg") != null) {

                    %>
                    <p><font color="green"><%=request.getAttribute("msg")%></font></p>
                    <%
        }


                    %>
                    <%
        if (request.getAttribute("clientError") != null) {
                    %>
                    <p><font color="red"><%=request.getAttribute("clientError")%></font></p>
                    <%
        }

                    %>
                </div>
                <ul >
                    <li id="li_1" >
                        <label class="description" for="element_1"> Doctor ID</label>
                        <div>
                            <input id="element_1" name="doctorId" class="element text medium" type="text" readonly="readonly" maxlength="255" value ="<%=doctor. getDoctorId()%>"/>
                        </div>
                    </li>

                    <li id="li_3" >
                        <label class="description" for="element_3">Mobile Number </label>
                        <div>
                            <input id="element_3" name="mobileNumber" class="element text medium" type="text" maxlength="255" value="<%=doctor. getMobileNumber()%>"/>
                        </div>
                    </li>		<li id="li_4" >
                        <label class="description" for="element_4">Email </label>
                        <div>
                            <input id="element_4" name="email" class="element text medium" type="text" maxlength="255" value="<%=doctor. getEmail()%>"/>
                        </div>
                    </li>		<li id="li_5" >
                    <label class="description" for="element_5">Experience </label>
                    <div>
                        <input id="element_5" name="experience" class="element text small" type="text" maxlength="255" value="<%=doctor. getExperience()%>"/>
                    </div>

                    <li class="buttons">
                        <input type="hidden" name="form_id" value="571654" />

                        <input id="saveForm" type="submit" value ="Update"/>
                    </li>
                </ul>
            </form>
            <div id="footer">
                <a href="adminHome.jsp">Cancel</a>
            </div>
        </div>
        <img id="bottom" src="bottom.png" alt="">
    </body>
</html>