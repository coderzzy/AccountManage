<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.AccountManage.model.Vip,com.AccountManage.util.*,java.sql.*"%>
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
 	Vip vip = (Vip) session.getAttribute("vip");
 	if (vip != null) {
 %> <%=vip.getName()%> <%
 	}
 %>
				</a>
			</div>
			<div class="col-xs-1">
				<a href="vip_logoutAction.do"> 注销 </a>
			</div>
		</div>

		<aside class="Hui-aside"> <input runat="server"
			id="divScrollValue" type="hidden" value="" />
		<div class="menu_dropdown bk_2">
			<ul>
				<li><a href="vip_activity.jsp">&nbsp;&nbsp;&nbsp;&nbsp;精彩活动</a></li>
			</ul>
			<ul>
				<li><a href="vip_feedback.jsp">&nbsp;&nbsp;&nbsp;&nbsp;反馈问题</a></li>
			</ul>
			<ul>
				<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;我的账号</a></li>
			</ul>
			<ul>
				<li><a href="vip_info.jsp">&nbsp;&nbsp;&nbsp;&nbsp;我的信息</a></li>
			</ul>
		</div>
		</aside>

		<section class="Hui-article-box">
		<table class="table table-border table-bordered table-hover">
		<form action="vip_accountdelAction.do" method="post">
			<thead>
				<tr>
					<th>编号</th>
					<td>账号昵称</td>
					<td>密码</td>
					<td>等级</td>
					<td>平台</td>
					<td>过期时间</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<%!Connection conn = null;%>
				<%!PreparedStatement psmt = null;%>
				<%!ResultSet rs = null;%>
				<%
					try {
						// 创建数据库连接
						conn = DBUtil.getConnection();
						String sql = "select *from vip_account,account,platform,platform_account where vip_account.vip_id = ? and vip_account.account_id = account.id and account.id = platform_account.account_id and platform_account.plat_id = platform.id "
								+"and account.id not in(select account_id from user_account where UNIX_TIMESTAMP(lend_time) = UNIX_TIMESTAMP(return_time))";
						// 预编译sql
						psmt = conn.prepareStatement(sql);
						psmt.setInt(1,vip.getId());
						// 执行此查询操作
						ResultSet rs = null;
						rs = psmt.executeQuery();
						// 查询到记录，则该账户名的用户存在，flag为true
						while (rs.next()) {
				%>
				<tr>
					<th><%=rs.getInt("account.id")%></th>
					<td><%=rs.getString("account.name") %></td>
					<td><%=rs.getString("account.password") %></td>
					<td><%=rs.getInt("account.level") %></td>
					<td><%=rs.getString("platform.name") %></td>
					<td><%=rs.getTimestamp("account.over_time") %></td>
					<td><input class="radius btn-primary" type="submit" value="删除" id=<%=rs.getInt("account.id") %> onclick="save(this)"></td>
				</tr>
				<%
					}
					} catch (SQLException e) {
						e.printStackTrace();
						throw new AppException("vip_myAccount.jsp");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new AppException("vip_myAccount.jsp");
					} finally {
						// 关闭数据库查询结果集
						DBUtil.closeResultSet(rs);
						// 关闭数据库查询指令
						DBUtil.closeStatement(psmt);
						// 关闭数据库连接
						DBUtil.closeConnection(conn);
					}
				%>
				<input type="hidden" id="hiddenText" name="hidden" value="">
				</form>
				<tr>
					<form action="vip_myaccountAction.do" method="post">
						<th>new</th>
						<td><input type="text" class="input-text radius size-M"
							name="name"></td>
						<td><input type="text" class="input-text radius size-M"
							name="password"></td>
						<td><input type="text" class="input-text radius size-M"
							name="level"></td>
						<td><input type="text" class="input-text radius size-M"
							name="platform"></td>
						<td><input type="text" class="input-text radius size-M"
							name="overtime"></td>
						<td><input class="radius btn-primary" type="submit"
							value="添加"></td>
					</form>
				</tr>
			</tbody>
		</table>
		</section>

		<jsp:include page="foot.jsp" />
		<script type="text/javascript">
			$(function() {
				$("#menu_notes dt").addClass("selected");
				$("#menu_notes dd").show();
				;
				$(".Hui-aside").scrollTop(566);
			});
			function save(obj){
				//alert(obj.id);
				document.getElementById("hiddenText").value = obj.id;
				//alert(document.getElementById("hiddenText").value);
			}
		</script>
	</div>
</body>
</html>