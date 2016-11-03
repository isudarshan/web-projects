<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/reset.css">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/style.css">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/grid_12.css">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/slider.css">
        <link href='http://fonts.googleapis.com/css?family=Condiment' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/tms-0.4.x.js"></script>

        <script>


            var res = null;
            $(document).ready(function(){
                $("#signInLink").click(function(){
                    $('#appHome_Ajax_Loading').show();


                    $.ajax({
                        type:'POST',
                        url:'${pageContext.request.contextPath}/login',
                        data:$('#form').serialize(),
                        success: function(response) {
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

                                }else if(res == '/studentHome'){
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

                    });

                });
            });

            function showPage() {
                console.debug("in showPage");
                window.location = '<%=request.getContextPath()%>'+ res;
            }
        </script>



        <!--[if lt IE 8]>
       <div style=' clear: both; text-align:center; position: relative;'>
         <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
           <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
        </a>
      </div>
    <![endif]-->
    <!--[if lt IE 9]>
        <script type="text/javascript" src="js/html5.js"></script>
        <link rel="stylesheet" type="text/css" media="screen" href="css/ie.css">
        <![endif]-->
    </head>
    <body>
        <div class="main">
            <!--==============================header=================================-->
            <header>
                <h1><a href="${pageContext.request.contextPath}/home"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt=""></a></h1>
                <div class="form-search">
                    <form id="form-search" method="post">
                        <input type="text" value="Type here..." onBlur="if(this.value=='') this.value='Type here...'" onFocus="if(this.value =='Type here...' ) this.value=''"  />
                        <a href="#" onClick="document.getElementById('form-search').submit()" class="search_button"></a>
                    </form>
                </div>
                <div class="clear"></div>
                <nav class="box-shadow">
                    <div>
                        <ul class="menu">
                            <li class="home-page"><a href="${pageContext.request.contextPath}/home"><span></span></a></li>
                            <li><a href="#">About</a></li>
                            <li><a href="#">Services</a></li>
                            <li><a href="#">Projects</a></li>
                            <li><a href="#">Clients</a></li>
                            <li class="current"><a href="contacts.html">Sign In</a></li>
                        </ul>
                        <div class="social-icons">
                            <span>Follow us:</span>
                            <a href="#" class="icon-3"></a>
                            <a href="#" class="icon-2"></a>
                            <a href="#" class="icon-1"></a>
                        </div>
                        <div class="clear"></div>
                    </div>
                </nav>
            </header>
            <!--==============================content================================-->
            <section id="content">
                <div class="container_12">
                    <div class="grid_12">
                        <div class="wrap pad-3">

                            <div class="block-6" id="loginDiv">
                                <h3>Register Users, Login</h3>
                                <div id="status" align="left">
                                    <sf:form id="form" method="post" modelAttribute="loginForm">
                                        <fieldset>
                                            <label><sf:input type="text" value="User Id" onBlur="if(this.value=='') this.value='User Id'" onFocus="if(this.value =='User Id' ) this.value=''" path="userName"/></label>
                                            <label><sf:input type="password" value="Password" onBlur="if(this.value=='') this.value='Password'" onFocus="if(this.value =='Password' ) this.value=''" path="password"/></label>
                                            <div id="appHome_Ajax_Loading" class="btns" style="display:none;">
                                                <img align="absmiddle" src="resources/images/spinner.gif">&nbsp;Processing...
                                            </div>
                                            <div class="btns"><a href="#" class="button" id="signInLink">Sign In</a><a href="${pageContext.request.contextPath}/getPassword" class="button">Forgot Password ?</a></div>
                                        </fieldset>
                                    </sf:form>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </section>
        </div>
        <!--==============================footer=================================-->
        <footer>
            <p>© 2013</p>
            <p>Website by : <a href="#" target="_blank" rel="nofollow">Sai Teja Info Tech, Vijayawada</a></p>
        </footer>
    </body>
</html>