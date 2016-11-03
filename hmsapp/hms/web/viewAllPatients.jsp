
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
        <div id="form_container" style="width: 1200px;">
            <%
        AppUser appUser = (AppUser) request.getSession().getAttribute("user");


        List<RegisteredPatient> patients = (List) request.getAttribute("Patients");
            %>
            <h1><a>Sign-In</a></h1>
            <form id="form_571622" class="appnitro"  method="get" action="DoctorController">
                <div class="form_description">


                    <h2>Hey <%=appUser.getUserName()%> !!</h2><div style="float: right;"><a href="SignOutController">SignOut</a></div>
                    <h4>Here Is Your Requested Patients's List</h4>

                </div>
                <table align="center" cellpadding="10" cellspacing="5" border="2">
                    <tr>

                        <th>Patient's name</th>
                        <th>Gender</th>
                        <th>Date Of Birth</th>
                        <th>Age</th>
                        <th>Height</th>
                        <th>Weight</th>
                        <th>Address</th>
                        <th>Mobile Number</th>
                        <th>Consultant Requested</th>
                        <th>Consultation Fee</th>
                        <th>Photograph</th>


                    </tr>
                    <%
        for (RegisteredPatient patient : patients) {
                    %>
                    <tr>
                        <td><%=patient.getFirstName()%></td>
                        <td><%=patient.getGender()%></td>
                        <td><%=patient.getDateOfBirth()%></td>
                        <td><%=patient.getAge()%></td>
                        <td><%=patient.getHeight()%></td>
                        <td><%=patient.getWeight()%></td>
                        <td><%=patient.getAddress()%></td>
                        <td><%=patient.getMobileNumber()%></td>
                        <td><%=patient.getRequestedConsultant()%></td>
                        <td><%=patient.getConsultationFee()%></td>
                        <td><img src ="ImageController2?firstName=<%=patient.getFirstName()%>" width ="50" height="50"></td>

                        <td><a href ="AssignDoctor?id=<%=patient.getId()%>">Assign Doctor</a></td>
                    </tr>

                    <%
        }
                    %>

                </table>

            </form>

            <div id="footer">
                <p align="center"><a href="adminHome.jsp">Cancel</a></p>

            </div>
        </div>
        <img id="bottom" src="bottom.png" alt="">
    </body>
</html>

