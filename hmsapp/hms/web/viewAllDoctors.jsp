
<%@page import="java.util.List"%>
<%@page import="com.hms.domain.sub.*"%>
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
                        <div id="form_container" style="width: 900px;">
                            <%
                                AppUser appUser = (AppUser) request.getSession().getAttribute("user");


                                List<RegisteredDoctor> doctors = (List) request.getAttribute("Doctors");
                            %>
                            <h1><a>Sign-In</a></h1>
                            <form id="form_571622" class="appnitro"  method="get" action="DoctorController">
                                <div class="form_description">


                                    <h2>Hey <%=appUser.getUserName()%> !!</h2>
                                    <div style="float: right;"><a href="SignOutController">SignOut</a></div>
                                    <h4>Here Is Your Requested Doctor's List</h4>


                                </div>
                                <table align="center" cellpadding="10" cellspacing="5" border="2">
                                    <tr>
                                        <th>Doctor Id</th>
                                        <th>Doctor's name</th>
                                        <th>Gender</th>
                                        <th>Specialization</th>
                                        <th>Mobile Number</th>
                                        <th>Email Id</th>
                                        <th>Experience</th>
                                        <th>Photograph</th>

                                    </tr>
                                    <%
                                        for (RegisteredDoctor doctor : doctors) {
                                    %>
                                    <tr>
                                        <td><%=doctor.getDoctorId()%></td>
                                        <td><%=doctor.getFirstName() + " " + doctor.getLastName()%></td>
                                        <td><%=doctor.getGender()%></td>
                                        <td><%=doctor.getSpecialization()%></td>
                                        <td><%=doctor.getMobileNumber()%></td>
                                        <td><%=doctor.getEmail()%></td>
                                        <td><%=doctor.getExperience()%></td>
                                        <td><image src ="ImageController?firstName=<%=doctor.getFirstName()%>" width ="50" height="50"></td>
                                    </tr>

                                    <%
                                        }
                                    %>

                                </table>

                            </form>					

                            <div id="footer">
                                <p align="center"> <a href="adminHome.jsp">Cancel</a></p>
                            </div>
                        </div>
                        <img id="bottom" src="bottom.png" alt="">
                            </body>
                            </html>
