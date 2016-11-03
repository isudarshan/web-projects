<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Student | Home </title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/reset.css">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/style.css">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/grid_12.css">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/slider.css">
        <link href='http://fonts.googleapis.com/css?family=Condiment' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.js"></script>

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
                <h1><a href="${pageContext.request.contextPath}/studentHome"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt=""></a></h1>

                <div style="position:relative;top:0px;left:800px;width:250px;height:auto">
                    <strong>Welcome, <c:out value="${student.lastName} ${student.firstName}"></c:out></strong> !
                </div>



                <div class="clear"></div>
                <nav class="box-shadow">
                    <div>
                        <ul class="menu">
                            <li class="home-page"><a href="${pageContext.request.contextPath}/studentHome"><span></span></a></li>
                            <li><a href="${pageContext.request.contextPath}/security">Setup Security Question</a></li>
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

                            <c:if test="${not empty msg}">
                                <h4 align="center"><font color="green">${msg}</font></h4><br/>
                            </c:if>

                            <c:if test="${not empty successMsg}">
                                <h4 align="center"><font color="green">${successMsg}</font></h4><br/>
                            </c:if>

                            <div class="block-5">
                                <h3 class="p5">Profile</h3>
                                <!--
                                <div class="map img-border">


                                </div>-->
                                <dl>
                                    <dt>Branch : ${student.departmentName} <br>Year : ${student.year}<br/> Semister : ${student.semister}</dt>
                                    <dd><span>First Name: </span>${student.lastName}</dd>
                                    <dd><span>Last Name: </span>${student.firstName}</dd>
                                    <dd><span>Mobile: </span>${student.mobile}</dd>
                                    <dd><span>E-mail: </span><a href="#" class="link">${student.email}</a></dd>
                                </dl>
                            </div>

                            <div class="block-6">
                                <h4>Subjects in Current Semister (Click Subject to Give FeedBack)</h4>
                                <ul class="list-1">

                                    <c:forEach items="${subjectList}" var="subject">
                                    <li><a href="${pageContext.request.contextPath}/feedback?subjectName=${subject.subjectName}">${subject.subjectName} ( ${subject.subjectCode} )</a></li>
                                    </c:forEach>
                                </ul>
                                
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