<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Admin | Reports </title>
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


// TO do for MBA. Two Years. ( Change Controller) 

                $("#departmentName").change(function(){

                    var departmentName = $("#departmentName").val();

                    if(departmentName == 'Master of Computer Applications') {
                        
                        $("#year").empty();
                        $('<option selected=selected>').val('Select Year').text('Select Year').appendTo(year);
                        $('<option>').val('Year - I').text('Year - I').appendTo(year);
                        $('<option>').val('Year - II').text('Year - II').appendTo(year);
                        $('<option>').val('Year - III').text('Year - III').appendTo(year);
                    }else {
                        $("#year").empty();
                        $('<option selected=selected>').val('Select Year').text('Select Year').appendTo(year);
                        $('<option>').val('Year - I').text('Year - I').appendTo(year);
                        $('<option>').val('Year - II').text('Year - II').appendTo(year);
                        $('<option>').val('Year - III').text('Year - III').appendTo(year);
                        $('<option>').val('Year - IV').text('Year - IV').appendTo(year);
                    }
                });



                // Year Change Function


                $("#year").change(function(){
                    var year = $("#year").val();

                    if(year == 'Year - I') {
                        $("#semValue").empty();
                        $('<option selected=selected>').val('Select Semister').text('Select Semister').appendTo(semValue);
                        $('<option>').val(1).text('Semister - I').appendTo(semValue);
                        $('<option>').val(2).text('Semister - II').appendTo(semValue);
                    }else if(year == 'Year - II') {
                        $("#semValue").empty();
                        $('<option selected=selected>').val('Select Semister').text('Select Semister').appendTo(semValue);
                        $('<option>').val(3).text('Semister - III').appendTo(semValue);
                        $('<option>').val(4).text('Semister - IV').appendTo(semValue);
                    }else if(year == 'Year - III') {
                        $("#semValue").empty();
                        $('<option selected=selected>').val('Select Semister').text('Select Semister').appendTo(semValue);
                        $('<option>').val(5).text('Semister - V').appendTo(semValue);
                        $('<option>').val(6).text('Semister - VI').appendTo(semValue);
                    }else if(year == 'Year - IV') {
                        $("#semValue").empty();
                        $('<option selected=selected>').val('Select Semister').text('Select Semister').appendTo(semValue);
                        $('<option>').val(5).text('Semister - VII').appendTo(semValue);
                        $('<option>').val(6).text('Semister - VIII').appendTo(semValue);
                    }

                });


                // Get Subject List using AJAX


                $("#semValue").change(function(){
                    var year = $("#year").val();
                    var departmentName = $("#departmentName").val();
                    var semValue = $("#semValue").val();
                    
                    $.ajax({
                        type:'GET',
                        url:'${pageContext.request.contextPath}/facultyMap',
                        data:'departmentName='+departmentName+'&year='+year+'&semValue='+semValue,
                        dataType:'json',
                        success : function(response) {
                            var $select = $('#subject');
                            $select.find('option').remove();
                            $('<option selected=selected>').val(0).text('Select Subject').appendTo($select);
                            $.each(response, function(key, value) {                             
                               
                                $('<option>').val(value).text(value).appendTo($select);
                            });

                        }



                    });

                });

                   // Subject Change

                $("#subject").change(function(){
                     
                     var year = $("#year").val();
                    var departmentName = $("#departmentName").val();
                    var semValue = $("#semValue").val();
                    var subject = $("#subject").val();
                    var $facultyName = $("#facultyName")
                    //alert(year+departmentName+semValue+subjectName);

                       $.ajax({
                        type:'GET',
                        url:'${pageContext.request.contextPath}/facultyMap',
                        data:'departmentName='+departmentName+'&year='+year+'&semValue='+semValue+'&subject='+subject,
                        
                        success : function(response) {                            
                            $facultyName.find('option').remove();
                            
                            $('<option>').val(response).text(response).appendTo($facultyName);
                            

                        }

                    });



                });

                // Create Map

               

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
                <h1><a href="${pageContext.request.contextPath}/adminHome"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt=""></a></h1>

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
                                <c:if test="${not empty msg}">
                                    <h4><font color="red">${msg}</font></h4>
                                </c:if>


                                <h3 class="p6"> <strong>Select Parameters to Genarate Report</strong></h3>

                                <div class="container_12">
                                    <div class="grid_12">
                                        <div class="pad-2 wrap">

                                            <div class="wrap">

                                                <sf:form id="form" method="post" modelAttribute="facultyMapForm" >
                                    <fieldset>

                                        <label><sf:select path="departmentName" id="departmentName">
                                                <sf:option value="Department">Department</sf:option>
                                                <c:forEach var="dept" items="${departments}">
                                                    <sf:option value="${dept.departmentName}">${dept.departmentName}</sf:option>
                                                </c:forEach>

                                            </sf:select>

                                        </label>
                                        <label><sf:select path="year" id="year">
                                                <sf:option value="Select Year">Select Year</sf:option>

                                            </sf:select>

                                        </label>
                                        <label><sf:select path="semister" id="semValue">
                                                <sf:option value="Select Semister" seleceted="selected" >Select Semister</sf:option>

                                            </sf:select>

                                        </label>
                                        <label><sf:select path="subject" id="subject">
                                                


                                            </sf:select>

                                        </label>
                                        <label><sf:select path="facultyName" id="facultyName">
                                                
                                                <sf:option value="Select Faculty Name">Select Faculty Name</sf:option>

                                            </sf:select>

                                        </label>

                                        
                                    </fieldset>
                                    <input type="submit" id="genarateReport" class="customButton" value="Genarate Report"/>
                                </sf:form>
                                                
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