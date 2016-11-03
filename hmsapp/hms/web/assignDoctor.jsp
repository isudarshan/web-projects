

<%@page import="java.util.List"%>
<%@page import="com.hms.domain.sub.RegisteredDoctor"%>
<%@page import="com.hms.domain.sub.RegisteredPatient"%>
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
                            <h1><a>HMS |  ADMIN</a></h1>
                            <form id="form_571622" class="appnitro"  method="post" action="AssignDoctor">
                                <div class="form_description">


                                    <h2>Welcome <%=appUser.getUserName()%> !!</h2><div style="float: right;"><a href="SignOutController">SignOut</a></div>
                                    <p>Assign A Doctor Here</p>
                                    <%
                                        if (request.getAttribute("message") != null) {

                                    %>
                                    <p><font color="green"><%=request.getAttribute("message")%></font></p>

                                    <%
                                        }
                                    %>
                                </div>
                                <%
                                    RegisteredPatient patient = (RegisteredPatient) request.getSession().getAttribute("patient");
                                    List<RegisteredDoctor> doctors = (List) request.getSession().getAttribute("doctors");
                                %>

                                <table align="center" cellpadding="10" cellspacing="5" border="2">
                                    <tr>
                                        <td>Patient Name</a></td>
                                        <td><input type="text" value="<%=patient.getFirstName()%>" name ="patientName"readonly></td>

                                    </tr>
                                    <tr>
                                        <td>Consultant Requested</td>
                                        <td><input type="text" value="<%=patient.getRequestedConsultant()%>" name ="requestedConsultant" readonly></td>

                                    </tr>
                                    <tr>
                                        <td>Doctor Name</td>
                                        <td><select name ="doctorName">
                                                <%
                                                    for (RegisteredDoctor doctor : doctors) {
                                                %>
                                                <option value="<%=doctor.getFirstName()%>"><%=doctor.getFirstName() + " " + doctor.getLastName()%></option>
                                                <%
                                                    }
                                                %>


                                            </select></td>

                                    </tr>


                                    <tr>
                                        <td></td>
                                        <td><input type="submit" value="Submit" name ="action"/></td>
                                    </tr>



                            </form>					



                            <div id="footer">
                                <a href ="adminHome.jsp">Back</a>
                            </div>
                        </div>
                </body>
                </html>
