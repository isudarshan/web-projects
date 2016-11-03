<%@taglib  prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <title>
            Select Year, Branch, Semister &amp; Branch.
        </title>

        <!-- Meta Tags -->
        <meta charset="utf-8">
        <meta name="generator" content="Wufoo">
        <meta name="robots" content="index, follow">

        <!-- CSS -->
        <link href="${pageContext.request.contextPath}/resources/css/structure.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/form.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/theme.css" rel="stylesheet">

        <!-- JavaScript -->
        <script src="${pageContext.request.contextPath}/resources/scripts/wufoo.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery-1.8.2.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function(){

                $("#sleectionForPost").submit(function(){
                    var year = $("#year").val();
                    var semValue = $("#semValue").val();
                    var branch = $("#branch").val();
                    var paper = $("#paper").val();

                    console.debug(year+' '+semValue+' '+branch+' '+paper);

                    if(year == 0 || year == null || semValue == 0 || semvalue == null || branch == 0 || branch == null || paper == 0 || paper == null) {
                        alert('Inavalid Selection');
                        return false;
                    }


                });

                $("#year").change(function(){
                    var year = $("#year").val();

                    if(year == 1) {
                        $("#semValue").empty();
                        $('<option selected=selected>').val(0).text('Select Semister').appendTo(semValue);
                        $('<option>').val(1).text('Semister - I').appendTo(semValue);
                        $('<option>').val(2).text('Semister - II').appendTo(semValue);
                    }else if(year == 2) {
                        $("#semValue").empty();
                        $('<option selected=selected>').val(0).text('Select Semister').appendTo(semValue);
                        $('<option>').val(3).text('Semister - III').appendTo(semValue);
                        $('<option>').val(4).text('Semister - IV').appendTo(semValue);
                    }else if(year == 3) {
                        $("#semValue").empty();
                        $('<option selected=selected>').val(0).text('Select Semister').appendTo(semValue);
                        $('<option>').val(5).text('Semister - V').appendTo(semValue);
                        $('<option>').val(6).text('Semister - VI').appendTo(semValue);
                    }

                });

                $("#semValue").change(function(){
                    var year = $("#year").val();
                    var branch = $("#branch").val();
                    var semValue = $("#semValue").val();

                    $.ajax({
                        type:'GET',
                        url:'${pageContext.request.contextPath}/params',
                        data:'year='+year+'&branch='+branch+'&semValue='+semValue,
                        dataType:'json',
                        success : function(response) {
                            var $select = $('#paper');
                            $select.find('option').remove();

                            $.each(response, function(key, value) {
                                $('<option selected=selected>').val(0).text('Select Semister').appendTo(semValue);
                                $('<option>').val(value).text(value).appendTo($select);
                            });

                        }


                    });

                });

            });

        </script>



    </head>

    <body id="public">
        <div id="container" class="ltr">

            <h1 id="logo">
                <a>Wufoo</a>
            </h1>

            <sf:form id="sleectionForPost" name="form3" class="wufoo topLabel page" autocomplete="off" enctype="multipart/form-data" method="post" action="" modelAttribute="searchForm">

                <header id="header" class="info">
                    <h2>Select Year, Branch, Semister & Branch.</h2>
                    <div>Update Student Marks.</div>
                    <div style="position:relative;top:10px;left:550px;width:10px;">
                        <a href="${pageContext.request.contextPath}/editMarks">Refresh</a>
                    </div>
                     <c:if test="${not empty msg}">
                        <p><font color="red"><c:out value="${msg}"></c:out></font></p>
                    </c:if>

                </header>



                <ul>

                    <li id="foli3" class="notranslate       ">
                        <label class="desc" id="title3" for="Field3">
                            Select a Year
                            <span id="req_3" class="req">*</span>
                        </label>
                        <div>
                            <sf:select id="year" name="Field3" cssClass="field select medium" tabindex="1" path="year" >
                                <sf:option value="" selected="selected">
                                Select Year</sf:option>
                                <sf:option value="1" >Year - I</sf:option>
                                <sf:option value="2" >Year - II</sf:option>
                                <sf:option value="3" >Year - III</sf:option>

                            </sf:select>
                        </div>
                    </li>
                    <li id="foli4" class="notranslate       ">
                        <label class="desc" id="title4" for="Field4">
                            Select a Branch
                        </label>
                        <div>
                            <sf:select id="branch" name="Field4" cssClass="field select medium" tabindex="2" path="branch" >
                                <sf:option value="0" selected="select" >Select Branch</sf:option>
                                <%
        int i = 1;
                                %>
                                <c:forEach var="branch" items="${branchList}">
                                    <sf:option value="<%=i%>" ><c:out value="${branch.branch}"></c:out></sf:option>
                                    <%
        ++i;
                                    %>
                                </c:forEach>
                            </sf:select>


                        </div>
                    </li>
                    <li id="foli6" class="notranslate       ">
                        <label class="desc" id="title6" for="Field6">
                            Select a Semister
                            <span id="req_6" class="req">*</span>
                        </label>
                        <div>
                            <sf:select id="semValue" name="Field6" cssClass="field select medium" tabindex="3" path="semister" >


                            </sf:select>
                        </div>
                    </li>
                    <li id="foli7" class="notranslate       ">
                        <label class="desc" id="title7" for="Field7">
                            Select a Paper
                            <span id="req_7" class="req">*</span>
                        </label>
                        <div>
                            <sf:select id="paper" name="Field7" cssClass="field select medium" tabindex="4" path="paper" >


                            </sf:select>
                        </div>
                    </li>
                    <li id="foli106" class="notranslate      ">
                        <label class="desc" id="title106" for="Field106">
                            Student Id.
                            <span id="req_106" class="req">*</span>
                        </label>
                        <div>
                            <sf:input id="studentId" name="Field106" path="studentId" type="text" class="field text small" value="" maxlength="255" tabindex="2" onkeyup="" />
                        </div>
                    </li>


                    <li class="buttons ">
                        <div>

                            <input id="" name="saveForm" class="btTxt"
                                   type="submit" value="Submit"
                               /></div>
                    </li>

                    <li class="hide">
                        <label for="comment">Do Not Fill This Out</label>
                        <textarea name="comment" id="comment" rows="1" cols="1"></textarea>
                        <input type="hidden" id="idstamp" name="idstamp" value="dWZRdHYMHm9f/V3/PY89/fYqlP3HWZIyjUus4y2YUM0=" />
                    </li>
                </ul>
            </sf:form>

            <div style="position:relative;height:40px;">
                <center>
                    <a href="${pageContext.request.contextPath}/home" class="powertiny">Cancel</a>
                </center>
            </div>


        </div><!--container-->

        <a class="powertiny" href="#" title="Powered by "
           style="display:block !important;visibility:visible !important;text-indent:0 !important;position:relative !important;height:auto !important;width:95px !important;overflow:visible !important;text-decoration:none;cursor:pointer !important;margin:0 auto !important">

            <b style="display:block !important;visibility:visible !important;text-indent:0 !important;position:static !important;height:auto !important;width:auto !important;overflow: auto !important;font-weight:normal;font-size:9px;color:#777;padding:0 0 0 3px;">Designed</b>
        </a>
    </body>
</html>