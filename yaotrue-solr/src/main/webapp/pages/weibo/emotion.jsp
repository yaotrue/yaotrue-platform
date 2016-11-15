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
		<div class="row">
			<div class="col-lg-12">
				<div class="container">
				<c:forEach items="${emotions }" var="emotion">
				<img alt="${emotion.phrase }-${emotion.type }${emotion.hot }" src="${emotion.url }">
				</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="/pages/commons/footer.jsp" %>
</body>
</html>