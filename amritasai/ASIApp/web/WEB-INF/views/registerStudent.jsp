<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Register Student</title>
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

            var email = null;
            var mobile= null;
            $(document).ready(function(){


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

                $("#register").click(function(){

                    var studentId = $("#studentId").val();
                    var firstName = $("#firstName").val();
                    var lastName = $("#lastName").val();
                    email = $("#email").val();
                    mobile = $("#mobile").val();
                    var address = $("#address").val();

                    if(studentId == 'Regd No' || studentId == null || studentId.length == 0) {
                        alert('Student Id is required !');
                        return false;
                    }

                    if(firstName == 'First Name' || firstName == null || firstName.length == 0) {
                        alert('First Name is required !');
                        return false;
                    }

                    if(lastName == 'Last Name' || lastName == null || lastName.length == 0) {
                        alert('Last Name is required !');
                        return false;
                    }

                    if(email == 'Email' || email == null || email.length == 0) {
                        alert('Email is reuired !');
                        return false;
                    }

                    if(IsEmail(email)==false){
                        alert('Invalid E-Mail !')
                        return false;
                    }

                    if(mobile == 'Mobile' || mobile == null || mobile.length == 0) {
                        alert('Mobile Number is required !');
                        return false;
                    }

                   

                    if(address == null || address.length == 0) {
                        alert('Address is required !');
                        return false;
                    }

                    $('#appHome_Ajax_Loading').show();

                    $.post($(".myForm1").attr("${pageContext.request.contextPath}/registerStudent"), $(".myForm1").serialize()+','+$(".myForm2").serialize(),

                    function(response) {
                        $('#appHome_Ajax_Loading').hide();
                        alert(response);
                    });


                });


            });

            function IsEmail(email) {
                var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
                if(!regex.test(email)) {
                    return false;
                }else{
                    return true;
                }
            }

            /*function isMobile(mobile) {
                var regex = "^[0-9]{10}";
                if(!regex.test(mobile)) {
                    return false;
                }else {
                    return true;
                }
            }*/

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


                            <div class="custom">
                                <h3 class="p6"> <strong>Student Department Deatils</strong></h3>

                                <sf:form id="form" method="post" modelAttribute="studentForm" class="myForm1" >
                                    <fieldset>

                                        <label><sf:select path="departmentName">
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

                                            </sf:select>

                                        </label>
                                        <label><sf:hidden path="subject" id="subject" value="subject"/>
                                                

                                            
                                        </label>

                                    </fieldset>
                                </sf:form>


                            </div>


                            <div class="custom">
                                <h3 class="p6"> <strong>Student Deatails</strong></h3>

                                <sf:form id="form" method="post" modelAttribute="studentForm" class="myForm2">
                                    <fieldset>

                                        <label><sf:input type="text" value="Regd No" onBlur="if(this.value=='') this.value='Regd No'" onFocus="if(this.value =='Regd No' ) this.value=''" path="studentId" id="studentId"/></label>
                                        <label><sf:input type="text" value="First Name" onBlur="if(this.value=='') this.value='First Name'" onFocus="if(this.value =='First Name' ) this.value=''" path="firstName" id="firstName"/></label>
                                        <label><sf:input type="text" value="Last Name" onBlur="if(this.value=='') this.value='Last Name'" onFocus="if(this.value =='Last Name' ) this.value=''" path="lastName" id="lastName"/></label>
                                        <label><sf:input type="text" value="E-Mail" onBlur="if(this.value=='') this.value='E-Mail'" onFocus="if(this.value =='E-Mail' ) this.value=''" path="email" id="email"/></label>
                                        <label><sf:input type="text" value="Mobile" onBlur="if(this.value=='') this.value='Mobile'" onFocus="if(this.value =='Mobile' ) this.value=''" path="mobile" id="mobile"/></label>
                                        <label><sf:textarea value = "Address" onBlur="if(this.value==''){this.value='Address'}" onFocus="if(this.value=='Address'){this.value=''}" path="address" id="address"/></label>

                                        <div id="appHome_Ajax_Loading" class="btns" style="display:none;">
                                                <img align="absmiddle" src="resources/images/spinner.gif">&nbsp;Processing...
                                            </div>
                                        <div class="btns"><a href="#" class="button" id="register">Register</a></div>
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