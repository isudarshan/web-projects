<%@page  import="com.hms.domain.sub.AppUser" %>
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


                    <%
                        AppUser appUser = (AppUser) request.getSession().getAttribute("user");

                    %>
                    <img id="top" src="top.png" alt="">
                        <div id="form_container">

                            <h1><a>Patient Registration Form</a></h1>
                            <form id="form_572390" class="appnitro"  method="post" action="ChangePhotoController"  enctype="multipart/form-data" >
                                <div class="form_description">
                                    <h2>Change Your Photograph Here..</h2>
                                    <p></p>
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
                                            <input id="element_2" name="userName" class="element text medium" type="text" maxlength="255" value="<%=appUser.getUserName()%>"/>
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
