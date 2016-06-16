<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>YaoTrue - 姚真</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/main.css" rel="stylesheet">
    
	<link rel="stylesheet" href="resources/css/font-awesome.min.css">
    
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,300,700' rel='stylesheet' type='text/css'>
    
    <script src="resources/scripts/jquery.min.js"></script>
    <script type="text/javascript" src="resources/scripts/smoothscroll.js"></script> 
    <script src="resources/scripts/Chart.js"></script>
  </head>

  <body data-spy="scroll" data-offset="0" data-target="#nav">

	<div id="section-topbar">
		<div id="topbar-inner">
			<div class="container">
				<div class="row">
					<div class="dropdown">
						<ul id="nav" class="nav">
							<li class="menu-item"><a class="smoothScroll" href="#about" title="About"><i class="icon-user"></i></a></li>
							<li class="menu-item"><a class="smoothScroll" href="#resume" title="Resume"><i class="icon-file"></i></a></li>
							<li class="menu-item"><a class="smoothScroll" href="#work" title="Works"><i class="icon-briefcase"></i></a></li>
							<li class="menu-item"><a class="smoothScroll" href="#contact" title="Contact"><i class="icon-envelope"></i></a></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	
	<div id="headerwrap">
		<div class="container">
			<div class="row centered">
				<div class="col-lg-12">
					<h1>Yao True</h1>
					<h3>Java Development | yaotrue@163.com</h3>
				</div>
			</div>
		</div>
	</div>

	<section id="about" name="about"></section>
	<div id="intro">
		<div class="container">
			<div class="row">
				
				<div class="col-lg-2 col-lg-offset-1">
					<h5>ABOUT</h5>
				</div>
				<div class="col-lg-6">
					<p>我是java开发姚真，YaoTrue的由来就是我的名字拉~程序员怎么可以没个自己玩儿的网站。</p>
				</div>
			</div>
		</div>
	</div>

	<section id="resume" name="resume"></section>
	<div class="container desc">
		<div class="row">

				<div class="col-lg-2 col-lg-offset-1">
					<h5>WORK</h5>
				</div>
				<div class="col-lg-6">
					<p><t>Java开发</t><br/>
						上海宝尊电子商务有限公司. <br/>
					</p>
					<p>
						<more>
						在公司的IT部实施组，主要工作内容为品牌官方商城网站的开发设计与维护，跟过匡威、哈根达斯和微软香港等项目，目前主要负责微软香港站。
						</more>
					</p>
				</div>
				<div class="col-lg-3">
					<p><sm>2012.06 - 现在</sm></p>
				</div>
		</div>
		<br>
	</div>

	<div id="skillswrap">
		<div class="container">
			<div class="row">
					<div class="col-lg-2 col-lg-offset-1">
						<h5>SKILLS</h5>
					</div>
					<div class="col-lg-3 centered">
						<canvas id="javascript" height="130" width="130"></canvas>
						<p>Javascript</p>
						<br>
						<script>
							var doughnutData = [
									{
										value: 60,
										color:"#1abc9c"
									},
									{
										value : 40,
										color : "#ecf0f1"
									}
								];
								var myDoughnut = new Chart(document.getElementById("javascript").getContext("2d")).Doughnut(doughnutData);
						</script>
					</div>
					<div class="col-lg-3 centered">
						<canvas id="htmlcss" height="130" width="130"></canvas>
						<p>Html/Css</p>
						<br>
						<script>
							var doughnutData = [
									{
										value: 55,
										color:"#1abc9c"
									},
									{
										value : 45,
										color : "#ecf0f1"
									}
								];
								var myDoughnut = new Chart(document.getElementById("htmlcss").getContext("2d")).Doughnut(doughnutData);
						</script>
					</div>
					<div class="col-lg-3 centered">
						<canvas id="jquery" height="130" width="130"></canvas>
						<p>Jquery</p>
						<br>
						<script>
							var doughnutData = [
									{
										value: 65,
										color:"#1abc9c"
									},
									{
										value : 35,
										color : "#ecf0f1"
									}
								];
								var myDoughnut = new Chart(document.getElementById("jquery").getContext("2d")).Doughnut(doughnutData);
						</script>
					</div>
					
					<div class="col-lg-3 col-lg-offset-3 centered">
						<canvas id="spring" height="130" width="130"></canvas>
						<p>Spring</p>
						<br>
						<script>
							var doughnutData = [
									{
										value: 70,
										color:"#1abc9c"
									},
									{
										value : 30,
										color : "#ecf0f1"
									}
								];
								var myDoughnut = new Chart(document.getElementById("spring").getContext("2d")).Doughnut(doughnutData);
						</script>
					</div>
					<div class="col-lg-3 centered">
						<canvas id="hibernate" height="130" width="130"></canvas>
						<p>Hibernate</p>
						<br>
						<script>
							var doughnutData = [
									{
										value: 70,
										color:"#1abc9c"
									},
									{
										value : 30,
										color : "#ecf0f1"
									}
								];
								var myDoughnut = new Chart(document.getElementById("hibernate").getContext("2d")).Doughnut(doughnutData);
						</script>
					</div>
					<div class="col-lg-3 centered">
						<canvas id="postGreSQL" height="130" width="130"></canvas>
						<p>PostGreSQL</p>
						<br>
						<script>
							var doughnutData = [
									{
										value: 60,
										color:"#1abc9c"
									},
									{
										value : 40,
										color : "#ecf0f1"
									}
								];
								var myDoughnut = new Chart(document.getElementById("postGreSQL").getContext("2d")).Doughnut(doughnutData);
						</script>
					</div>
					<div class="col-lg-3 col-lg-offset-3 centered">
						<canvas id="solr" height="130" width="130"></canvas>
						<p>Solr</p>
						<br>
						<script>
							var doughnutData = [
									{
										value: 60,
										color:"#1abc9c"
									},
									{
										value : 40,
										color : "#ecf0f1"
									}
								];
								var myDoughnut = new Chart(document.getElementById("solr").getContext("2d")).Doughnut(doughnutData);
						</script>
					</div>
					<div class="col-lg-3 centered">
						<canvas id="ubuntu" height="130" width="130"></canvas>
						<p>Ubuntu</p>
						<br>
						<script>
							var doughnutData = [
									{
										value: 45,
										color:"#1abc9c"
									},
									{
										value : 55,
										color : "#ecf0f1"
									}
								];
								var myDoughnut = new Chart(document.getElementById("ubuntu").getContext("2d")).Doughnut(doughnutData);
						</script>
					</div>
			</div>
			<br>
		</div>
	</div>

	<section id="contact" name="contact"></section>
	<div id="footwrap">
		<div class="container">
			<div class="row">
			
				<div class="col-lg-2 col-lg-offset-1">
					<h5>CONTACT</h5>
				</div>
				<div class="col-lg-6">
					<p><t>Email</t><br/>
						yaotrue@163.com <br/>
					</p>
					<p><t>Adress</t><br/>
						闸北区万荣路1268号B栋 <br/>
						邮编 200000 <br/>
						上海市, 中国. <br/>
					</p>
				</div>
				<div class="col-lg-3">
					<p><sm>SOCIAL LINKS</sm></p>
					<p>
						<a href="http://weibo.com/u/3865219173" target="_blank"><i class="icon-weibo"></i></a>
					</p>
				</div>
			</div>
		</div>
	</div>
	
	<div id="c">
		<div class="container">
			<p>Created by <a href="http://www.yaotrue.com">YAOTRUE.COM</a></p>
		</div>
	</div>
	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="resources/scripts/bootstrap.js"></script>
  </body>
</html>