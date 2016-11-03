<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>IN ADMIN PANEL | LOGIN</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ddaccordion.js"></script>
        <script type="text/javascript">
            ddaccordion.init({
                headerclass: "submenuheader", //Shared CSS class name of headers group
                contentclass: "submenu", //Shared CSS class name of contents group
                revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
                mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
                collapseprev: true, //Collapse previous content (so only one open at any time)? true/false
                defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
                onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
                animatedefault: false, //Should contents open by default be animated into view?
                persiststate: true, //persist state of opened contents within browser session?
                toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
                togglehtml: ["suffix", "<img src='resources/images/plus.gif' class='statusicon' />", "<img src='resources/images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
                animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
                oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
                    //do nothing
                },
                onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
                    //do nothing
                }
            })
        </script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jconfirmaction.jquery.js"></script>
        <script type="text/javascript">

            $(document).ready(function() {
                $('.ask').jConfirmAction();

                $('#submit').click(function(){
                    var userName = $('#userName').val();
                    var password = $('#password').val();

                    if(userName == null || userName.length == 0) {
                        alert('UserName is required !');
                        return false;
                    }

                    if(password == null || password.length == 0) {
                        alert('Password is required !');
                        return false;
                    }

                    $('#appHome_Ajax_Loading').show();

                    $.ajax({
                        type:'POST',
                        url:'${pageContext.request.contextPath}/login',
                        data:$('#loginForm').serialize(),
                        success:function(response) {
                            res = response;

                            $("#status").ajaxComplete(function(event,request,settings) {

                                $('#appHome_Ajax_Loading').hide();


                                if(res == 'Invalid UserId/Password') {
                                    alert(res);
                                    return;
                                }
                                if(res == '/admin') {

                                    var login_response = '<div id="logged_in">'
                                        + '<div style="width: 350px; float: left; margin-left: 70px;">'
                                        + '<div style="width: 40px; float: left;">'
                                        + '<img style="margin: 5px 5px 5px 0px;" src="resources/images/ajax-loader.gif">'
                                        + '</div>'
                                        + '<div style="margin: 5px 5px 5px 5px;width: 300px;color:#2A2A2A;font:18px Arial,Helvetica,sans-serif;">'
                                        + "You are successfully logged in! <br /> Please wait ...</div></div>";

                                    $(this).html(login_response);
                                    setTimeout('showPage()',3000);

                                }else if(res == '/employeeHome'){
                                    var login_response = '<div id="logged_in">'
                                        + '<div style="width: 350px; float: left; margin-left: 70px;">'
                                        + '<div style="width: 40px; float: left;">'
                                        + '<img style="margin: 5px 5px 5px 0px;" src="resources/images/ajax-loader.gif">'
                                        + '</div>'
                                        + '<div style="margin: 5px 5px 5px 5px;width: 300px;color:#2A2A2A;font:18px Arial,Helvetica,sans-serif;">'
                                        + "You are successfully logged in! <br /> Please wait ...</div></div>";

                                    $(this).html(login_response);
                                    setTimeout('showPage()',3000);

                                }

                            });






                        }

                        // end success
                    });


                });


            });


            function showPage() {
                console.debug("in showPage");
                window.location = '<%=request.getContextPath()%>'+ res;
            }
        </script>

        <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/niceforms.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/resources/css/niceforms-default.css" />

    </head>
    <body>
        <div id="main_container">

            <div class="header_login">
                <div class="logo"><a href="#"><img src="resources/images/logo.gif" alt="" title="" border="0" /></a></div>

            </div>


            <div class="login_form">

                <h3>Admin Panel Login</h3>

                <a href="${pageContext.request.contextPath}/forgotPassword" class="forgot_pass">Forgot password</a>
                <div id="status" align="left">
                    <sf:form action="" method="post" class="niceform" modelAttribute="loginForm" id="loginForm">

                        <fieldset>
                            <dl>
                                <dt><label for="email">Username:</label></dt>
                                <dd><sf:input type="text" name="" id="userName" size="54" path="userName" /></dd>
                            </dl>
                            <dl>
                                <dt><label for="password">Password:</label></dt>
                                <dd><sf:password name="" id="password" size="54" path="password" /></dd>
                            </dl>




                            <dl class="submit">
                                <input type="button" name="submit" id="submit" value="Login" />
                            </dl>

                            <div id="appHome_Ajax_Loading"  style="position:relative; left:300px;width:100px; display:none;">
                                <img align="absmiddle" src="resources/images/spinner.gif">&nbsp;Processing...
                            </div>

                        </fieldset>

                    </sf:form>
                </div>
            </div>



            <div class="footer_login">

                <div class="left_footer_login">IN ADMIN PANEL | Powered By <a href="#">Sai Teja Infotech</a></div>
                <div class="right_footer_login"><a href=#"><img src="resources/images/indeziner_logo.gif" alt="" title="" border="0" /></a></div>

            </div>

        </div>
    </body>
</html>