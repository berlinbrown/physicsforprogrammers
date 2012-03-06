<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.berlin.math.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fibonacci Literate Programming Example</title>
</head>
<body>
<h3>Fibonacci Literate Programming Example</h3>
<%
final String func = request.getParameter("func");
String resultMessage = "invalid ; Invalid Request";

final MathServicesServlet m = new MathServicesServlet();
final String n = request.getParameter("n");
try { 			
	final int ni = Integer.parseInt(n);
	if (ni >= 30) {
		resultMessage = "error ; Error at function (invalid value for n=" + n + ")";
	} else {
		final int fib = m.mathFuncFibonacci(ni);					
		resultMessage = String.valueOf(fib);
	}
} catch(final Throwable t) {
	resultMessage = "error ; Error at function";
} // End of the try - catch //		
%>

Result = <span><%=resultMessage %></span>

<!-- ======================================================== -->
<!-- = Java Sourcecode to HTML automatically converted code = -->
<!-- =   Java2Html Converter 5.0 [2006-02-26] by Markus Gebhard  markus@jave.de   = -->
<!-- =     Further information: http://www.java2html.de     = -->
<div align="left" class="java">
<table border="0" cellpadding="3" cellspacing="0" bgcolor="#ffffff">
   <tr>
  <!-- start source code -->
   <td nowrap="nowrap" valign="top" align="left">
    <code>
<font color="#7f0055"><b>package&nbsp;</b></font><font color="#000000">org.berlin.math.literate;</font><br />
<font color="#ffffff"></font><br />
<font color="#7f0055"><b>public&nbsp;class&nbsp;</b></font><font color="#000000">LiterateFib&nbsp;</font><font color="#000000">{</font><br />
<font color="#ffffff">&nbsp;&nbsp;</font><font color="#3f5fbf">/**</font><br />
<font color="#ffffff">&nbsp;&nbsp;&nbsp;</font><font color="#3f5fbf">*&nbsp;The&nbsp;Fibonacci&nbsp;sequence&nbsp;is&nbsp;named&nbsp;after&nbsp;Leonardo&nbsp;of&nbsp;Pisa.</font><br />
<font color="#ffffff">&nbsp;&nbsp;&nbsp;</font><font color="#3f5fbf">*&nbsp;</font><br />
<font color="#ffffff">&nbsp;&nbsp;&nbsp;</font><font color="#3f5fbf">*&nbsp;0,&nbsp;1,&nbsp;1,&nbsp;2,&nbsp;3,&nbsp;5,&nbsp;8,&nbsp;13,&nbsp;21&nbsp;&nbsp;&nbsp;&nbsp;</font><br />
<font color="#ffffff">&nbsp;&nbsp;&nbsp;</font><font color="#3f5fbf">*&nbsp;</font><br />
<font color="#ffffff">&nbsp;&nbsp;&nbsp;</font><font color="#3f5fbf">*&nbsp;</font><font color="#7f9fbf">@param&nbsp;</font><font color="#3f5fbf">n</font><br />
<font color="#ffffff">&nbsp;&nbsp;&nbsp;</font><font color="#3f5fbf">*&nbsp;</font><font color="#7f9fbf">@return</font><br />
<font color="#ffffff">&nbsp;&nbsp;&nbsp;</font><font color="#3f5fbf">*/</font><br />
<font color="#ffffff">&nbsp;&nbsp;</font><font color="#7f0055"><b>protected&nbsp;</b></font><font color="#7f0055"><b>int&nbsp;</b></font><font color="#000000">mathFuncFibonacci</font><font color="#000000">(</font><font color="#7f0055"><b>final&nbsp;</b></font><font color="#7f0055"><b>int&nbsp;</b></font><font color="#000000">n</font><font color="#000000">)&nbsp;{</font><br />
<font color="#ffffff">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font color="#7f0055"><b>int&nbsp;</b></font><font color="#000000">f0a&nbsp;=&nbsp;</font><font color="#990000">0</font><font color="#000000">;</font><br />
<font color="#ffffff">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font color="#7f0055"><b>int&nbsp;</b></font><font color="#000000">f1b&nbsp;=&nbsp;</font><font color="#990000">1</font><font color="#000000">;</font><br />
<font color="#ffffff">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font color="#7f0055"><b>for&nbsp;</b></font><font color="#000000">(</font><font color="#7f0055"><b>int&nbsp;</b></font><font color="#000000">i&nbsp;=&nbsp;</font><font color="#990000">0</font><font color="#000000">;&nbsp;i&nbsp;&lt;&nbsp;n;&nbsp;i++</font><font color="#000000">)&nbsp;{</font><br />
<font color="#ffffff">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font color="#7f0055"><b>final&nbsp;</b></font><font color="#7f0055"><b>int&nbsp;</b></font><font color="#000000">savePrev1&nbsp;=&nbsp;f0a;</font><br />
<font color="#ffffff">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font color="#000000">f0a&nbsp;=&nbsp;f1b;</font><br />
<font color="#ffffff">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font color="#000000">f1b&nbsp;=&nbsp;savePrev1&nbsp;+&nbsp;f1b;</font><br />
<font color="#ffffff">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font color="#000000">}</font><br />
<font color="#ffffff">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font color="#7f0055"><b>return&nbsp;</b></font><font color="#000000">f0a;</font><br />
<font color="#ffffff">&nbsp;&nbsp;</font><font color="#000000">}&nbsp;</font><font color="#3f7f5f">//&nbsp;End&nbsp;of&nbsp;the&nbsp;method&nbsp;//</font><br />
<font color="#000000">}</font></code>
    
   </td>
  <!-- end source code -->
   </tr>
</table>
</div>
<!-- =       END of automatically generated HTML code       = -->
<!-- ======================================================== -->


</body>
</html>