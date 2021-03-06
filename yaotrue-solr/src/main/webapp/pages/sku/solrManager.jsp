<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE head PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%-- <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/scripts/uploadify/uploadify.css" media="screen" /> --%>
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
		$("#deleteAll").click(function(){
			$.ajax({
				url : base + "/solrDeleteAll.json",
				type : 'POST',
				async : true
			})
		})
		$("#refreshBySkuId").click(function(){
			var skuId = $("#skuId").val();
			if('' == skuId){
				alert('请输入产品ID');
				return false;
			}
			$.ajax({
				url : base + "/solrRefreshBySkuId.json",
				type : 'POST',
				data : {
					skuId : skuId
				},
				async : true
			})
		})
		$("#deleteBySkuId").click(function(){
			var skuId = $("#skuId").val();
			if('' == skuId){
				alert('请输入产品ID');
				return false;
			}
			$.ajax({
				url : base + "/solrDeleteBySkuId.json",
				type : 'POST',
				data : {
					skuId : skuId
				},
				async : true
			})
		})
	})
</script>

<body>
	<p><a href="javascript:void(0)" id="refreshAll">全局刷新</a></p>
	<p><a href="javascript:void(0)" id="deleteAll">清空SOLR</a></p>
	<p>
		<input type="text" id="skuId"/>
		<a href="javascript:void(0)" id="refreshBySkuId">更新</a>
		<a href="javascript:void(0)" id="deleteBySkuId">删除</a>
	</p>
</body>
</html>