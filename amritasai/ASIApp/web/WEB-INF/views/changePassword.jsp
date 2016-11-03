<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Change Passwordt</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/reset.css">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/style.css">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/grid_12.css">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/slider.css">
        <link href='http://fonts.googleapis.com/css?family=Condiment' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.js"></script>

        <script>


            $(document).ready(function(){

                $("#changePassword").click(function(){
                    $('#appHome_Ajax_Loading').show();
                    
                    var studentId = $("#studentId").val();
                    var currentPassword = $("#currentPassword").val();
                    var newPassword = $("#newPassword").val();
                    var confirmPassword = $("#confirmPassword").val();


                    if(studentId == 'Regd No' || studentId == null || studentId.length == 0) {
                        alert('Student Id is required !');
                        return false;
                    }

                    if(currentPassword == null || currentPassword.length == 0) {
                        alert('Current Password is required !');
                        return false;
                    }

                    if(newPassword == null || newPassword.length == 0) {
                        alert('New Password is required !');
                        return false;
                    }

                    if(confirmPassword == null || confirmPassword.length == 0) {
                        alert('You must Confirm the Password !');
                        return false;
                    }


                    if(confirmPassword!=newPassword) {
                        alert('New Password & Confirm Password did not Matched !');
                        return;
                    }

                    $.ajax({
                        type:'POST',
                        url:'${pageContext.request.contextPath}/changePassword',
                        data:$('#form').serialize(),
                        success: function(response) {
                            res = response;

                            $("#status").ajaxComplete(function(event,request,settings) {

                                $('#appHome_Ajax_Loading').hide();
                                alert(res);

                            });

                        }

                    });


                });

                });


        </script>


    </head>
    <body>
        <div class="main">
            <!--==============================header=================================-->
            <header>
                <h1><a href="${pageContext.request.contextPath}/studentHome"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt=""></a></h1>

                <div style="position:relative;top:0px;left:800px;width:250px;height:auto">
                    <strong>Welcome, <c:out value="${student.lastName} ${student.firstName}"></c:out></strong> !
                </div>



                <div class="clear"></div>
                <nav class="box-shadow">
                    <div>
                        <ul class="menu">
                            <li class="home-page" class="current"><a href="${pageContext.request.contextPath}/studentHome"><span></span></a></li>

                            <li><a href="${pageContext.request.contextPath}/changePassword">Change Password</a></li>
                            <li><a href="${pageContext.request.contextPath}/signout">Signout</a></li>
                        </ul>

                        <div class="clear"></div>
                    </div>
                </nav>
            </header>
            <!--==============================content================================-->
            <section id="content">
                <div class="container_12">
                    <div class="grid_12">
                        <div class="wrap pad-3">


                            <div class="custom">
                                <h3 class="p6"> <strong>Change Password</strong></h3>
                                <div id="status" align="left">
                                <sf:form id="form" method="post" modelAttribute="changePasswordForm" class="myForm2">
                                    <fieldset>

                                        Registration Number<label><sf:input type="text"  path="studentId" id="studentId" value="${student.studentId}" readonly="true"/></label>
                                        Current Password<label><sf:input type="password" path="currentPassword" id="currentPassword"/></label>
                                        New Password<label><sf:input type="password" path="newPassword" id="newPassword"/></label>
                                        Confirm Password<label><sf:input type="password" path="confirmPassword" id="confirmPassword"/></label>

                                        <div id="appHome_Ajax_Loading" class="btns" style="display:none;">
                                            <img align="absmiddle" src="resources/images/spinner.gif">&nbsp;Processing...
                                        </div>
                                        <div class="btns"><a href="#" class="button" id="changePassword">Change Password</a></div>
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