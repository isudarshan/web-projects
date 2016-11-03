<%@page  import="com.hms.domain.sub.AppUser" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Sign-In</title>
            <link rel="stylesheet" type="text/css" href="view.css" media="all">
                <script type="text/javascript" src="view.js"></script>

                </head>
                <body id="main_body" >


                    <%
                        AppUser appUser = (AppUser) request.getSession().getAttribute("user");

                    %>
                    <img id="top" src="top.png" alt="">
                        <div id="form_container">

                            <h1><a>Sign-In</a></h1>
                            <form id="form_571622" class="appnitro"  method="post" action="SetQuestionController">
                                <div class="form_description">
                                    <h2>Set Security Question</h2><div style="float: right;"><a href="SignOutController">SignOut</a></div>
                                    <p>Make Your Account Secure</p>
                                    <%
                                        if (request.getAttribute("clientError") != null){
                                    %>
                                    <p><font color="red"><%=request.getAttribute("clientError")%></p></font>
                                    <%
                                                                       }
                                    %>
                                    <%
                                    if (request.getAttribute("matchError") != null){
                                    %>
                                    <p><font color="red"><%=request.getAttribute("matchError")%></font>
                                        <%
                                                                               }
                                        %>
                                     <%
                                        if (request.getAttribute("errormsg") != null) {

                                    %>
                                    <p><font color ="red"><%=request.getAttribute("errormsg")%></p></font>

                                     <%
                                                                         }
                                     %>

                                </div>
                                <ul >

                                    <li id="li_1" >
                                        <label class="description" for="element_1">User Name </label>
                                        <div>
                                            <input id="element_1" name="username" class="element text medium" type="text" maxlength="255" value="<%=appUser.getUserName()%>" readonly/>
                                        </div><p class="guidelines" id="guide_1"><small>Enter user Name</small></p>
                                    </li>		<li id="li_2" >
                                        <label class="description" for="element_2">Security Question </label>
                                        <div>
                                            <select id="question" name="question">
                                                <option>What is your native place?</option>
                                                <option>What is your date of birth?</option>
                                                <option>What is your RegistrationId?</option>
                                                <option>What is your nick name?</option>
                                            </select>
                                        </div><p class="guidelines" id="guide_2"><small>Select Security Question</small></p>
                                    </li>
                                    <li id="li_3" >
                                        <label class="description" for="element_3">Answer </label>
                                        <div>
                                            <input id="element_2" name="answer" class="element text medium" type="password" maxlength="255" value=""/>
                                        </div><p class="guidelines" id="guide_3"><small>Enter Answer</small></p>
                                    </li>
                                    
                                    <li class="buttons">
                                        <input type="hidden" name="form_id" value="571622" />

                                        <input id="saveForm" class="button_text" type="submit" name="submit" value="Submit" />
                                    </li>
                                </ul>
                            </form>
                            <div id="footer">
                                <a href="<%=appUser.getUserRole()%>Home.jsp">Cancel</a>
                            </div>
                        </div>
                        <img id="bottom" src="bottom.png" alt="">
                            </body>
                            </html>