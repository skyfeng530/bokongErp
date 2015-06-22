<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../../common/common-css.jsp" %>
<%@include file="../../common/common-js.jsp" %>
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath }/css/fenyecss.css" />
<link type="text/css" rel="stylesheet" 
	href="${pageContext.servletContext.contextPath }/style/blue/pageCommon.css" />
</head>
<body>
<form id="fenye" name="fenye" action="${pageContext.servletContext.contextPath }/background/workflow/myTaskList.html" method="post">
<table width="100%">
  <tr>
    <td height="30" background="${pageContext.servletContext.contextPath }/images/tab_05.gif"><table width="100%">
      <tr>
        <td>
        	<div id="Title_bar">
			    <div id="Title_bar_Head">
			        <div id="Title_Head"></div>
			        <div id="Title"><!--页面标题-->
			            <img border="0" width="13" height="13" src="${pageContext.servletContext.contextPath }/style/images/title_arrow.gif"/> 待我审批任务
			        </div>
			        <div id="Title_End"></div>
			    </div>
			</div>
        </td>
      </tr>
    </table></td>
  </tr>
  <tr>
  </tr>
  <tr>
    <td><table class="listtable" width="100%">
      <tr>
        <td width="8" background="${pageContext.servletContext.contextPath }/images/tab_12.gif">&nbsp;</td>
        <td><table class="ttab" width="100%" cellspacing="1" onmouseover="changeto()"  onmouseout="changeback()">
          <tr align="CENTER" valign="MIDDLE" id="TableTitle">
			<td width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">标题</td>
			<td width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">申请人</td>
			<td width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">申请日期</td>
			<td width="30%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">相关操作</td>
		</tr>
		<tr>
           <td>设备采购单_管理员_2015-06-01</td>
			<td>管理员</td>
			<td>2015-06-01 09:30</td>
			<td><a href="${pageContext.servletContext.contextPath }/background/workflow/showForm.html">查看申请信息</a>
				<a href="${pageContext.servletContext.contextPath }/background/workflow/approvedHistory.html">查看流转记录</a>
			</td>
	  	</tr>
          <%-- <c:forEach var="key" items="${pageView.records}">
          <tr>
            <td><a href="${pageContext.servletContext.contextPath }/Flow_Formflow/showForm.html">设备采购单_管理员_2015-06-01</a></td>
			<td>管理员</td>
			<td>2015-06-01 09:30</td>
			<td>审批中</td>
			<td><a href="${pageContext.servletContext.contextPath }/Flow_Formflow/showForm.html">查看申请信息</a>
				<a href="${pageContext.servletContext.contextPath }/Flow_Formflow/approvedHistory.html">查看流转记录</a>
			</td>
		  </tr> 
          </c:forEach>--%>
        </table></td>
        <td width="8" background="${pageContext.servletContext.contextPath }/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="${pageContext.servletContext.contextPath }/images/tab_19.gif"><%@include file="../../common/webfenye2.jsp" %>
    </td>
  </tr>
</table>
</form>
<div class="Description">
	说明：<br />
	1，这里列出的所有的表单状态都为"审批中"。
</div>
</body>
</html>