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
				<table>
						<tr>
							<td>用户UID</td><td>${user.id }</td>
							<td>微博昵称</td><td>${user.screenName }</td>
							<td>友好显示名称</td><td>${user.name }</td>
						</tr>
						<tr>
							<td>省份编码</td><td>${user.province }</td>
							<td>城市编码</td><td>${user.city }</td>
							<td>地址</td><td>${user.location }</td>
						</tr>
						<tr>
							<td>个人描述</td><td>${user.description }</td>
							<td>用户博客地址</td><td><a href="${user.url }" target="_blank">URL</a></td>
							<td>自定义图像</td><td><img src="${user.profileImageUrl }"/></td>
						</tr>
						<tr>
							<td>用户个性化URL</td><td>${user.userDomain }</td>
							<td>性别</td><td>${user.gender }</td>
							<td>粉丝数</td><td>${user.followersCount }</td>
						</tr>
						<tr>
							<td>关注数</td><td>${user.friendsCount }</td>
							<td>微博数</td><td>${user.statusesCount }</td>
							<td>收藏数</td><td>${user.favouritesCount }</td>
						</tr>
						<tr>
							<td>创建时间</td><td><fmt:formatDate value="${user.createdAt }" pattern="yyyy-MM-dd HH:mm:ss.SSS" /></td>
							<td>是否已关注</td><td>${user.following }</td>
							<td>加V标示</td><td>${user.verified }</td>
						</tr>
						<tr>
							<td>认证类型</td><td>${user.verifiedType }</td>
							<td>是否允许所有人给我发私信</td><td>${user.allowAllActMsg }</td>
							<td>是否允许所有人对我的微博进行评论</td><td>${user.allowAllComment }</td>
						</tr>
						<tr>
							<td>此用户是否关注我</td><td>${user.followMe }</td>
							<td>大头像地址</td><td><img src="${user.avatarLarge }"/></td>
							<td>用户在线状态</td><td>${user.onlineStatus }</td>
						</tr>
						<tr>
							<td>用户最新一条微博</td><td>${user.status.text }</td>
							<td>互粉数</td><td>${user.biFollowersCount }</td>
							<td>备注信息</td><td>${user.remark }</td>
						</tr>
						<tr>
							<td>用户语言版本</td><td>${user.lang }</td>
							<td>认证原因</td><td>${user.verifiedReason }</td>
							<td>微號</td><td>${user.weihao }</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="/pages/commons/footer.jsp" %>
</body>
</html>