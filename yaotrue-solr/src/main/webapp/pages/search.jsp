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
						<li>搜索页</li>
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
						  <li><a href="javascript:void(0)" onclick="window.location.href='${base}/search.htm?pageNo=${pagination.currentPage-1 }&keyword=${keyword }'">上一页</a></li>
						  </c:otherwise>
						  </c:choose>
						  <li class="active"><a href="javascript:void(0)">${pagination.currentPage }</a></li>
						  <c:choose>
						  <c:when test="${pagination.lastPage }">
						  <li><a href="javascript:void(0)">下一页</a></li>
						  </c:when>
						  <c:otherwise>
						  <li><a href="javascript:void(0)" onclick="window.location.href='${base}/search.htm?pageNo=${pagination.currentPage+1 }&keyword=${keyword }'">下一页</a></li>
						  </c:otherwise>
						  </c:choose>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="/pages/commons/footer.jsp" %>
</body>
</html>