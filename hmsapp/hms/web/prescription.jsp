

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
                            <h1><a>HMS |  DOCTOR</a></h1>
                            <form id="form_571622" class="appnitro"  method="post" action="DoctorController">
                                <div class="form_description">


                                    <h2>Welcome <%=appUser.getUserName()%> !!</h2>
                                    <div style="float: right;"><a href="SignOutController">SignOut</a></div>
                                    <p>Give Prescription Here</p>
                                </div>


                                <table align="center" cellpadding="10" cellspacing="5" >
                                    <tr>
                                        <td>Patient Name</a></td>
                                        <td><input type="text" value="<%=request.getParameter("patientName")%>" name ="patientName"readonly></td>

                                    </tr>
                                    <tr>
                                        <td>Patient Id</td>
                                        <td><input type="text" value="<%=request.getParameter("patientId")%>" name ="patientId" readonly></td>

                                    </tr>
                                        <tr>
                                          <td>Doctor's Prescription</td>
                                          <td><textarea name ="prescription" cols="30" rows="10"></textarea></td>
  
                                            
                                            
                                        </tr>
                                    <tr>
                                        <td>Test's Suggested</td>
                                        <td><select name ="tests">
                                                <option value ="Blood Test">Blood Test</option> 
                                                <option value ="Sugar Test">Sugar Test</option>
                                                <option value ="MRI Scan">MRI Scan</option>
                                                <option value ="X-Ray">X-Ray</option>
                                                <option value ="Urine Test">Urine Test</option>
                                            </select></td>

                                    </tr>


                                    <tr>
                                        <td></td>
                                        <td><input type="submit" value="submitPrescription" name ="action"/></td>
                                    </tr>


                                </table>
                                        <input type="hidden" name="doctorId" value="<%=request.getParameter("doctorId")%>"/>
                                        <input type="hidden" name="doctorName" value="<%=request.getParameter("doctorName")%>"/>
                            
                            </form>					



                            <div id="footer">
                                <a href ="doctorHome.jsp">Cancel</a>
                            </div>
                        </div>
                </body>
                </html>
