/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M11
 * Generated at: 2017-04-03 12:48:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/head.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t<title>登录界面</title>\r\n");
      out.write("\t</head> \r\n");
      out.write("\t<body>\r\n");
      out.write("\t<div id=\"container\" class=\"background-login text-c\"><!-- 内容居中对齐，块居中对齐 -->\r\n");
      out.write("\t\t<div id=\"login_page\">\r\n");
      out.write("\t\t\t<h1><strong>AccountManage</strong><small>    zzy</small></h1>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"mt-20\">\r\n");
      out.write("\t\t\t\t<div class=\"f-l\" style=\"height: 10px; width: 100px\">\r\n");
      out.write("\t\t\t\t\t<span class=\"f-16\">账号种类： </span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"f-l\" style=\"height: 10px; width: 250px\">\r\n");
      out.write("\t\t\t\t\t<input id=\"user\" name=\"user_type\" type=\"radio\" value=\"user\" onclick=\"login()\"/>普通用户\r\n");
      out.write("\t\t\t\t\t<input id=\"vip\" name=\"user_type\" type=\"radio\" value=\"vip\" onclick=\"login()\"/>会员用户\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"mt-20\">&nbsp</div>\r\n");
      out.write("\t\t\t<form id=\"actionForm\" action=\"\" method=\"post\">\r\n");
      out.write("\t\t\t\t<div class=\"mt-20\">\r\n");
      out.write("\t\t\t\t\t<div class=\"f-l\" style=\"height:10px;width:100px\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"f-16\">账户: </span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"f-l\" style=\"height:10px;width:250px\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"input-text radius\" type=\"text\" name=\"name\" placeholder=\"邮箱/会员帐号/手机号\" \r\n");
      out.write("\t\t\t\t\t\tautofocus required/>\r\n");
      out.write("\t\t\t\t\t</div><br/>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"mt-20\">\r\n");
      out.write("\t\t\t\t\t<div class=\"f-l\" style=\"height:10px;width:100px\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"f-16\">密码: </span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"f-l\" style=\"height:10px;width:250px\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"input-text radius\" type=\"password\" name=\"password\" placeholder=\"请输入密码\" \r\n");
      out.write("\t\t\t\t\t\trequired/>\r\n");
      out.write("\t\t\t\t\t</div><br/>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- 验证码 -->\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"mt-20 f-12\">\r\n");
      out.write("\t\t\t\t\t<div style=\"float:left;width:100px\">&nbsp</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"text-c f-l\" style=\"width:100px\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" checked=\"checked\"><span>记住密码</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"text-c f-l\" style=\"width:100px\">\r\n");
      out.write("          \t\t\t\t<input type=\"checkbox\" checked=\"checked\"><span>下次自动登录</span>\r\n");
      out.write("          \t\t\t</div><br/>\r\n");
      out.write("          \t\t</div>\r\n");
      out.write("          \t\t<div class=\"mt-20\">\r\n");
      out.write("          \t\t\t<p class=\"f-24\">\r\n");
      out.write("          \t\t\t<input class=\"radius btn-primary\" type=\"submit\" value=\"登录\"  style=\"width:200px;height:30px\"></p>\r\n");
      out.write("          \t\t</div>\r\n");
      out.write("          \t</form>\r\n");
      out.write("          \t\r\n");
      out.write("          \t<div class=\"mt-20\">\r\n");
      out.write("          \t\t<p class=\"f-12\">\r\n");
      out.write("          \t\t\t<a href=\"toPassword_forget.do\">忘记密码？</a> \r\n");
      out.write("          \t\t\t<span class=\"pipe\">|</span>\r\n");
      out.write("          \t\t\t<a href=\"toRegister.do\">注册</a>\r\n");
      out.write("          \t\t</p>\r\n");
      out.write("          \t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/foot.jsp", out, false);
      out.write(" \r\n");
      out.write("\t\t<!-- 使用action方法根据单选框结果，利用一个form跳转不同页面 -->\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("    \t\tfunction login(){\r\n");
      out.write("    \t\t\tif(document.getElementById(\"user\").checked == true){\r\n");
      out.write("    \t\t\t\tdocument.getElementById(\"actionForm\").action=\"user_loginAction.do\";\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t\telse{\r\n");
      out.write("    \t\t\t\tdocument.getElementById(\"actionForm\").action=\"vip_loginAction.do\";\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t}\r\n");
      out.write("\t\t</script> \r\n");
      out.write("\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}