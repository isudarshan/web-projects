

<%@page import="com.hms.domain.sub.RegisteredDoctor"%>
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
                            <%
                                RegisteredDoctor registeredDoctor = (RegisteredDoctor) request.getAttribute("Doctor");
                            %>
                            <h1><a>Sign-In</a></h1>
                            <form id="form_571622" class="appnitro"  method="get" action="DoctorController">
                                <div class="form_description">


                                    <h2>Welcome <%=appUser.getUserName()%> !!</h2>
                                    <div style="float: right;"><a href="SignOutController">SignOut</a></div>
                                    <p>Your Profile</p>



                                </div>
                                <table align="center" cellpadding="10" cellspacing="5">
                                    <tr>
                                        <th>Doctor Id</th>
                                        <td><%=registeredDoctor.getDoctorId()%></td>
                                        <th>Profile Picture</th>
                                        <td><img src="ImageController?firstName=<%=registeredDoctor.getFirstName()%>" width="100" height="100"></td>
                                           </tr>
                                        <tr>
                                            <th> Doctor Name</th>
                                            <td><%=registeredDoctor.getFirstName()+ " "+registeredDoctor.getLastName()%></td>
                                        </tr>
                                        <tr>
                                           <th>Gender</th>
                                           <td><%=registeredDoctor.getGender()%></td>
                                        </tr>
                                        <tr>
                                           <th>Specialization</th>
                                           <td><%=registeredDoctor.getSpecialization()%></td>
                                        </tr>
                                        <tr>
                                           <th>Mobile Number</th>
                                           <td><%=registeredDoctor.getMobileNumber()%></td>
                                        </tr>
                                        <tr>
                                           <th>Email Id</th>
                                           <td><%=registeredDoctor.getEmail()%></td>
                                        </tr>
                                        <tr>
                                           <th>Experience</th>
                                           <td><%=registeredDoctor.getExperience()%></td>
                                        </tr>
                                        
                                </table>

                            </form>					

                            <div id="footer">
                                <a href="doctorHome.jsp">Cancel</a>
                            </div>
                        </div>
                        <img id="bottom" src="bottom.png" alt="">
                            </body>
                            </html>
