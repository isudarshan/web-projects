<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>IN ADMIN PANEL | Powered by Sai Teja Infotech</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/clockp.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/clockh.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ddaccordion.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskedinput.min.js"></script>
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
                //$("#dob").mask("99/99/9999");
                //$("#moblie").mask("(999) 999-9999");

                $('.ask').jConfirmAction();

                $('#submit').click(function(){
                    var employeeId = $('#employeeId').val();
                    var question = $('#question').val();
                    var answer = $('#answer').val();


                    if(employeeId == null || employeeId.length == 0) {
                        alert('Employee ID is required !');
                        return false;
                    }

                    if(question == null || question.length == 0) {
                        alert('Question is required !');
                        return false;
                    }

                    if(answer == null || answer.length == 0) {
                        alert("Answer is required");
                        return false;
                    }



                    $('#appHome_Ajax_Loading').show();

                    $.ajax({
                        type:'POST',
                        url:'${pageContext.request.contextPath}/security',
                        data:$('#securityForm').serialize(),
                        success:function(response) {

                                $('#appHome_Ajax_Loading').hide();
                                alert(response);
                        }

                    });

                });

            });

        </script>

        <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/niceforms.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/resources/css/niceforms-default.css" />
    </head>
    <body>
        <div id="main_container">

            <div class="header">
                <div class="logo"><a href="#"><img src="resources/images/logo.gif" alt="" title="" border="0" /></a></div>

                <div class="right_header">Setup Security Question | <a href="${pageContext.request.contextPath}/employeeHome" class="">Home</a></div>
                <div id="clock_a"></div>
            </div>

            <div class="main_content">

                <div class="menu">
                    <ul>

                    </ul>
                </div>
                <div class="center_content">

                    <div class="right_content">

                        <h2>Setup Security Question</h2>

                        <div class="form">
                            <div id="status" align="left">
                                <sf:form action="" id="securityForm" class="niceform" modelAttribute="securityForm">

                                    <fieldset>
                                        <dl>
                                            <dt><label for="email">Employee ID/User Name:</label></dt>
                                            <dd><sf:input path="employeeId" name="" id="employeeId" size="20" value="${staff.employeeId}" /></dd>
                                        </dl>


                                        <dl>
                                            <dt><label for="gender">Security Question:</label></dt>
                                            <dd>
                                                <sf:select size="1" name="question" id="question" path="question">
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

                                                </sf:select>
                                            </dd>
                                        </dl>

                                        <dl>
                                            <dt><label for="email">Answer:</label></dt>
                                            <dd><sf:input path="answer" name="" id="answer" size="54" /></dd>
                                        </dl>


                                        <dl class="submit">
                                            <input type="button" name="submit" id="submit" value="Submit" />
                                        </dl>

                                        <div id="appHome_Ajax_Loading"  style="position:relative; left:300px;width:100px; display:none;">
                                            <img align="absmiddle" src="resources/images/spinner.gif">&nbsp;Processing...
                                        </div>

                                    </fieldset>

                                </sf:form>
                            </div>
                        </div>


                    </div><!-- end of right content-->


                </div>   <!--end of center content -->




                <div class="clear"></div>
            </div> <!--end of main content-->


            <div class="footer">

                <div class="left_footer">IN ADMIN PANEL | Powered by <a href="#">INDEZINER</a></div>
                <div class="right_footer"><a href="http://indeziner.com"><img src="" alt="" title="" border="0" /></a></div>

            </div>

        </div>
    </body>

</html>