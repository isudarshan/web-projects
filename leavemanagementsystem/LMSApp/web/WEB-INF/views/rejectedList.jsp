<%@page import="java.util.*,com.lms.domain.sub.*;" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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




            });

        </script>

        <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/niceforms.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/resources/css/niceforms-default.css" />
    </head>
    <body>

        <%
        Map<String, String> map = (Map) request.getSession().getAttribute("map");
        List<StaffLeave> list = (List) request.getSession().getAttribute("staffLeaveList");
        %>
        <div id="main_container">

            <div class="header">
                <div class="logo"><a href="#"><img src="resources/images/logo.gif" alt="" title="" border="0" /></a></div>

                <div class="right_header">Welcome Admin,  | <a href="${pageContext.request.contextPath}/logout" class="logout">Logout</a></div>
                <div id="clock_a"></div>
            </div>

            <div class="main_content">

                <div class="menu">
                    <ul>
                        <li><a class="current" href="${pageContext.request.contextPath}/admin">Admin Home</a></li>
                        <li><a href="list.html">Leave Requests<!--[if IE 7]><!--></a><!--<![endif]-->
                    <!--[if lte IE 6]><table><tr><td><![endif]-->
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/leaveView" title="">Applied Leaves</a></li>
                                <li><a href="${pageContext.request.contextPath}/approvedList" title="">Approved Leave Requests</a></li>
                                <li><a href="" title="">Rejected Leave Requests</a></li>

                            </ul>
                            <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                        </li>

                    </ul>
                </div>
                <div class="center_content">

                    <div class="left_content">

                        <div class="sidebar_search">
                            <form>
                                <input type="text" name="" class="search_input" value="search keyword" onclick="this.value=''" />
                                <input type="image" class="search_submit" src="resources/images/search.png" />
                            </form>
                        </div>

                        <div class="sidebarmenu">

                            <a class="menuitem" href="${pageContext.request.contextPath}/changePassword">Change Password</a>



                        </div>


                    </div>

                    <div class="right_content">

                        <h2>Rejected Staff Leave Details</h2>


                        <table id="rounded-corner" summary="2007 Major IT Companies' Profit">
                            <thead>
                                <tr>
                                    <th scope="col" class="rounded-company"></th>
                                    <th scope="col" class="rounded">Employee Id</th>
                                    <th scope="col" class="rounded">Name</th>
                                    <th scope="col" class="rounded">Leave TO Date</th>
                                    <th scope="col" class="rounded">Leave From Date</th>
                                    <th scope="col" class="rounded">Leave Type</th>
                                    <th scope="col" class="rounded">Mobile</th>
                                    <th scope="col" class="rounded">No.Of.days</th>

                                </tr>
                            </thead>
                            <tfoot>
                                <tr>



                                </tr>
                            </tfoot>
                            <tbody>
                                <%
        for (StaffLeave staffLeave : list) {

            if (staffLeave.getActive() == 2) {
                                %>
                                <tr>
                                    <td></td>


                                    <td><%=staffLeave.getEmployeeId()%></td>
                                    <td><%=map.get(staffLeave.getEmployeeId())%></td>
                                    <td><%=staffLeave.getLeaveStart()%></td>
                                    <td><%=staffLeave.getLeaveEnd()%></td>
                                    <td><%=staffLeave.getType()%></td>
                                    <td><%=staffLeave.getMobile()%></td>
                                    <td><%=staffLeave.getLeaveCount()%></td>




                                </tr>
                                <%
            }
        }
                                %>
                            </tbody>
                        </table>









                    </div><!-- end of right content-->


                </div>   <!--end of center content -->




                <div class="clear"></div>
            </div> <!--end of main content-->


            <div class="footer">

                <div class="left_footer">IN ADMIN PANEL | Powered by <a href="http://indeziner.com">INDEZINER</a></div>
                <div class="right_footer"><a href="http://indeziner.com"><img src="resources/images/indeziner_logo.gif" alt="" title="" border="0" /></a></div>

            </div>

        </div>
    </body>
</html>