<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>审批流程列表</title>
    <%@include file="../../common/common-css.jsp" %>
	<%@include file="../../common/common-js.jsp" %>
	<link type="text/css" rel="stylesheet" 
		href="${pageContext.servletContext.contextPath }/style/blue/pageCommon.css" />
    <script type="text/javascript">
	     function showProcessImage(processDefId,imageName){
	    	 var url = "${pageContext.servletContext.contextPath }/background/workflow/viewImage.html?deploymentId="+processDefId+"&imageName=" + imageName;
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
	
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.servletContext.contextPath }/style/images/title_arrow.gif"/> 部署信息管理列表
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<div id="MainArea">
	<table class="ttab" width="100%" cellspacing="1" onmouseover="changeto()"  onmouseout="changeback()">
		<tr>
			<td align="center" width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">ID</td>
			<td align="center" width="40%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">流程名称</td>
			<td align="center" width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">发布时间</td>
			<td align="center" width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">操作</td>
		</tr>
		<c:forEach var="key" items="${depList}">
          <tr>
            <td align="center" height="20" ><span class="STYLE1">${key.id}</span></td>
            <td align="center" height="20" ><span class="STYLE1">${key.name}</span></td>
            <td align="center" height="20" ><span class="STYLE1">
            	<fmt:formatDate value="${key.deploymentTime}" pattern="yyyy-MM-dd HH:mm" />
            </span></td>
            <td align="center" height="20" ><span class="STYLE1">
            	<a href="javascript:void(0);" onclick="deleteId('${pageContext.servletContext.contextPath }/background/workflow/delDeployment.html?deploymentId=${key.id}');">
            	删除</a>
            </span></td>
          </tr>
        </c:forEach>
	</table>
</div>

<br><br><br>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.servletContext.contextPath }/style/images/title_arrow.gif"/> 流程定义信息列表
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<div id="MainArea">
	<table class="ttab" width="100%" cellspacing="1" onmouseover="changeto()"  onmouseout="changeback()">
		<tr>
			<td align="center" width="12%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">ID</td>
			<td align="center" width="18%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">名称</td>
			<td align="center" width="10%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">流程定义的KEY</td>
			<td align="center" width="10%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">流程定义的版本</td>
			<td align="center" width="15%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">流程定义的规则文件名称</td>
			<td align="center" width="15%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">流程定义的规则图片名称</td>
			<td align="center" width="10%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">部署ID</td>
			<td align="center" width="10%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">操作</td>
		</tr>
		<c:forEach var="key" items="${pdList}">
          <tr>
            <td align="center" height="20" ><span class="STYLE1">${key.id}</span></td>
            <td align="center" height="20" ><span class="STYLE1">${key.name}</span></td>
            <td align="center" height="20" ><span class="STYLE1">${key.key}</span></td>
            <td align="center" height="20" ><span class="STYLE1">${key.version}</span></td>
            <td align="center" height="20" ><span class="STYLE1">${key.resourceName}</span></td>
            <td align="center" height="20" ><span class="STYLE1">${key.diagramResourceName}</span></td>
            <td align="center" height="20" ><span class="STYLE1">${key.deploymentId}</span></td>
            <td align="center" height="20" ><span class="STYLE1">
            	<a href="javascript:void(0);" onclick="showProcessImage('${key.deploymentId}','${key.diagramResourceName}');">查看流程图</a>
            </span></td>
          </tr>
        </c:forEach>
	</table>
</div>

<br><br><br>

<!-- 其他功能超链接 -->
<div id="TableTail">
    <div id="TableTail_inside">
        <table border="0" cellspacing="0" cellpadding="10" align="left">
            <tr>
       			<td><div class="FuncBtn">
                        <div class=FuncBtnHead></div>
                        <div class=FuncBtnMemo><a href="deployUI.html">部署流程定义文档</a></div>
                        <div class=FuncBtnTail></div>
                        <div class=FuncBtnHead></div>
                        <div class=FuncBtnMemo><a href="autoNewdeploy.html">自动部署流程定义文档</a></div>
                        <div class=FuncBtnTail></div>
                    </div>
                </td>
            </tr>
		</table>
    </div>
</div>
    
<div class="Description">
	说明：<br />
	1，列表显示的是所有流程定义（不同名称）的最新版本。<br />
	2，删除流程定义时，此名称的所有版本的流程定义都会被删除。<br />
</div>
	
</body>
</html>