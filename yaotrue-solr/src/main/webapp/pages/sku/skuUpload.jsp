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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/scripts/uploadify/jquery.uploadify.v2.1.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/scripts/uploadify/swfobject.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/sku.js"></script>

<body>
	<!-- 这里是商品基本信息上传 -->
	<div class="boxedit">
		<div class="group_edit_bg">
			<h3 class="p_l_5 p_t_5 fLeft">商品基本信息上传</h3>
		</div>
		<!-- 这里是页面内容区 -->

		<div style="padding: 10px;">
			<fieldset>
				<div class="showtip">
					请确定上传的商品基本信息文件是有效的Excel文件，且必填项已填写完整。<br>点击浏览按钮选择要上传的文件。
				</div>
				<p>
					<input type="file" id="skuinfo-upload" name="file" />
				</p>
				<p style="margin-top: 5px; font-size: 14px; font-weight: bold;">
					<a href="javascript:if(checkImport('#skuinfo-uploadQueue')){$('#skuinfo-upload').uploadifyUpload();}">上传文件</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:$('#skuinfo-upload').uploadifyClearQueue();">取消上传</a>
				</p>
				<p style="margin-top: 5px; font-size: 14px; font-weight: bold;">
					<span id="upload-skuinfo-result"></span>
				</p>
			</fieldset>

			<div id="upload-skuinfo-message" class="upload-message"></div>

		</div>
		<div class="clear group_edit_bottom"></div>
	</div>
</body>
</html>