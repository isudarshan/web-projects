<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Get Password</title>
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

                $("#submit").click(function(){
                   

                    var answer = $("#answer").val();
                    var studentId = $("#studentId").val();
                    if(studentId == null || studentId.length == 0) {
                        alert('Student Id is required !');
                        return false;
                    }
                    if(answer == null || answer.length == 0) {
                        alert('Answer is required !');
                        return false;
                    }

                     $('#appHome_Ajax_Loading').show();

                    $.ajax({
                        type:'POST',
                        url:'${pageContext.request.contextPath}/getPassword',
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
                <h1><a href="${pageContext.request.contextPath}/home"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt=""></a></h1>




                <div class="clear"></div>
                <nav class="box-shadow">
                    <div>
                        <ul class="menu">
                            <li class="home-page" class="current"><a href="${pageContext.request.contextPath}/home"><span></span></a></li>

                            <li><a href="${pageContext.request.contextPath}/getPassword">Forgot Password ?</a></li>

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
                                <h3 class="p6"> <strong>Get Your Password</strong></h3>
                                <div id="status" align="left">
                                    <sf:form id="form" method="post" modelAttribute="getPasswordForm" class="myForm2">
                                        <fieldset>

                                            Registration Number<label><sf:input type="text"  path="studentId" id="studentId"/></label>
                                            Security Question<label><sf:select path="question">

                                                    <sf:option value="What was your childhood nickname?">What was your childhood nickname?</sf:option>
                                                    <sf:option value="In what city did you meet your spouse/significant other?">In what city did you meet your spouse/significant other?</sf:option>
                                                    <sf:option value="What is the name of your favorite childhood friend?">What is the name of your favorite childhood friend?</sf:option>
                                                    <sf:option value="What street did you live on in third grade?">What street did you live on in third grade?</sf:option>
                                                    <sf:option value="What is your oldest sibling birthday month and year?">What is your oldest sibling birthday month and year?</sf:option>
                                                    <sf:option value="What is the middle name of your oldest child?">What is the middle name of your oldest child?</sf:option>
                                                    <sf:option value="What is your oldest sibling middle name?">What is your oldest sibling middle name?</sf:option>
                                                    <sf:option value="What school did you attend for sixth grade?">What school did you attend for sixth grade?</sf:option>
                                                    <sf:option value="What was your childhood phone number including area code?">What was your childhood phone number including area code?</sf:option>
                                                    <sf:option value="What is your oldest cousin first and last name?">What is your oldest cousin first and last name?</sf:option>
                                            </sf:select></label>
                                            Answer<label><sf:input type="text" path="answer" id="answer"/></label>


                                            <div id="appHome_Ajax_Loading" class="btns" style="display:none;">
                                                <img align="absmiddle" src="resources/images/spinner.gif">&nbsp;Processing...
                                            </div>
                                            <div class="btns"><a href="#" class="button" id="submit">Submit</a></div>
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