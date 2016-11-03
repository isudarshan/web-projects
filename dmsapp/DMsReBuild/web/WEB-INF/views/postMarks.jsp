<%@taglib  prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <title>
            Post Internal Marks
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
                $("#saveForm").click(function(){

                    var studentId = $('#studentId').val();
                    var internalOne = $('#internalOne').val();
                    var internalTwo = $('#internalTwo').val();
                    var assignmentMarks = $('#assignmentMarks').val();
                    var hasMarks = $('#hasMarks').val();
                    var attendanceMarks = $('#attendanceMarks').val();

                    if(studentId == null || studentId.length == 0) {
                        alert('Registration Number is required !');
                        return false;
                    }

                    if(internalOne == null || internalOne.length == 0) {
                        alert('Internal Marks - I are required !');
                        return false;
                    }

                    if(internalTwo == null || internalTwo.length == 0) {
                        alert('Internal Marks - II are required !');
                        return false;
                    }

                    if(attendanceMarks == null || attendanceMarks.length == 0) {
                        alert('Working Days are required !');
                        return false;
                    }


                    if(hasMarks == '1') {
                        if(assignmentMarks == null || assignmentMarks.length == 0) {
                            alert('Assignment Marks are required !');
                            return false;
                        }
                    }


                    $.ajax({
                        type:'POST',
                        url : '${pageContext.request.contextPath}/doPost',
                        data:$('#form2').serialize(),
                        success:function(response) {
                            alert(response);
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

            <sf:form id="form2" name="form2" class="wufoo topLabel page" modelAttribute="marksMasterForm" action="${pageContext.request.contextPath}/doPost">

                <header id="header" class="info">
                    <h2>Post Internal Marks</h2>
                    <div>Please fill all required Fields.</div>
                </header>

                <br/>

                <table  border="1" cellpadding="5" cellspacing="3" width="100%">
                    <tr>
                        <th>Year</th>
                        <th>Branch</th>
                        <th>Semister</th>
                        <th>Paper Name</th>

                    </tr>

                    <tr>
                        <td>${master.year}</td>
                        <td>${master.branch}</td>
                        <td>${master.semister}</td>
                        <td>${master.paper}</td>

                    </tr>
                </table>
                <br/>
                <sf:hidden path="year"/>
                <sf:hidden path="branch"/>
                <sf:hidden path="semister"/>
                <sf:hidden path="paper"/>
                <ul>

                    <li id="foli6" class="notranslate      ">
                        <fieldset>
                            <![if !IE | (gte IE 8)]>
                            <legend id="title6" class="desc">
                                <font color="green"><h3>To Mark a Student as Absent, Type "A" in Marks (Internal I or II) Field.</h3></font>
                            </legend>
                            <![endif]>
                            <!--[if lt IE 8]>
<label id="title6" class="desc">
Check the Box to Marks Student as Absent
</label>
                            <![endif]-->

                            <!--
                            <div>
                                <span>
                                    <input id="Field6" name="Field6" type="checkbox" class="field checkbox" value="Is Absent ?" tabindex="1" />
                                    <label class="choice" for="Field6">Is Absent ?</label>
                                </span>
                            </div>
                            -->
                        </fieldset>
                    </li><li id="foli106" class="notranslate      ">
                        <label class="desc" id="title106" for="Field106">
                            Registration Number
                            <span id="req_106" class="req">*</span>
                        </label>
                        <div>
                            <sf:input id="studentId" name="Field106" path="studentId" type="text" class="field text medium" value="" maxlength="255" tabindex="2" onkeyup="" />
                        </div>
                    </li><li id="foli107" class="notranslate      ">
                        <label class="desc" id="title107" for="Field107">
                            Internal Marks - I
                            <span id="req_107" class="req">*</span>
                        </label>
                        <div>
                            <sf:input path ="internalOne" id="internalOne" name="Field107" type="text" class="field text small" value="" maxlength="255" tabindex="3" onkeyup=""/>
                        </div>
                    </li><li id="foli211" class="notranslate      ">
                        <label class="desc" id="title211" for="Field211">
                            Internal Marks - II
                            <span id="req_211" class="req">*</span>
                        </label>
                        <div>
                            <sf:input path ="internalTwo" id="internalTwo" name="Field211" type="text" class="field text small" value="" maxlength="255" tabindex="4" onkeyup="" />
                        </div>
                    </li><li id="foli211" class="notranslate      ">
                        <label class="desc" id="title211" for="Field211">
                            Number of Days.Attended
                            <span id="req_211" class="req">*</span>
                        </label>
                        <div>
                            <sf:input path ="attendanceMarks" id="attendanceMarks" name="Field211" type="text" class="field text small" value="" maxlength="255" tabindex="4" onkeyup="" />
                        </div>
                    </li>

                    <c:if test="${master.hasAssMarks == 1}">
                        <li id="foli208" class="notranslate      ">
                            <label class="desc" id="title208" for="Field208">
                                Assignment Marks
                                <span id="req_208" class="req">*</span>
                            </label>
                            <input type="hidden" value="${master.hasAssMarks}" id="hasMarks"/>
                            <div id="">
                                <sf:input path ="assignmentMarks" id="assignmentMarks" name="Field208" type="text" class="field text small" value="" maxlength="255" tabindex="5" onkeyup=""/>
                            </div>
                        </li>
                    </c:if>

                    <li class="buttons ">
                        <div>

                            <input id="saveForm" name="saveForm" class="btTxt submit"
                                   type="button" value="Post Marks"
                               /></div>
                    </li>

                    <li class="hide">
                        <label for="comment">Do Not Fill This Out</label>
                        <textarea name="comment" id="comment" rows="1" cols="1"></textarea>
                        <input type="hidden" id="idstamp" name="idstamp" value="HpYblGJ4w4zgwT+ht3bMR1XjBDFKNKh+6mNXr0AI+nY=" />
                    </li>
                </ul>
            </sf:form>

             <div style="position:relative;height:40px;">
                 <center>
                     <a href="${pageContext.request.contextPath}/params" class="powertiny">Cancel</a>
                 </center>
             </div>

        </div><!--container-->

        <a class="powertiny" href="#" title="Powered by Wufoo"
           style="display:block !important;visibility:visible !important;text-indent:0 !important;position:relative !important;height:auto !important;width:95px !important;overflow:visible !important;text-decoration:none;cursor:pointer !important;margin:0 auto !important">

            <b style="display:block !important;visibility:visible !important;text-indent:0 !important;position:static !important;height:auto !important;width:auto !important;overflow: auto !important;font-weight:normal;font-size:9px;color:#777;padding:0 0 0 3px;">Designed</b>
        </a>
    </body>
</html>