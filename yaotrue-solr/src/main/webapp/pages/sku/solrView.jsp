<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--去除el表达式带来的源代码中的空行 --%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE head PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta charset="utf-8">
<script>
	var base = '${pageContext.request.contextPath}';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#refreshAll").click(function(){
			$.ajax({
				url : base + "/solrRefreshAll.json",
				type : 'POST',
				async : true
			})
		})
	})
</script>

<body>
	<div style="width: 80%;margin: 0 auto;">
		<c:forEach items="${pagination.items }" var="sku">
		<div style="width: 25%;float: left;">
			<div style="width: 100%">
				<a href="${sku.tgUrl }">
					<img src="${sku.skuImgUrl }" width="90%"/>
				</a>
			</div>
			<div>
				<p>${sku.skuName }</p>
				<div>
					<p>${sku.shopName }</p>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
</body>
</html>