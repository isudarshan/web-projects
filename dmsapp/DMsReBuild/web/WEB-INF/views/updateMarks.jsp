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


            });

        </script>



    </head>

    <body id="public">
        <div id="container" class="ltr">

            <h1 id="logo">
                <a>Wufoo</a>
            </h1>

            <sf:form id="sleectionForPost" name="form3" class="wufoo topLabel page" autocomplete="off" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/doUpdate" modelAttribute="updateForm">

                <header id="header" class="info">
                    <h2>Select Year, Branch, Semister & Branch to Update.</h2>
                    <c:if test="${not empty msg}">

                        <p><font color="red"><c:out value="${msg}"></c:out></font></p>
                    </c:if>

                    <h3>Year : <c:out value="${updateObject.year}"></c:out></h3>
                    <h3>Branch:  <c:out value="${updateObject.branch}"></c:out></h3>
                    <h3>Semister: <c:out value="${updateObject.semister}"></c:out></h3>
                    <h3>Paper: <c:out value="${updateObject.paper}"></c:out></h3>

                    <br/>

                </header>

                <sf:hidden path="id" value="${updateObject.id}"/>
                <sf:hidden path="year" value="${updateObject.year}"/>
                <sf:hidden path="branch" value="${updateObject.branch}"/>
                <sf:hidden path="semister" value="${updateObject.semister}"/>
                <sf:hidden path="paper" value="${updateObject.paper}"/>
                <sf:hidden path="studentId" value="${updateObject.studentId}"/>


                <table cellpadding="8" cellspacing="3" align="left">



                    <tr>
                        <td>Internal - I Marks</td>
                        <td><sf:input type="text" value="${updateObject.internalOne}" path="internalOne" id="marks"/></td>
                    </tr>

                    <tr>
                        <td>Internal - II Marks</td>
                        <td><sf:input type="text" value="${updateObject.internalTwo}" path="internalTwo" id="marks"/></td>
                    </tr>

                    <c:if test="${updateObject.assignmentMarks != null}">
                        <tr>
                            <td>Assignment Marks</td>
                            <td><sf:input type="text" value="${updateObject.assignmentMarks}" path="assignmentMarks" id="assMarks"/></td>
                        </tr>
                    </c:if>

                    <tr>
                        <td><font color="green">Number of Days Attended</font></td>
                        <td><sf:input type="text" value="${updateObject.attendanceMarks}" path="attendanceMarks" id="attMarks"/></td>

                    </tr>

                    <tr>
                        <td></td>
                        <td><input type="submit" value="Update"/></td>
                    </tr>
                </table>

                <ul>





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