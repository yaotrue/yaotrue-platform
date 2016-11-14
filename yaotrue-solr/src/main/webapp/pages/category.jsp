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
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="${base }/">首页</a></li>
						<li><a href="${base }/category.htm">分类页</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div id="main-content" class="col-md-12">
					<c:set value="0" var="eachend"/>
					<c:forEach items="${pagination.items }" var="sku" varStatus="status" step="3">
						<div class="row">
							<div class="col-md-12">
								<div class="products">
									<c:forEach items="${pagination.items }" var="sku1" begin="${eachend*3 }" end="${eachend*3 + 2 > fn:length(pagination.items) ? fn:length(pagination.items) : eachend*3 + 2 }">
									<div class="col-lg-4 col-md-4 col-xs-12">
										<div class="product">
											<div class="image"><a href="${sku1.tgUrl }" target="_blank"><img class="lazy" data-original="${sku1.skuImgUrl }" /></a></div>
											<!-- <div class="buttons">
												<a class="btn cart" href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a>
												<a class="btn wishlist" href="#"><span class="glyphicon glyphicon-heart"></span></a>
												<a class="btn compare" href="#"><span class="glyphicon glyphicon-transfer"></span></a>
											</div> -->
											<div class="caption">
												<div class="name"><h3><a href="${sku1.tgUrl }" target="_blank">${sku1.skuName }</a></h3></div>
												<div class="price">优惠价￥${sku1.price }</div>
												<div class="rating">${sku1.platformName }&nbsp;${sku1.shopName }</div>
											</div>
										</div>
									</div>
									</c:forEach>
									<c:set value="${eachend+1 }" var="eachend"/>
								</div>
							</div>
						</div>
					</c:forEach>
					
					<div class="row text-center">
						<ul class="pagination">
						  <c:choose>
						  <c:when test="${pagination.firstPage }">
						  <li><a href="javascript:void(0)">上一页</a></li>
						  </c:when>
						  <c:otherwise>
						  <li><a href="javascript:void(0)" onclick="window.location.href='${base}/category.htm?pageNo=${pagination.currentPage-1 }'">上一页</a></li>
						  </c:otherwise>
						  </c:choose>
						  <li class="active"><a href="javascript:void(0)">${pagination.currentPage }</a></li>
						  <c:choose>
						  <c:when test="${pagination.lastPage }">
						  <li><a href="javascript:void(0)">下一页</a></li>
						  </c:when>
						  <c:otherwise>
						  <li><a href="javascript:void(0)" onclick="window.location.href='${base}/category.htm?pageNo=${pagination.currentPage+1 }'">下一页</a></li>
						  </c:otherwise>
						  </c:choose>
						</ul>
					</div>
				</div>
				<!-- <div id="sidebar" class="col-md-4">
					<div class="widget wid-categories">
						<div class="heading"><h4>CATEGORIES</h4></div>
						<div class="content">
							<ul>
								<li><a href="#">PC Computers</a></li>
								<li><a href="#">Laptops & Notebooks</a></li>
								<li><a href="#">Mobiles & Tablet</a></li>
								<li><a href="#">Software</a></li>
							</ul>
						</div>
					</div>
					<div class="widget wid-type">
						<div class="heading"><h4>TYPE</h4></div>
						<div class="content">
							<select>
								<option value="EL" selected>Electronics</option>
								<option value="MT">Mice and Trackballs</option>
								<option value="WC">Web Cameras</option>
								<option value="TA">Tablates</option>
								<option value="AP">Audio Parts</option>
							</select>
						</div>
					</div>
					<div class="widget wid-discouts">
						<div class="heading"><h4>DISCOUNTS</h4></div>
						<div class="content">
							<label class="checkbox"><input type="checkbox" name="discount" checked="">Upto - 10% (20)</label>
							<label class="checkbox"><input type="checkbox" name="discount">40% - 50% (5)</label>
							<label class="checkbox"><input type="checkbox" name="discount">30% - 20% (7)</label>
							<label class="checkbox"><input type="checkbox" name="discount">10% - 5% (2)</label>
							<label class="checkbox"><input type="checkbox" name="discount">Other(50)</label>
						</div>
					</div>
					<div class="widget wid-brand">
						<div class="heading"><h4>BRAND</h4></div>
						<div class="content">
							<label class="checkbox"><input type="checkbox" name="brand">Nokia</label>
							<label class="checkbox"><input type="checkbox" name="brand">Samsung</label>
							<label class="checkbox"><input type="checkbox" name="brand">Iphone</label>
							<label class="checkbox"><input type="checkbox" name="brand">HTC</label>
							<label class="checkbox"><input type="checkbox" name="brand">Oppo</label>
							<label class="checkbox"><input type="checkbox" name="brand">Kings</label>
							<label class="checkbox"><input type="checkbox" name="brand">Zumba</label>	
						</div>
					</div>
					<div class="widget wid-product">
						<div class="heading"><h4>LATEST</h4></div>
						<div class="content">
							<div class="product">
								<a href="#"><img src="images/galaxy-note.jpg" /></a>
								<div class="wrapper">
									<h5><a href="#">Samsung Galaxy Tab</a></h5>
									<div class="price">$122</div>
									<div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span></div>
								</div>
							</div>
							<div class="product">
								<a href="#"><img src="images/galaxy-s4.jpg" /></a>
								<div class="wrapper">
									<h5><a href="#">Samsung Galaxy Tab</a></h5>
									<div class="price">$122</div>
									<div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span></div>
								</div>
							</div>
							<div class="product">
								<a href="#"><img src="images/Z1.png" /></a>
								<div class="wrapper">
									<h5><a href="#">Samsung Galaxy Tab</a></h5>
									<div class="price">$122</div>
									<div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span></div>
								</div>
							</div>
						</div>
					</div>
				</div> -->
			</div>
		</div>
	</div>
	
	<%@include file="/pages/commons/footer.jsp" %>
</body>
</html>