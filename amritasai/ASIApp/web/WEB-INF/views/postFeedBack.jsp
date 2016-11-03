<%@page  import="java.util.*,com.asiapp.domain.sub.Subject;" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Student | Post FeedBack </title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/reset.css">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/style.css">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/grid_12.css">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/slider.css">
        <link href='http://fonts.googleapis.com/css?family=Condiment' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.js"></script>
        <style>
            th {
                background-color: #EEEEEE;
                border: 1px solid #CCCCCC;
                color: #555555;
                padding: 3px;
                text-align: center;
            }

            table {
                border-collapse: collapse;
                border-spacing: 0;
            }

            td {
                border: 1px solid #CCCCCC;
                padding: 1px 1px;
                vertical-align: top;
            }

            caption {
                text-align: center;
                background-color: #EFEFEF;
                border: 1px solid #CCCCCC;
                border-bottom: none;
                font-weight: bold;
                padding: 2px;
            }
        </style>

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
        <%
        Map<String, String> map = (Map) request.getSession().getAttribute("map");
        List<Subject> subjectList = (List) request.getSession().getAttribute("subjectList");
        int cols = map.size();
        %>

        <div class="main">
            <!--==============================header=================================-->
            <header>
                <h1><a href="${pageContext.request.contextPath}/home"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt=""></a></h1>

                <div style="position:relative;top:0px;left:800px;width:250px;height:auto">
                    <strong>Welcome, <c:out value="${student.lastName} ${student.firstName}"></c:out></strong> !
                </div>



                <div class="clear"></div>
                <nav class="box-shadow">
                    <div>
                        <ul class="menu">
                            <li class="home-page"><a href="${pageContext.request.contextPath}/home"><span></span></a></li>

                            <li><a href="#">Change Password</a></li>
                            <li><a href="${pageContext.request.contextPath}/postFeedBack">Post FeedBack</a></li>
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


                            <form>
                                <table>
                                    <caption>FeedBack for Department : ${student.departmentName}, ${student.year}, Semister : ${student.semister} <br/>Dated on : <%=new java.util.Date()%></caption>


                                    <tr>
                                        <th>Parameters</th>


                                        <%
        for (Subject subject : subjectList) {
                                        %>
                                        <th><%=subject.getSubjectName()%> <br/>( <%=map.get((Object) subject.getSubjectName())%> ) <input type="hidden" name ="fname" value="<%=map.get((Object) subject.getSubjectName())%>"> <input type="hidden" name ="subject" value="<%=subject.getSubjectName()%>"></th>


                                        <%
        }
                                        %>
                                        



                                    </tr>

                                    <tr>
                                        <th>Punctuality</th>
                                        <%
        for (int i = 0; i < subjectList.size(); i++) {
            Subject subject = subjectList.get(i);
                                        %>
                                        <th>Average&nbsp;&nbsp;<input type="radio" name="<%=i%>"/> <br/> Good&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="<%=i%>"/>  <br/>Excellent <input type="radio" name="<%=i%>"/></th>
                                        <%        }
                                        %>
                                    </tr>
                                    <tr>
                                        <th>Communication Skills</th>
                                        <%
        for (int i = 0; i < subjectList.size(); i++) {
            Subject subject = subjectList.get(i);
                                        %>
                                        <th>Average&nbsp;&nbsp;<input type="radio" name="<%=subject.getSubjectName() + map.get((Object) subject.getSubjectName())%>"/> <br/> Good&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="<%=subject.getSubjectName() + map.get((Object) subject.getSubjectName())%>"/>  <br/>Excellent <input type="radio" name="<%=subject.getSubjectName() + map.get((Object) subject.getSubjectName())%>"/></th>
                                        <%        }
                                        %>
                                    </tr>

                                    <tr>
                                        <th>Class Command</th>
                                        <%
        for (int i = 0; i < subjectList.size(); i++) {
                                        %>
                                        <th>Average&nbsp;&nbsp;<input type="radio"/> <br/> Good&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"/>  <br/>Excellent <input type="radio"/></th>
                                        <%        }
                                        %>
                                    </tr>

                                    <tr>
                                        <th>Doubts Clearance</th>
                                        <%
        for (int i = 0; i < subjectList.size(); i++) {
                                        %>
                                        <th>Average&nbsp;&nbsp;<input type="radio"/> <br/> Good&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"/>  <br/>Excellent <input type="radio"/></th>
                                        <%        }
                                        %>
                                    </tr>
                                    <tr>
                                        <th>Subject Depth</th>
                                        <%
        for (int i = 0; i < subjectList.size(); i++) {
                                        %>
                                        <th>Average&nbsp;&nbsp;<input type="radio"/> <br/> Good&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"/>  <br/>Excellent <input type="radio"/></th>
                                        <%        }
                                        %>
                                    </tr>

                                    <tr>
                                        <th>Board Usage</th>
                                        <%
        for (int i = 0; i < subjectList.size(); i++) {
                                        %>
                                        <th>Average&nbsp;&nbsp;<input type="radio"/> <br/> Good&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"/>  <br/>Excellent <input type="radio"/></th>
                                        <%        }
                                        %>
                                    </tr>

                                </table>

                                <div class="btns"><a href="#" class="button" id="postFeedback">Post FeedBack</a></div>

                            </form>

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