<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.AccountManage.model.Vip"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="head.jsp"/>
		<title>欢迎来到账号租赁系统</title>
	</head>
<body>
	<div class="container text-c"><!-- 容器，内部字体居中 -->
		<div class="row cl f-20">
			<div class="col-xs-2"><strong>账号租赁系统</strong></div>
			<div class="col-xs-8">&nbsp</div> 
			<div class="col-xs-1">
				<a href="#">
					<!-- 获取session中的用户对象，显示用户名 -->
					<%
					Vip vip = (Vip)session.getAttribute("vip");
					if(vip != null){
					%>
					<%=vip.getName() %>
					<%
					}
					%>
				</a>
			</div>
			<div class="col-xs-1">
				<a href="vip_logoutAction.do">
					注销
				</a>
			</div>
		</div>
		
	<aside class="Hui-aside">
		<input runat="server" id="divScrollValue" type="hidden" value="" />
		<div class="menu_dropdown bk_2">
			<ul>
				<li><a href="vip_activity.jsp">&nbsp;&nbsp;&nbsp;&nbsp;精彩活动</a></li>
			</ul>
			<ul>
				<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;反馈问题</a></li>
			</ul>
			<ul>
				<li><a href="vip_myAccount.jsp">&nbsp;&nbsp;&nbsp;&nbsp;我的账号</a></li>
			</ul>
			<ul>
				<li><a href="vip_info.jsp">&nbsp;&nbsp;&nbsp;&nbsp;我的信息</a></li>
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