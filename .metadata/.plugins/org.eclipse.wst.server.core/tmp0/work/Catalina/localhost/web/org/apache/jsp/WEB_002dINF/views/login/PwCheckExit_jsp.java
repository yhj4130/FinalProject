/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.41
 * Generated at: 2019-07-13 12:42:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class PwCheckExit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/gram/Desktop/FinalProject/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/TogatherProject/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1561878082826L));
  }

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
      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>To_gather</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script> \r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t.login-form {\r\n");
      out.write("\t\twidth: 600px;\r\n");
      out.write("    \tmargin: 100px auto;\r\n");
      out.write("\t}\r\n");
      out.write("    .login-form form {\r\n");
      out.write("    \tmargin-bottom: 50px;\r\n");
      out.write("        background: white;\r\n");
      out.write("       \r\n");
      out.write("        padding: 0px;\r\n");
      out.write("    }\r\n");
      out.write("    .login-form h2 {\r\n");
      out.write("        margin: 0 0 15px;\r\n");
      out.write("    }\r\n");
      out.write("    .form-control, .btn {\r\n");
      out.write("        min-height: 38px;\r\n");
      out.write("        border-radius: 2px;\r\n");
      out.write("        width: 60%;\r\n");
      out.write("    }\r\n");
      out.write("    .btn {        \r\n");
      out.write("        font-size: 15px;\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"login-form\">\r\n");
      out.write("    <form action=\"exitform.do\" method=\"post\">\r\n");
      out.write("        <h2 class=\"text-center\"><a href=\"aftermain.do\"><img src=\"");
      out.print(cp );
      out.write("/resources/images/To_gather.png\" style=\"width: 500px;\" height=\"150px;\"></a></h2>    \r\n");
      out.write("        \r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <h3 class=\"text-center\">회원탈퇴</h3>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <br>\r\n");
      out.write("        <div>\r\n");
      out.write("            <input type=\"password\" class=\"form-control\" name=\"userPw\" id=\"userPw\" required=\"required\" placeholder=\"비밀번호를 입력해주세요.\" style=\"width: 100%;\">\r\n");
      out.write("        </div>\r\n");
      out.write("       \r\n");
      out.write("        <br><br>\r\n");
      out.write("        \r\n");
      out.write("        <div style=\"text-align: center;\">\r\n");
      out.write("          \t<button type=\"button\" class=\"btn\" style=\"width: 240px; margin: 5px;\">확인</button>\r\n");
      out.write("            <button type=\"button\" class=\"btn\" style=\"width: 240px; margin: 5px;\" onclick=\"history.go(-1); return false;\">취소</button>\r\n");
      out.write("        </div>             \r\n");
      out.write("    </form>    \r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>                                \t\t                            ");
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
