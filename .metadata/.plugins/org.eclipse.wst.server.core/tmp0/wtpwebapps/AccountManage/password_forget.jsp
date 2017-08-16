<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="head.jsp"/>
		<title>查找页面</title>
	</head>
<body>
	<div id="container" class="text-c"><!-- 内容居中对齐，块居中对齐 -->
		<div id="login_page">
			<h1>
				<strong>查找账号</strong>
			</h1>
			<!-- 上传表单 username和password -->
			<form id="registerAction" action="registerAction.do" method="post">
				<div class="mt-20">
					<div class="f-l" style="height: 10px; width: 100px">
						<span class="f-16">账户: </span>
					</div>
					<div class="f-l" style="height: 10px; width: 250px">
						<input class="input-text radius" type="text" name="username"
							placeholder="邮箱/会员帐号/手机号" id="nm" autofocus required />
					</div>
					<br />
				</div>
				<div class="mt-20">
					<p class="f-24">
						<input class="radius btn-primary" type="submit" id="submit" value="立即查找"
							style="width: 200px; height: 30px">
					</p>
				</div>
			</form>
		</div>
		<jsp:include page="foot.jsp" />
	</div>
</body>
</html>