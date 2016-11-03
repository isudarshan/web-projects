<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Create Faculty</title>
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
                    $("#createFaculty").click(function(){                       
                        $.ajax({
                            type:'POST',
                            url:'${pageContext.request.contextPath}/faculty',
                            data:$('#form').serialize(),
                            success:function(response){
                                alert(response);
                            }

                        });


                    });


            });

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

                <div style="position:relative;top:0px;left:800px;width:250px;height:auto">
                    <strong>Welcome, <c:out value="${appUser.userRole}"></c:out></strong> !
                </div>



                <div class="clear"></div>
                <nav class="box-shadow">
                    <div>
                        <ul class="menu">
                            <li class="home-page" class="current"><a href="${pageContext.request.contextPath}/admin"><span></span></a></li>
                           
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
                        <li><a href="#">Register Student</a></li>


                    </ul>
                            </div>
                            <div class="block-6">
                                <h3 class="p6"> <strong>Create Faculty</strong></h3>

                                <sf:form id="form" method="post" modelAttribute="facultyForm" >
                                    <fieldset>
                                        <label><sf:input type="text" value="Faculty Name" onBlur="if(this.value=='') this.value='Faculty Name'" onFocus="if(this.value =='Faculty Name' ) this.value=''" path="facultyName"/></label>
                                        <label><sf:input type="text" value="Email" onBlur="if(this.value=='') this.value='Email'" onFocus="if(this.value =='Email' ) this.value=''" path="email"/></label>
                                        <label><sf:input type="text" value="Mobile" onBlur="if(this.value=='') this.value='Mobile'" onFocus="if(this.value =='Mobile' ) this.value=''" path="mobile"/></label>
                                        <label><sf:select path="departmentName">
                                                <sf:option value="Department">Department</sf:option>
                                                <c:forEach var="dept" items="${departments}">
                                                    <sf:option value="${dept.departmentName}">${dept.departmentName}</sf:option>
                                                </c:forEach>

                                            </sf:select>

                                        </label>                                        

                                        <div class="btns"><a href="#" class="button" id="createFaculty">Create</a></div>
                                    </fieldset>
                                </sf:form>


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