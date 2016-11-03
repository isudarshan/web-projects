<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Registered Doctors </title>
            <link rel="stylesheet" type="text/css" href="view.css" media="all">
                <script type="text/javascript" src="view.js"></script>

                </head>
                <body id="main_body" >

                    <img id="top" src="top.png" alt="">
                        <div id="form_container">

                            <h1><a>Registered Doctors </a></h1>
                            <form id="form_571654" class="appnitro" enctype="multipart/form-data" method="post" action="DoctorController">
                                <div class="form_description">
                                    <h2>Registered Doctors </h2>
                                    <div style="float: right;"><a href="SignOutController">SignOut</a></div>
                                    <p>Register a doctor here..</p>
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
                                        <label class="description" for="element_1"> UserName</label>
                                        <div>
                                            <input id="element_1" name="userName" class="element text medium" type="text" maxlength="255" value ="<%=(request.getParameter("userName")!= null)?(request.getParameter("userName")):""%>"/> 
                                        </div> 
                                    </li>	

                                    <li id="li_1" >
                                        <label class="description" for="element_1">Doctor ID </label>
                                        <div>
                                            <input id="element_1" name="doctorId" class="element text medium" type="text" maxlength="255" value="<%=(request.getParameter("doctorId"))!= null?request.getParameter("doctorId"):""%>"/> 
                                        </div> 
                                    </li>		<li id="li_2" >
                                        <label class="description" for="element_2">Doctor Name </label>
                                        <span>
                                            <input id="element_2_1" name= "firstName" class="element text" maxlength="255" size="8" value="<%=(request.getParameter("firstName"))!= null?request.getParameter("firstName"):""%>"/>
                                            <label>First</label>
                                        </span>
                                        <span>
                                            <input id="element_2_2" name= "lastName" class="element text" maxlength="255" size="14" value="<%=(request.getParameter("lastName"))!= null?request.getParameter("lastName"):""%>"/>
                                            <label>Last</label>
                                        </span> 
                                    </li>		<li id="li_7" >
                                        <label class="description" for="element_7">Gender </label>
                                        <div>
                                            <select class="element select small" id="element_7" name="gender"> 
                                                <option value="" selected="selected"></option>
                                                <option value="male" >Male</option>
                                                <option value="female" >Female</option>


                                            </select>
                                        </div> 
                                    </li>		<li id="li_8" >
                                        <label class="description" for="element_8">Specialization </label>
                                        <div>
                                            <select class="element select medium" id="element_8" name="specialization"> 
                                                <option value="" selected="selected"></option>
                                                <option value="General Medicine" >General Medicine</option>
                                                <option value="Cardiologist" >Cardiologist</option>
                                                <option value="Dermatology" >Dermatology</option>
                                                <option value="Orthopedics" >Orthopedics</option>
                                                <option value="Pediatrics" >Pediatrics</option>
                                                <option value="Psychiatry" >Psychiatry</option>

                                            </select>
                                        </div> 
                                    </li>		<li id="li_3" >
                                        <label class="description" for="element_3">Mobile Number </label>
                                        <div>
                                            <input id="element_3" name="mobileNumber" class="element text medium" type="text" maxlength="255" value="<%=(request.getParameter("mobileNumber"))!= null?request.getParameter("mobileNumber"):""%>"/> 
                                        </div> 
                                    </li>		<li id="li_4" >
                                        <label class="description" for="element_4">Email </label>
                                        <div>
                                            <input id="element_4" name="email" class="element text medium" type="text" maxlength="255" value="<%=(request.getParameter("email"))!= null?request.getParameter("email"):""%>"/> 
                                        </div> 
                                    </li>		<li id="li_5" >
                                        <label class="description" for="element_5">Experience </label>
                                        <div>
                                            <input id="element_5" name="experience" class="element text small" type="text" maxlength="255" value="<%=(request.getParameter("experience"))!= null?request.getParameter("experience"):""%>"/> 
                                        </div> 
                                    </li>		<li id="li_6" >
                                        <label class="description" for="element_6">Photograph </label>
                                        <div>
                                            <input id="element_6" name="photograph" class="element file" type="file"/> 
                                        </div>  
                                    </li>

                                    <li class="buttons">
                                        <input type="hidden" name="form_id" value="571654" />

                                        <input id="saveForm" type="submit" value ="Create"/>
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