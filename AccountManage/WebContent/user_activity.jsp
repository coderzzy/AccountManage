<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.AccountManage.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="head.jsp" />
<title>欢迎来到账号租赁系统</title>

</head>
<body>
	<div class="container text-c">
		<!-- 容器，内部字体居中 -->
		<div class="row cl f-20">
			<div class="col-xs-2">
				<strong>账号租赁系统</strong>
			</div>
			<div class="col-xs-8">&nbsp</div>
			<div class="col-xs-1">
				<a href="#"> <!-- 获取session中的用户对象，显示用户名 --> <%
					User user = (User)session.getAttribute("user");
					if(user != null){
					%> <%=user.getName() %> <%
					}
					%>
				</a>
			</div>
			<div class="col-xs-1">
				<a href="user_logoutAction.do"> 注销 </a>
			</div>
		</div>
		
	<aside class="Hui-aside">
		<input runat="server" id="divScrollValue" type="hidden" value="" />
		<div class="menu_dropdown bk_2">
			<dl id="menu_notes">
				<dt>&nbsp;&nbsp;&nbsp;&nbsp;租赁账号<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
				<dd>
					<ul>
						<li><a href="user_account_xunlei.jsp">&nbsp;&nbsp;&nbsp;&nbsp;迅雷</a></li>
						<li><a href="user_account_aiqiyi.jsp">&nbsp;&nbsp;&nbsp;&nbsp;爱奇艺</a></li>
						<li><a href="user_account_youku.jsp">&nbsp;&nbsp;&nbsp;&nbsp;优酷</a></li>
					</ul>
				</dd>
			</dl>
			<ul>
				<li><a href="user_account_return.jsp">&nbsp;&nbsp;&nbsp;&nbsp;归还账号</a></li>
			</ul>
			<ul>
				<li><a href="user_account_history.jsp">&nbsp;&nbsp;&nbsp;&nbsp;租赁记录</a></li>
			</ul>
			<ul>
				<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;精彩活动</a></li>
			</ul>
			<ul>
				<li><a href="user_feedback.jsp">&nbsp;&nbsp;&nbsp;&nbsp;反馈问题</a></li>
			</ul>
			<ul>
				<li><a href="user_info.jsp">&nbsp;&nbsp;&nbsp;&nbsp;我的信息</a></li>
			</ul>
		</div>
	</aside>
	
	<section class="Hui-article-box">
         <div>敬请期待</div>
  	</section>
		
		<jsp:include page="foot.jsp" />
		<script type="text/javascript">
		$(function(){
			$("#menu_notes dt").addClass("selected");$("#menu_notes dd").show();;
			$(".Hui-aside").scrollTop(566);	
		});
		</script> 
	</div>
</body>
</html>