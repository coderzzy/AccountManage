<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="head.jsp"/>
		<title>失败界面</title> 
	</head> 
	<body>
	<div id="container" class="background-error text-c"><!-- 内容居中对齐，块居中对齐 -->
		<div id="login_page">
			<h1>&nbsp</h1>
			<div class="mt-20">&nbsp</div>
			<div class="mt-20">&nbsp</div>
			<div class="mt-20">&nbsp</div>
			<div class="panel panel-danger">
				<div class="panel-header">验证失败</div>
				<form id="toLogin" action="toLogin.do" method="post">
					<div id="div_back" class="panel-body"></div><!-- 具体内容在js中实现 -->
				</form>
			</div>
		</div>
		
		<jsp:include page="foot.jsp"/>
		<!-- 5s之后返回登陆界面 -->
		<script type="text/javascript">
    		var start = 5;  
    		var step = -1;  
    		function count() {  
    			document.getElementById("div_back").innerHTML = 
    				"<a href='javascript:document.getElementById(&quot;toLogin&quot;).submit()'>点此返回至登陆界面，或者页面将在" +start+ "秒后返回登录页面...</a>"; 
        		start += step;  
        		if (start <= 0) {  
            		start = 5;  
            		//alert(start);  
            		window.location = "login.jsp";//重定位  
        		}  
        		setTimeout("count()", 1000);  
    		}  
    		window.onload = count;  
		</script>
	</div>
	</body>
</html>