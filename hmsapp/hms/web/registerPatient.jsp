<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Untitled Form</title>
        <link rel="stylesheet" type="text/css" href="view.css" media="all">
        <script type="text/javascript" src="view.js"></script>
        <script type="text/javascript" src="calendar.js"></script>

    </head>
    <body id="main_body" >

        <img id="top" src="top.png" alt="">
        <div id="form_container">

            <h1><a>Patient Registration Form</a></h1>
            <form id="form_572390" class="appnitro"  method="post" action="PatientController"  enctype="multipart/form-data" >
                <div class="form_description">
                    <h2>Patient Registration Form</h2>
                    <p>Register yourself here..</p>
                    <%
        if (request.getAttribute("clientError") != null) {
                    %>
                    <p><font color="red"></font><%=request.getAttribute("clientError")%></p>
                    <%
        }
                    %>

                </div>

                <ul><li id="li_2" >

                        <label class="description" for="element_2">UserName</label>
                        <div>
                            <input id="element_2" name="userName" class="element text medium" type="text" maxlength="255" value="<%=(request.getParameter("userName") != null) ? (request.getParameter("userName")) : ""%>"/>
                        </div>
                    </li>

                    <li id="li_1" >
                        <label class="description" for="element_1">Patient Name </label>
                        <span>
                            <input  name= "firstName" class="element text" maxlength="255" size="8" value="<%=(request.getParameter("firstName") != null) ? (request.getParameter("firstName")) : ""%>"/>
                            <label>First</label>
                        </span>
                        <span>
                            <input  name= "lastName" class="element text" maxlength="255" size="14" value="<%=(request.getParameter("lastName") != null) ? (request.getParameter("lastName")) : ""%>"/>
                            <label>Last</label>
                        </span>
                    </li>
                    <li id="li_2" >

                        <label class="description" for="element_2">Patient ID</label>
                        <div>
                            <input id="element_2" name="patientId" class="element text medium" type="text" maxlength="255" value="<%=(request.getParameter("patientId") != null) ? (request.getParameter("patientId")) : ""%>"/>
                        </div>
                    </li>
                    <li id="li_1" >
                        <label class="description" for="element_1">Date Of Birth </label>
                        <span>
                            <input id="element_1_1" name="month" class="element text" size="2" maxlength="2" value="" type="text"> /
                            <label for="element_1_1">MM</label>
                        </span>
                        <span>
                            <input id="element_1_2" name="day" class="element text" size="2" maxlength="2" value="" type="text"> /
                            <label for="element_1_2">DD</label>
                        </span>
                        <span>
                            <input id="element_1_3" name="year" class="element text" size="4" maxlength="4" value="" type="text">
                            <label for="element_1_3">YYYY</label>
                        </span>

                        <span id="calendar_1">
                            <img id="cal_img_1" class="datepicker" src="calendar.gif" alt="Pick a date.">
                        </span>
                        <script type="text/javascript">
                            Calendar.setup({
                                inputField	 : "element_1_3",
                                baseField    : "element_1",
                                displayArea  : "calendar_1",
                                button		 : "cal_img_1",
                                ifFormat	 : "%B %e, %Y",
                                onSelect	 : selectDate
                            });
                        </script>

                    </li>	<li id="li_2" >
                        <label class="description" for="element_2">Age</label>
                        <div>
                            <input id="element_2" name="age" class="element text small" type="text" maxlength="255" value="<%=(request.getParameter("age") != null) ? (request.getParameter("age")) : ""%>"/>
                        </div>
                    </li>		<li id="li_8" >
                        <label class="description" for="element_8">Gender </label>
                        <div>
                            <select class="element select medium" id="element_8" name="gender">

                                <option value="male" >Male</option>
                                <option value="female" >Female</option>

                            </select>
                        </div>
                    </li>  <li id="li_2" >
                        <label class="description" for="element_2">Height</label>
                        <div>
                            <input id="element_2" name="height" class="element text small" type="text" maxlength="255" value="<%=(request.getParameter("height") != null) ? (request.getParameter("height")) : ""%>"/>
                        </div>
                    </li>
                    <li id="li_2" >
                        <label class="description" for="element_2">Weight</label>
                        <div>
                            <input id="element_2" name="weight" class="element text small" type="text" maxlength="255" value="<%=(request.getParameter("weight") != null) ? (request.getParameter("weight")) : ""%>"/>
                        </div>
                    </li>
                    <li id="li_3" >
                        <label class="description" for="element_3">Patient Address </label>
                        <div>
                            <input id="element_2" name="address" class="element text medium" type="text" maxlength="255" value="<%=(request.getParameter("address") != null) ? (request.getParameter("address")) : ""%>"/>
                        </div>

                    </li>		<li id="li_4" >
                        <label class="description" for="element_4">Phone Number </label>
                        <div>
                            <input id="element_4" name="phoneNumber" class="element text small" type="text" maxlength="255" value="<%=(request.getParameter("phoneNumber") != null) ? (request.getParameter("phoneNumber")) : ""%>"/>
                        </div>
                    </li>			<li id="li_9" >
                        <label class="description" for="element_9">Requested Consultant  </label>
                        <div>
                            <select class="element select medium" id="element_9" name="requestedConsultant">
                                <option value="" selected="selected"></option>
                                <option value="General Medicine" >Medicine Doctor</option>

                                <option value="Cardiologist" >Cardiologist</option>
                                <option value="Dermatology" >Dermatology</option>
                                <option value="Orthopedics" >Orthopedics</option>
                                <option value="Pediatrics" >Pediatrics</option>
                                <option value="Psychiatry" >Psychiatry</option>

                            </select>
                        </div>
                        

                   <li id="li_7" >
                        <label class="description" for="element_7">Previous Medical Reports </label>
                        <div>
                            <textarea id="element_7" name="medicalReports" class="element textarea medium"></textarea>
                        </div>
                    </li>
                    <li id="li_2" >
                        <label class="description" for="element_2">Consultation Fee</label>
                        <div>
                            <input id="element_2" name="consultationFee" class="element text small" type="text" maxlength="255" size="10" value="<%=(request.getParameter("consultationFee") != null) ? (request.getParameter("consultationFee")) : ""%>"/>
                        </div>
                    </li>
                    <li id="li_6" >
                        <label class="description" for="element_6">Photograph </label>
                        <div>
                            <input id="element_6" name="photograph" class="element file" type="file"/>
                        </div>
                    </li>
                    <li class="buttons">
                        <input type="hidden" name="form_id" value="572390" />

                        <input id="saveForm" class="button_text" type="submit" name="submit" value="Submit" />
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
