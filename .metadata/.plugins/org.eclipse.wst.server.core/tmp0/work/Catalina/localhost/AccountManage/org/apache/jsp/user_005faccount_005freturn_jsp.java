/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M11
 * Generated at: 2017-04-03 13:20:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.AccountManage.model.User;
import com.AccountManage.util.*;
import java.sql.*;

public final class user_005faccount_005freturn_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

Connection conn = null;
PreparedStatement psmt = null;
ResultSet rs = null;
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.AccountManage.util");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.AccountManage.model.User");
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
      out.write("<head>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "head.jsp", out, false);
      out.write("\r\n");
      out.write("<title>欢迎来到账号租赁系统</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container text-c\">\r\n");
      out.write("\t\t<!-- 容器，内部字体居中 -->\r\n");
      out.write("\t\t<div class=\"row cl f-20\">\r\n");
      out.write("\t\t\t<div class=\"col-xs-2\">\r\n");
      out.write("\t\t\t\t<strong>账号租赁系统</strong>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-xs-8\">&nbsp</div>\r\n");
      out.write("\t\t\t<div class=\"col-xs-1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\"> <!-- 获取session中的用户对象，显示用户名 --> ");

					User user = (User)session.getAttribute("user");
					if(user != null){
					
      out.write(' ');
      out.print(user.getName() );
      out.write(' ');

					}
					
      out.write("\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-xs-1\">\r\n");
      out.write("\t\t\t\t<a href=\"user_logoutAction.do\"> 注销 </a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t<aside class=\"Hui-aside\">\r\n");
      out.write("\t\t<input runat=\"server\" id=\"divScrollValue\" type=\"hidden\" value=\"\" />\r\n");
      out.write("\t\t<div class=\"menu_dropdown bk_2\">\r\n");
      out.write("\t\t\t<dl id=\"menu_notes\">\r\n");
      out.write("\t\t\t\t<dt>&nbsp;&nbsp;&nbsp;&nbsp;租赁账号<i class=\"Hui-iconfont menu_dropdown-arrow\">&#xe6d5;</i></dt>\r\n");
      out.write("\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"user_account_xunlei.jsp\">&nbsp;&nbsp;&nbsp;&nbsp;迅雷</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"user_account_aiqiyi.jsp\">&nbsp;&nbsp;&nbsp;&nbsp;爱奇艺</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"user_account_youku.jsp\">&nbsp;&nbsp;&nbsp;&nbsp;优酷</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t</dl>\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">&nbsp;&nbsp;&nbsp;&nbsp;归还账号</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><a href=\"user_account_history.jsp\">&nbsp;&nbsp;&nbsp;&nbsp;租赁记录</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><a href=\"user_activity.jsp\">&nbsp;&nbsp;&nbsp;&nbsp;精彩活动</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><a href=\"user_feedback.jsp\">&nbsp;&nbsp;&nbsp;&nbsp;反馈问题</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><a href=\"user_info.jsp\">&nbsp;&nbsp;&nbsp;&nbsp;我的信息</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</aside>\r\n");
      out.write("\t\t\r\n");
      out.write("\t<section class=\"Hui-article-box\">\r\n");
      out.write("\t<form action=\"user_accountreturnAction.do\" method=\"post\">\r\n");
      out.write("\t\t<table class=\"table table-border table-bordered table-hover\">\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>账号编号</th>\r\n");
      out.write("\t\t\t\t\t<td>账号昵称</td>\r\n");
      out.write("\t\t\t\t\t<td>等级</td>\r\n");
      out.write("\t\t\t\t\t<td>平台</td>\r\n");
      out.write("\t\t\t\t\t<td>租赁时间</td>\r\n");
      out.write("\t\t\t\t\t<td>租赁价格</td>\r\n");
      out.write("\t\t\t\t\t<td>操作</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t");

					try {
						// 创建数据库连接
						conn = DBUtil.getConnection();
						String sql = "select *from user_account,account,platform_account,platform where "+
							"user_account.user_id = ? and user_account.account_id = account.id and account.id = platform_account.account_id and platform_account.plat_id = platform.id";
						// 预编译sql
						psmt = conn.prepareStatement(sql);
						psmt.setInt(1,user.getId());
						// 执行此查询操作
						ResultSet rs = null;
						rs = psmt.executeQuery();
						// 查询到记录，则该账户名的用户存在，flag为true
						while (rs.next()) {
							if(rs.getTimestamp("user_account.lend_time").getTime() == rs.getTimestamp("user_account.return_time").getTime()){
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>");
      out.print(rs.getInt("account.id"));
      out.write("</th>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(rs.getString("account.name") );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(rs.getInt("account.level") );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(rs.getString("platform.name") );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(rs.getTimestamp("user_account.lend_time") );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>0.25</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input class=\"radius btn-primary\" type=\"submit\" value=\"归还\" id=");
      out.print(rs.getInt("account.id") );
      out.write(" onclick=\"save(this)\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

							}
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
				
      out.write("\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"hiddenText\" name=\"hidden\" value=\"\">\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "foot.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\t$(\"#menu_notes dt\").addClass(\"selected\");$(\"#menu_notes dd\").show();;\r\n");
      out.write("\t\t\t$(\".Hui-aside\").scrollTop(566);\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction save(obj){\r\n");
      out.write("\t\t\t//alert(obj.id);\r\n");
      out.write("\t\t\tdocument.getElementById(\"hiddenText\").value = obj.id;\r\n");
      out.write("\t\t\t//alert(document.getElementById(\"hiddenText\").value);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t</script> \r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
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
