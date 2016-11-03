<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Admin | Home </title>
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
                <h1><a href="${pageContext.request.contextPath}/home"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt=""></a></h1>

                <div style="position:relative;top:0px;left:800px;width:250px;height:auto">
                    <strong>Welcome, <c:out value="${appUser.userRole}"></c:out></strong> !
                </div>



                <div class="clear"></div>
                <nav class="box-shadow">
                    <div>
                        <ul class="menu">
                            <li class="home-page"><a href="${pageContext.request.contextPath}/home"><span></span></a></li>
                           
                            <li><a href="${pageContext.request.contextPath}/reports">Reports</a></li>
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
                            <div class="block-5">
                                <h3>Admin Services</h3>
                                <ul class="list-1">
                                    <li><a href="${pageContext.request.contextPath}/createDept">Create Department</a></li>
                                    <li><a href="${pageContext.request.contextPath}/createSubject">Create Subject</a></li>
                                    <li><a href="${pageContext.request.contextPath}/faculty">Register Faculty</a></li>
                                    <li><a href="${pageContext.request.contextPath}/facultyMap">Faculty Mapping</a></li>
                                    <li><a href="${pageContext.request.contextPath}/registerStudent">Register Student</a></li>


                                </ul>
                            </div>
                            <div class="block-6">
                                <h3 class="p6"> <strong>Dash Board</strong></h3>

                                <div class="container_12">
                                    <div class="grid_12">
                                        <div class="pad-2 wrap">

                                            <div class="wrap">
                                                <div class="block-7">
                                                    <div class="wrap">
                                                        <img src="resources/images/page3-img1.png" alt="" class="img-indent">
                                                        <div class="extra-wrap">
                                                            <p><a href="#" class="link"><strong>Faculties View</strong></a></p>
                                                            <p>Update Faculty Information, Edit Name, Email and Mobile Etc.</p>
                                                        </div>
                                                    </div>
                                                    <div class="wrap top-2">
                                                        <img src="resources/images/page3-img4.png" alt="" class="img-indent">
                                                        <div class="extra-wrap">
                                                            <p><a href="#" class="link"><strong>Faculty Mapping View</strong></a></p>
                                                            <p>Change Faculty Mapping, Modify Subject, Year and Semister.</p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="block-7">
                                                    <div class="wrap">
                                                        <img src="resources/images/page3-img2.png" alt="" class="img-indent">
                                                        <div class="extra-wrap">
                                                            <p><a href="#" class="link"><strong>Subjects View</strong></a></p>
                                                            <p>List Subjects and Provides Updatation Feture.</p>
                                                        </div>
                                                    </div>
                                                    <div class="wrap top-2">
                                                        <img src="resources/images/page3-img5.png" alt="" class="img-indent">
                                                        <div class="extra-wrap">
                                                            <p><a href="#" class="link"><strong>Student View</strong></a></p>
                                                            <p>View and Update Student Information.</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
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