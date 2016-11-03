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
                $("#dob").mask("99/99/9999");
                //$("#moblie").mask("(999) 999-9999");

                $('.ask').jConfirmAction();

                $('#submit').click(function(){
                    var employeeId = $('#employeeId').val();
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

                    if(email == null || email.length == 0) {
                        alert('Email is required !');
                        return false;
                    }

                    if(mobile == null || mobile.length == 0 ){
                        alert('Mobile is required !');
                        return false;
                    }

                    $('#appHome_Ajax_Loading').show();

                    $.ajax({
                        type:'POST',
                        url:'${pageContext.request.contextPath}/addStaff',
                        data:$('#staffForm').serialize(),
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

                <div class="right_header">Welcome Admin,  | <a href="${pageContext.request.contextPath}/admin" class="">Home</a> | <a href="${pageContext.request.contextPath}/logout" class="logout">Logout</a> </div>
                <div id="clock_a"></div>
            </div>

            <div class="main_content">

                <div class="menu">
                    <ul>
                        <li><a class="current" href="#">Add Staff</a></li>
                    </ul>
                </div>
                <div class="center_content">

                    <div class="right_content">

                        <h2>Staff Member Creation</h2>

                        <div class="form">
                            <div id="status" align="left">
                                <sf:form action="" id="staffForm" class="niceform" modelAttribute="stafForm">

                                    <fieldset>
                                        <dl>
                                            <dt><label for="email">Employee ID:</label></dt>
                                            <dd><sf:input path="employeeId" name="" id="employeeId" size="20" /></dd>
                                        </dl>


                                        <dl>
                                            <dt><label for="gender">Select Department:</label></dt>
                                            <dd>
                                                <sf:select size="1" name="gender" id="departmentName" path="departmentName">

                                                    <c:forEach items="${departmentList}" var="dept">
                                                        <sf:option value="${dept.departmentName}">${dept.departmentName}</sf:option>
                                                    </c:forEach>

                                                </sf:select>
                                            </dd>
                                        </dl>

                                        <dl>
                                            <dt><label for="email">Employee Full Name:</label></dt>
                                            <dd><sf:input path="fullName" name="" id="fullName" size="54" /></dd>
                                        </dl>
                                        <dl>
                                            <dt><label for="email">Date of Birth(DD/MM/YYYY):</label></dt>
                                            <dd><sf:input path="dateOfBirth" name="" id="dob" size="20" /></dd>
                                        </dl>
                                        <dl>
                                            <dt><label for="color">Select Gender</label></dt>
                                            <dd>
                                                <sf:radiobutton path="gender" value="M" /><label class="check_label">Male</label>
                                                <sf:radiobutton path="gender" value="F" /><label class="check_label">Female</label>

                                            </dd>
                                        </dl>

                                        <dl>
                                            <dt><label for="email">E-Mail:</label></dt>
                                            <dd><sf:input path="email" name="" id="email" size="54" /></dd>
                                        </dl>
                                        <dl>
                                            <dt><label for="email">Mobile Number:</label></dt>
                                            <dd><sf:input path="mobile" name="" id="moblie" size="30" /></dd>
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