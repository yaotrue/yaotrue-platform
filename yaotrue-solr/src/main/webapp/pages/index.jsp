<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="">
<meta name="author" content="">

<title>YaoTrue商品优选首页</title>

<%@include file="/pages/commons/common-css.jsp" %>
<%@include file="/pages/commons/common-javascript.jsp" %>
</head>

<body>
	<%@include file="/pages/commons/header.jsp" %>
	<div id="page-content" class="home-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<!-- Carousel -->
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators hidden-xs">
							<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>
						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<a href="${base }/">
								<img class="lazy" data-original="${pageContext.request.contextPath}/resources/images/big-banner-1.jpg" alt="First slide" width="100%" height="600px;">
								<!-- Static Header -->
								<div class="header-text hidden-xs">
									<div class="col-md-12 text-center"></div>
								</div>
								</a>
								<!-- /header-text -->
							</div>
							<div class="item">
								<a href="${base }/">
								<img class="lazy" data-original="${pageContext.request.contextPath}/resources/images/big-banner-2.jpg" alt="Second slide" width="100%" height="600px;">
								<!-- Static Header -->
								<div class="header-text hidden-xs">
									<div class="col-md-12 text-center"></div>
								</div>
								</a>
								<!-- /header-text -->
							</div>
							<div class="item">
								<a href="${base }/">
								<img class="lazy" data-original="${pageContext.request.contextPath}/resources/images/big-banner-3.jpg" alt="Third slide" width="100%" height="600px;">
								<!-- Static Header -->
								<div class="header-text hidden-xs">
									<div class="col-md-12 text-center"></div>
								</div>
								</a>
								<!-- /header-text -->
							</div>
						</div>
						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic" data-slide="prev"> 
							<span class="glyphicon glyphicon-chevron-left"></span>
						</a> 
						<a class="right carousel-control" href="#carousel-example-generic" data-slide="next"> 
							<span class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
					<!-- /carousel -->
				</div>
			</div>
			<div class="row">
				<div class="banner">
					<div class="col-sm-4">
						<a href="${base }/">
						<img class="lazy" data-original="${pageContext.request.contextPath}/resources/images/sub-banner1.png" />
						</a>
					</div>
					<div class="col-sm-4">
						<a href="${base }/">
						<img class="lazy" data-original="${pageContext.request.contextPath}/resources/images/sub-banner2.png" />
						</a>
					</div>
					<div class="col-sm-4">
						<a href="${base }/">
						<img class="lazy" data-original="${pageContext.request.contextPath}/resources/images/sub-banner3.png" />
						</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="heading">
						<h2>今日推荐</h2>
					</div>
					<div class="products">
						<c:forEach begin="0" end="7">
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="product">
								<div class="image">
									<a href="product.html"><img class="lazy" data-original="${pageContext.request.contextPath}/resources/images/iphone.png" /></a>
								</div>
								<div class="buttons">
									<a class="btn cart" href="#"><span
										class="glyphicon glyphicon-shopping-cart"></span></a> <a
										class="btn wishlist" href="#"><span
										class="glyphicon glyphicon-heart"></span></a> <a
										class="btn compare" href="#"><span
										class="glyphicon glyphicon-transfer"></span></a>
								</div>
								<div class="caption">
									<div class="name">
										<h3>
											<a href="product.html">Aliquam erat volutpat</a>
										</h3>
									</div>
									<div class="price">
										$122<span>$98</span>
									</div>
									<div class="rating">
										<span class="glyphicon glyphicon-star"></span><span
											class="glyphicon glyphicon-star"></span><span
											class="glyphicon glyphicon-star"></span><span
											class="glyphicon glyphicon-star"></span><span
											class="glyphicon glyphicon-star-empty"></span>
									</div>
								</div>
							</div>
						</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="banner">
					<div class="col-sm-6">
						<a href="${base }/">
						<img class="lazy" data-original="${pageContext.request.contextPath}/resources/images/sub-banner4.jpg" />
						</a>
					</div>
					<div class="col-sm-6">
						<a href="${base }/">
						<img class="lazy" data-original="${pageContext.request.contextPath}/resources/images/sub-banner5.png" />
						</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="heading">
						<h2>热门点击</h2>
					</div>
					<div class="products">
						<c:forEach begin="0" end="7">
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="product">
								<div class="image">
									<a href="product.html"><img class="lazy" data-original="${pageContext.request.contextPath}/resources/images/iphone.png" /></a>
								</div>
								<div class="buttons">
									<a class="btn cart" href="#"><span
										class="glyphicon glyphicon-shopping-cart"></span></a> <a
										class="btn wishlist" href="#"><span
										class="glyphicon glyphicon-heart"></span></a> <a
										class="btn compare" href="#"><span
										class="glyphicon glyphicon-transfer"></span></a>
								</div>
								<div class="caption">
									<div class="name">
										<h3>
											<a href="product.html">Aliquam erat volutpat</a>
										</h3>
									</div>
									<div class="price">
										$122<span>$98</span>
									</div>
									<div class="rating">
										<span class="glyphicon glyphicon-star"></span><span
											class="glyphicon glyphicon-star"></span><span
											class="glyphicon glyphicon-star"></span><span
											class="glyphicon glyphicon-star"></span><span
											class="glyphicon glyphicon-star-empty"></span>
									</div>
								</div>
							</div>
						</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="/pages/commons/footer.jsp" %>
</body>
</html>