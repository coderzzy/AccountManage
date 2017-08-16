<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="/head.jsp"/>
		<title>登录界面</title>
	</head> 
	<body>
	<div id="container" class="background-login text-c"><!-- 内容居中对齐，块居中对齐 -->
		<div id="login_page">
			<h1><strong>AccountManage</strong><small>    zzy</small></h1>
			
			<div class="mt-20">
				<div class="f-l" style="height: 10px; width: 100px">
					<span class="f-16">账号种类： </span>
				</div>
				<div class="f-l" style="height: 10px; width: 250px">
					<input id="user" name="user_type" type="radio" value="user" onclick="login()"/>普通用户
					<input id="vip" name="user_type" type="radio" value="vip" onclick="login()"/>会员用户
				</div>
			</div>
			
			<div class="mt-20">&nbsp</div>
			<form id="actionForm" action="" method="post">
				<div class="mt-20">
					<div class="f-l" style="height:10px;width:100px">
						<span class="f-16">账户: </span>
					</div>
					<div class="f-l" style="height:10px;width:250px">
						<input class="input-text radius" type="text" name="name" placeholder="邮箱/会员帐号/手机号" 
						autofocus required/>
					</div><br/>
				</div>
				<div class="mt-20">
					<div class="f-l" style="height:10px;width:100px">
						<span class="f-16">密码: </span>
					</div>
					<div class="f-l" style="height:10px;width:250px">
						<input class="input-text radius" type="password" name="password" placeholder="请输入密码" 
						required/>
					</div><br/>
				</div>
				<!-- 验证码 -->
				
				<div class="mt-20 f-12">
					<div style="float:left;width:100px">&nbsp</div>
					<div class="text-c f-l" style="width:100px">
						<input type="checkbox" checked="checked"><span>记住密码</span>
					</div>
					<div class="text-c f-l" style="width:100px">
          				<input type="checkbox" checked="checked"><span>下次自动登录</span>
          			</div><br/>
          		</div>
          		<div class="mt-20">
          			<p class="f-24">
          			<input class="radius btn-primary" type="submit" value="登录"  style="width:200px;height:30px"></p>
          		</div>
          	</form>
          	
          	<div class="mt-20">
          		<p class="f-12">
          			<a href="toPassword_forget.do">忘记密码？</a> 
          			<span class="pipe">|</span>
          			<a href="toRegister.do">注册</a>
          		</p>
          	</div>
		</div>
		<jsp:include page="/foot.jsp"/> 
		<!-- 使用action方法根据单选框结果，利用一个form跳转不同页面 -->
		<script type="text/javascript">
    		function login(){
    			if(document.getElementById("user").checked == true){
    				document.getElementById("actionForm").action="user_loginAction.do";
    			}
    			else{
    				document.getElementById("actionForm").action="vip_loginAction.do";
    			}
    		}
		</script> 
	</div>
	</body>
</html>