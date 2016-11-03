

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
        List<Doctor_Patient> doctor_Patients = (List) request.getSession().getAttribute("Doctor_Patients");
            %>
            <h1><a>HMS | ADMIN HOME</a></h1>
            <form id="form_571622" class="appnitro"  method="post" action="LoginController">
                <div class="form_description">


                    <h2>Welcome <%=appUser.getUserName()%> !!</h2>
                    <div style="float: right;"><a href="SignOutController">SignOut</a></div>
                    <p>View Your Patients Here..</p>

                    <%
        if (request.getAttribute("successMsg") != null) {

                    %>
                    <p><font color="green"><%=request.getAttribute("successMsg")%></font></p>
                    <%
        }
                    %>
                    <%
        if (request.getAttribute("msg1") != null) {

                    %>
                    <p><font color="red"><%=request.getAttribute("msg1")%></font></p>
                    <%
        }
                    %>



                </div>
                <table align="center" cellpadding="10" cellspacing="5" border="2">
                    <tr>
                        <th>Patient Name</th>
                        <th>Patient Id</th>
                        <th>Required Consultation</th>
                        <th>Medical History</th>
                        <th>Observation</th>
                        <th>Photo</th>
                    </tr>
                    <%
        for (Doctor_Patient doctor_Patient : doctor_Patients) {
                    %>
                    <tr>
                        <td><%=doctor_Patient.getPatientName()%></td>
                        <td><%=doctor_Patient.getPatientId()%></td>
                        <td><%=doctor_Patient.getRequiredConsultation()%></td>
                        <td><%=doctor_Patient.getMedicalHistory()%></td>
                        <td><%=doctor_Patient.getObservation()%></td>
                        <td><img src="${pageContext.request.contextPath}/ImageController2?firstName=<%=doctor_Patient.getPatientName()%>" width="100" height="100"/></td>
                        <td><a href="PatientController?action=prescription&patientId=<%=doctor_Patient.getPatientId()%>&patientName=<%=doctor_Patient.getPatientName()%>&doctorId=<%=doctor_Patient.getDoctorId()%>&doctorName=<%=doctor_Patient.getDoctorName()%>">Give Prescription</a></td>

                    </tr>

                    <%
        }
                    %>


                </table>

            </form>

            <div id="footer">
                <a href="doctorHome.jsp">Cancel</a>
            </div>
        </div>
        <img id="bottom" src="bottom.png" alt="">
    </body>
</html>