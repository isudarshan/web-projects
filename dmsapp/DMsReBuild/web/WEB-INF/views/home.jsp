<!DOCTYPE html>
<html lang="en" style="-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;">
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=0" />
	<title>SDMS College</title>
	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/css/images/favicon.ico" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/appstyle.css" type="text/css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flexslider.css" type="text/css" media="all" />
	<link href='http://fonts.googleapis.com/css?family=Ubuntu:400,500,700' rel='stylesheet' type='text/css' />

	<script src="${pageContext.request.contextPath}/resources/scripts/jquery-1.8.2.min.js" type="text/javascript"></script>
	<!--[if lt IE 9]>
		<script src="js/modernizr.custom.js"></script>
	<![endif]-->
	<script src="${pageContext.request.contextPath}/resources/scripts/jquery.flexslider-min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/scripts/functions.js" type="text/javascript"></script>
</head>
<body>
	<!-- wraper -->
	<div id="wrapper">
		<!-- shell -->
		<div class="shell">
			<!-- container -->
			<div class="container">
				<!-- header -->
				<header id="header">
					<h1 id="logo"><a href="#">SDMS</a></h1>
					<!-- search -->
					<div class="search">
						<form method="post">
							<span class="field"><input type="text" class="field" value="keywords here ..." title="keywords here ..." /></span>
							<input type="submit" class="search-btn" value="" />
						</form>
					</div>
					<!-- end of search -->
				</header>
				<!-- end of header -->
				<!-- navigation -->
				<nav id="navigation">
					<a href="#" class="nav-btn">HOME<span class="arr"></span></a>
					<ul>
						<li class="active"><a href="#">HOME</a></li>
						<li><a href="#">About Us</a></li>
						<li><a href="#">Departments</a></li>
						<li><a href="#">Courses</a></li>
						<li><a href="#">Alumni</a></li>
						<li><a href="#">Gallery</a></li>
						<li><a href="#">contact us</a></li>
					</ul>
				</nav>
				<!-- end of navigation -->
				<!-- slider -->
				<div class="m-slider">
					<div class="slider-holder">
						<span class="slider-shadow"></span>
						<span class="slider-b"></span>
						<div class="slider flexslider">
							<ul class="slides">
								<li>
									<div class="img-holder">
										<img src="resources/css/images/slide-img1.jpg" alt="" />
									</div>
									<div class="slide-cnt">
										<h2>Mixing Chemicals at</h2><h2>Chemistry Lab.</h2>
										<div class="box-cnt">
											
										</div>
										
									</div>
								</li>
								<li>
									<div class="img-holder">
										<img src="resources/css/images/slide-img2.jpg" alt="" />
									</div>
									<div class="slide-cnt">
										<h2>Eco-friendly Ambience.</h2>
										<div class="box-cnt">
											
										</div>
										
									</div>
								</li>
								<li>
									<div class="img-holder">
										<img src="resources/css/images/slide-img3.jpg" alt="" />
									</div>
									<div class="slide-cnt">
										<h2>Acquiring Knowledge at Library.</h2>
										<div class="box-cnt">
											
										</div>
										
									</div>
								</li>
                                <li>
									<div class="img-holder">
										<img src="resources/css/images/slide-img7.jpg" alt="" />
									</div>
									<div class="slide-cnt">
										<h2>The Best at Cultural Performance.</h2>
										<div class="box-cnt">
											
										</div>
										
									</div>
								</li>
                                <li>
									<div class="img-holder">
										<img src="resources/css/images/slide-img4.jpg" alt="" />
									</div>
									<div class="slide-cnt">
										<h2>Students Entering the Campus.</h2>
										<div class="box-cnt">
											
										</div>
										
									</div>
								</li>
                                <li>
									<div class="img-holder">
										<img src="resources/css/images/slide-img5.jpg" alt="" />
									</div>
									<div class="slide-cnt">
										<h2>Hostel-A Home away from home.</h2>
										<div class="box-cnt">
											
										</div>
										
									</div>
								</li>
                                <li>
									<div class="img-holder">
										<img src="resources/css/images/slide-img6.jpg" alt="" />
									</div>
									<div class="slide-cnt">
										<h2>Bubbling with Enthusiasm.</h2>
										<div class="box-cnt">
											
										</div>
										
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<!-- end of slider -->
				<!-- main -->
				<div class="main">
					
					
					
				</div>
				<!-- end of main -->
				<div class="socials">
					<div class="socials-inner">
						<h3>Follow us on Social</h3>
						<ul>
							<li><a href="#" class="facebook-ico"><span></span>Facebook</a></li>
							<li><a href="#" class="twitter-ico"><span></span>Twitter</a></li>
							<li><a href="#" class="rss-feed-ico"><span></span>Rss-feed</a></li>
							<li><a href="#" class="myspace-ico"><span></span>myspace</a></li>
							
						</ul>
						<div class="cl">&nbsp;</div>
					</div>
				</div>
				<div id="footer">
					<div class="footer-cols">
						<div class="col">
							<h2>Exams</h2>
							<ul>
								<li><a href="${pageContext.request.contextPath}/params">Post Internal Marks</a></li>
								<li><a href="${pageContext.request.contextPath}/attendance">Class Work Attendance</a></li>
								<li><a href="${pageContext.request.contextPath}/report">Reports</a></li>
								<li><a href="${pageContext.request.contextPath}/editMarks">Update Internal Marks</a></li>
                                <li><a href="${pageContext.request.contextPath}/adminDash">Manage Branches</a></li>
							</ul>
						</div>
						<div class="col">
							<h2>Help & Support</h2>
							<ul>
								<li><a href="#">Academic Calendar</a></li>
								<li><a href="#">Book Store</a></li>
								<li><a href="#">Courses</a></li>
								<li><a href="#">Professional Programs</a></li>
                                <li><a href="#">Diploma Programs</a></li>
							</ul>
						</div>
						<div class="col">
							<h2>Addmission</h2>
							<ul>
								<li><a href="#">Under Graduate</a></li>
								<li><a href="#">Post Graduate</a></li>
								<li><a href="#">Certificate Courses </a></li>
								<li><a href="#">Distance Education</a></li>
                                <li><a href="#">Dual Certification</a></li>
							</ul>
						</div>
						<div class="col">
							<h2>Quick Links</h2>
							<ul>
								<li><a href="#">Students Support</a></li>
								<li><a href="#">Reports</a></li>
								<li><a href="#">Downloads</a></li>
								<li><a href="#">Results</a></li>
                                <li><a href="#">Transcripts</a></li>
							</ul>
						</div>
						<div class="cl">&nbsp;</div>
					</div>
					<!-- end of footer-cols -->
					<div class="footer-bottom">
						<nav class="footer-nav">
							<ul>
								<li class="active"><a href="#">HOME</a></li>
						<li><a href="#">About Us</a></li>
						<li><a href="#">Departments</a></li>
						<li><a href="#">Courses</a></li>
						<li><a href="#">Alumni</a></li>
						<li><a href="#">Gallery</a></li>
						<li><a href="#">Contact Us</a></li>
							</ul>
						</nav>
						<p class="copy">&copy; Copyright 2013<span>|</span> <strong>Design by Sai Teja InfoTech, Vijayawada - 10<a href="#"></a></strong></p>
						<div class="cl">&nbsp;</div>
					</div>
				</div>
			</div>
			<!-- end of container -->
		</div>
		<!-- end of shell -->
	</div>
	<!-- end of wrapper -->
</body>
</html>