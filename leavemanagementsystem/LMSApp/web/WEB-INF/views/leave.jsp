<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Leave | Home</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/redmond/jquery-ui-1.8.23.custom.css" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/clockp.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/clockh.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ddaccordion.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskedinput.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.22.custom.min.js"></script>
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

                


                /*var date = new Date();
             var currentMonth = date.getMonth();
             var currentDate = date.getDate();
             var currentYear = date.getFullYear();*/

                /*if($("#date-picker").length > 0){
                $("#date-picker").datepicker({
                 maxDate: new Date(currentYear, currentMonth, currentDate)
             });
            }*/

                $("#date-picker").datepicker({ minDate: 0,dateFormat: 'dd-mm-yy' });
                $("#date-picker1").datepicker({ minDate: 0 ,dateFormat: 'dd-mm-yy'});



                /*$('#date-picker').datepicker( {

                    changeMonth: true,
                    changeYear: true,
                    dateFormat: 'dd-mm-yy',
                    inline: true

                });*/

                /*$('#date-picker1').datepicker( {

                    changeMonth: true,
                    changeYear: true,
                    dateFormat: 'dd-mm-yy',
                    inline: true

                });*/



                $("#dob").mask("99/99/9999");
                //$("#moblie").mask("(999) 999-9999");

                $('.ask').jConfirmAction();

                $('#submit').click(function(){
                    /*var employeeId = $('#employeeId').val();
                    var departmentName = $('#departmentName').val();
                    var fullName = $('#fullName').val();
                    var email = $('#email').val();
                    var mobile = $('#moblie').val();
                    var dob = $('#dob').val();

                    if(employeeId == null || employeeId.length == 0) {
                        alert('Employee ID is required !');
                        return false;
                    }

                    if(departmentName == null || departmentName.length == 0) {
                        alert('Department Name is required !');
                        return false;
                    }

                    if(fullName == null || fullName.length == 0) {
                        alert("Name is required");
                        return false;
                    }

                    if(dob == null || dob.length == 0) {
                        alert('Date of Birth is required !');
                        return false;
                    }

                    if ($("#staffForm :radio:checked").length == 0) {
                        alert("Gender is required !");
                        return false;
                    }


                    if(gen == 'F') {
                        var from = $('#date-picker').date();
                        var to = $('date-picker').date();

                        if(from.eq(to) == 61) {
                          alert('You r Going to Apply Matarnity Leave');
                        }
                    }

                    if(email == null || email.length == 0) {
                        alert('Email is required !');
                        return false;
                    }

                    if(mobile == null || mobile.length == 0 ){
                        alert('Mobile is required !');
                        return false;
                    }*/

                   

                    $.ajax({
                        type:'POST',
                        url:'${pageContext.request.contextPath}/leave',
                        data:$('#leaveForm').serialize(),
                        success:function(response) {
                                alert(response);
                        }

                    });

                });


                $("#perYear").click(function(){

                        $.ajax({
                            type:'GET',
                            url:'${pageContext.request.contextPath}/perYear?employeeId=${staff.employeeId}',
                            success : function(response) {
                                console.debug(response);
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

                <div class="right_header">Welcome ${staff.fullName},  | <a href="${pageContext.request.contextPath}/employeeHome" class="">Home</a> | <a href="${pageContext.request.contextPath}/logout" class="logout">Logout</a> </div>
                <div id="clock_a"></div>
            </div>

            <div class="main_content">

                <div class="menu">
                    <ul>

                        <li><a class="current" href="#">Apply Leave</a></li>
                    </ul>
                </div>
                <div class="center_content">

                   <div style="position:relative;top:50px;left:500px;width:200px;">
                    <a href="#" id ="perYear" class="menuitem">Balance Leave Per Year</a>
                   </div>

                   

                    <div class="right_content">

                        <h2>Application for Leave</h2>

                        <div class="form">
                            <div id="status" align="left">
                                <sf:form action="" id="leaveForm" class="niceform" modelAttribute="leaveForm">

                                    <fieldset>

                                        <sf:hidden path="employeeId" name="" id="employeeId" size="20" value="${staff.employeeId}"/>
                                        <dl>
                                            <dt><label for="email">Leave Requested From:</label></dt>
                                            <dd><sf:input path="fromDate" name="" id="date-picker" size="20" /></dd>
                                        </dl>


                                        <dl>
                                            <dt><label for="gender">To Date:</label></dt>
                                            <dd>
                                                <sf:input path="toDate" name="" id="date-picker1" size="20" />
                                            </dd>
                                        </dl>

                                        <dl>
                                            <dt><label for="gender">Leave Type:</label></dt>
                                            <dd>
                                                <sf:select path="leaveType" name="" id="leaveType">
                                                    <sf:option value="Casual">Casual</sf:option>
                                                    <sf:option value="Sick">Sick</sf:option>
                                                    <c:if test="${staff.gender == 'F'}">
                                                        <sf:option value="Maturnaty">Maturnaty</sf:option>
                                                    </c:if>
                                                    <sf:option value="Special">Special</sf:option>
                                                </sf:select>
                                            </dd>
                                        </dl>


                                        <dl>
                                            <dt><label for="email">Reasons for Leave:</label></dt>
                                            <dd><sf:textarea path="reasonsforLeave" name="" id="resonsForLeave" size="30" /></dd>
                                        </dl>
                                        <dl>
                                            <dt><label for="email">Contact Address:</label></dt>
                                            <dd><sf:textarea path="contactAddress" name="" id="contactAddress" size="30" /></dd>
                                        </dl>
                                        <dl>
                                            <dt><label for="email">Mobile Number:</label></dt>
                                            <dd><sf:input path="mobile" name="" id="moblie" size="30" /></dd>
                                        </dl>


                                        <dl class="submit">
                                            <input type="button" name="submit" id="submit" value="Apply" />
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