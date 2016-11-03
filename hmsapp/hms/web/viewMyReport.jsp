

<%@page import="com.hms.domain.sub.LabAdmin"%>
<%@page import="com.hms.domain.sub.Prescription"%>
<%@page import="java.util.List"%>
<%@page import="com.hms.domain.sub.Doctor_Patient"%>
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
                        <div id="form_container" style="width: 800px;">
                            <%
                                AppUser appUser = (AppUser) request.getSession().getAttribute("user");
                                List<LabAdmin> list = (List) request.getAttribute("list");

                            %>
                            <h1><a>HMS | Patient</a></h1>
                            <form id="form_571622" class="appnitro"  method="get" action="PatientController">
                                <div class="form_description">


                                    <h2>Welcome <%=appUser.getUserName()%> !!</h2>
                                    <div style="float: right;"><a href="SignOutController">SignOut</a></div>
                                    <p>View Your Reports Here...</p>




                                </div>
                                <table align="center" cellpadding="10" cellspacing="5" border="2">
                                    <tr>
                                        <th>Doctor Name</th>
                                        <th>Doctor Id</th>
                                        <th>Test</th>
                                        <th>Report</th>
                                        <th>Test Fee</th>

                                    </tr>
                                    <%
                                        for (LabAdmin labAdmin : list) {

                                    %>
                                    <tr>
                                        <td><%=labAdmin.getDoctorName()%></td>
                                        <td><%=labAdmin.getDoctorId()%></td>
                                        <td><%=labAdmin.getTestSuggested()%></td>
                                        <td><%=labAdmin.getReport()%></td>
                                        <td><%=labAdmin.getTestFee()%></td>


                                    </tr>

                                    <%

                                        }
                                    %>


                                </table>

                            </form>					

                            <div id="footer">
                                <a href="patientHome.jsp">Cancel</a>

                            </div>
                        </div>
                        <img id="bottom" src="bottom.png" alt="">
                            </body>
                            </html>
