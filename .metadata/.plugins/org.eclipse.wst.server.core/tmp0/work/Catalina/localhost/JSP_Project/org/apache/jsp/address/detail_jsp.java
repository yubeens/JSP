/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.36
 * Generated at: 2025-03-06 05:07:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.address;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import com.address.Address;
import com.address.AddressDAO;

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(3);
    _jspx_imports_classes.add("com.address.AddressDAO");
    _jspx_imports_classes.add("com.address.Address");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
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

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");

AddressDAO dao = new AddressDAO();
int num = Integer.parseInt(request.getParameter("num"));
Address address = dao.detail(num);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("function zipfinder(){\r\n");
      out.write("	window.open(\"zipCheck.jsp\",\"\",\"width=700 height=400\")\r\n");
      out.write("	\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function del(){\r\n");
      out.write("	if(confirm(\"정말 삭제 할까요?\")){\r\n");
      out.write("		location.href=\"deleteProcess.jsp?num=");
      out.print(num);
      out.write("\";\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h3>상세보기</h3>\r\n");
      out.write("<form action = \"updateProcess.jsp\">\r\n");
      out.write("<input type=\"hidden\" name=\"num\" value=\"");
      out.print(address.getNum());
      out.write("\">\r\n");
      out.write(" <table>\r\n");
      out.write(" 	<tr>\r\n");
      out.write(" 	 <th>번호</th>\r\n");
      out.write(" 	 <!--<td>");
      out.print(address.getNum());
      out.write("\"></td>-->\r\n");
      out.write(" 	 <!--<td><input type=\"text\" name=\"num\" value=\"");
      out.print(address.getNum());
      out.write("\" disabled=\"disabled\"></td> input type hidden을 만들어야 값이 넘어감--> \r\n");
      out.write(" 	 <td><input type=\"text\" name=\"num\" value=\"");
      out.print(address.getNum());
      out.write("\" readonly=\"readonly\"></td>  <!--hidden없이 값을 넘길 수 잇음 -->\r\n");
      out.write(" 	 </tr>\r\n");
      out.write(" 	<tr>\r\n");
      out.write(" 	 	<th>이름</th>\r\n");
      out.write(" 	 	<td><input type=\"text\" name=\"name\" value=\"");
      out.print(address.getName());
      out.write("\"></td>\r\n");
      out.write(" 	</tr>\r\n");
      out.write(" 	<tr>\r\n");
      out.write(" 	 	<th>우편번호</th>\r\n");
      out.write(" 	 	<td><input type=\"text\" name=\"zipcode\" id=\"zipcode\" value=\"");
      out.print(address.getZipcode());
      out.write("\" size=7 readonly=\"readonly\">\r\n");
      out.write(" 	 	<button type=\"button\" onclick=\"zipfinder()\">검색</button></td>\r\n");
      out.write(" 	</tr>\r\n");
      out.write(" 	<tr>\r\n");
      out.write(" 	 	<th>주소</th>\r\n");
      out.write(" 	 	<td><input type=\"text\" name=\"address\" id=\"addr\" value=\"");
      out.print(address.getAddress());
      out.write("\" size=50></td>\r\n");
      out.write(" 	</tr>\r\n");
      out.write(" 	<tr>\r\n");
      out.write(" 	 	<th>전화번호</th>\r\n");
      out.write(" 	 	<td><input type=\"text\" name=\"tel\" value=\"");
      out.print(address.getTel());
      out.write("\"></td>\r\n");
      out.write(" 	</tr>\r\n");
      out.write(" 	<tr>\r\n");
      out.write(" 	  <td colspan=\"2\">\r\n");
      out.write(" 	  		<button>수정</button>\r\n");
      out.write(" 	  		<button type =\"reset\">수정취소</button>\r\n");
      out.write(" 	  		<button type=\"button\" onclick=\"del()\">삭제</button>\r\n");
      out.write(" 	  		<button type=\"button\" onclick=\"location.href='list.jsp'\">전체보기</button>\r\n");
      out.write(" 	  </td>\r\n");
      out.write(" 	 </tr>\r\n");
      out.write(" </table>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
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
