<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/grid_12.css">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/slider.css">
    <link href='http://fonts.googleapis.com/css?family=Condiment' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/tms-0.4.x.js"></script>
    <script>
		$(document).ready(function(){
			$('.slider')._TMS({
				show:0,
				pauseOnHover:true,
				prevBu:false,
				nextBu:false,
				playBu:false,
				duration:1000,
				preset:'fade',
				pagination:true,
				pagNums:false,
				slideshow:7000,
				numStatus:true,
				banners:'fromRight',
				waitBannerAnimation:false,
				progressBar:false
			})
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
        <div class="form-search">
            <form id="form-search" method="post">
              <input type="text" value="Type here..." onBlur="if(this.value=='') this.value='Type here...'" onFocus="if(this.value =='Type here...' ) this.value=''"  />
              <a href="#" onClick="document.getElementById('form-search').submit()" class="search_button"></a>
            </form>
        </div>
        <div class="clear"></div>
        <nav class="box-shadow">
            <div>
                <ul class="menu">
                    <li class="home-page current"><a href="${pageContext.request.contextPath}/home"><span></span></a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Departments</a></li>
                    <li><a href="#">Alumini</a></li>
                    <li><a href="#">Research</a></li>
                    <li><a href="${pageContext.request.contextPath}/login">Sign In</a></li>
                </ul>
                <div class="social-icons">
                    <span>Follow us:</span>
                    <a href="#" class="icon-3"></a>
                    <a href="#" class="icon-2"></a>
                    <a href="#" class="icon-1"></a>
                </div>
                <div class="clear"></div>
            </div>
        </nav>
    </header>
  <!--==============================content================================-->
    <section id="content">
        <div id="slide" class="box-shadow">
            <div class="slider">
                <ul class="items">
                    <li><img src="${pageContext.request.contextPath}/resources/images/slider-1.png" alt="" /><div class="banner">The Next Level of Your Success&nbsp;</div></li>
                    <li><img src="${pageContext.request.contextPath}/resources/images/slider-2.png" alt="" /><div class="banner">We Offer Different Ways of Problem Solving&nbsp;</div></li>
                    <li><img src="${pageContext.request.contextPath}/resources/images/slider-3.png" alt="" /><div class="banner">We Craft Practical Solutions&nbsp;</div></li>
                    <li><img src="${pageContext.request.contextPath}/resources/images/slider-4.png" alt="" /><div class="banner">We Craft Practical Solutions&nbsp;</div></li>
                    <li><img src="${pageContext.request.contextPath}/resources/images/slider-5.png" alt="" /><div class="banner">We Craft Practical Solutions&nbsp;</div></li>
                </ul>
            </div>
        </div>
        <div class="container_12">
          <div class="grid_12">
            <div class="pad-0 border-1">
                <h2 class="top-1 p0">We Will Show You The Way To Success!</h2>
                <p class="p2">Amrita Sai Institute of Science and Technology affiliated to JNTU-K is located 30 kilometers away from <strong>Nationwide important land marks</strong> of Krishnaveni River, Goddess Kanaka Durga on abode of Indrakiladri Mountain and Krishna barrage. Krishnaveni waters are elexier of life to people of Andhra Pradesh and ASIST is an elexier to wide range of life potential and skills for the personality development of our students. The Goddess Durga temple and for the people of Vijayawada <strong>KSHETRAPALAKA</strong> is lord Anjaneya and we have <strong>Second Tallest Abhayanjaneya</strong> in Paritala protecting all Asistians. The Krishna Barrage paves way to bridge gaps to other districts; similarly we have excellent teachers to serve as complete knowledge pavers. The barrage stores water for continuous irrigation; our institute facilitates continuous updating with smart technologies. We have begun our journey with blessings of Mata Amritanandamayi and we hope that Shirdi Sai and Goddess Durga will bless us all.</p>
            </div>
            <div class="wrap block-1 pad-1">
                <div>
                    <h3>Placements</h3>
                    <img src="${pageContext.request.contextPath}/resources/images/page1-img3.jpg" alt="" class="img-border">
                    <p>The objective of Training & Placement Department is to equip students with globally employable skills through training and to help them attain their desired employment and career goals..</p>
                    <a href="#" class="button">More</a>
                </div>
                <div>
                    <h3>Research</h3>
                    <img src="${pageContext.request.contextPath}/resources/images/page1-img2.jpg" alt="" class="img-border">
                    <p>The Centre for Research is initiated in the campus to bring out the talents and innovative thoughts of students and faculty aiming to cater the needs of the society  world-class facilities.</p>
                    <a href="#" class="button">More</a>
                </div>
                <div class="last">
                    <h3>Faculty</h3>
                    <img src="${pageContext.request.contextPath}/resources/images/page1-img1.jpg" alt="" class="img-border">
                    <p>All professors of the Institute decides the academic policy of the Institute. It controls and approves the curriculum, courses, examinations and results. It appoints committees to look into academic matters .</p>
                    <a href="#" class="button">More</a>
                </div>
            </div>
          </div>
          <div class="clear"></div>
        </div>
        <div class="aside">
            <div class="container_12">
                <div class="grid_12">
                    <div class="pad-2 block-2 wrap">
                        <div>
                            <h3 class="p3">E-Learning!</h3>
                            <p class="p4">The core objective of serving students in higher educational institutions by providing affordable, high quality knowledge based services to catalyze effective and efficient learning..</p>
                            <a href="#" class="button">More</a>
                        </div>
                        <div class="last">
                            <h3 class="p3">Vision & Mission</h3>
                            <p class="p4">To nurture excellence in various fields of engineering by imparting timeless core values to the learners and to mould the institution into a center of academic excellence and advanced research.</p>
                            <a href="#" class="button">More</a>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
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