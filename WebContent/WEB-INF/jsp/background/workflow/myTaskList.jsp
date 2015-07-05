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
	<script type="text/javascript">
	     function showProcessImage(taskId){
	    	 var url = "${pageContext.servletContext.contextPath }/background/workflow/viewCurrentImage.html?taskId="+taskId;
	    	 var h_sp1 = 600;
	    	 var w_sp1 = 800;
	    	//兼容IE，firefox,google.模态窗口居中问题
	    	 var iTop2 = (window.screen.availHeight - 20 - h_sp1) / 2;
	    	 var iLeft2 = (window.screen.availWidth - 10 - w_sp1) / 2;
	    	 var params = 'menubar:no;dialogHeight=' + h_sp1 + 'px;dialogWidth=' + w_sp1 + 'px;dialogLeft=' + iLeft2 + 'px;dialogTop=' + iTop2 + 'px;resizable=yes;scrollbars=0;resizeable=0;center=yes;location:no;status:no;scroll:no'
	    	 window.showModalDialog(url, window, params);
	    }
    </script> 
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
			<td width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">任务ID</td>
			<td width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">任务当前步骤名称</td>
			<td width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">创建时间</td>
			<td width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">办理人</td>
			<td width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">相关操作</td>
		</tr>
          <c:forEach var="key" items="${pageView.records}">
          <tr>
            <td><a href="#">${key.id }</a></td>
			<td>${key.name }</td>
			<td>
				<fmt:formatDate value="${key.createTime}" pattern="yyyy-MM-dd HH:mm"/>
			</td>
			<td>${key.assignee}</td>
			<td><a href="${pageContext.servletContext.contextPath }/background/workflow/viewTaskForm.html?taskId=${key.id}">办理任务</a>
				<a href="javascript:void(0);" onclick="showProcessImage('${key.id}');">查看当前流程图</a>
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
	1，这里列出的所有的表单状态都为"审批中"。
</div>
</body>
</html>