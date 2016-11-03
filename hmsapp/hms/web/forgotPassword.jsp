<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Forgot Password</title>
            <link rel="stylesheet" type="text/css" href="view.css" media="all">
                <script type="text/javascript" src="view.js"></script>

                </head>
                <body id="main_body" >

                    <img id="top" src="top.png" alt="">
                        <div id="form_container">

                            <h1><a>Forgot Password</a></h1>
                            <form id="form_571654" class="appnitro"  method="post" action="ForgotPasswordController">
                                <div class="form_description">
                                    <h2>Forgot Password</h2>
                                    <p>Get your password here..</p>
                                    <%
                                        if (request.getAttribute("errorMsg") != null) {

                                    %>
                                    <p><font color="red"><%=request.getAttribute("errorMsg")%></p></font>
                                    <%
                                        }
                                    %>
                                    <%
                                        if (request.getAttribute("password") != null) {

                                    %>
                                    <p><font color="green"> Your Password is :<%=request.getAttribute("password")%></p></font>
                                    <%
                                        }
                                    %>

                                </div>						
                                <ul >

                                    <li id="li_1" >
                                        <label class="description" for="element_1">User Name </label>
                                        <div>
                                            <input id="element_1" name="username" class="element text medium" type="text" maxlength="255" value=""/> 
                                        </div><p class="guidelines" id="guide_1"><small>Enter your User Name</small></p> 
                                    </li>		<li id="li_3" >
                                        <label class="description" for="element_3">Security Question </label>
                                        <div>
                                            <select class="element select medium" id="element_3" name="securityQuestion"> 
                                                <option value="" selected="selected"></option>
                                                <option value="What is your native place?" >What is your native place?</option>
                                                <option value="What is your nick name?" >What is your nick name?</option>
                                                <option value="What is your best friend's name?" >What is your best friend's name?</option>

                                            </select>
                                        </div><p class="guidelines" id="guide_3"><small>Choose your security question</small></p> 
                                    </li>		<li id="li_2" >
                                        <label class="description" for="element_2">Answer </label>
                                        <div>
                                            <input id="element_2" name="answer" class="element text medium" type="text" maxlength="255" value=""/> 
                                        </div><p class="guidelines" id="guide_2"><small>Enter Your Answer  </small></p> 
                                    </li>

                                    <li class="buttons">
                                        <input type="hidden" name="form_id" value="571654" />

                                        <input id="saveForm" class="button_text" type="submit" name="submit" value="Submit" />
                                    </li>
                                </ul>
                            </form>	
                            <div id="footer">
                               <a href="login.jsp">Cancel</a>
                            </div>
                        </div>
                        <img id="bottom" src="bottom.png" alt="">
                            </body>
                            </html>