/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.41
 * Generated at: 2019-07-11 06:52:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Join_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css\">\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\tfunction themaCodeArr() {\r\n");
      out.write("\t\tvar themaCode = [];\r\n");
      out.write("\t\t$(\"input[name='themaCode']:checked\").each(function(i){\r\n");
      out.write("\t\t\tthemaCode.push($(this).val());\r\n");
      out.write("\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container\" style=\"width: 1500px;\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-sm-12 text-center\">\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-3\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-6\">\r\n");
      out.write("\t\t\t\t\t<h2><a href=\"beforemain.do\"><img src=\"");
      out.print(cp );
      out.write("/resources/images/To_gather.png\" style=\"width: 500px;\" height=\"150px;\"></a></h2>\r\n");
      out.write("\t\t\t\t\t<h3><span style=\"font-family: 맑은 고딕; font-size: 20pt;\">회원가입</span></h3>\r\n");
      out.write("\t\t\t\t\t<h5><span style=\"font-family: 맑은 고딕; font-size: 12pt; color: red;\">* 필수 입력 사항</span></h5>\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<form action=\"joininsert.do\"  method=\"post\" id=\"form\" >\r\n");
      out.write("\t\t\t\t\t\t<table class=\"table table-boardered\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>아이디*</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"userId\" name=\"userId\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\tplaceholder=\"영소문자,숫자 혼합 8자리 ~ 12자리\" onkeydown=\"inputIdChk()\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn\" id=\"idCheckBtn\">중복검사</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"idCheck\" value=\"idUncheck\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>패스워드*</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type=\"password\" class=\"form-control\" id=\"userPw\" name=\"userPw\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tplaceholder=\"영소문자,숫자 혼합 8자리 ~ 12자리\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>패스워드확인*</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type=\"password\" class=\"form-control\" id=\"pw2\" name=\"pw2\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tplaceholder=\"영소문자,숫자 혼합 8자리 ~ 12자리\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>이름*</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type=\"text\" class=\"form-control\" name=\"name\" id=\"name\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>닉네임*</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type=\"text\" class=\"form-control\" id=\"nickName\" name=\"nickName\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tplaceholder=\"최대 5글자\" onkeydown=\"inputNickNameChk()\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn\" id=\"nicknameCheckBtn\">중복검사</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"nicknameCheck\" value=\"nicknameUncheck\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>생년월일*</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type=\"date\" class=\"form-control\" id=\"birth\" name=\"birth\"></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>성별*</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"radio\" name=\"genderCode\" value=\"1\" checked=\"checked\">남자\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"radio\" name=\"genderCode\" value=\"2\">여자</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>이메일*</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" onkeydown=\"inputEmailChk()\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn\" id=\"emailCheckBtn\">중복검사</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"emailCheck\" value=\"emailUncheck\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>자기소개(선택)</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type=\"text\" class=\"form-control\" id=\"intro\" name=\"intro\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tplaceholder=\"30자 이내\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>관심 여행테마(최대 3가지)</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type=\"checkbox\" name=\"themaCode\" value=\"1\" onclick=\"javascript:chk(this)\">자연\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;&nbsp; <input type=\"checkbox\" name=\"themaCode\" value=\"2\" onclick=\"javascript:chk(this)\">문화관광\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;&nbsp; <input type=\"checkbox\" name=\"themaCode\" value=\"3\" onclick=\"javascript:chk(this)\">레저/스포츠\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;&nbsp; <input type=\"checkbox\" name=\"themaCode\" value=\"4\" onclick=\"javascript:chk(this)\">쇼핑\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;&nbsp; <input type=\"checkbox\" name=\"themaCode\" value=\"5\" onclick=\"javascript:chk(this)\">맛집\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;&nbsp; <input type=\"checkbox\" name=\"themaCode\" value=\"6\" onclick=\"javascript:chk(this)\">기타\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<div style=\"margin-bottom: 50px;\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" id=\"join\" name=\"join\" class=\"btn\" style=\"width: 240px; margin: 5px;\">회원가입</button>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn\" style=\"width: 240px; margin: 5px;\" onclick=\"history.back(-1); return false;\">취소</button>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t$(\"#userId\").focus();\r\n");
      out.write("\r\n");
      out.write("\t// 다시 중복체크\r\n");
      out.write("\tfunction inputIdChk() {\r\n");
      out.write("\t\tdocument.getElementById(\"idCheck\").value = \"idUnCheck\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction inputNickNameChk() {\r\n");
      out.write("\t\tdocument.getElementById(\"nicknameCheck\").value = \"nicknameUnCheck\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction inputEmailChk() {\r\n");
      out.write("\t\tdocument.getElementById(\"emailCheck\").value = \"emailUnCheck\";\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t$(document).ready(function()\r\n");
      out.write("\t{ \t\r\n");
      out.write("\t\tvar id = /^[A-Za-z0-9+]{8,12}$/;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar pw = /^[A-Za-z0-9+]{8,12}$/;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#join\").click(function()\r\n");
      out.write("\t\t{\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif($(\"#userId\").val()==\"\" || $(\"#userPw\").val()==\"\" || $(\"#pw2\").val()==\"\" || $(\"#name\").val()==\"\" || $(\"#nickName\").val()==\"\"\r\n");
      out.write("\t\t\t\t\t|| $(\"#birth\").val()==\"\"  || $(\"#email\").val()==\"\")\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"필수 항목이 누락되었습니다.\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif (!id.test(document.getElementById(\"userId\").value))\r\n");
      out.write("\t\t\t{\t\r\n");
      out.write("\t\t\t\talert(\"아이디가 조건에 맞지 않습니다\");\r\n");
      out.write("\t\t\t\t$(\"#userId\").focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif (!pw.test(document.getElementById(\"userPw\").value))\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"패스워드가 조건에 맞지 않습니다\");\r\n");
      out.write("\t\t\t\t$(\"#userPw\").focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(document.getElementById(\"userPw\").value != document.getElementById(\"pw2\").value)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"패스워드와 패스워드확인이 일치하지 않습니다. \");\r\n");
      out.write("\t\t\t\t$(\"#pw2\").focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t        if($(\"#nickName\").val().length > 5) \t   \r\n");
      out.write("\t        {\r\n");
      out.write("\t        \talert(\"닉네임은 최대 5글자 입니다.\");\r\n");
      out.write("\t        \t$(\"#nickName\").focus();\r\n");
      out.write("\t            return false;\r\n");
      out.write("\t        }\r\n");
      out.write("\t        \r\n");
      out.write("\t        if($(\"#intro\").val().length > 30) \t   \r\n");
      out.write("\t        {\r\n");
      out.write("\t        \talert(\"30자 이내로 작성해주세요.\");\r\n");
      out.write("\t        \t$(\"#intro\").focus();\r\n");
      out.write("\t            return false;\r\n");
      out.write("\t        }\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\tif($(\"#idCheck\").val() != \"idCheck\")\r\n");
      out.write("\t\t\t{\t\r\n");
      out.write("\t\t\t\talert(\"아이디를 중복체크 해주세요!\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif($(\"#nicknameCheck\").val() !=\"nicknameCheck\")\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"닉네임을 중복체크 해주세요!\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif($(\"#emailCheck\").val()!=\"emailCheck\")\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"이메일을 중복체크 해주세요!\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#idCheckBtn\").click(function() {\r\n");
      out.write("\t\t\tvar userId = $(\"#userId\").val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(userId == \"\")\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"아이디를 입력해주세요.\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"");
      out.print(cp);
      out.write("/idcheck.do\",\r\n");
      out.write("\t\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\t\tdata : {'userId':userId},\r\n");
      out.write("\t\t\t\tsuccess: function(count) {\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif (!id.test(document.getElementById(\"userId\").value))\r\n");
      out.write("\t\t\t\t\t{\t\r\n");
      out.write("\t\t\t\t\t\talert(\"아이디가 조건에 맞지 않습니다\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#userId\").focus();\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t// 중복안됨\r\n");
      out.write("\t\t\t\t\tif(count == 0)\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\talert(\"사용가능한 아이디입니다.\");\r\n");
      out.write("\t\t\t\t\t\tdocument.getElementById(\"idCheck\").value = \"idCheck\";\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\talert(\"중복된 아이디입니다.\");\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#nicknameCheckBtn\").click(function() {\r\n");
      out.write("\t\t\tvar nickName = $(\"#nickName\").val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(nickName == \"\")\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"닉네임을 입력해주세요.\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"");
      out.print(cp);
      out.write("/nicknamecheck.do\",\r\n");
      out.write("\t\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\t\tdata : {'nickName':nickName},\r\n");
      out.write("\t\t\t\tsuccess: function(count) {\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif($(\"#nickName\").val().length > 5) \t   \r\n");
      out.write("\t\t\t        {\r\n");
      out.write("\t\t\t        \talert(\"닉네임은 최대 5글자 입니다.\");\r\n");
      out.write("\t\t\t        \t$(\"#nickName\").focus();\r\n");
      out.write("\t\t\t            return false;\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t// 중복안됨\r\n");
      out.write("\t\t\t\t\tif(count == 0)\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\talert(\"사용가능한 닉네임입니다.\");\r\n");
      out.write("\t\t\t\t\t\tdocument.getElementById(\"nicknameCheck\").value = \"nicknameCheck\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\talert(\"중복된 닉네임입니다.\");\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#emailCheckBtn\").click(function() {\r\n");
      out.write("\t\t\tvar email = $(\"#email\").val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(email == \"\")\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"이메일을 입력해주세요.\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"");
      out.print(cp);
      out.write("/emailcheck.do\",\r\n");
      out.write("\t\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\t\tdata : {'email':email},\r\n");
      out.write("\t\t\t\tsuccess: function(count) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t// 중복안됨\r\n");
      out.write("\t\t\t\t\tif(count == 0)\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\talert(\"사용가능한 이메일입니다.\");\r\n");
      out.write("\t\t\t\t\t\tdocument.getElementById(\"emailCheck\").value = \"emailCheck\";\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\talert(\"중복된 이메일입니다.\");\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function chk(obj){\r\n");
      out.write("\r\n");
      out.write("\tvar chkbox = document.getElementsByName(\"themaCode\");\r\n");
      out.write("\r\n");
      out.write("\tvar chkCnt = 0;\r\n");
      out.write("\r\n");
      out.write("\tfor(var i=0;i<chkbox.length; i++){\r\n");
      out.write("\r\n");
      out.write("\t\tif(chkbox[i].checked){\r\n");
      out.write("\r\n");
      out.write("\t\t\tchkCnt++;\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tif(chkCnt>3){\r\n");
      out.write("\r\n");
      out.write("\t\talert(\"관심테마는 최대 3개까지 선택가능합니다.\");\r\n");
      out.write("\r\n");
      out.write("\t\tobj.checked = false;\r\n");
      out.write("\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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
