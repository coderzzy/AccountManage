<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="head.jsp" />
	<title>注册页面</title>
</head>
<body>
	<div id="container" class="background-register text-c">
		<!-- 内容居中对齐，块居中对齐 -->
		<div id="login_page">
			<h1>
				<strong>注册新账号</strong>
			</h1>
			
			<div class="mt-20">
				<div class="f-l" style="height: 10px; width: 100px">
					<span class="f-16">账号种类： </span>
				</div>
				<div class="f-l" style="height: 10px; width: 250px">
					<input id="user" name="user_type" type="radio" value="user" onclick="register()"/>普通用户 
					<input id="vip" name="user_type" type="radio" value="vip" onclick="register()"/>会员用户 
				</div>
				<br />
			</div>
			
			<!-- 上传表单 username和password,email,mobile -->
			<form id="actionForm" action="" method="post">
				<div class="mt-20">
					<div class="f-l" style="height: 10px; width: 100px">
						<span class="f-16">昵称: </span>
					</div>
					<div class="f-l" style="height: 10px; width: 250px">
						<input class="input-text radius" type="text" name="name"
							placeholder="4-10个字母，数字或下划线" id="nm" autofocus required />
					</div>
					<br />
				</div>
				<div class="mt-20">
					<div class="f-l" style="height: 10px; width: 100px">
						<span class="f-16">密码: </span>
					</div>
					<div class="f-l" style="height: 10px; width: 250px">
						<input class="input-text radius" type="password" name="password"
							placeholder="请输入密码" id="pw1" required />
					</div>
					<br />
				</div>
				<div class="mt-20">
					<div class="f-l" style="height: 10px; width: 100px">
						<span class="f-16">确认密码: </span>
					</div>
					<div class="f-l" style="height: 10px; width: 250px">
						<input class="input-text radius" type="password"
							placeholder="请确认密码" id="pw2" required />
					</div>
					<br />
				</div>
				<div class="mt-20">
					<div class="f-l" style="height: 10px; width: 100px">
						<span class="f-16">*手机号: </span>
					</div>
					<div class="f-l" style="height: 10px; width: 250px">
						<input class="input-text radius" type="text" name="mobile"
							placeholder="11位数字" autofocus required />
					</div>
					<br />
				</div>
				<div class="mt-20">
					<div class="f-l" style="height: 10px; width: 100px">
						<span class="f-16">*邮箱: </span>
					</div>
					<div class="f-l" style="height: 10px; width: 250px">
						<input class="input-text radius" type="text" name="email"
							 autofocus required />
					</div>
					<br />
				</div>
				<div class="mt-20">
					<p class="f-24">
						<input class="radius btn-primary" type="submit" value="立即注册" style="width: 200px; height: 30px" onclick="return check()">
					</p>
				</div>
			</form>
		</div>
		<jsp:include page="foot.jsp" />
		
		<!-- 防止输入为空 -->
		<script type="text/javascript">
		//根据单选框不同结果建立不同的action处理
		function register(){
			if(document.getElementById("user").checked == true){
				document.getElementById("actionForm").action="user_registerAction.do";
			}
			else{
				document.getElementById("actionForm").action="vip_registerAction.do";
			}
		}
		//防止最终输入内容有些为空
		function check() {
			var nm = document.getElementById("nm").value;
			var pw1 = document.getElementById("pw1").value;
			var pw2 = document.getElementById("pw2").value;
			if (nm == "" || pw1 == "" || pw2 == "") {
				window.alert("用户昵称 密码不能为空");
				return false;
			} else {
				if (pw1 == pw2) {
					return true;
				} else {
					window.alert("两次密码输入不一样");
					return false;
				}
			}
		}
		</script>
	</div>
</body>
</html>