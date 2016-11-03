<%-- 
    Document   : userhomepage
    Created on : 22 Apr, 2014, 3:21:58 PM
    Author     : cmc5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>

        <script type="text/javascript">

        </script>
        <style type="text/css">

            #well{
                height:700px;
            }

            #tabletext{

                text-decoration: none;

            }

            #image{
                position: relative;
                width:700px;
                height:520px;
                left:10px;
                top: 5px;
            }
            #paragraph{
                position:relative;
                width:300px;
                height:510px;
                left:780px;
                border:1px solid lightsteelblue;
                top:-530px;
                border-radius:8px; 
            }

        </style>
    </head>
    <%@include file="logoutButton.jsp"%>
    <body>
        <div class="container">
            <div id="pannel">
                <h2 align="center" class='bg-primary'>User Home Page</h2>

                <div class="well well-sm" id="well">

                    <div class="panel panel-body" style="background-color: lightsteelblue">

                        <table class="table table-bordered table-hover table-striped">
                            <tr>
                                <td id="tabletext">

                                    <a href="#"><h4 align="center">Account Number</h4></a>

                                </td>
                                <td><a href="#"><h4 align="center">Branch</h4></a></td>

                                <td><a href="#"><h4 align="center">Check Balance</h4></a></td>           


                                <td><a href="#"><h4 align="center">View Profile</h4></a></td>               
                            </tr>


                        </table></div>
                    <div class="panel panel-body" id="image" style="background-color: lightsteelblue">

                        <img alt=" " src='images/4.jpg' width='700' height='100' class="img img-responsive">
                    </div>

                    <div id="paragraph"><h5 align="center"><b>Banking in India was generally fairly mature in terms of supply, product range and reach-even though reach in rural India and to the poor still remains a challenge</b></h5>
                    </div>

                </div>
            </div>
        </div>
    </div>
</body>
</html>
