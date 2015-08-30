<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="../../common/common-css.jsp" %>
     <script src="${pageContext.servletContext.contextPath }/js/jquery_1_7_2_min.js" type="text/javascript"></script>
  </head>
  
  <body>
<br/>
<br/>  
		<table class="ttab" height="100" width="70%" border="0" cellpadding="0" cellspacing="1"
			align="center">
			<tr>
				<td height="30"
					 colspan="2">
					<div align="center">
					<font color="blue" size="3" ><b>用户列表</b></font>
					</div>
				</td>
			</tr>
			<tr>	
				<td height="30"width="20%" >
					<div align="right" class="STYLE1" >
							分组：
					</div>
				</td>
				<td >
					<div align="left" class="STYLE1"  style="padding-left:10px;">
					${dName}
					</div>
				</td>
			</tr>
				<tr>
				<td colspan="2">
				<table class="listtable" width="100%">
			      <tr>
			        <td><table class="ttab" width="100%" cellspacing="1" onmouseover="changeto()"  onmouseout="changeback()">
			          <tr>
			 			<td width="15%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">用户名</td>
			            <td width="5%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif" ><span class="STYLE1">真实姓名</span></td>
			            <td width="12%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif" ><span class="STYLE1">联系方式</span></td>
			          </tr>
			          
			          <c:forEach var="user" items="${users}">
			          <tr>
			            <td height="20" ><span class="STYLE1">${user.userName}</span></td>
			            <td height="20" ><span class="STYLE1">${user.userRealname}</span></td>
			            <td height="20" ><span class="STYLE1">${user.userPhone}</span></td>
			          </tr>
			          </c:forEach>
			        </table></td>
			      </tr>
   				</table>
				</td>
				</tr>
				<tr>
					<td colspan="2" style="padding: 10px">
						<div align="center">
			 				<input id="backBt" type="button" value="　关　闭　" class="input_btn_style1" onclick="javascript:window.close();"/>
		 				</div>
					</td>
				</tr>
		</table>
  </body>
</html>
