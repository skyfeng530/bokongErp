<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<table width="100%" height="180" border="0" cellpadding="0" cellspacing="0">
	<!-- 标题 -->
  <tr>
    <td  height="26"  background="${pageContext.servletContext.contextPath }/images/1.gif" ><font color="#000000">
    <b>&nbsp;&nbsp;通知</b></font></td>
    <td background="${pageContext.servletContext.contextPath }/images/1.gif" ><div align="right">
    	<a href="#"><img src="${pageContext.servletContext.contextPath }/images/more.jpg" width="36" height="11" border="0"></a>&nbsp;
    </div></td>
  </tr>
  <!-- 内容 -->
  <tr>
    <td height="2" colspan="2" bgcolor="43AAE5"></td>
  </tr>
  <tr>
    <td  colspan="2" align="left" valign="top" >
	 <table width="100%"  border="0" cellpadding="2" cellspacing="1" bgcolor="#E7E8EA">
	 <c:forEach var="key" items="${deviceTips}">
	    <tr bgcolor="#FFFFFF" onMouseOver = "this.style.backgroundColor = '#EEEEEE'" onMouseOut = "this.style.backgroundColor = ''" class=>
	       <td height="28" colspan="2" align="left" valign="middle">
	         <div align="left">
				 <a href="" title="【${key.name }】需要检修" onMouseOver=" window.status='none';return true ">
				 	<font color="#3E3E3E">&nbsp;&nbsp;【${key.name }】需要检修</font>
				 </a>
	         </div>
	       </td>
	       <td width="12%" align="center" valign="middle"> <div align="center">
	       	<font color="#999999">${userSession.userName}</font>
	       </div></td>
	       <td width="20%" align="left" valign="middle"> <div align="center">
	       </div></td>
	   </tr>
	</c:forEach>
	</table> 
	</td>
  </tr>
  <tr>
    <td colspan="2" ></td>
  </tr>
</table>
</body>
</html>