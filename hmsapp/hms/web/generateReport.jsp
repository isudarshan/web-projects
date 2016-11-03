<%@page import="com.hms.domain.sub.AppUser"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HMS | PATIENT HOME</title>
        <link rel="stylesheet" type="text/css" href="view.css" media="all">
        <script type="text/javascript" src="view.js"></script>

    </head>
    <body id="main_body" >

        <img id="top" src="top.png" alt="">
        <div id="form_container">
            <%
        AppUser appUser = (AppUser) request.getSession().getAttribute("user");
            %>
            <h1><a>Sign-In</a></h1>
            <form id="form_571622" class="appnitro"  method="post" action="LabAdminController" enctype="multipart/form-data">
                <div class="form_description">


                    <h2>Hey <%=appUser.getUserName()%> !!</h2>
                    <div style="float: right;"><a href="SignOutController">SignOut</a></div>
                    <p>Write the report here..</p>


                </div>
                <table align="center" cellpadding="10" cellspacing="5" >
                    <tr>
                        <td>Report</td>
                        <td><textarea  cols="30" rows="10" name="report"></textarea></td>

                    </tr>
                    <tr>
                        <td>Test Fee</td>
                        <td><input type="text"  name="testFee"></td>
                    </tr>

                    <tr>
                        <td>Upload Report</td>
                        <td><input type="file" name="uploadReport"></td>
                    </tr>
                    <tr>
                    <input type="hidden" name="id" value="<%=request.getAttribute("id")%>"/>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="SubmitReport"/></td>


                    </tr>


                </table>

            </form>

            <div id="footer">
                <a href="tests.jsp">Cancel</a>
            </div>
        </div>
        <img id="bottom" src="bottom.png" alt="">
    </body>
</html>
