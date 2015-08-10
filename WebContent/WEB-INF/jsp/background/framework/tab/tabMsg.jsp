<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<SCRIPT src="${pageContext.servletContext.contextPath }/js/Clock.js" type=text/javascript></SCRIPT>
<title>无标题文档</title>
<style type="text/css">
.BgColorWhite {  
	background-color: #FFFFFF; /*奇数行，我定义为白色背景*/
}
.BgColorGray {
    background-color: #F3FAFF; /*偶数行，我定义为灰色背景*/
    }
.style1 {color: #009900}
</style>

<style type="text/css">
a:link {
color: #686868;
font-size: 12px;
	text-decoration: none;
}
a:visited {
	font-size: 12px;
	color: #686868
;
	text-decoration: none;
}
a:hover {
	font-size: 12px;
	color: #686868;
}
<style type="text/css">
body  {
/*overflow: scroll; */
border: solid 2px black; 	
}
td {
	font-size: 12px;
	color: #3A3A3A;
}
test{    
   filter: Alpha(opacity=10);    
   -moz-opacity:.1;    
   opacity:0.1;    
}
</style>

<style type="text/css"> 
body  {
	SCROLLBAR-FACE-COLOR: C7D1DC;
	SCROLLBAR-HIGHLIGHT-COLOR: #C7D1DC;
	SCROLLBAR-SHADOW-COLOR: #C7D1DC;
	SCROLLBAR-3DLIGHT-COLOR: #C7D1DC;
	SCROLLBAR-ARROW-COLOR: #ffffff;
	SCROLLBAR-TRACK-COLOR: #ffffff;
	SCROLLBAR-DARKSHADOW-COLOR: #ffffff;
	font-size: 12px;
}
div.RoundedCorner{background: #4884CA} 
b.rtop, b.rbottom{display:block;background: #FFF} 
b.rtop b, b.rbottom b{display:block;height: 1px;overflow: hidden; background: #4884CA} 
b.r1{margin: 0 4px} 
b.r2{margin: 0 3px} 
b.r3{margin: 0 2px} 
b.rtop b.r4, {margin: 0 1px;height: 1px}
.style1 {
	font-size: 13px;
	color: #FFFFFF;
font-weight: bold;
}
</style>
</head>

<body>
<table width="100%"  border="0" cellpadding="2" cellspacing="1" bgcolor="#E7E8EA">
	<tr bgcolor="#FFFFFF">
		<td height="80" width="50%" align="left" valign="middle">
			<%@ include file="subMsg1.jsp" %>
		</td>
		<td height="80" width="50%" align="left" valign="middle">
			<%@ include file="subMsg2.jsp" %>
		</td>
	</tr>
</table>
 
</body>
</body>
</html>
