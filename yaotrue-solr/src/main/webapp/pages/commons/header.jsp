<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/pages/commons/common.jsp"%>
<!--Top-->
<nav id="top">
	<div class="container">
		<div class="row">
			<div class="col-xs-6">
				<select class="language">
					<option value="中文" selected="selected">中文</option>
					<option value="English">English</option>
				</select>
			</div>
			<div class="col-xs-6">
				<ul class="top-link">
					<li><a href="account.html"><span
							class="glyphicon glyphicon-user"></span> My Account</a></li>
					<li><a href="contact.html"><span
							class="glyphicon glyphicon-envelope"></span> Contact</a></li>
				</ul>
			</div>
		</div>
	</div>
</nav>
<!--Header-->
<header class="container">
	<div class="row">
		<div class="col-md-4">
			<div id="logo">
				<a href="${base }/">
					<img src="${pageContext.request.contextPath}/resources/images/logo4.png" />
				</a>
			</div>
		</div>
		<div class="col-md-4">
			<form class="form-search">
				<input type="text" class="input-medium search-query">
				<button type="submit" class="btn">
					<span class="glyphicon glyphicon-search"></span>
				</button>
			</form>
		</div>
		<div class="col-md-4">
			<div id="cart">
				<a class="btn btn-1" href="cart.html"><span
					class="glyphicon glyphicon-shopping-cart"></span>CART : 0 ITEM</a>
			</div>
		</div>
	</div>
</header>
<!--Navigation-->
<nav id="menu" class="navbar">
	<div class="container">
		<div class="navbar-header">
			<span id="heading" class="visible-xs">Categories</span>
			<button type="button" class="btn btn-navbar navbar-toggle"
				data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<i class="fa fa-bars"></i>
			</button>
		</div>
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li><a href="${base }/">首页</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">商品分类</a>
					<div class="dropdown-menu">
						<div class="dropdown-inner">
							<ul class="list-unstyled">
								<li><a href="${base }/category.htm">超级好玩</a></li>
								<li><a href="${base }/category.htm">超级好看</a></li>
								<li><a href="${base }/category.htm">超级好吃</a></li>
								<li><a href="${base }/category.htm">超级好用</a></li>
							</ul>
							<ul class="list-unstyled">
								<li><a href="${base }/category.htm">送父母</a></li>
								<li><a href="${base }/category.htm">送小孩</a></li>
								<li><a href="${base }/category.htm">送老婆</a></li>
							</ul>
						</div>
					</div></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">热门推荐</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">超级划算</a></li>
				<li><a href="category.htm">热门活动</a></li>
			</ul>
		</div>
	</div>
</nav>