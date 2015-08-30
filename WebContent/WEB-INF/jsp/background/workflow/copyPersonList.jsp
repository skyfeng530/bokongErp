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
<form id="fenye" name="fenye" action="${pageContext.servletContext.contextPath }/background/workflow/myApplyList.html" method="post">
<table width="100%">
  <tr>
    <td height="30" background="${pageContext.servletContext.contextPath }/images/tab_05.gif"><table width="100%">
      <tr>
        <td>
        	<div id="Title_bar">
			    <div id="Title_bar_Head">
			        <div id="Title_Head"></div>
			        <div id="Title"><!--页面标题-->
			            <img border="0" width="13" height="13" src="${pageContext.servletContext.contextPath }/style/images/title_arrow.gif"/> 抄送我的任务
			        </div>
			        <div id="Title_End"></div>
			    </div>
			</div>
        </td>
      </tr>
    </table></td>
  </tr>
  <tr>
  <td align="center">
  </td>
  </tr>
  <tr>
    <td><table class="listtable" width="100%">
      <tr>
        <td width="8" background="${pageContext.servletContext.contextPath }/images/tab_12.gif">&nbsp;</td>
        <td><table class="ttab" width="100%" cellspacing="1" onmouseover="changeto()"  onmouseout="changeback()">
          <tr align="CENTER" valign="MIDDLE" id="TableTitle">
			<td width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">申请单名称</td>
			<td width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">申请人</td>
			<td width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">当前状态</td>
			<td width="40%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">相关操作</td>
		</tr>
        <c:forEach var="key" items="${pageView.records}">
          <tr>
            <td>${key.pdname}</td>
			<td>${key.applyperson}</td>
			<td>
				<c:if test="${key.state eq 0}">初始录入</c:if>
				<c:if test="${key.state eq 1}">审核中</c:if>
				<c:if test="${key.state eq 2}">审核完成</c:if>
			</td>
			<td>
				<a href="${pageContext.request.contextPath }/background/workflow/hisComment_Copy.html?title=${key.businesskey}">查看审核记录</a>
			</td>
		  </tr> 
        </c:forEach>
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
	1：对于退回的表单，可以执行“修改后再次提交”与“删除”的操作。<br />&nbsp;&nbsp;
	   其他状态表单（正在审批的或是审批完成的）则没有这两个操作。<br />
	2：删除退回的申请文档后，此文档相关的审批信息也要同时删除，对应的流程也终止了。<br />
</div>
</body>
</html>